/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.businessapi;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.infy.entities.triggerinputs.TriggerInputs;
import org.infy.entities.triggerinputs.TriggerJobName;
import org.infy.idp.dataapi.base.PostGreSqlDbContext;
import org.infy.idp.entities.jobs.IDPJob;
import org.infy.idp.entities.jobs.applicationinfo.ApplicationInfo;
import org.infy.idp.entities.nexus.Item;
import org.infy.idp.entities.nexus.Nexus;
import org.infy.idp.utils.ConfigurationManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

import jtest.AppContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppContext.class)
public class NexusGetTriggerDetails {

	@Spy
	@InjectMocks
	private PostGreSqlDbContext postGreSqlDbContext;

	@Spy
	@Autowired
	private ConfigurationManager configurationManager;

	@Spy
	@InjectMocks
	private TriggerDetailBL testedObject;

	/**
	 * Constructor for test class.
	 *
	 */
	public NexusGetTriggerDetails() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	@Test
	public void getTriggerdetailsgetNexus() {

		Gson g = new Gson();
		TriggerJobName triggerJobName = new TriggerJobName();
		TriggerInputs t1 = new TriggerInputs();
		String ab = "{\"basicInfo\":{\"applicationName\":\"Nexus_Sanity\",\"pipelineName\":\"Nexus_DotNet\",\"buildServerOS\":\"windows\",\"engine\":\"Jenkins Workflow\",\"buildInterval\":{\"pollSCM\":\"off\",\"buildInterval\":\"\",\"buildIntervalValue\":\"0\"},\"additionalMailRecipients\":{\"applicationTeam\":\"\",\"emailIds\":\"\"}},\"code\":{\"category\":\"Standard\",\"technology\":\"dotNetCsharp\",\"scm\":[{\"type\":\"tfs\",\"url\":\"http://tfs2013-farm01:8080/tfs/QTOOLS\",\"userName\":\"harshita.badlani\",\"password\":\"svplh18282708*\",\"projPath\":\"$/ToolsGroupDevelopment/ReservationSystem_2013\"}],\"buildScript\":[{\"tool\":\"\"},{\"tool\":\"\"},{}]},\"buildInfo\":{\"buildtool\":\"msBuild\",\"artifactToStage\":{\"artifact\":\"**/*.dll\",\"artifactRepo\":{\"repoURL\":\"localhost:8081\",\"repoName\":\"idp_Nexus\",\"repoUsername\":\"admin\",\"repoPassword\":\"admin123\"},\"artifactRepoName\":\"nexus\"},\"castAnalysis\":{},\"modules\":[{\"version\":\"(Default)\",\"moduleName\":\"ReservationSystem\",\"relativePath\":\"ReservationSystem_2013/ReservationSystem.sln\",\"codeAnalysis\":[]}],\"postBuildScript\":{}},\"deployInfo\":{\"deployEnv\":[{\"envName\":\"DEV\",\"deploySteps\":[{\"stepName\":\"step1\",\"deployOS\":\"\",\"runScript\":{\"scriptType\":\"batchScript\",\"scriptFilePath\":\"echo.bat\",\"targets\":\"\",\"host\":\"\",\"userName\":\"\",\"password\":\"\",\"script\":\"\",\"pathToFiles\":\"\",\"destinationDir\":\"\",\"flattenFilePath\":\"off\"},\"deployToContainer\":{\"containerName\":\"\"}}]}]},\"testInfo\":{\"testEnv\":[{\"envName\":\"DEV\",\"envFlag\":\"off\"}]}}";
		IDPJob idp = g.fromJson(ab, IDPJob.class);
		String abc = "{\"applicationName\":\"Nexus_Sanity\",\"pipelineAdmins\":\"chirag.sharma,kudaka_vijayakumar\",\"releaseManager\":\"idpadmin\",\"slavesDetails\":[{\"labels\":\"Nexus_slave\",\"slaveName\":\"Nexus_slave\",\"buildServerOS\":\"windows\",\"workspacePath\":\"D:/NexusSlave\",\"slaveUsage\":\"both\",\"createNewSlave\":\"on\"}],\"developers\":\"idpadmin\",\"sapApplication\":\"off\",\"environmentOwnerDetails\":[{\"qa\":\"idpadmin\",\"environmentName\":\"DEV\",\"environmentOwners\":\"idpadmin,kudaka_vijayakumar\"},{\"environmentName\":\"Stage\",\"environmentOwners\":\"farneet.khehra\"},{\"environmentName\":\"Stage3\",\"environmentOwners\":\"idpadmin\"}],\"artifactToStage\":{\"artifactRepo\":{\"repoURL\":\"localhost:8081\",\"repoUsername\":\"admin\",\"repoPassword\":\"admin123\",\"repoName\":\"idp_Nexus\"},\"artifactRepoName\":\"nexus\"}}";
		ApplicationInfo app = g.fromJson(abc, ApplicationInfo.class);

		t1 = testedObject.getNexus(triggerJobName, t1, idp, app, "Nexus_DotNet");
		TriggerInputs t2 = new TriggerInputs();
		t2.setRepoName("idp_Nexus");

		assertEquals(t2.getRepoName(), t1.getRepoName());

	}

