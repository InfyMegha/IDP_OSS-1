/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.triggerparameter;


import java.util.ArrayList;

import org.infy.entities.triggerinputs.PackageTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hardik.rathod01
 *
 */
public class TriggerDetailsTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public TriggerDetailsTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	@Test
	public void testTriggerDertails() throws Throwable {

		TriggerDetails triggerDetails = new TriggerDetails();
		triggerDetails.setAppId("app");
		triggerDetails.setApplicationName("app");
		triggerDetails.setArtifactorySelected("true");
		triggerDetails.setBranchOrTag("branch");
		ArrayList<Boolean> branchOrTagList = new ArrayList<>();
		triggerDetails.setBranchOrTagList(branchOrTagList);
		triggerDetails.setBranchOrTagValue("value");
		Build build = new Build();
		triggerDetails.setBuild(build);
		triggerDetails.setBuildartifactNumber("number");
		triggerDetails.setCastSlaveName("slave");
		triggerDetails.setClient("client");
		triggerDetails.setDashBoardLink("dashboard");
		triggerDetails.setDbOperations("operation");
		Deploy deploy = new Deploy();
		triggerDetails.setDeploy(deploy);
		triggerDetails.setDeployDB("db");
		triggerDetails.setDepParam("param");
		triggerDetails.setEmailed("email");
		triggerDetails.setEnvSelected("dev");
		triggerDetails.setErrorCode("404");
		triggerDetails.setGitTag("tag");
		triggerDetails.setInstance("instance");
		triggerDetails.setJobBuildId("1");

		ArrayList<JobParamTrigger> jobParam = new ArrayList<>();
		triggerDetails.setJobParam(jobParam);
		triggerDetails.setLanguage("english");
		triggerDetails.setLanscapeName("land");
		triggerDetails.setMtmProjectName("mtm");
		triggerDetails.setMtmStepName("mtm");
		triggerDetails.setNonRepoDeployStatus("non");
		triggerDetails.setNotify("notify");
		triggerDetails.setNugetPackaging(true);
		triggerDetails.setPassword("pwd");
		triggerDetails.setPipelineName("pip");
		triggerDetails.setPipId("pip");
		triggerDetails.setReleaseNumber("1.0");
		triggerDetails.setRepoDeployStatus("success");
		triggerDetails.setRestoreDB("db");
		triggerDetails.setRmAssemblies("rm");
//		triggerDetails.setSapUserName("admin");
		triggerDetails.setScmBranch("scm");
		triggerDetails.setSlaveName("slave");
		triggerDetails.setSonardashBoardLink("dashboard");
		triggerDetails.setSubApplicationName("sub");
		triggerDetails.setSystemName("system");
		triggerDetails.setTechnology("angular");
		triggerDetails.setTestPlanId("id");
		triggerDetails.setTestSelected("test");
		triggerDetails.setTestSlaveName("slave");
		ArrayList<String> testStep = new ArrayList<>();
		triggerDetails.setTestStep(testStep);
		triggerDetails.setTestSuitId("id");
		/*Remove VSTS ALM
		triggerDetails.setTfsWorkItem("tfs");
		*/
		ArrayList<String> transportRequest = new ArrayList<>();
		triggerDetails.setTransportRequest(transportRequest);
		triggerDetails.setTriggerId(101);
		triggerDetails.setUsePreviousArtifact("yes");
		triggerDetails.setUserName("admin");
		triggerDetails.setUserStories("55918");

		assertEquals("app", triggerDetails.getAppId());
		assertEquals("pip", triggerDetails.getPipId());
		assertEquals("mtm", triggerDetails.getMtmProjectName());
		assertEquals("scm", triggerDetails.getScmBranch());
		assertEquals("101", triggerDetails.getTriggerId()+"");
		/*Remove VSTS ALM
		assertEquals("tfs", triggerDetails.getTfsWorkItem());
		*/
		assertEquals("mtm", triggerDetails.getMtmStepName());
		assertEquals("id", triggerDetails.getTestPlanId());
		assertEquals("id", triggerDetails.getTestSuitId());
		assertEquals(jobParam, triggerDetails.getJobParam());
		assertEquals("db", triggerDetails.getDeployDB());
		assertEquals("db", triggerDetails.getRestoreDB());
		assertEquals("branch", triggerDetails.getBranchOrTag());
		assertEquals("operation", triggerDetails.getDbOperations());
		assertEquals("sub", triggerDetails.getSubApplicationName());
		assertEquals("rm", triggerDetails.getRmAssemblies());
		assertEquals("param", triggerDetails.getDepParam());
		assertEquals("success", triggerDetails.getRepoDeployStatus());
		assertEquals("non", triggerDetails.getNonRepoDeployStatus());
		assertEquals("value", triggerDetails.getBranchOrTagValue());
		assertTrue(triggerDetails.getNugetPackaging());
		assertEquals(branchOrTagList, triggerDetails.getBranchOrTagList());
		assertEquals("notify", triggerDetails.getNotify());
		assertEquals("land", triggerDetails.getLanscapeName());
		assertEquals("dashboard", triggerDetails.getSonardashBoardLink());
		assertEquals("instance", triggerDetails.getInstance());
		assertEquals("client", triggerDetails.getClient());
//		assertEquals("admin", triggerDetails.getSapUserName());
		assertEquals("pwd", triggerDetails.getPassword());
		assertEquals("angular", triggerDetails.getTechnology());
		assertEquals("english", triggerDetails.getLanguage());
		assertEquals("55918", triggerDetails.getUserStories());
		assertEquals("system", triggerDetails.getSystemName());
		assertEquals(transportRequest, triggerDetails.getTransportRequest());
		assertEquals("dashboard", triggerDetails.getDashBoardLink());
		assertEquals("404", triggerDetails.getErrorCode());
		assertEquals("1", triggerDetails.getJobBuildId());
		assertEquals(testStep, triggerDetails.getTestStep());
		assertEquals("email", triggerDetails.getEmailed());
		assertEquals("app", triggerDetails.getApplicationName());
		assertEquals("pip", triggerDetails.getPipelineName());
		assertEquals("1.0", triggerDetails.getReleaseNumber());
		assertEquals("admin", triggerDetails.getUserName());
		assertEquals("slave", triggerDetails.getSlaveName());
		assertEquals("dev", triggerDetails.getEnvSelected());
		assertEquals(build, triggerDetails.getBuild());
		assertEquals(deploy, triggerDetails.getDeploy());
		assertEquals("test", triggerDetails.getTestSelected());
		assertEquals("tag", triggerDetails.getGitTag());
		assertEquals("yes", triggerDetails.getUsePreviousArtifact());
		assertEquals("number", triggerDetails.getBuildartifactNumber());
		assertEquals("true", triggerDetails.getArtifactorySelected());
		assertEquals("slave", triggerDetails.getTestSlaveName());
		assertEquals("slave", triggerDetails.getCastSlaveName());

	}

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

	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.triggerparameter.TriggerDetailsTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */

	@SuppressWarnings("rawtypes")
	public Class getTestedClass() {
		return TriggerDetails.class;
	}

}
