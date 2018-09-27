/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.ge.jenkins;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestAnalysisTest is a test class for TestAnalysis
 *
 * @see org.infy.idp.entities.ge.jenkins.TestAnalysis
 *  
 */
public class TestAnalysisTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public TestAnalysisTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method TestAnalysis().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see TestAnalysis#TestAnalysis()
	 *  
	 * 
	 */
	@Test
	public void testTestAnalysisValues() throws Throwable {
		TestAnalysis testedObject = new TestAnalysis();
		testedObject.setTool("Tool12");
		testedObject.setTotalTests(-2147483648);
		testedObject.setSuccess(-1000);
		testedObject.setFailure(256);
		testedObject.setStatus("status11");
		assertEquals(-1000, testedObject.getSuccess());
		assertEquals(256, testedObject.getFailure());
		assertEquals("Tool12", testedObject.getTool());
		assertEquals("status11", testedObject.getStatus());
		assertEquals(-2147483648, testedObject.getTotalTests());
	}

	/**
	 * Test for method TestAnalysis().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see TestAnalysis#TestAnalysis()
	 *  
	 * 
	 */
	@Test
	public void testTestAnalysisValues2() throws Throwable {
		TestAnalysis testedObject = new TestAnalysis();
		testedObject.setTool("Tool1");
		testedObject.setTotalTests(1000);
		testedObject.setSuccess(858);
		testedObject.setFailure(2147483647);
		testedObject.setStatus((String) null);
		assertEquals(858, testedObject.getSuccess());
		assertEquals(2147483647, testedObject.getFailure());
		assertEquals("Tool1", testedObject.getTool()); 
		assertNull(testedObject.getStatus());
		assertEquals(1000, testedObject.getTotalTests());
	}
	
	/**
	 * Test for method TestAnalysis().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see TestAnalysis#TestAnalysis()
	 *  
	 * 
	 */
	@Test
	public void testTestAnalysisNull() throws Throwable {
		TestAnalysis testedObject = new TestAnalysis();
		assertEquals(0, testedObject.getSuccess()); // jtest_unverified
		assertEquals(0, testedObject.getFailure()); // jtest_unverified
		assertNull(testedObject.getTool()); // jtest_unverified
		assertNull(testedObject.getStatus()); // jtest_unverified
		assertEquals(0, testedObject.getTotalTests()); // jtest_unverified
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
	 * Usage: java TestAnalysisTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.ge.jenkins.TestAnalysisTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class<TestAnalysis> getTestedClass() {
		return TestAnalysis.class;
	}
}
// JTEST_CURRENT_ID=-1950607200.