	@Test
	public void getTriggerdetailsgetNexus2() {

		Gson g = new Gson();
		TriggerJobName triggerJobName = new TriggerJobName();
		TriggerInputs t1 = new TriggerInputs();
		String ab = "{\"basicInfo\":{\"applicationName\":\"Nexus_Sanity\",\"pipelineName\":\"Nexus_DotNet\",\"buildServerOS\":\"windows\",\"engine\":\"Jenkins Workflow\",\"buildInterval\":{\"pollSCM\":\"off\",\"buildInterval\":\"\",\"buildIntervalValue\":\"0\"},\"additionalMailRecipients\":{\"applicationTeam\":\"\",\"emailIds\":\"\"}},\"code\":{\"category\":\"Standard\",\"technology\":\"dotNetCsharp\",\"scm\":[{\"type\":\"tfs\",\"url\":\"http://tfs2013-farm01:8080/tfs/QTOOLS\",\"userName\":\"harshita.badlani\",\"password\":\"svplh18282708*\",\"projPath\":\"$/ToolsGroupDevelopment/ReservationSystem_2013\"}],\"buildScript\":[{\"tool\":\"\"},{\"tool\":\"\"},{}]},\"buildInfo\":{\"buildtool\":\"msBuild\",\"artifactToStage\":{\"artifact\":\"**/*.dll\",\"artifactRepo\":{\"repoURL\":\"localhost:8081\",\"repoName\":\"idp_Nexus\",\"repoUsername\":\"admin\",\"repoPassword\":\"admin123\"},\"artifactRepoName\":\"nexus\"},\"castAnalysis\":{},\"modules\":[{\"version\":\"(Default)\",\"moduleName\":\"ReservationSystem\",\"relativePath\":\"ReservationSystem_2013/ReservationSystem.sln\",\"codeAnalysis\":[]}],\"postBuildScript\":{}},\"deployInfo\":{\"deployEnv\":[{\"envName\":\"DEV\",\"deploySteps\":[{\"stepName\":\"step1\",\"deployOS\":\"\",\"runScript\":{\"scriptType\":\"batchScript\",\"scriptFilePath\":\"echo.bat\",\"targets\":\"\",\"host\":\"\",\"userName\":\"\",\"password\":\"\",\"script\":\"\",\"pathToFiles\":\"\",\"destinationDir\":\"\",\"flattenFilePath\":\"off\"},\"deployToContainer\":{\"containerName\":\"\"}}]}]},\"testInfo\":{\"testEnv\":[{\"envName\":\"DEV\",\"envFlag\":\"off\"}]}}";
		IDPJob idp = g.fromJson(ab, IDPJob.class);
		String abc = "{\"applicationName\":\"Nexus_Sanity\",\"pipelineAdmins\":\"chirag.sharma,kudaka_vijayakumar\",\"releaseManager\":\"idpadmin\",\"slavesDetails\":[{\"labels\":\"Nexus_slave\",\"slaveName\":\"Nexus_slave\",\"buildServerOS\":\"windows\",\"workspacePath\":\"D:/NexusSlave\",\"slaveUsage\":\"both\",\"createNewSlave\":\"on\"}],\"developers\":\"idpadmin\",\"sapApplication\":\"off\",\"environmentOwnerDetails\":[{\"qa\":\"idpadmin\",\"environmentName\":\"DEV\",\"environmentOwners\":\"idpadmin,kudaka_vijayakumar\"},{\"environmentName\":\"Stage\",\"environmentOwners\":\"farneet.khehra\"},{\"environmentName\":\"Stage3\",\"environmentOwners\":\"idpadmin\"}],\"artifactToStage\":{\"artifactRepo\":{\"repoURL\":\"localhost:8081\",\"repoUsername\":\"admin\",\"repoPassword\":\"admin123\",\"repoName\":\"idp_Nexus\"},\"artifactRepoName\":\"na\"}}";
		ApplicationInfo app = g.fromJson(abc, ApplicationInfo.class);

		t1 = testedObject.getNexus(triggerJobName, t1, idp, app, "Nexus_DotNet");
		TriggerInputs t2 = new TriggerInputs();
		t2.setRepoName("idp_Nexus");

		assertEquals(t2.getRepoName(), t1.getRepoName());

	}

