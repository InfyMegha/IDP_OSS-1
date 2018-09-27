/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.triggerparameter;

import java.util.ArrayList;

import org.infy.entities.triggerinputs.DeployArtifact;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DeployTest is a test class for Deploy
 *
 * @see org.infy.idp.entities.triggerparameter.Deploy
 * 
 */
public class DeployTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public DeployTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method Deploy().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Deploy#Deploy()
	 * 
	 * 
	 */
	@Test
	public void testDeploy0() throws Throwable {
		Deploy testedObject = new Deploy();
		testedObject.setVersion("version12");
		testedObject.setArtifactID("artifactID12");
		testedObject.setNexusId("nexusId11");
		testedObject.setDestEnvOwner("owner");
		testedObject.setPassword("pwd");
		testedObject.setSrcEnv("dev");
		testedObject.setAllEnvOwner("owner");
		testedObject.setDestLandscape("land");
		testedObject.setPairName("dev-sit");
		testedObject.setSourceEnvName("dev");
		testedObject.setManifestFileName("export");
		ArrayList<String> deployModule = new ArrayList<>();
		testedObject.setDeployModule(deployModule);
		ArrayList<String> deployStep = new ArrayList<>();
		testedObject.setDeployStep(deployStep);
		DeployArtifact deployArtifact = new DeployArtifact();
		testedObject.setDeployArtifact(deployArtifact);
		testedObject.setDeploymentType("type");
		testedObject.setDbDeployOperation("deploy");
		testedObject.setDbDeployRollbackType("type");
		testedObject.setDbDeployRollbackValue("value");
		testedObject.setDbDeployFailSafe("safe");
		testedObject.setDbDeployPipelineOwners("owner");
		testedObject.setDbDeployPipelineList("pepiline");

		assertEquals("owner", testedObject.getDestEnvOwner());
		assertEquals("pwd", testedObject.getPassword());
		assertEquals("dev", testedObject.getSrcEnv());
		assertEquals("owner", testedObject.getAllEnvOwner());
		assertEquals("land", testedObject.getDestLandscape());
		assertEquals("dev-sit", testedObject.getPairName());
		assertEquals("dev", testedObject.getSourceEnvName());
		assertEquals("export", testedObject.getManifestFileName());
		assertEquals(deployModule, testedObject.getDeployModule());
		assertEquals(deployStep, testedObject.getDeployStep());
		assertEquals(deployArtifact, testedObject.getDeployArtifact());
		assertEquals("type", testedObject.getDeploymentType());
		assertEquals("deploy", testedObject.getDbDeployOperation());
		assertEquals("type", testedObject.getDbDeployRollbackType());
		assertEquals("value", testedObject.getDbDeployRollbackValue());
		assertEquals("safe", testedObject.getDbDeployFailSafe());
		assertEquals("owner", testedObject.getDbDeployPipelineOwners());
		assertEquals("pepiline", testedObject.getDbDeployPipelineList());
		ArrayList<String> subModule = new ArrayList<>();
		testedObject.setSubModule(subModule);
		assertEquals(subModule, testedObject.getSubModule());

		assertEquals("nexusId11", testedObject.getNexusId()); // jtest_unverified
		assertEquals("version12", testedObject.getVersion()); // jtest_unverified
		assertEquals("artifactID12", testedObject.getArtifactID()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method Deploy().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Deploy#Deploy()
	 * 
	 * 
	 */
	@Test
	public void testDeploy2() throws Throwable {
		Deploy testedObject = new Deploy();
		testedObject.setVersion("version0");
		testedObject.setArtifactID("artifactID0");
		testedObject.setNexusId((String) null);
		assertEquals(null, testedObject.getNexusId()); // jtest_unverified
		assertEquals("version0", testedObject.getVersion()); // jtest_unverified
		assertEquals("artifactID0", testedObject.getArtifactID()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method Deploy().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Deploy#Deploy()
	 * 
	 * 
	 */
	@Test
	public void testDeploy3() throws Throwable {
		Deploy testedObject = new Deploy();
		assertEquals(null, testedObject.getNexusId()); // jtest_unverified
		assertEquals(null, testedObject.getVersion()); // jtest_unverified
		assertEquals(null, testedObject.getArtifactID()); // jtest_unverified
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
	 * Usage: java DeployTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.triggerparameter.DeployTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class getTestedClass() {
		return Deploy.class;
	}
}
// JTEST_CURRENT_ID=-1497533494.