/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.entities.triggerinputs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.infy.idp.entities.jobs.applicationinfo.SlavesDetail;
import org.infy.idp.entities.triggerparameter.ApplicationDetails;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TriggerInputsTest is a test class for TriggerInputs
 *
 * @see org.infy.entities.triggerinputs.TriggerInputs
 * 
 */
public class TriggerInputsTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public TriggerInputsTest() {
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
	 * @see TriggerInputs#getBuild()
	 * 
	 * 
	 */
	@Test
	public void testGetBuild0() throws Throwable {
		TriggerInputs testedObject = new TriggerInputs();
		Build result = testedObject.getBuild();
		assertEquals(null, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * 
	 * Test for Set Function
	 * 
	 */

	@Test
	public void testSet() throws Throwable {

		TriggerInputs testedObject = new TriggerInputs();
		testedObject.setApplicationName(null);
		testedObject.setBuild(null);
		testedObject.setDeploy(null);
		testedObject.setDeployTestEnv(null);
		testedObject.setJobStatus(null);
		testedObject.setPermissions(null);
		testedObject.setReleaseNumber(null);
		testedObject.setRoles(null);
		testedObject.setSlaves(null);
		testedObject.setTest(null);
		testedObject.setUserName(null);
		testedObject.setPipelineName(null);

	}

	/**
	 * Test for method getDeploy().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerInputs#getDeploy()
	 * 
	 * 
	 */
	@Test
	public void testGetDeploy0() throws Throwable {
		TriggerInputs testedObject = new TriggerInputs();
		Deploy result = testedObject.getDeploy();
		assertEquals(null, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method getDeployTestEnv().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerInputs#getDeployTestEnv()
	 * 
	 * 
	 */
	@Test
	public void testGetDeployTestEnv0() throws Throwable {
		TriggerInputs testedObject = new TriggerInputs();
		DeployTestEnv result = testedObject.getDeployTestEnv();
		assertEquals(null, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method getPermissions().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerInputs#getPermissions()
	 * 
	 * 
	 */
	@Test
	public void testGetPermissions0() throws Throwable {
		TriggerInputs testedObject = new TriggerInputs();
		List result = testedObject.getPermissions();
		assertEquals(null, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method getRoles().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerInputs#getRoles()
	 * 
	 * 
	 */
	@Test
	public void testGetRoles0() throws Throwable {
		TriggerInputs testedObject = new TriggerInputs();
		List result = testedObject.getRoles();
		assertEquals(null, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method getSlaves().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerInputs#getSlaves()
	 * 
	 * 
	 */
	@Test
	public void testGetSlaves0() throws Throwable {
		TriggerInputs testedObject = new TriggerInputs();
		List result = testedObject.getSlaves();
		assertEquals(null, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method TriggerInputs().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerInputs#TriggerInputs()
	 * 
	 * 
	 */
	@Test
	public void testTriggerInputs12() throws Throwable {
		TriggerInputs testedObject = new TriggerInputs();
		assertEquals(null, testedObject.getPermissions()); // jtest_unverified
		assertEquals(null, testedObject.getDeployTestEnv()); // jtest_unverified
		assertEquals(null, testedObject.getBuild()); // jtest_unverified
		assertEquals(null, testedObject.getSlaves()); // jtest_unverified
		assertEquals(null, testedObject.getDeploy()); // jtest_unverified
		assertEquals(null, testedObject.getRoles()); // jtest_unverified
		assertEquals(null, testedObject.getTest()); // jtest_unverified
		assertEquals(null, testedObject.getJobStatus()); // jtest_unverified
		assertEquals(null, testedObject.getUserName()); // jtest_unverified
		assertEquals(null, testedObject.getPipelineName()); // jtest_unverified
		assertEquals(null, testedObject.getReleaseNumber()); // jtest_unverified
		assertEquals(null, testedObject.getApplicationName()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	@Test
	public void testTriggerInputs() throws Throwable {
		TriggerInputs testedObject = new TriggerInputs();
		DeployArtifact artifact = new DeployArtifact();
//		testedObject.setJiraProjectKey("MCAIN");
		testedObject.setDeployStep("tomcat");
		ArrayList<String> listString = new ArrayList<>();
		listString.add("release1");
		HashMap<String, List<String>> hashrelease = new HashMap<>();
		hashrelease.put("one", listString);
		testedObject.setReleaseBranches(hashrelease);
		testedObject.setScmType("git");
		testedObject.setSubApplicationName("app");
		ArrayList<String> listBranch = new ArrayList<>();
		listBranch.add("master");
		testedObject.setBranchList(listBranch);
		testedObject.setTagList(listString);
		testedObject.setNexusURL("idpwinv05:8081");
		testedObject.setRepoName("idp_Nexus");
		artifact.setArtifactID("101");
		artifact.setArtifactName("artifact1");
		ArrayList<DeployArtifact> deployArtifact = new ArrayList<>();
		deployArtifact.add(artifact);
		testedObject.setArtifactList(deployArtifact);
		testedObject.setSystemNames(listString);
		testedObject.setEnvironment("dev");
		testedObject.setSshAndDependent("ssh");
		Set<String> set = new HashSet<>();
		String[] array = { "foo", "bar", "baz" };

		Collections.addAll(set, array);
		testedObject.setRelaseList(set);
		/*
		 * Remove VSTS ALM testedObject.setUserStory("55918");
		 */
		testedObject.setTechnology("Angular");
		ArrayList<BuildDeployEnv> listBuildDeploy = new ArrayList<>();
		BuildDeployEnv be = new BuildDeployEnv();
		be.setEnv(listString);
		be.setReleaseNumber("101");
		listBuildDeploy.add(be);
		testedObject.setBuildDeployEnv(listBuildDeploy);
		SlavesDetail slaveDetail = new SlavesDetail();
		slaveDetail.setBuildServerOS("linux");
		slaveDetail.setBuild("build");
		slaveDetail.setDeploy("deploy");
		ArrayList<SlavesDetail> listSlaveDetails = new ArrayList<>();
		listSlaveDetails.add(slaveDetail);
		testedObject.setAppSlaves(listSlaveDetails);

//		TriggerDetails trigger=new TriggerDetails();
//		trigger.setAppId("app1");
//		trigger.setApplicationName("15Dec");

		ApplicationDetails appDetails = new ApplicationDetails();

		ArrayList<ApplicationDetails> listTrigger = new ArrayList<>();
		listTrigger.add(appDetails);
		testedObject.setPipelines(listTrigger);

//		assertEquals("MCAIN",testedObject.getJiraProjectKey());
		assertEquals("tomcat", testedObject.getDeployStep());
		assertEquals(hashrelease, testedObject.getReleaseBranches());
		assertEquals("git", testedObject.getScmType());
		assertEquals(listBranch, testedObject.getBranchList());
		assertEquals("app", testedObject.getSubApplicationName());
		assertEquals(listString, testedObject.getTagList());
		assertEquals("idpwinv05:8081", testedObject.getNexusURL());
		assertEquals("idp_Nexus", testedObject.getRepoName());
		assertEquals(deployArtifact, testedObject.getArtifactList());
		assertEquals(listString, testedObject.getSystemNames());
		assertEquals("dev", testedObject.getEnvironment());
		assertEquals("ssh", testedObject.getSshAndDependent());
		assertEquals(set, testedObject.getRelaseList());
		/*
		 * Remove VSTS ALM assertEquals("55918",testedObject.getUserStory());
		 */
		assertEquals("Angular", testedObject.getTechnology());
		assertEquals(listBuildDeploy, testedObject.getBuildDeployEnv());
		assertEquals(listSlaveDetails, testedObject.getAppSlaves());
		assertEquals(listTrigger, testedObject.getPipelines());

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
		try {
			/*
			 * Add any necessary cleanup code here (e.g., close a socket).
			 */
		} finally {
			super.tearDown();
		}
	}

	/**
	 * Utility main method. Runs the test cases defined in this test class.
	 * 
	 * Usage: java TriggerInputsTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.entities.triggerinputs.TriggerInputsTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class getTestedClass() {
		return TriggerInputs.class;
	}
}
// JTEST_CURRENT_ID=1568702564.