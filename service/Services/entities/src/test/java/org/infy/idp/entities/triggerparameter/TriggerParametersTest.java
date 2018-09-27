/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.triggerparameter;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TriggerParametersTest is a test class for TriggerParameters
 *
 * @see org.infy.idp.entities.triggerparameter.TriggerParameters
 * 
 */
public class TriggerParametersTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public TriggerParametersTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method getBuild().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerParameters#getBuild()
	 * 
	 * 
	 */
	@Test
	public void testGetBuild0() throws Throwable {
		TriggerParameters testedObject = new TriggerParameters();
		Build result = testedObject.getBuild();
		assertEquals(null, result);
	}

	/**
	 * Test for method getDeploy().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerParameters#getDeploy()
	 * 
	 * 
	 */
	@Test
	public void testGetDeploy0() throws Throwable {
		TriggerParameters testedObject = new TriggerParameters();
		Deploy result = testedObject.getDeploy();
		assertEquals(null, result);
	}

	/**
	 * Test for method TriggerParameters().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerParameters#TriggerParameters()
	 * 
	 * 
	 */
	@Test
	public void testTriggerParameters0() throws Throwable {
		List<String> testSteps = new ArrayList<>();
		testSteps.add("testStep22");
		TriggerParameters testedObject = new TriggerParameters();
		testedObject.setDashBoardLink("dashBoardLink22");
		testedObject.setErrorCode("errorCode22");
		testedObject.setJobBuildId("jobBuildId22");
		testedObject.setTestStep((ArrayList<String>) testSteps);
		testedObject.setEmailed("emailed22");
		testedObject.setApplicationName("applicationName22");
		testedObject.setPipelineName("pipelineName22");
		testedObject.setReleaseNumber("releaseNumber22");
		testedObject.setUserName("userName22");
		testedObject.setSlaveName("slaveName22");
		testedObject.setEnvSelected("envSelected22");
		Build build = new Build();
		testedObject.setBuild(build);
		Deploy deploy = new Deploy();
		testedObject.setDeploy(deploy);
		testedObject.setTestSelected("testSelected21");
		List<String> outTestSteps = new ArrayList<>();
		outTestSteps.add("testStep22");
		testedObject.setJobType("type");
		testedObject.setApprInput("input");
		testedObject.setApprComment("comment");
		testedObject.setApprBuildNo("1");
		testedObject.setApprStepName("step");
		testedObject.setReleaseManagers("manager");
		testedObject.setLandscapeType("type");
		testedObject.setSrcEnv("dev");
		testedObject.setFileName("file");
		testedObject.setPairName("dev-sit");
		testedObject.setAppId("id");
		ArrayList<ApplicationDetails> pipelines = new ArrayList<>();
		testedObject.setPipelines(pipelines);
		testedObject.setPipId("id");
		testedObject.setMtmProjectName("mtm");
		testedObject.setScmBranch("scm");
		testedObject.setTriggerId(101);
		testedObject.setMtmStepName("mtm");
		testedObject.setTestPlanId("id");
		testedObject.setTestSuitId("id");
		ArrayList<JobParamTrigger> jobParam = new ArrayList<>();
		testedObject.setJobParam(jobParam);
		testedObject.setDeployDB("db");
		testedObject.setRestoreDB("db");
		testedObject.setBranchOrTag("branch");
		testedObject.setDbOperations("operation");
		testedObject.setSubApplicationName("sub");
		testedObject.setRmAssemblies("rm");
		testedObject.setDepParam("param");
		testedObject.setRepoDeployStatus("success");
		testedObject.setNonRepoDeployStatus("non");
		testedObject.setNugetPackaging(true);
		testedObject.setBranchOrTagValue("value");
		ArrayList<Boolean> branchOrTagList = new ArrayList<>();
		testedObject.setBranchOrTagList(branchOrTagList);
		testedObject.setNotify("notify");
		testedObject.setLanscapeName("land");
		testedObject.setSystemId("id");
		testedObject.setSonardashBoardLink("dashboard");
		testedObject.setInstance("instance");
		testedObject.setClient("client");
		testedObject.setPassword("pwd");
		testedObject.setTechnology("angular");
		testedObject.setLanguage("english");
		testedObject.setUserStories("55918");
		testedObject.setSystemName("system");
		ArrayList<String> transportRequest = new ArrayList<>();
		testedObject.setTransportRequest(transportRequest);
		testedObject.setCopyTR(true);
		testedObject.setGitTag("git");
		testedObject.setUsePreviousArtifact("yes");
		testedObject.setBuildartifactNumber("number");
		testedObject.setArtifactorySelected("yes");
		testedObject.setTestSlaveName("slave");
		testedObject.setCastSlaveName("slave");
		assertEquals("type", testedObject.getJobType());
		assertEquals("input", testedObject.getApprInput());
		assertEquals("comment", testedObject.getApprComment());
		assertEquals("1", testedObject.getApprBuildNo());
		assertEquals("step", testedObject.getApprStepName());
		assertEquals("manager", testedObject.getReleaseManagers());
		assertEquals("type", testedObject.getLandscapeType());
		assertEquals("dev", testedObject.getSrcEnv());
		assertEquals("file", testedObject.getFileName());
		assertEquals("dev-sit", testedObject.getPairName());
		assertEquals("id", testedObject.getAppId());
		assertEquals(pipelines, testedObject.getPipelines());
		assertEquals("id", testedObject.getPipId());
		assertEquals("mtm", testedObject.getMtmProjectName());
		assertEquals("scm", testedObject.getScmBranch());
		assertEquals("101", testedObject.getTriggerId() + "");
		assertEquals("mtm", testedObject.getMtmStepName());
		assertEquals("id", testedObject.getTestPlanId());
		assertEquals("id", testedObject.getTestSuitId());
		assertEquals(jobParam, testedObject.getJobParam());
		assertEquals("db", testedObject.getDeployDB());
		assertEquals("db", testedObject.getRestoreDB());
		assertEquals("branch", testedObject.getBranchOrTag());
		assertEquals("operation", testedObject.getDbOperations());
		assertEquals("sub", testedObject.getSubApplicationName());
		assertEquals("rm", testedObject.getRmAssemblies());
		assertEquals("param", testedObject.getDepParam());
		assertEquals("success", testedObject.getRepoDeployStatus());
		assertEquals("non", testedObject.getNonRepoDeployStatus());
		assertEquals("value", testedObject.getBranchOrTagValue());
		assertTrue(testedObject.getNugetPackaging());
		assertEquals(branchOrTagList, testedObject.getBranchOrTagList());
		assertEquals("notify", testedObject.getNotify());
		assertEquals("land", testedObject.getLanscapeName());
		assertEquals("id", testedObject.getSystemId());
		assertEquals("dashboard", testedObject.getSonardashBoardLink());
		assertEquals("instance", testedObject.getInstance());
		assertEquals("client", testedObject.getClient());

		assertEquals("pwd", testedObject.getPassword());
		assertEquals("angular", testedObject.getTechnology());
		assertEquals("english", testedObject.getLanguage());
		assertEquals("55918", testedObject.getUserStories());
		assertEquals("system", testedObject.getSystemName());
		assertEquals(transportRequest, testedObject.getTransportRequest());
		assertTrue(testedObject.getCopyTR());
		assertEquals("git", testedObject.getGitTag());
		assertEquals("yes", testedObject.getUsePreviousArtifact());
		assertEquals("number", testedObject.getBuildartifactNumber());
		assertEquals("yes", testedObject.getArtifactorySelected());
		assertEquals("slave", testedObject.getTestSlaveName());
		assertEquals("slave", testedObject.getCastSlaveName());

		assertEquals(build, testedObject.getBuild()); // jtest_unverified
		assertEquals(deploy, testedObject.getDeploy()); // jtest_unverified
		assertEquals("applicationName22", testedObject.getApplicationName()); // jtest_unverified
		assertEquals("envSelected22", testedObject.getEnvSelected()); // jtest_unverified
		assertEquals("pipelineName22", testedObject.getPipelineName()); // jtest_unverified
		assertEquals("userName22", testedObject.getUserName()); // jtest_unverified
		assertEquals("emailed22", testedObject.getEmailed()); // jtest_unverified
		assertEquals(outTestSteps, testedObject.getTestStep()); // jtest_unverified
		assertEquals("dashBoardLink22", testedObject.getDashBoardLink()); // jtest_unverified
		assertEquals("slaveName22", testedObject.getSlaveName()); // jtest_unverified
		assertEquals("errorCode22", testedObject.getErrorCode()); // jtest_unverified
		assertEquals("testSelected21", testedObject.getTestSelected()); // jtest_unverified
		assertEquals("releaseNumber22", testedObject.getReleaseNumber()); // jtest_unverified
		assertEquals("jobBuildId22", testedObject.getJobBuildId()); // jtest_unverified
	}

	/**
	 * Test for method TriggerParameters().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerParameters#TriggerParameters()
	 * 
	 * 
	 */
	@Test
	public void testTriggerParameters11() throws Throwable {
		List<String> inTestSteps = new ArrayList<>();
		inTestSteps.add("testSelected0");
		inTestSteps.add("testStep1");
		TriggerParameters testedObject = new TriggerParameters();
		testedObject.setDashBoardLink("dashBoardLink1");
		testedObject.setErrorCode("errorCode1");
		testedObject.setJobBuildId("jobBuildId1");
		testedObject.setTestStep((ArrayList<String>) inTestSteps);
		testedObject.setEmailed("emailed1");
		testedObject.setApplicationName("applicationName1");
		testedObject.setPipelineName("pipelineName1");
		testedObject.setReleaseNumber("releaseNumber1");
		testedObject.setUserName("userName1");
		testedObject.setSlaveName("slaveName1");
		testedObject.setEnvSelected("envSelected1");
		testedObject.setBuild((Build) null);
		testedObject.setDeploy((Deploy) null);
		testedObject.setTestSelected("testSelected0");
		List<String> outTestSteps = new ArrayList<>();
		outTestSteps.add("testSelected0");
		outTestSteps.add("testStep1");
		assertEquals(null, testedObject.getBuild()); // jtest_unverified
		assertEquals(null, testedObject.getDeploy()); // jtest_unverified
		assertEquals("applicationName1", testedObject.getApplicationName()); // jtest_unverified
		assertEquals("envSelected1", testedObject.getEnvSelected()); // jtest_unverified
		assertEquals("pipelineName1", testedObject.getPipelineName()); // jtest_unverified
		assertEquals("userName1", testedObject.getUserName()); // jtest_unverified
		assertEquals("emailed1", testedObject.getEmailed()); // jtest_unverified
		assertEquals(outTestSteps, testedObject.getTestStep()); // jtest_unverified
		assertEquals("dashBoardLink1", testedObject.getDashBoardLink()); // jtest_unverified
		assertEquals("slaveName1", testedObject.getSlaveName()); // jtest_unverified
		assertEquals("errorCode1", testedObject.getErrorCode()); // jtest_unverified
		assertEquals("testSelected0", testedObject.getTestSelected()); // jtest_unverified
		assertEquals("releaseNumber1", testedObject.getReleaseNumber()); // jtest_unverified
		assertEquals("jobBuildId1", testedObject.getJobBuildId()); // jtest_unverified
	}

	/**
	 * Test for method TriggerParameters().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerParameters#TriggerParameters()
	 * 
	 * 
	 */
	@Test
	public void testTriggerParameters12() throws Throwable {
		List<String> testSteps = new ArrayList<>();
		testSteps.add("testStep0");
		TriggerParameters testedObject = new TriggerParameters();
		testedObject.setDashBoardLink("dashBoardLink0");
		testedObject.setErrorCode("errorCode0");
		testedObject.setJobBuildId("jobBuildId0");
		testedObject.setTestStep((ArrayList<String>) testSteps);
		testedObject.setEmailed("emailed0");
		testedObject.setApplicationName("applicationName0");
		testedObject.setPipelineName("pipelineName0");
		testedObject.setReleaseNumber("releaseNumber0");
		testedObject.setUserName("userName0");
		testedObject.setSlaveName("slaveName0");
		testedObject.setEnvSelected("envSelected0");
		testedObject.setBuild((Build) null);
		testedObject.setDeploy((Deploy) null);
		testedObject.setTestSelected((String) null);
		List<String> outTestSteps = new ArrayList<>();
		outTestSteps.add("testStep0");
		assertEquals(null, testedObject.getBuild()); // jtest_unverified
		assertEquals(null, testedObject.getDeploy()); // jtest_unverified
		assertEquals("applicationName0", testedObject.getApplicationName()); // jtest_unverified
		assertEquals("envSelected0", testedObject.getEnvSelected()); // jtest_unverified
		assertEquals("pipelineName0", testedObject.getPipelineName()); // jtest_unverified
		assertEquals("userName0", testedObject.getUserName()); // jtest_unverified
		assertEquals("emailed0", testedObject.getEmailed()); // jtest_unverified
		assertEquals(outTestSteps, testedObject.getTestStep()); // jtest_unverified
		assertEquals("dashBoardLink0", testedObject.getDashBoardLink()); // jtest_unverified
		assertEquals("slaveName0", testedObject.getSlaveName()); // jtest_unverified
		assertEquals("errorCode0", testedObject.getErrorCode()); // jtest_unverified
		assertEquals(null, testedObject.getTestSelected()); // jtest_unverified
		assertEquals("releaseNumber0", testedObject.getReleaseNumber()); // jtest_unverified
		assertEquals("jobBuildId0", testedObject.getJobBuildId()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method TriggerParameters().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerParameters#TriggerParameters()
	 * 
	 * 
	 */
	@Test
	public void testTriggerParameters13() throws Throwable {
		TriggerParameters testedObject = new TriggerParameters();
		assertEquals(null, testedObject.getBuild()); // jtest_unverified
		assertEquals(null, testedObject.getDeploy()); // jtest_unverified
		assertEquals(null, testedObject.getApplicationName()); // jtest_unverified
		assertEquals(null, testedObject.getEnvSelected()); // jtest_unverified
		assertEquals(null, testedObject.getPipelineName()); // jtest_unverified
		assertEquals(null, testedObject.getUserName()); // jtest_unverified
		assertEquals(null, testedObject.getEmailed()); // jtest_unverified
		assertEquals(null, testedObject.getTestStep()); // jtest_unverified
		assertEquals(null, testedObject.getDashBoardLink()); // jtest_unverified
		assertEquals(null, testedObject.getSlaveName()); // jtest_unverified
		assertEquals(null, testedObject.getErrorCode()); // jtest_unverified
		assertEquals(null, testedObject.getTestSelected()); // jtest_unverified
		assertEquals(null, testedObject.getReleaseNumber()); // jtest_unverified
		assertEquals(null, testedObject.getJobBuildId()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Used to set up the test. This method is called by JUnit before each of the
	 * tests are executed.
	 * 
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		/*
		 * Add any necessary initialization code here (e.g., open a socket). Call
		 * Repository.putTemporary() to provide initialized instances of objects to be
		 * used when testing.
		 */
		super.setUp();
		// jtest.Repository.putTemporary("name", object);

	}

	/**
	 * Used to clean up after the test. This method is called by JUnit after each of
	 * the tests have been completed.
	 * 
	 * 
	 */
	@After
	public void tearDown() throws Exception {
		/*
		 * Add any necessary cleanup code here (e.g., close a socket).
		 */
		super.tearDown();
	}

	/**
	 * Utility main method. Runs the test cases defined in this test class.
	 * 
	 * Usage: java TriggerParametersTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.triggerparameter.TriggerParametersTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<TriggerParameters> getTestedClass() {
		return TriggerParameters.class;
	}
}
// JTEST_CURRENT_ID=-1935033386.