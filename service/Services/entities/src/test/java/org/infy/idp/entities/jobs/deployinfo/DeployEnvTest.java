/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.deployinfo;

import java.util.ArrayList;
import java.util.List;

import org.infy.idp.entities.jobs.deployinfo.DeployEnv;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DeployEnvTest is a test class for DeployEnv
 *
 * @see org.infy.idp.entities.jobs.deployinfo.DeployEnv
 *  
 */
public class DeployEnvTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public DeployEnvTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method DeployEnv().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see DeployEnv#DeployEnv()
	 *  
	 * 
	 */
	@Test
	public void testDeployEnv0() throws Throwable {
		DeployEnv testedObject = new DeployEnv();
		testedObject.setEnvName("envName12");
		List deploySteps = new ArrayList();
		testedObject.setDeploySteps(deploySteps);
		testedObject.setApprover("approver11");
		testedObject.setEnvFlag("envFlag12");
		testedObject.setScriptType("scriptType11");
		assertEquals(deploySteps, testedObject.getDeploySteps()); // jtest_unverified
		assertEquals("envName12", testedObject.getEnvName()); // jtest_unverified
		assertEquals("approver11", testedObject.getApprover()); // jtest_unverified
		assertEquals("envFlag12", testedObject.getEnvFlag()); // jtest_unverified
		assertEquals("scriptType11", testedObject.getScriptType()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method DeployEnv().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see DeployEnv#DeployEnv()
	 *  
	 * 
	 */
	@Test
	public void testDeployEnv1() throws Throwable {
		DeployEnv testedObject = new DeployEnv();
		testedObject.setEnvName("envName1");
		testedObject.setDeploySteps((List) null);
		testedObject.setApprover("approver0");
		assertEquals(null, testedObject.getDeploySteps()); // jtest_unverified
		assertEquals("envName1", testedObject.getEnvName()); // jtest_unverified
		assertEquals("approver0", testedObject.getApprover()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method DeployEnv().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see DeployEnv#DeployEnv()
	 *  
	 * 
	 */
	@Test
	public void testDeployEnv2() throws Throwable {
		DeployEnv testedObject = new DeployEnv();
		testedObject.setEnvName("envName0");
		testedObject.setDeploySteps((List) null);
		testedObject.setApprover((String) null);
		assertEquals(null, testedObject.getDeploySteps()); // jtest_unverified
		assertEquals("envName0", testedObject.getEnvName()); // jtest_unverified
		assertEquals(null, testedObject.getApprover()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method DeployEnv().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see DeployEnv#DeployEnv()
	 *  
	 * 
	 */
	@Test
	public void testDeployEnv3() throws Throwable {
		DeployEnv testedObject = new DeployEnv();
		assertEquals(null, testedObject.getDeploySteps()); // jtest_unverified
		assertEquals(null, testedObject.getEnvName()); // jtest_unverified
		assertEquals(null, testedObject.getApprover()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method getDeploySteps().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see DeployEnv#getDeploySteps()
	 *  
	 * 
	 */
	@Test
	public void testGetDeploySteps0() throws Throwable {
		DeployEnv testedObject = new DeployEnv();
		List result = testedObject.getDeploySteps();
		assertEquals(null, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Used to set up the test. This method is called by JUnit before each of
	 * the tests are executed.
	 * 
	 *  
	 */
	@Before
	public void setUp() throws Exception {
		/*
		 * Add any necessary initialization code here (e.g., open a socket).
		 * Call Repository.putTemporary() to provide initialized instances of
		 * objects to be used when testing.
		 */
		super.setUp();
		// jtest.Repository.putTemporary("name", object);

	}

	/**
	 * Used to clean up after the test. This method is called by JUnit after
	 * each of the tests have been completed.
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
	 * Usage: java DeployEnvTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.deployInfo.DeployEnvTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return DeployEnv.class;
	}
}
// JTEST_CURRENT_ID=625544709.