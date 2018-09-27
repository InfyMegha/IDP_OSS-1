/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.entities.triggerinputs;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DeployTestEnvTest is a test class for DeployTestEnv
 *
 * @see org.infy.entities.triggerinputs.DeployTestEnv
 *  
 */
public class DeployTestEnvTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public DeployTestEnvTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method DeployTestEnv().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see DeployTestEnv#DeployTestEnv()
	 *  
	 * 
	 */
	@Test
	public void testDeployTestEnv0() throws Throwable {
		DeployTestEnv testedObject = new DeployTestEnv();
		List env = new ArrayList();
		testedObject.setEnv(env);
		EnvironmentObj env1=new EnvironmentObj();
		EnvironmentObj env2=new EnvironmentObj();
		EnvironmentObj env3=new EnvironmentObj();
		ArrayList<EnvironmentObj> listEnvObj=new ArrayList<>();
		listEnvObj.add(env1);
		listEnvObj.add(env2);
		listEnvObj.add(env3);
		testedObject.setEnvObj(listEnvObj);
		
		assertEquals(env, testedObject.getEnv()); // jtest_unverified
		assertEquals(listEnvObj,testedObject.getEnvObj());
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method DeployTestEnv().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see DeployTestEnv#DeployTestEnv()
	 *  
	 * 
	 */
	@Test
	public void testDeployTestEnv1() throws Throwable {
		DeployTestEnv testedObject = new DeployTestEnv();
		testedObject.setEnv((List) null);
		ArrayList<EnvironmentObj> listEnvObj=null;
		testedObject.setEnvObj(listEnvObj);
		assertNull(testedObject.getEnvObj());
		assertEquals(null, testedObject.getEnv()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method DeployTestEnv().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see DeployTestEnv#DeployTestEnv()
	 *  
	 * 
	 */
	@Test
	public void testDeployTestEnv2() throws Throwable {
		DeployTestEnv testedObject = new DeployTestEnv();
		assertEquals(null, testedObject.getEnv()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method getEnv().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see DeployTestEnv#getEnv()
	 *  
	 * 
	 */
	@Test
	public void testGetEnv0() throws Throwable {
		DeployTestEnv testedObject = new DeployTestEnv();
		List result = testedObject.getEnv();
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
	 * Usage: java DeployTestEnvTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.entities.triggerinputs.DeployTestEnvTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return DeployTestEnv.class;
	}
}
// JTEST_CURRENT_ID=-356897389.