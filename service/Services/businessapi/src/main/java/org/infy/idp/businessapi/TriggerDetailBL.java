/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.businessapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.infy.entities.artifact.ArtifactoryArtifacts;
import org.infy.entities.artifact.ArtifactoryFile;
import org.infy.entities.triggerinputs.ApproveBuild;
import org.infy.entities.triggerinputs.Build;
import org.infy.entities.triggerinputs.BuildDeployEnv;
import org.infy.entities.triggerinputs.Deploy;
import org.infy.entities.triggerinputs.DeployArtifact;
import org.infy.entities.triggerinputs.DeployTestEnv;
import org.infy.entities.triggerinputs.Steps;
import org.infy.entities.triggerinputs.Test;
import org.infy.entities.triggerinputs.TestSteps;
import org.infy.entities.triggerinputs.TriggerInputs;
import org.infy.entities.triggerinputs.TriggerJobName;
import org.infy.idp.dataapi.services.EnvironmentDetails;
import org.infy.idp.dataapi.services.JobDetailsDL;
import org.infy.idp.dataapi.services.ReleaseDetails;
import org.infy.idp.entities.jobs.IDPJob;
import org.infy.idp.entities.jobs.applicationinfo.ApplicationInfo;
import org.infy.idp.entities.jobs.applicationinfo.SlavesDetail;
import org.infy.idp.entities.jobs.buildinfo.Module;
import org.infy.idp.entities.jobs.buildinfo.SubModule;
import org.infy.idp.entities.jobs.code.Scm;
import org.infy.idp.entities.jobs.deployinfo.DeployEnv;
import org.infy.idp.entities.jobs.deployinfo.DeployStep;
import org.infy.idp.entities.jobs.testinfo.TestEnv;
import org.infy.idp.entities.jobs.testinfo.TestStep;
import org.infy.idp.entities.models.GitHubBrachModel;
import org.infy.idp.entities.nexus.Nexus;
import org.infy.idp.entities.triggerparameter.TriggerParameters;
import org.infy.idp.utils.BitBucketBranchTagFetcher;
import org.infy.idp.utils.ConfigurationManager;
import org.infy.idp.utils.GitHubBranchTagFetcher;
import org.infy.idp.utils.GitLabBranchTagFetcher;
import org.infy.idp.utils.TFSBranchFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * The class TriggerDetailBL contains method for triggering the job
 * @author Infosys
 */
@Component
public class TriggerDetailBL {
	private static final Logger logger = LoggerFactory.getLogger(TriggerDetailBL.class);
	private static final String GENERAL = "General";
	private static final String BUILD = "BUILD";
	private static final String DEPLOY = "DEPLOY";
	private static final String TEST = "TEST";
	private static final String WORKFLOW = "workflow";

	@Autowired
	private FetchJobDetails fetchJobDetails;
	@Autowired
	private ConfigurationManager configmanager;
	@Autowired
	private JobDetailsDL getJobDetails;
	@Autowired
	private JobsBL jobsBL;
	@Autowired
	private GitLabBranchTagFetcher gitLabBranchTagFetcher;
	@Autowired
	private GitHubBranchTagFetcher gitHubBranchTagFetcher;
	@Autowired
	private BitBucketBranchTagFetcher bitBucketBranchTagFetcher;
	@Autowired
	private TFSBranchFetcher tFSBranchFetcher;
	@Autowired
	private ReleaseDetails releaseDetails;
	@Autowired
	private EnvironmentDetails environmentDetails;

	TriggerDetailBL() {

	}

