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
 * SonarAnalysisInfoTest is a test class for SonarAnalysisInfo
 *
 * @see org.infy.idp.entities.ge.jenkins.SonarAnalysisInfo
 *  
 */
public class SonarAnalysisInfoTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public SonarAnalysisInfoTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method SonarAnalysisInfo().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see SonarAnalysisInfo#SonarAnalysisInfo()
	 *  
	 * 
	 */
	@Test
	public void testSonarAnalysisInfoValues() throws Throwable {
		SonarAnalysisInfo testedObject = new SonarAnalysisInfo();
		testedObject.setMajorIssue(-2147483648);
		testedObject.setMinorIssue(-1000);
		testedObject.setLinesOfCode(256);
		testedObject.setStatus("status11");
		assertEquals("status11", testedObject.getStatus());
		assertEquals(-2147483648, testedObject.getMajorIssue());
		assertEquals(256, testedObject.getLinesOfCode());
		assertEquals(-1000, testedObject.getMinorIssue());
	}

	/**
	 * Test for method SonarAnalysisInfo().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see SonarAnalysisInfo#SonarAnalysisInfo()
	 *  
	 * 
	 */
	@Test
	public void testSonarAnalysisInfoValues2() throws Throwable {
		SonarAnalysisInfo testedObject = new SonarAnalysisInfo();
		testedObject.setMajorIssue(1000);
		testedObject.setMinorIssue(858);
		testedObject.setLinesOfCode(2147483647);
		testedObject.setStatus("status0");
		assertEquals("status0", testedObject.getStatus());
		assertEquals(1000, testedObject.getMajorIssue());
		assertEquals(2147483647, testedObject.getLinesOfCode());
		assertEquals(858, testedObject.getMinorIssue());
	}

	/**
	 * Test for method SonarAnalysisInfo().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see SonarAnalysisInfo#SonarAnalysisInfo()
	 *  
	 * 
	 */
	@Test
	public void testSonarAnalysisInfoValues3() throws Throwable {
		SonarAnalysisInfo testedObject = new SonarAnalysisInfo();
		testedObject.setMajorIssue(5);
		testedObject.setMinorIssue(-10);
		testedObject.setLinesOfCode(100);
		testedObject.setStatus((String) null);
		assertNull(testedObject.getStatus());
		assertEquals(5, testedObject.getMajorIssue());
		assertEquals(100, testedObject.getLinesOfCode());
		assertEquals(-10, testedObject.getMinorIssue());
	}

	/**
	 * Test for method SonarAnalysisInfo().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see SonarAnalysisInfo#SonarAnalysisInfo()
	 *  
	 * 
	 */
	@Test
	public void testSonarAnalysisInfoNull() throws Throwable {
		SonarAnalysisInfo testedObject = new SonarAnalysisInfo();
		assertNull(testedObject.getStatus()); 
		assertEquals(0, testedObject.getMajorIssue());
		assertEquals(0, testedObject.getLinesOfCode());
		assertEquals(0, testedObject.getMinorIssue());
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
	 * Usage: java SonarAnalysisInfoTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.ge.jenkins.SonarAnalysisInfoTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class<SonarAnalysisInfo> getTestedClass() {
		return SonarAnalysisInfo.class;
	}
}
// JTEST_CURRENT_ID=-1847500891.