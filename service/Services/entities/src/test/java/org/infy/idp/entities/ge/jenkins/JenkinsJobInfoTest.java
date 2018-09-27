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
 * JenkinsJobInfoTest is a test class for JenkinsJobInfo
 *
 * @see org.infy.idp.entities.ge.jenkins.JenkinsJobInfo
 * 
 */
public class JenkinsJobInfoTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public JenkinsJobInfoTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method getNumber().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsJobInfo#getNumber()
	 * 
	 * 
	 */
	@Test
	public void testGetNumberNull() throws Throwable {
		JenkinsJobInfo testedObject = new JenkinsJobInfo();
		Integer result = testedObject.getNumber();
		assertNull(result);
	}

	/**
	 * Test for method getTimestamp().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsJobInfo#getTimestamp()
	 * 
	 * 
	 */
	@Test
	public void testGetTimestampNull() throws Throwable {
		JenkinsJobInfo testedObject = new JenkinsJobInfo();
		Long result = testedObject.getTimestamp();
		assertNull(result);
	}

	/**
	 * Test for method JenkinsJobInfo().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsJobInfo#JenkinsJobInfo()
	 * 
	 * 
	 */
	@Test
	public void testJenkinsJobInfoValues() throws Throwable {
		JenkinsJobInfo testedObject = new JenkinsJobInfo();
		testedObject.set_class("class11");
		testedObject.setBuilding("building11");
		testedObject.setFullDisplayName("fullDisplayName11");
		Integer number = new Integer(5);
		testedObject.setNumber(number);
		testedObject.setResult("result11");
		Long timestamp = new Long(5L);
		testedObject.setTimestamp(timestamp);
		assertEquals("result11", testedObject.getResult());
		assertEquals(number, testedObject.getNumber());
		assertEquals(timestamp, testedObject.getTimestamp());
		assertEquals("class11", testedObject.get_class());
		assertEquals("building11", testedObject.getBuilding());
		assertEquals("fullDisplayName11", testedObject.getFullDisplayName());
	}

	/**
	 * Test for method JenkinsJobInfo().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsJobInfo#JenkinsJobInfo()
	 * 
	 * 
	 */
	@Test
	public void testJenkinsJobInfoValues2() throws Throwable {
		JenkinsJobInfo testedObject = new JenkinsJobInfo();
		testedObject.set_class("class0");
		testedObject.setBuilding("building0");
		testedObject.setFullDisplayName("fullDisplayName0");
		testedObject.setNumber((Integer) null);
		testedObject.setResult("result0");
		testedObject.setTimestamp((Long) null);

		assertEquals("result0", testedObject.getResult()); // jtest_unverified
		assertNull(testedObject.getNumber()); // jtest_unverified
		assertNull(testedObject.getTimestamp()); // jtest_unverified
		assertEquals("class0", testedObject.get_class()); // jtest_unverified
		assertEquals("building0", testedObject.getBuilding()); // jtest_unverified
		assertEquals("fullDisplayName0", testedObject.getFullDisplayName()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method JenkinsJobInfo().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see JenkinsJobInfo#JenkinsJobInfo()
	 * 
	 * 
	 */
	@Test
	public void testJenkinsJobInfoNull() throws Throwable {
		JenkinsJobInfo testedObject = new JenkinsJobInfo();
		assertNull(testedObject.getResult());
		assertNull(testedObject.getNumber());
		assertNull(testedObject.getTimestamp());
		assertNull(testedObject.get_class());
		assertNull(testedObject.getBuilding());
		assertNull(testedObject.getFullDisplayName());
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
	 * Usage: java JenkinsJobInfoTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.ge.jenkins.JenkinsJobInfoTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<JenkinsJobInfo> getTestedClass() {
		return JenkinsJobInfo.class;
	}
}
// JTEST_CURRENT_ID=-1132441793.