	/**
	 * Returns trigger option for trigger job
	 * @param triggerJobName
	 * @return Trigger Input
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	public TriggerInputs fecthTriggerOptions(TriggerJobName triggerJobName) throws SQLException {
		TriggerInputs triggerInputs = new TriggerInputs();
		Gson gson = new Gson();
		// setting application, pipeline and user names.
		triggerInputs.setApplicationName(triggerJobName.getApplicationName());
		triggerInputs.setPipelineName(triggerJobName.getPipelineName());
		triggerInputs.setUserName(triggerJobName.getUserName());
		String userName = triggerJobName.getUserName();
		boolean deployStatus = false;
		boolean testStatus = false;

		// setting roles
		try {
			List<String> roles = getJobDetails.getRoles(triggerJobName.getUserName(),
					triggerJobName.getApplicationName());
			triggerInputs.setRoles(roles);
			logger.debug("roles : " + roles.toString());

			// getting entity info from pipeline table
			IDPJob idp = getJobDetails.getPipelineInfo(triggerJobName.getApplicationName(),
					triggerJobName.getPipelineName());

			logger.debug("pipelineInfo : " + gson.toJson(idp));
			// getting enitity info from application table
			ApplicationInfo app = getJobDetails.getApplication(triggerJobName.getApplicationName());
			logger.debug("application info : " + gson.toJson(app));
			// getting technology
			// check for workflow / pipeline
			String technology = null;

			if (idp.getCode() != null) {
				technology = idp.getCode().getTechnology();
				logger.debug("technology : " + technology);
			}
			triggerInputs.setTechnology(technology);
			logger.debug("technology : " + technology);
			// getting Permissions
			List<String> permissions = getPermissions(triggerJobName.getApplicationName(),
					triggerJobName.getUserName());
			triggerInputs.setPermissions(permissions);
			logger.debug("permissions : " + permissions.toString());
			boolean ssh = false;
			if (idp.getDeployInfo() != null && idp.getDeployInfo().getDeployEnv() != null) {
				int depEnvSize = idp.getDeployInfo().getDeployEnv().size();
				for (int i = 0; i < depEnvSize; i++) {
					if (idp.getDeployInfo().getDeployEnv().get(i).getDeploySteps() != null) {
						int depStepSize = idp.getDeployInfo().getDeployEnv().get(i).getDeploySteps().size();
						for (int j = 0; j < depStepSize; j++) {
							if (idp.getDeployInfo().getDeployEnv().get(i).getDeploySteps().get(j).getRunScript() != null
									&& idp.getDeployInfo().getDeployEnv().get(i).getDeploySteps().get(j).getRunScript()
											.getScriptType() != null
									&& idp.getDeployInfo().getDeployEnv().get(i).getDeploySteps().get(j).getRunScript()
											.getScriptType().equalsIgnoreCase("sshExecution")) {
								ssh = true;
								break;
							}

						}
					}
					if (ssh)
						break;
				}
			}
			if (technology != null && !WORKFLOW.equalsIgnoreCase(technology)
					&& idp.getBuildInfo().getPostBuildScript() != null
					&& idp.getBuildInfo().getPostBuildScript().getDependentPipelineList() != null
					&& (idp.getBuildInfo().getPostBuildScript().getDependentPipelineList().size() > 0) && ssh)
				triggerInputs.setSshAndDependent("on");
			else
				triggerInputs.setSshAndDependent("off");

			if (triggerInputs.getSshAndDependent().equalsIgnoreCase("on")) {
				triggerInputs.setRelaseList(
						jobsBL.getReleaseNumber(triggerJobName.getApplicationName(), triggerJobName.getPipelineName(),
								idp.getBuildInfo().getPostBuildScript().getDependentPipelineList()));
			}
			List<String> userEnvs = fetchJobDetails.getUserEnvironment(app, userName);

			if (permissions.contains(BUILD) && technology != null && !WORKFLOW.equalsIgnoreCase(technology)) {

				logger.debug("Build section enabled for pipeline : " + triggerJobName.getPipelineName());
				triggerInputs.setBuild(getBuildInfo(idp, technology));
				if (GENERAL.equalsIgnoreCase(technology)) {

					List<String> jsonResponse = checkApproval(
							triggerJobName.getApplicationName() + "_" + triggerJobName.getPipelineName(), BUILD, "");
					triggerInputs.getBuild().setJobType(BUILD);
					if (jsonResponse != null && jsonResponse.size() != 0)
						triggerInputs.getBuild().setApproveBuild(apprParamSet(jsonResponse, triggerInputs, "build"));
				}
			}
			// getting slave details
			triggerInputs.setSlaves(getSlaveDetails(app, idp));

			// get all application details based on OS
			triggerInputs.setAppSlaves(getAppSlaveDetails(app, idp));

			// getting release number
			List<String> releaseNumbers = getJobDetails.getReleaseNumber(triggerJobName.getApplicationName(),
					triggerJobName.getPipelineName());
			HashMap<String, List<String>> releaseAndBranches = null;
			try {
				releaseAndBranches = getJobDetails.getReleaseNumberAndBranches(triggerJobName.getApplicationName(),
						triggerJobName.getPipelineName());
			} catch (Exception e) {
				logger.error("release and branches: " + e.getMessage());
			}

			triggerInputs.setReleaseTransportInfo(getJobDetails
					.getReleaseTransportInfo(triggerJobName.getApplicationName(), triggerJobName.getPipelineName()));
			triggerInputs.setReleaseNumber(releaseNumbers);
			triggerInputs.setReleaseBranches(releaseAndBranches);

			// getting scm type

			if (technology != null && !WORKFLOW.equalsIgnoreCase(technology) && idp.getCode().getScm() != null
					&& idp.getCode().getScm().size() != 0 && idp.getCode().getScm().get(0) != null
					&& idp.getCode().getScm().get(0).getType() != null) {

				String scmType = idp.getCode().getScm().get(0).getType();

				triggerInputs.setScmType(scmType);
				// getting branch List

				if (scmType.equalsIgnoreCase("git")) {

					String repoBrowser = idp.getCode().getScm().get(0).getRepositoryBrowser();
					if (repoBrowser.equalsIgnoreCase("gitlab")) {
						String repoUrl = idp.getCode().getScm().get(0).getBrowserUrl();
						String username = idp.getCode().getScm().get(0).getUserName();

						String pwd = idp.getCode().getScm().get(0).getPassword();

						String projectUrl = idp.getCode().getScm().get(0).getUrl();

						ArrayList<ArrayList<String>> branchTagList = gitLabbranchesTagsFetcher(repoUrl, username, pwd,
								projectUrl);

						if (branchTagList != null) {
							if (branchTagList.size() != 0) {
								triggerInputs.setBranchList(branchTagList.get(0));
							}

							if (branchTagList.size() > 1) {
								triggerInputs.setTagList(branchTagList.get(1));
							}

						}

					}

					else if (repoBrowser.equalsIgnoreCase("github")) {

						String username = idp.getCode().getScm().get(0).getUserName();
						String pwd = idp.getCode().getScm().get(0).getPassword();
						logger.info(idp.getCode().getScm().toString());
						String projectUrl = idp.getCode().getScm().get(0).getUrl();
						String proxy = idp.getCode().getScm().get(0).getProxy();
						String port = idp.getCode().getScm().get(0).getProxyPort();

						String s[] = projectUrl.split("/");
						String repoUrl = s[0] + "//" + s[2];

						List<ArrayList<String>> branchTagList = gitHubBranchesTagsFetcher(
								new GitHubBrachModel(repoUrl, username, pwd, projectUrl, proxy, port));
						if (branchTagList != null) {
							if (branchTagList.size() != 0) {
								triggerInputs.setBranchList(branchTagList.get(0));
							}

							if (branchTagList.size() > 1) {
								triggerInputs.setTagList(branchTagList.get(1));
							}

						}

					}

					else if (repoBrowser.equalsIgnoreCase("bitbucket")) {

						String repoUrl = idp.getCode().getScm().get(0).getBrowserUrl();

						String username = idp.getCode().getScm().get(0).getUserName();
						String pwd = idp.getCode().getScm().get(0).getPassword();
						logger.info(idp.getCode().getScm().toString());
						String projectUrl = idp.getCode().getScm().get(0).getUrl();
						String proxy = idp.getCode().getScm().get(0).getProxy();
						String port = idp.getCode().getScm().get(0).getProxyPort();
						logger.info(port);
						logger.info(idp.getCode().getScm().get(0).getProxyPort());

						List<ArrayList<String>> branchTagList = bitBucketbranchesTagsFetcher(repoUrl, username, pwd,
								projectUrl, proxy, port);
						logger.info("sjowing branchTag");
						logger.info(branchTagList.toString());
						if (branchTagList != null) {
							if (branchTagList.size() != 0) {
								triggerInputs.setBranchList(branchTagList.get(0));
							}

							if (branchTagList.size() > 1) {
								logger.info("1");
								triggerInputs.setTagList(branchTagList.get(1));
							}

						}

					}

				}

				else if (scmType.equalsIgnoreCase("tfs")) {
					String repoUrl = idp.getCode().getScm().get(0).getUrl();
					String projPath = idp.getCode().getScm().get(0).getProjPath();
					String username = idp.getCode().getScm().get(0).getUserName();
					String pwd = idp.getCode().getScm().get(0).getPassword();

					triggerInputs.setBranchList(branchFetcher(repoUrl, projPath, username, pwd));
				}

			}

			// getting environments

			if (permissions.contains(DEPLOY) && technology != null && !WORKFLOW.equalsIgnoreCase(technology)) {

				Deploy deploy = new Deploy();

				if (idp.getDeployInfo() != null && idp.getDeployInfo().getDeployEnv() != null) {
					triggerInputs.setDeploy(deploy);
					List<DeployEnv> deployEnvs = idp.getDeployInfo().getDeployEnv();
					HashMap<String, List<ApproveBuild>> workEnvApprovalList = new HashMap<>();

					int deployEnvsSize = deployEnvs.size();
					for (int i = 0; i < deployEnvsSize; i++) {
						if (null != deployEnvs.get(i).getDeploySteps()
								&& !deployEnvs.get(i).getDeploySteps().isEmpty()) {
							deployStatus = true;
							if (GENERAL.equalsIgnoreCase(technology)) {
								String env = deployEnvs.get(i).getEnvName();

								List<String> jsonResponse = checkApproval(
										triggerJobName.getApplicationName() + "_" + triggerJobName.getPipelineName(),
										DEPLOY, env);
								deploy.setJobType(DEPLOY);
								if (jsonResponse != null && jsonResponse.size() != 0) {
									apprParamSet(jsonResponse, triggerInputs, "deploy");
									workEnvApprovalList.put(env, apprParamSet(jsonResponse, triggerInputs, "deploy"));

								}
							} else {
								break;
							}
						}
					}

					if (deployStatus) {
						logger.info("Deploy steps are found in the pipeline");
						List<String> envInDeploy = fetchJobDetails.getEnvironmentsDeploy(idp, userEnvs);
						deploy.setDeployEnv(envInDeploy);
						deploy.setBizobj(fetchJobDetails.getbizObj(idp, envInDeploy));
						deploy.setWorkEnvApprovalList(workEnvApprovalList);
					}
				}
			}

			if (permissions.contains(TEST) && technology != null && !WORKFLOW.equalsIgnoreCase(technology)) {
				Test test = new Test();

				if (idp.getTestInfo() != null && idp.getTestInfo().getTestEnv() != null) {
					triggerInputs.setTest(test);
					List<TestEnv> testEnvs = idp.getTestInfo().getTestEnv();
					for (int i = 0; i < testEnvs.size(); i++) {
						if (null != testEnvs.get(i).getTestSteps() && !testEnvs.get(i).getTestSteps().isEmpty()) {
							testStatus = true;
							break;
						}
					}
					if (testStatus) {
						logger.info("test steps are found in the pipeline");
						List<String> envIntest = fetchJobDetails.getEnvironmentsTest(app, idp, userEnvs, userName);

						test.setTestEnv(envIntest);
						triggerInputs.setTest(test);
					}
				}
			}

			if (permissions.contains(DEPLOY) && permissions.contains(TEST) && (deployStatus && testStatus)
					&& technology != null && !WORKFLOW.equalsIgnoreCase(technology)) {
				logger.info("Deploy and test both are selected!!");
				List<String> envInDeployTest = fetchJobDetails.getEnvironmentsDeployTest(app, idp, userEnvs, userName);
				DeployTestEnv deployTestEnv = new DeployTestEnv();
				deployTestEnv.setEnv(envInDeployTest);
				deployTestEnv.setEnvObj(fetchJobDetails.getbizObj(idp, envInDeployTest));
				triggerInputs.setDeployTestEnv(deployTestEnv);
			}

			if (permissions.contains(DEPLOY) && permissions.contains(BUILD) && technology != null
					&& !WORKFLOW.equalsIgnoreCase(technology)) {

				List<String> envInDeploy = fetchJobDetails.getEnvironmentsDeploy(idp, userEnvs);
				List<BuildDeployEnv> buildDeployEnvList = new ArrayList<>();
				for (String releaseNum : releaseNumbers) {
					int releaseId = releaseDetails.getReleaseId(triggerInputs.getApplicationName(),
							triggerInputs.getPipelineName(), releaseNum, "on");
					List<String> commonEnvList = new ArrayList<>();
					int pathCount = environmentDetails.getPathCount(releaseId);
					if (pathCount > 0) {
						List<String> firstEnv = environmentDetails.getFirstEnv(releaseId);

						for (String env : firstEnv) {

							if (envInDeploy.stream().anyMatch(str -> str.equalsIgnoreCase(env))) {

								commonEnvList.add(env);
							}

						}
					} else {
						commonEnvList = envInDeploy;
					}
					BuildDeployEnv buildDeployEnv = new BuildDeployEnv();
					buildDeployEnv.setReleaseNumber(releaseNum);
					buildDeployEnv.setEnv(commonEnvList);
					buildDeployEnvList.add(buildDeployEnv);
				}

				triggerInputs.setBuildDeployEnv(buildDeployEnvList);

			}

			if (technology != null && !WORKFLOW.equalsIgnoreCase(technology)
					&& "git".equalsIgnoreCase(idp.getCode().getScm().get(0).getType())) {

				List<String> gitBranches = new ArrayList<>();
				gitBranches.add(idp.getCode().getScm().get(0).getBranch());
				triggerInputs.getBuild().setGitBranches(gitBranches);
				logger.debug("Git Branch is set");
			}
			if (null != triggerInputs.getBuild()) {
				triggerInputs.getBuild().setGitTag(gitSelected(idp.getCode().getScm()));
			}

			if (technology != null && !WORKFLOW.equalsIgnoreCase(technology)
					&& idp.getCode().getTechnology().equalsIgnoreCase("dbDeployDelphix")) {
				TriggerInputs triggerInputsNew = new TriggerInputs();
				List<String> dependentPipelines = idp.getBuildInfo().getPostBuildScript().getDependentPipelineList();
				List<DeployArtifact> artifactList = new ArrayList<>();
				for (int i = 0; i < dependentPipelines.size(); i++) {
					String depPipeline = dependentPipelines.get(i);
					idp = getJobDetails.getPipelineInfo(triggerJobName.getApplicationName(), depPipeline);
					triggerInputsNew = getNexus(triggerJobName, triggerInputs, idp, app, depPipeline);
					for (DeployArtifact artifact : triggerInputsNew.getArtifactList()) {
						artifactList.add(artifact);
					}
				}
				triggerInputs.setArtifactList(artifactList);
			} else if (technology != null && !WORKFLOW.equalsIgnoreCase(technology)) {
				triggerInputs = getNexus(triggerJobName, triggerInputs, idp, app, triggerJobName.getPipelineName());
			}
			return triggerInputs;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw e;

		}

	}

	/**
	 * 
	 * Checks approval of build 
	 * @param jobName
	 * @param jobType
	 * @param workEnv
	 * @return List<String>
	 */
	public List<String> checkApproval(String jobName, String jobType, String workEnv) {
		Integer buildNumber;
		Integer noOfBuildsToReview;
		String jsonResponse = "";
		String buildUrl;
		List<String> responsesForBuildNumbers = new ArrayList<>();
		if (BUILD.equalsIgnoreCase(jobType)) {
			jsonResponse = jobsBL.getJobJSON(jobName, "apprNext;BUILD");
			buildUrl = jobName + "_Build";
		} else {
			jsonResponse = jobsBL.getJobJSON(jobName, "apprNext;DEPLOY;" + workEnv + ";");
			buildUrl = jobName + "_Deploy_" + workEnv + "/job/" + jobName + "_Deploy_" + workEnv;
		}
		if (!"".equalsIgnoreCase(jsonResponse)) {
			JSONObject json = JSONObject.fromObject(jsonResponse);
			buildNumber = (int) json.getLong("nextBuildNumber");
			logger.info("Next Build Number :" + buildNumber);
			noOfBuildsToReview = Integer.parseInt(configmanager.getNoOfBuildsToreview());
			Integer startBuild;

			if (buildNumber <= noOfBuildsToReview)
				startBuild = 1;
			else
				startBuild = (int) (buildNumber - noOfBuildsToReview);
			logger.info("Start build set to " + startBuild);

			for (int i = startBuild; i < buildNumber; i++) {
				logger.info("Checking for the build no " + i);
				jsonResponse = jobsBL.getJobJSON(jobName, "/" + i + ";ApprovalCheck;" + buildUrl);
				if ("".equalsIgnoreCase(jsonResponse)) {
					logger.info("Build No " + i + " is not wating for job " + jobName + " Hence continuing");
					continue;
				} else {
					String response = jobsBL.getJobJSON(jobName, "/" + i + ";getJson;" + buildUrl);
					responsesForBuildNumbers.add(response);
				}

			}

		}

		return responsesForBuildNumbers;
	}

