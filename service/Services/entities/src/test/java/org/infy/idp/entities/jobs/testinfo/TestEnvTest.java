/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.testinfo;

import java.util.ArrayList;
import java.util.List;

import org.infy.idp.entities.jobs.testinfo.TestEnv;
import org.infy.idp.entities.jobs.testinfo.TestStep;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestEnvTest is a test class for TestEnv
 *
 * @see org.infy.idp.entities.jobs.testinfo.TestEnv
 * 
 */
public class TestEnvTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public TestEnvTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method getTestSteps().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TestEnv#getTestSteps()
	 * 
	 * 
	 */
	@Test
	public void testGetTestStepsNull() throws Throwable {
		TestEnv testedObject = new TestEnv();
		List<TestStep> result = testedObject.getTestSteps();
		assertNull(result);
	}

	/**
	 * Test for method TestEnv().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TestEnv#TestEnv()
	 * 
	 * 
	 */
	@Test
	public void testTestEnvValues() throws Throwable {
		TestEnv testedObject = new TestEnv();
		testedObject.setEnvName("envName11");
		List<TestStep> testSteps = new ArrayList<TestStep>();
		testedObject.setTestSteps(testSteps);
		testedObject.setEnvFlag("on");
		assertEquals(testSteps, testedObject.getTestSteps());
		assertEquals("envName11", testedObject.getEnvName());
		assertEquals("on", testedObject.getEnvFlag());
	}

	/**
	 * Test for method TestEnv().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TestEnv#TestEnv()
	 * 
	 * 
	 */
	@Test
	public void testTestEnvValues2() throws Throwable {
		TestEnv testedObject = new TestEnv();
		testedObject.setEnvName("envName0");
		testedObject.setTestSteps((List<TestStep>) null);
		testedObject.setEnvFlag("on");
		assertEquals(null, testedObject.getTestSteps());
		assertEquals("envName0", testedObject.getEnvName());
		assertEquals("on", testedObject.getEnvFlag());
	}

	/**
	 * Test for method TestEnv().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TestEnv#TestEnv()
	 * 
	 * 
	 */
	@Test
	public void testTestEnvNull() throws Throwable {
		TestEnv testedObject = new TestEnv();
		assertNull(testedObject.getTestSteps());
		assertNull(testedObject.getEnvName());
		assertNull(testedObject.getEnvFlag());
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
	 * Usage: java TestEnvTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.testInfo.TestEnvTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<TestEnv> getTestedClass() {
		return TestEnv.class;
	}
}
// JTEST_CURRENT_ID=-1870429002.