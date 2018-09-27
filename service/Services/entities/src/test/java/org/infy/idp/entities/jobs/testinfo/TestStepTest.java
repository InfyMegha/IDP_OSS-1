/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.testinfo;

import org.infy.idp.entities.jobs.testinfo.TestScript;
import org.infy.idp.entities.jobs.testinfo.TestStep;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestStepTest is a test class for TestStep
 *
 * @see org.infy.idp.entities.jobs.testinfo.TestStep
 * 
 */
public class TestStepTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public TestStepTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method getRunScript().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TestStep#getRunScript()
	 * 
	 * 
	 */
	@Test
	public void testGetRunScriptNull() throws Throwable {
		TestStep testedObject = new TestStep();
		TestScript result = testedObject.getRunScript();
		assertNull(result);
	}

	/**
	 * Test for method TestStep().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TestStep#TestStep()
	 * 
	 * 
	 */
	@Test
	public void testTestStepNullValues() throws Throwable {
		TestStep testedObject = new TestStep();
		testedObject.setRunScript(null);
		testedObject.setStepName(null);
		testedObject.setTest(null);

		assertNull(testedObject.getTest());
		assertNull(testedObject.getRunScript());
		assertNull(testedObject.getStepName());
	}

	/**
	 * Test for method TestStep().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TestStep#TestStep()
	 * 
	 * 
	 */
	@Test
	public void testTestStepNull() throws Throwable {
		TestStep testedObject = new TestStep();

		assertNull(testedObject.getTest());
		assertNull(testedObject.getRunScript());
		assertNull(testedObject.getStepName());
	}

	/**
	 * Test for method TestStep().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TestStep#TestStep()
	 * 
	 * 
	 */
	@Test
	public void testTestStepValues() throws Throwable {
		TestStep testedObject = new TestStep();
		TestScript tsObj = new TestScript();
		org.infy.idp.entities.jobs.testinfo.Test testObj = new org.infy.idp.entities.jobs.testinfo.Test();
		testedObject.setRunScript(tsObj);
		testedObject.setStepName("test");
		testedObject.setTest(testObj);

		assertEquals(testObj, testedObject.getTest());
		assertEquals(tsObj, testedObject.getRunScript());
		assertEquals("test", testedObject.getStepName());
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
	 * Usage: java TestStepTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.testInfo.TestStepTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<TestStep> getTestedClass() {
		return TestStep.class;
	}
}
// JTEST_CURRENT_ID=1579279778.