	/**
	 * Returns module build for pipeline
	 * @param json
	 * @param triggerInputs
	 * @param type
	 * @return List<ApproveBuild>
	 */
	public List<ApproveBuild> apprParamSet(List<String> json, TriggerInputs triggerInputs, String type) {

		List<ApproveBuild> appr = new ArrayList<>();

		for (int i = 0; i < json.size(); i++) {
			JSONObject jo = JSONObject.fromObject(json.get(i));
			ApproveBuild app = new ApproveBuild();
			if (jo.has("actions")) {
				JSONArray actionJsonArr = jo.getJSONArray("actions");
				logger.info(actionJsonArr.toString());

				int actionJsonArrSize = actionJsonArr.size();
				for (int z = 0; z < actionJsonArrSize; z++) {
					JSONObject actionJson = (JSONObject) actionJsonArr.get(z);
					if (actionJson.has("parameters")) {
						JSONArray parametersJsonArr = actionJson.getJSONArray("parameters");
						logger.info(parametersJsonArr.toString());
						String buildNo = "";
						String releaseNo = "";
						String moduleList = "";
						String userInfo = "";

						int parametersJsonArrSize = parametersJsonArr.size();
						for (int j = 0; j < parametersJsonArrSize; j++) {
							JSONObject parameterJson = (JSONObject) parametersJsonArr.get(j);

							if ("PIPELINE_BUILD_ID".equalsIgnoreCase((String) parameterJson.get("name"))) {
								buildNo = (String) parameterJson.get("value");
								app.setApprBuildNo(buildNo);
							}
							if ("MODULE_LIST".equalsIgnoreCase((String) parameterJson.get("name"))) {
								moduleList = " Executing Modules: " + parameterJson.get("value") + "";

								app.setModuleList(moduleList);

							}
							if ("USER_INFO".equalsIgnoreCase((String) parameterJson.get("name"))) {
								String userInfoT = (String) parameterJson.get("value");
								userInfo = " Executed by: " + userInfoT.split(";")[0];

								app.setUserInfo(userInfo);

							}

							if ("RELEASE_IDENTIFIER".equalsIgnoreCase((String) parameterJson.get("name"))) {
								releaseNo = (String) parameterJson.get("value");

								app.setReleaseIdentifier(releaseNo);

							}

						}

					}

				}
				appr.add(app);
			}
		}

		return appr;
	}