	@Test
	public void getTriggerdetailsgetNexus3() {

		Gson g = new Gson();
		TriggerJobName triggerJobName = new TriggerJobName();
		TriggerInputs t1 = new TriggerInputs();
		String ab = "{\"basicInfo\":{\"applicationName\":\"Nexus_Sanity\",\"pipelineName\":\"Nexus_DotNet\",\"buildServerOS\":\"windows\",\"engine\":\"Jenkins Workflow\",\"buildInterval\":{\"pollSCM\":\"off\",\"buildInterval\":\"\",\"buildIntervalValue\":\"0\"},\"additionalMailRecipients\":{\"applicationTeam\":\"\",\"emailIds\":\"\"}},\"code\":{\"category\":\"Standard\",\"technology\":\"dotNetCsharp\",\"scm\":[{\"type\":\"tfs\",\"url\":\"http://tfs2013-farm01:8080/tfs/QTOOLS\",\"userName\":\"harshita.badlani\",\"password\":\"svplh18282708*\",\"projPath\":\"$/ToolsGroupDevelopment/ReservationSystem_2013\"}],\"buildScript\":[{\"tool\":\"\"},{\"tool\":\"\"},{}]},\"buildInfo\":{\"buildtool\":\"msBuild\",\"artifactToStage\":{\"artifact\":\"**/*.dll\",\"artifactRepo\":{\"repoURL\":\"localhost:8081\",\"repoName\":\"na\",\"repoUsername\":\"admin\",\"repoPassword\":\"admin123\"},\"artifactRepoName\":\"na\"},\"castAnalysis\":{},\"modules\":[{\"version\":\"(Default)\",\"moduleName\":\"ReservationSystem\",\"relativePath\":\"ReservationSystem_2013/ReservationSystem.sln\",\"codeAnalysis\":[]}],\"postBuildScript\":{}},\"deployInfo\":{\"deployEnv\":[{\"envName\":\"DEV\",\"deploySteps\":[{\"stepName\":\"step1\",\"deployOS\":\"\",\"runScript\":{\"scriptType\":\"batchScript\",\"scriptFilePath\":\"echo.bat\",\"targets\":\"\",\"host\":\"\",\"userName\":\"\",\"password\":\"\",\"script\":\"\",\"pathToFiles\":\"\",\"destinationDir\":\"\",\"flattenFilePath\":\"off\"},\"deployToContainer\":{\"containerName\":\"\"}}]}]},\"testInfo\":{\"testEnv\":[{\"envName\":\"DEV\",\"envFlag\":\"off\"}]}}";
		IDPJob idp = g.fromJson(ab, IDPJob.class);
		String abc = "{\"applicationName\":\"Nexus_Sanity\",\"pipelineAdmins\":\"chirag.sharma,kudaka_vijayakumar\",\"releaseManager\":\"idpadmin\",\"slavesDetails\":[{\"labels\":\"Nexus_slave\",\"slaveName\":\"Nexus_slave\",\"buildServerOS\":\"windows\",\"workspacePath\":\"D:/NexusSlave\",\"slaveUsage\":\"both\",\"createNewSlave\":\"on\"}],\"developers\":\"idpadmin\",\"sapApplication\":\"off\",\"environmentOwnerDetails\":[{\"qa\":\"idpadmin\",\"environmentName\":\"DEV\",\"environmentOwners\":\"idpadmin,kudaka_vijayakumar\"},{\"environmentName\":\"Stage\",\"environmentOwners\":\"farneet.khehra\"},{\"environmentName\":\"Stage3\",\"environmentOwners\":\"idpadmin\"}],\"artifactToStage\":{\"artifactRepo\":{\"repoURL\":\"localhost:8081\",\"repoUsername\":\"admin\",\"repoPassword\":\"admin123\",\"repoName\":\"na\"},\"artifactRepoName\":\"na\"}}";
		ApplicationInfo app = g.fromJson(abc, ApplicationInfo.class);

		t1 = testedObject.getNexus(triggerJobName, t1, idp, app, "Nexus_DotNet");
		TriggerInputs t2 = new TriggerInputs();
		t2.setRepoName("na");

		assertEquals(t2.getRepoName(), t1.getRepoName());

	}

	@Test
	public void getInputStream() {

		String url = "http://localhost:8081/service/siesta/rest/beta/search?repository=idp_Nexus&group=Nexuhs_fun&name=Job_nkexus";
		String admin = "admin";
		String password = "admin123";
		String t1 = testedObject.getInputStream(admin, password, url);
		Gson gson = new Gson();
		Nexus nexus = gson.fromJson(t1, Nexus.class);
		Nexus nx = new Nexus();
		List<Item> it = new ArrayList<Item>();
		nx.setItems(it);
		String t3 = gson.toJson(nexus);
		String t2 = gson.toJson(nx);
		assertEquals(t2, t3);

	}

	/**
	 * Used to set up the test. This method is called by JUnit before each of the
	 * tests are executed.
	 * 
	 * @author Infosys
	 */
	@Before
	public void setUp() throws Exception {
		/*
		 * Add any necessary initialization code here (e.g., open a socket). Call
		 * Repository.putTemporary() to provide initialized instances of objects to be
		 * used when testing.
		 */

		try {

			MockitoAnnotations.initMocks(this);
			Method postConstruct = PostGreSqlDbContext.class.getDeclaredMethod("init", null); // methodName,parameters
			postConstruct.setAccessible(true);
			postConstruct.invoke(postGreSqlDbContext);

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Utility main method. Runs the test cases defined in this test class.
	 * 
	 * Usage: java JobDetailsDLTest
	 * 
	 * @param args command line arguments are not needed
	 */
	public static void main(String[] args) {
		

		org.junit.runner.JUnitCore.main("org.infy.idp.businessapi.NexusGetTriggerDetails");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 */
	public Class getTestedClass() {
		return TriggerDetailBL.class;
	}

}
