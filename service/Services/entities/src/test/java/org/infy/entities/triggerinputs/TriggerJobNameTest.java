/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.entities.triggerinputs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TriggerJobNameTest is a test class for TriggerJobName
 *
 * @see org.infy.entities.triggerinputs.TriggerJobName
 * 
 */
public class TriggerJobNameTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public TriggerJobNameTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method TriggerJobName().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerJobName#TriggerJobName()
	 * 
	 * 
	 */
	@Test
	public void testTriggerJobName0() throws Throwable {
		TriggerJobName testedObject = new TriggerJobName();
		testedObject.setEnvName("dev");
		testedObject.setReleaseNumber("march18");
		testedObject.setMailBody("MailBody12");
		testedObject.setMethod("method12");
		testedObject.setApplicationName("applicationName12");
		testedObject.setPipelineName("pipelineName12");
		testedObject.setUserName("userName11");
		assertEquals("method12", testedObject.getMethod()); // jtest_unverified
		assertEquals("applicationName12", testedObject.getApplicationName()); // jtest_unverified
		assertEquals("pipelineName12", testedObject.getPipelineName()); // jtest_unverified
		assertEquals("MailBody12", testedObject.getMailBody()); // jtest_unverified
		assertEquals("userName11", testedObject.getUserName()); // jtest_unverified
		assertEquals("dev", testedObject.getEnvName());
		assertEquals("march18", testedObject.getReleaseNumber());
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method TriggerJobName().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerJobName#TriggerJobName()
	 * 
	 * 
	 */
	@Test
	public void testTriggerJobName2() throws Throwable {
		TriggerJobName testedObject = new TriggerJobName();
		testedObject.setMailBody("MailBody0");
		testedObject.setMethod("method0");
		testedObject.setApplicationName("applicationName0");
		testedObject.setPipelineName("pipelineName0");
		testedObject.setUserName((String) null);
		assertEquals("method0", testedObject.getMethod()); // jtest_unverified
		assertEquals("applicationName0", testedObject.getApplicationName()); // jtest_unverified
		assertEquals("pipelineName0", testedObject.getPipelineName()); // jtest_unverified
		assertEquals("MailBody0", testedObject.getMailBody()); // jtest_unverified
		assertEquals(null, testedObject.getUserName()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method TriggerJobName().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see TriggerJobName#TriggerJobName()
	 * 
	 * 
	 */
	@Test
	public void testTriggerJobName3() throws Throwable {
		TriggerJobName testedObject = new TriggerJobName();
		assertEquals(null, testedObject.getMethod()); // jtest_unverified
		assertEquals(null, testedObject.getApplicationName()); // jtest_unverified
		assertEquals(null, testedObject.getPipelineName()); // jtest_unverified
		assertEquals(null, testedObject.getMailBody()); // jtest_unverified
		assertEquals(null, testedObject.getUserName()); // jtest_unverified
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
	 * Usage: java TriggerJobNameTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.entities.triggerinputs.TriggerJobNameTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public Class getTestedClass() {
		return TriggerJobName.class;
	}
}
// JTEST_CURRENT_ID=-1090685269.