	/**
	 * Checks if nexus is selected
	 * @param idp
	 * @return boolean
	 */
	public boolean isNexusSelected(IDPJob idp) {
		if (idp.getBuildInfo() != null && idp.getBuildInfo().getArtifactToStage() != null
				&& idp.getBuildInfo().getArtifactToStage().getArtifactRepoName() != null
				&& !idp.getBuildInfo().getArtifactToStage().getArtifactRepoName().equalsIgnoreCase("na")
				&& !idp.getBuildInfo().getArtifactToStage().getArtifactRepoName().equalsIgnoreCase("")) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Returns nexus or artifactory details for trigger job
	 * @param triggerJobName
	 * @param triggerInputs
	 * @param idp
	 * @param app
	 * @param pipelineName
	 * @return TriggerInputs
	 */

	public TriggerInputs getNexus(TriggerJobName triggerJobName, TriggerInputs triggerInputs, IDPJob idp,
			ApplicationInfo app, String pipelineName) {

		boolean artifact = false;
		String userName = null;
		String passWord = null;
		String nexusURL = null;
		String repoName = null;
		String artifactType = null;

		List<DeployArtifact> arList = new ArrayList<>();
		if (idp.getBuildInfo() != null && idp.getBuildInfo().getArtifactToStage() != null
				&& idp.getBuildInfo().getArtifactToStage().getArtifactRepoName() != null
				&& !idp.getBuildInfo().getArtifactToStage().getArtifactRepoName().equalsIgnoreCase("na")
				&& !idp.getBuildInfo().getArtifactToStage().getArtifactRepoName().equalsIgnoreCase("")) {
			userName = idp.getBuildInfo().getArtifactToStage().getArtifactRepo().getRepoUsername();
			passWord = idp.getBuildInfo().getArtifactToStage().getArtifactRepo().getRepoPassword();
			nexusURL = idp.getBuildInfo().getArtifactToStage().getArtifactRepo().getRepoURL();
			repoName = idp.getBuildInfo().getArtifactToStage().getArtifactRepo().getRepoName();
			artifactType = idp.getBuildInfo().getArtifactToStage().getArtifactRepoName();
			artifact = true;

		} else if ((idp.getBuildInfo() != null && idp.getBuildInfo().getArtifactToStage() != null
				&& (idp.getBuildInfo().getArtifactToStage().getArtifactRepoName() == null
						|| idp.getBuildInfo().getArtifactToStage().getArtifactRepoName().equalsIgnoreCase(""))
				|| (idp.getBuildInfo() != null && idp.getBuildInfo().getArtifactToStage() == null))) {
			if (app.getArtifactToStage() != null && app.getArtifactToStage().getArtifactRepo() != null
					&& !app.getArtifactToStage().getArtifactRepoName().equalsIgnoreCase("na")
					&& !app.getArtifactToStage().getArtifactRepoName().equalsIgnoreCase("")) {
				userName = app.getArtifactToStage().getArtifactRepo().getRepoUsername();
				passWord = app.getArtifactToStage().getArtifactRepo().getRepoPassword();
				nexusURL = app.getArtifactToStage().getArtifactRepo().getRepoURL();
				repoName = app.getArtifactToStage().getArtifactRepo().getRepoName();
				artifactType = app.getArtifactToStage().getArtifactRepoName();
				artifact = true;
			}
		}
		if (idp.getCode().getTechnology().equalsIgnoreCase("J2EE/Ant") && app.getArtifactToStage() != null
				&& app.getArtifactToStage().getArtifactRepo() != null
				&& !app.getArtifactToStage().getArtifactRepoName().equalsIgnoreCase("na")
				&& !app.getArtifactToStage().getArtifactRepoName().equalsIgnoreCase("")) {
			userName = app.getArtifactToStage().getArtifactRepo().getRepoUsername();
			passWord = app.getArtifactToStage().getArtifactRepo().getRepoPassword();
			nexusURL = app.getArtifactToStage().getArtifactRepo().getRepoURL();
			repoName = app.getArtifactToStage().getArtifactRepo().getRepoName();
			artifactType = app.getArtifactToStage().getArtifactRepoName();
			artifact = true;

		}
		if (artifact) {
			if (artifactType.equalsIgnoreCase("nexus")) {
				String urlToHit = "http://" + nexusURL + "/service/siesta/rest/beta/search?repository=" + repoName
						+ "&group=" + triggerJobName.getApplicationName() + "&name=" + pipelineName;
				triggerInputs.setRepoName(repoName);
				triggerInputs.setNexusURL(nexusURL);

				String response = this.getInputStream(userName, passWord, urlToHit);
				Gson gson = new Gson();
				Nexus nexus = gson.fromJson(response, Nexus.class);
				logger.debug(gson.toJson(nexus));
				if (nexus != null && nexus.getItems() != null && (nexus.getItems().size() != 0)) {
					for (int i = 0; i < nexus.getItems().size(); i++) {
						DeployArtifact d1 = new DeployArtifact();
						d1.setArtifactID(nexus.getItems().get(i).getName());
						d1.setGroupId(nexus.getItems().get(i).getGroup());
						d1.setVersion(nexus.getItems().get(i).getVersion());
						d1.setDownloadURL(nexus.getItems().get(i).getAssets().get(0).getDownloadUrl());
						d1.setArtifactName(nexus.getItems().get(i).getGroup() + "_" + nexus.getItems().get(i).getName()
								+ "_" + nexus.getItems().get(i).getVersion());

						List<List> tpt = getJobDetails.getTriggerEntity(triggerJobName.getApplicationName(),
								pipelineName, d1.getVersion());

						d1.setTimestamp("NA");

						d1.setEnvironment("NA");
						d1.setUserInfo("NA");

						if (tpt.size() == 0) {
							logger.info("No trigger entity!");
						} else {
							int tptSize = tpt.size();
							for (int j = 0; j < tptSize; j++) {

								TriggerParameters tp = (TriggerParameters) tpt.get(j).get(0);
								String timestamp = (String) tpt.get(j).get(1);
								if ((tp.getDeploy() != null && tp.getDeploy().getDeployArtifact() != null
										&& tp.getDeploy().getDeployArtifact().getArtifactName() != null
										&& tp.getDeploy().getDeployArtifact().getArtifactName()
												.endsWith("latestArtifact")
										&& tp.getDeploy().getDeployArtifact().getRepoName().equals(repoName))) {

									try {
										List tps = getJobDetails.getTriggerEntitytime(
												triggerJobName.getApplicationName(), pipelineName, d1.getVersion());

										if (tps != null) {
											tp = (TriggerParameters) tps.get(0);
											timestamp = (String) tps.get(1);

											String env = "NA";
											d1.setUserInfo(tp.getUserName());
											if (tp.getDeploy() != null) {
												env = tp.getEnvSelected();
												d1.setTimestamp(timestamp);
											}
											d1.setEnvironment(env);

											break;

										}
									} catch (Exception e) {
										logger.error(e.getLocalizedMessage());
									}
								}
								if (tp.getDeploy() != null && tp.getDeploy().getDeployArtifact() != null
										&& tp.getDeploy().getDeployArtifact().getArtifactName() != null
										&& tp.getDeploy().getDeployArtifact().getArtifactName()
												.equalsIgnoreCase(d1.getArtifactName())) {

									String env = "NA";
									d1.setUserInfo(tp.getUserName());
									if (tp.getDeploy() != null) {
										env = tp.getEnvSelected();
										d1.setTimestamp(timestamp);
									}
									d1.setEnvironment(env);

									break;
								}

							}
							if (null == d1.getBuildModulesList()) {
								List tpsb = getJobDetails.getTriggerEntitytime(triggerJobName.getApplicationName(),
										pipelineName, d1.getVersion());
								List<String> module = new ArrayList<>();
								if (tpsb != null) {
									TriggerParameters tpb = (TriggerParameters) tpsb.get(0);
									if (tpb.getBuild() != null) {
										if (tpb.getBuild().getModule() != null
												&& tpb.getBuild().getModule().size() > 0) {
											module = tpb.getBuild().getModule();
											d1.setBuildModulesList(module);
										}
									}

								}
							}
							arList.add(d1);
						}

					}
				}

			} else if (artifactType.equalsIgnoreCase("jfrog")) {

				String urlToHit = nexusURL + "/api/storage/" + repoName + "/" + pipelineName
						+ "?list&deep=1&listFolders=0";
				if (!urlToHit.startsWith("http")) {
					urlToHit = "http://" + urlToHit;
				}
				triggerInputs.setRepoName(repoName);
				triggerInputs.setNexusURL(nexusURL);

				String response = this.getInputStream(userName, passWord, urlToHit);
				Gson gson = new Gson();
				ArtifactoryArtifacts artifacts = gson.fromJson(response, ArtifactoryArtifacts.class);
				logger.debug(gson.toJson(artifacts));

				if (artifacts != null && artifacts.getFiles() != null && (artifacts.getFiles().size() != 0)) {
					for (int i = 0; i < artifacts.getFiles().size(); i++) {
						DeployArtifact d1 = new DeployArtifact();
						ArtifactoryFile artifactoryFile = artifacts.getFiles().get(i);
						String[] pathSplit = artifactoryFile.getUri().split("\\/");

						d1.setArtifactID(pathSplit[1]);
						d1.setGroupId("");
						d1.setVersion(pathSplit[1].split("-")[2]);
						logger.info("Artifact version :  " + d1.getArtifactID());
						d1.setDownloadURL(nexusURL + "/" + repoName + "/" + pipelineName + artifactoryFile.getUri());
						d1.setArtifactName(triggerInputs.getApplicationName() + "_" + triggerInputs.getPipelineName()
								+ "_" + pathSplit[1]);

						List<List> tpt = getJobDetails.getTriggerEntity(triggerJobName.getApplicationName(),
								pipelineName, d1.getVersion());

						d1.setTimestamp("NA");

						d1.setEnvironment("NA");
						d1.setUserInfo("NA");

						if ((tpt.size() == 0)) {
							logger.info("No trigger entity!");

						} else {
							int tptSize = tpt.size();
							for (int j = 0; j < tptSize; j++) {

								TriggerParameters tp = (TriggerParameters) tpt.get(j).get(0);
								String timestamp = (String) tpt.get(j).get(1);
								if ((tp.getDeploy() != null && tp.getDeploy().getDeployArtifact() != null
										&& tp.getDeploy().getDeployArtifact().getArtifactName() != null
										&& tp.getDeploy().getDeployArtifact().getArtifactName()
												.endsWith("latestArtifact")
										&& tp.getDeploy().getDeployArtifact().getRepoName().equals(repoName))) {

									try {
										List tps = getJobDetails.getTriggerEntitytime(
												triggerJobName.getApplicationName(), pipelineName, d1.getVersion());

										if (tps != null) {
											tp = (TriggerParameters) tps.get(0);
											timestamp = (String) tps.get(1);

											String env = "NA";
											d1.setUserInfo(tp.getUserName());
											if (tp.getDeploy() != null) {
												env = tp.getEnvSelected();
												d1.setTimestamp(timestamp);
											}
											d1.setEnvironment(env);

											break;

										}
									} catch (Exception e) {
										logger.error(e.getLocalizedMessage());
									}
								}
								if (tp.getDeploy() != null && tp.getDeploy().getDeployArtifact() != null
										&& tp.getDeploy().getDeployArtifact().getArtifactName() != null
										&& tp.getDeploy().getDeployArtifact().getArtifactName()
												.equalsIgnoreCase(d1.getArtifactName())) {

									String env = "NA";
									d1.setUserInfo(tp.getUserName());
									if (tp.getDeploy() != null) {
										env = tp.getEnvSelected();
										d1.setTimestamp(timestamp);
									}
									d1.setEnvironment(env);

									break;
								}

							}
							if (null == d1.getBuildModulesList()) {
								List tpsb = getJobDetails.getTriggerEntitytime(triggerJobName.getApplicationName(),
										pipelineName, d1.getVersion());
								List<String> module = new ArrayList<>();
								if (tpsb != null) {
									TriggerParameters tpb = (TriggerParameters) tpsb.get(0);
									if (tpb.getBuild() != null && tpb.getBuild().getModule() != null
											&& tpb.getBuild().getModule().size() > 0) {
										module = tpb.getBuild().getModule();
										d1.setBuildModulesList(module);
									}

								}
							}
							arList.add(d1);
						}

					}
				}

			}
		} else {

			triggerInputs.setRepoName("na");

		}
		triggerInputs.setArtifactList(arList);

		return triggerInputs;
	}

	/**
	 * Returns response stream of url request
	 * 
	 * @param userName
	 * @param passWord
	 * @param urltohit
	 * @return String
	 */
	public String getInputStream(String userName, String passWord, String urltohit) {

		String urlToHit = urltohit;

		String authString = userName + ":" + passWord;

		String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes());
		BufferedReader br = null;
		InputStream is = null;
		InputStreamReader isr = null;
		URL url;
		try {
			url = new URL(urlToHit);

			URLConnection urlconnection = url.openConnection();
			urlconnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			is = urlconnection.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			String response = "";
			String line = br.readLine();
			while (line != null) {
				response += line + "\n";
				line = br.readLine();
			}
			return response;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (null != br) {
					br.close();
				}
				if (null != is) {
					is.close();
				}
				if (null != isr) {
					isr.close();
				}
			} catch (Exception e2) {
				logger.error(e2.getMessage(), e2);
			}

		}
		return null;

	}

	/**
	 * checks if repository is git
	 * @param scm
	 * @return String
	 */
	private String gitSelected(List<Scm> scm) {

		String flag = "off";
		if (scm == null)
			return flag;

		for (Scm scmSection : scm) {
			if ("git".equalsIgnoreCase(scmSection.getType())) {
				flag = "on";
				return flag;
			}
		}

		return flag;
	}

	/**
	 * 
	 * Returnsting artifact details
	 *
	 * @param pipelineName    the String
	 * @param applicationName the String
	 * @param user            the String
	 *
	 * @return List<DeployArtifact>
	 * 
	 */
	public List<DeployArtifact> getArtifactDetails(String pipelineName, String applicationName) {

		List<DeployArtifact> deployArtifacts = new ArrayList<>();
		DeployArtifact deployArtifact;

		try {
			if (getJobDetails.getTriggerCount(applicationName, pipelineName) == 0) {
				deployArtifact = new DeployArtifact();
				deployArtifact.setArtifactID(applicationName + "_" + pipelineName);
				deployArtifact.setVersion("1");
				deployArtifacts.add(deployArtifact);
			} else {
				deployArtifacts = getJobDetails.getArtifactDetails(pipelineName, applicationName);
			}
		} catch (SQLException e) {

			logger.error("Error in getting the deploy artifacts", e);
			logger.debug(e.getMessage());
		}

		return deployArtifacts;
	}

	/**
	 * 
	 * Fetching all permissions
	 *
	 * @param applicationName the String
	 * @param user            the String
	 *
	 * @return permission the List<String>
	 * 
	 */
	public List<String> getPermissions(String applicationName, String user) {

		List<String> permission = new ArrayList<>();
		try {
			permission = getJobDetails.getPermissions(user, applicationName);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		return permission;

	}

	/**
	 * 
	 * returns build info
	 * 
	 * @param idp        the IDPJob
	 * @param technology the String
	 * 
	 * @return build the Build
	 */
	public Build getBuildInfo(IDPJob idp, String technology) {
		Build build = new Build();
		switch (technology) {
		case "dotNetCsharp":
		case "dotNetVb":
		case "dotNet":
		case "general":
		case "J2EE/Ant":
		case "ant":
			build.setModules(setModules(idp));
			break;

		case "J2EE/Maven":
			build.setSubModules(setSubModules(idp));
			break;
		default:
			break;
		}
		return build;
	}

	/**
	 * 
	 * Returns Slave Details
	 *
	 * @param app the ApplicationInfo
	 *
	 * @return slaveNames the List<String>
	 * 
	 */
	public List<String> getSlaveDetails(ApplicationInfo app, IDPJob idp) {
		List<SlavesDetail> slaves = app.getSlavesDetails();
		List<String> slaveNames = new ArrayList<>();
		int slaveSize = slaves.size();
		for (int i = 0; i < slaveSize; i++) {
			if (slaves.get(i).getBuildServerOS().equalsIgnoreCase(idp.getBasicInfo().getBuildServerOS())) {
				slaveNames.add(slaves.get(i).getSlaveName());

			}

		}
		return slaveNames;
	}

	/**
	 * 
	 * Returns Slave Details
	 *
	 * @param app the ApplicationInfo, idp IDPJob
	 *
	 * @return all slaves of the application the List<SlavesDetail>
	 * 
	 */
	public List<SlavesDetail> getAppSlaveDetails(ApplicationInfo app, IDPJob idp) {
		List<SlavesDetail> slaves = app.getSlavesDetails();
		List<SlavesDetail> slaveListOsDependent = new ArrayList<>();
		int slavesSize = slaves.size();
		for (int i = 0; i < slavesSize; i++) {
			// OS dependent slave List
			if (slaves.get(i).getBuildServerOS().equalsIgnoreCase(idp.getBasicInfo().getBuildServerOS())) {
				slaveListOsDependent.add(slaves.get(i));
			}

		}
		return slaveListOsDependent;
	}

	/**
	 * 
	 * set modules for build
	 * 
	 * @param idp the IDPJob
	 * @return modulesNames the List<String>
	 */
	public List<org.infy.entities.triggerinputs.Module> setModules(IDPJob idp) {

		List<Module> modules = idp.getBuildInfo().getModules();
		List<org.infy.entities.triggerinputs.Module> modulesNames = new ArrayList<>();
		org.infy.entities.triggerinputs.Module module;
		logger.info("module size " + modules.size());

		int modulesSize = modules.size();
		for (int i = 0; i < modulesSize; i++) {
			module = new org.infy.entities.triggerinputs.Module();
			module.setModuleName(modules.get(i).getModuleName());
			module.setDefaultModule(modules.get(i).getDefaultModule());
			modulesNames.add(module);
		}
		logger.info(
				"modules for the pipeline " + idp.getBasicInfo().getPipelineName() + " : " + modulesNames.toString());
		return modulesNames;
	}

	/**
	 * Returns modules for job
	 * @param idp
	 * @return List<org.infy.entities.triggerinputs.SubModule>
	 */
	public List<org.infy.entities.triggerinputs.SubModule> setSubModules(IDPJob idp) {

		List<SubModule> subModules = null;
		List<org.infy.entities.triggerinputs.SubModule> subModulesNames = new ArrayList<>();
		if (null != idp.getBuildInfo().getSubModule()) {
			subModules = idp.getBuildInfo().getSubModule();

			org.infy.entities.triggerinputs.SubModule subModule;
			int subModulesSize = subModules.size();
			for (int i = 0; i < subModulesSize; i++) {
				subModule = new org.infy.entities.triggerinputs.SubModule();
				subModule.setModuleName(subModules.get(i).getModuleName());
				subModule.setDefaultModule(subModules.get(i).getDefaultModule());
				subModulesNames.add(subModule);

			}
		}
		return subModulesNames;

	}

	/**
	 * Check if code analysis is selected
	 * @param idp
	 * @return boolean
	 */

	public boolean isCodeAnalysisEnabled(IDPJob idp) {

		if (null == idp.getBuildInfo().getModules().get(0).getCodeAnalysis()
				|| idp.getBuildInfo().getModules().get(0).getCodeAnalysis().isEmpty()
				|| "".equalsIgnoreCase(idp.getBuildInfo().getModules().get(0).getCodeAnalysis().get(0))) {
			logger.info("code analysis is not selected for the pipeline : " + idp.getBasicInfo().getPipelineName());
			return false;
		} else {
			logger.info("code analysis is selected.");
			return true;
		}

	}

	/**
	 * Checks if unit testing is selected
	 * @param idp
	 * @return boolean
	 */
	public boolean isUnitTestingEnabled(IDPJob idp) {

		if (null == idp.getBuildInfo().getModules().get(0).getUnitTesting()
				|| idp.getBuildInfo().getModules().get(0).getUnitTesting().isEmpty()
				|| "".equalsIgnoreCase(idp.getBuildInfo().getModules().get(0).getUnitTesting())
				|| "off".equalsIgnoreCase(idp.getBuildInfo().getModules().get(0).getUnitTesting())) {
			logger.info("unit testing is not selected for the pipeline : " + idp.getBasicInfo().getPipelineName());
			return false;
		} else {
			logger.info("unit testing is selected.");
			return true;
		}

	}

	

	/**
	 * Returns gitlab branch and tag 
	 * 
	 * @param repoUrl
	 * @param username
	 * @param pwd
	 * @param projectUrl
	 * @return ArrayList<ArrayList<String>>
	 */
	public ArrayList<ArrayList<String>> gitLabbranchesTagsFetcher(String repoUrl, String username, String pwd,
			String projectUrl) {

		String token = "";
		int id = 0;
		ArrayList<ArrayList<String>> list = null;

		try {
			list = new ArrayList<ArrayList<String>>();
			token = gitLabBranchTagFetcher.getPrivateToken(repoUrl, username, pwd);
			id = gitLabBranchTagFetcher.getId(token, repoUrl, projectUrl);
			ArrayList<String> branchList = gitLabBranchTagFetcher.getBranch(id, repoUrl, token);
			ArrayList<String> tagList = gitLabBranchTagFetcher.getTag(id, repoUrl, token);
			list.add(branchList);
			list.add(tagList);
			logger.info(branchList.toString());
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
		}
		return list;

	}

	/**
	 * Return branch and tag for github
	 * 
	 * @param repoUrl
	 * @param username
	 * @param pwd
	 * @param projectUrl
	 * @param proxy
	 * @param port
	 * @return List<ArrayList<String>>
	 */
	public List<ArrayList<String>> gitHubBranchesTagsFetcher(GitHubBrachModel branchModel) {

		List<ArrayList<String>> list = null;
		try {
			list = new ArrayList<ArrayList<String>>();
			list = gitHubBranchTagFetcher.getBranchList(branchModel);

		} catch (Exception e) {

			logger.error(e.getMessage(), e);

		}
		return list;
	}

	/**
	 * Return branch and tag for bitbucket
	 * 
	 * @param repoUrl
	 * @param username
	 * @param pwd
	 * @param projectUrl
	 * @param proxy
	 * @param port
	 * @return List<ArrayList<String>>
	 */
	public List<ArrayList<String>> bitBucketbranchesTagsFetcher(String repoUrl, String username, String pwd,
			String projectUrl, String proxy, String port) {

		List<ArrayList<String>> list = null;
		try {
			list = new ArrayList<ArrayList<String>>();
			list = bitBucketBranchTagFetcher.getBranchList(repoUrl, username, pwd, projectUrl, proxy, port);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return list;
	}

	/**
	 * Return branch and tag for TFS
	 * 
	 * @param repoUrl
	 * @param projPath
	 * @param username
	 * @param pwd
	 * @return ArrayList<String>
	 */

	public ArrayList<String> branchFetcher(String repoUrl, String projPath, String username, String pwd) {

		ArrayList<String> list = null;

		list = new ArrayList<>();

		try {
			list = tFSBranchFetcher.getAllBranches(repoUrl, projPath, "1.0", username, pwd);
			if (list == null) {
				list = new ArrayList<>();
			}
		} catch (JSONException | NullPointerException e) {

			logger.error(e.getMessage(), e);
		}
		return list;
	}

	/**
	 * 
	 * Fetch Trigger Steps
	 * 
	 * @param appName      the Application Name
	 * @param pipelineName the Pipeline Name
	 * @param envName      the Environment Selected
	 * 
	 * @return TriggerInputs with deploy and test Steps set
	 */
	public Steps fecthTriggerSteps(String appName, String pipelineName, String envName) {

		Steps steps = new Steps();
		List<DeployStep> deploySteps = null;
		List<TestStep> testSteps = null;

		try {
			IDPJob idp = getJobDetails.getPipelineInfo(appName, pipelineName);
			List<DeployEnv> deployEnvs = idp.getDeployInfo().getDeployEnv();
			List<TestEnv> testEnvs = idp.getTestInfo().getTestEnv();

			int deployEnvSize = deployEnvs.size();
			for (int i = 0; i < deployEnvSize; i++) {
				if (deployEnvs.get(i).getEnvName().equalsIgnoreCase(envName)
						&& (null != deployEnvs.get(i).getDeploySteps()
								&& !deployEnvs.get(i).getDeploySteps().isEmpty())) {
					deploySteps = deployEnvs.get(i).getDeploySteps();
					steps.setDeploySteps(getDeployStep(deploySteps));
				}

			}
			for (int i = 0; i < testEnvs.size(); i++) {
				if (testEnvs.get(i).getEnvName().equalsIgnoreCase(envName)
						&& (null != testEnvs.get(i).getTestSteps() && !testEnvs.get(i).getTestSteps().isEmpty())) {
					testSteps = testEnvs.get(i).getTestSteps();
					steps.setTestSteps(getTestStep(testSteps));
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return steps;
	}

	/**
	 * Returns deploy step
	 * 
	 * @param list
	 * @return ArrayList<String>
	 */
	private ArrayList<String> getDeployStep(List<DeployStep> list) {
		ArrayList<String> arrayList = new ArrayList<>();
		for (DeployStep tempDeploy : list) {
			arrayList.add(tempDeploy.getStepName());
		}
		return arrayList;
	}

	/**
	 * Returns test steps
	 * 
	 * @param list
	 * @return ArrayList<TestSteps>
	 */
	private ArrayList<TestSteps> getTestStep(List<TestStep> list) {
		ArrayList<TestSteps> arrayList = new ArrayList<>();
		for (TestStep tempDeploy : list) {
			TestSteps testSteps = new TestSteps();
			testSteps.setStepName(tempDeploy.getStepName());
			if (tempDeploy.getTest() != null && tempDeploy.getTest().getTestTypeName() != null
					&& !tempDeploy.getTest().getTestTypeName().equals("")) {
				testSteps.setToolName(tempDeploy.getTest().getTestTypeName());
			} else {
				testSteps.setToolName("na");
			}

			arrayList.add(testSteps);
		}
		return arrayList;
	}

	/**
	 * Returns pairs for environment for job
	 * 
	 * @param idp
	 * @param envName
	 * @return List<String>
	 */
	public List<String> getPairNames(IDPJob idp, String envName) {
		logger.info("inside get trigger details");
		Gson gson = new Gson();
		List<String> pairnames = new ArrayList<>();
		logger.info("idp json " + gson.toJson(idp));
		List<DeployEnv> deployEnvs = idp.getDeployInfo().getDeployEnv();

		for (DeployEnv deployEnv : deployEnvs) {
			logger.info("deployenv : " + gson.toJson(deployEnv));
			if (envName.equalsIgnoreCase(deployEnv.getEnvName())) {
				int depStepsSize = deployEnv.getDeploySteps().size();
				for (int i = 0; i < depStepsSize; i++) {
					pairnames.add(deployEnv.getDeploySteps().get(i).getDeployToContainer().getPairName());
					logger.info("added pairname : "
							+ deployEnv.getDeploySteps().get(i).getDeployToContainer().getPairName());
				}
				break;
			}

		}
		return pairnames;
	}

}
