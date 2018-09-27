/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd. 
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ResponseTest is a test class for Response
 *
 * @see org.infy.idp.config.Response
 *  
 */
public class ResponseTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public ResponseTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method fail().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see Response#fail()
	 *  
	 * 
	 */
	@Test
	public void testFail0() throws Throwable {
		Response result = Response.fail();
		assertNotNull(result); // jtest_unverified
		assertEquals(false, result.isOk()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method isOk().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see Response#isOk()
	 *  
	 * 
	 */
	@Test
	public void testIsOk0() throws Throwable {
		Response testedObject = Response.fail();
		boolean result = testedObject.isOk();
		assertEquals(false, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method ok().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see Response#ok()
	 *  
	 * 
	 */
	@Test
	public void testOk0() throws Throwable {
		Response result = Response.ok();
		assertNotNull(result); // jtest_unverified
		assertEquals(true, result.isOk()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method Response(boolean).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see Response#Response(boolean)
	 *  
	 * 
	 */
	@Test
	public void testResponse0() throws Throwable {
		Response response = Response.fail();
		response.setOk(false);
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
	 * Usage: java ResponseTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.config.ResponseTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return Response.class;
	}
}
// JTEST_CURRENT_ID=-2000404770.