/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd. 
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.config.entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * LoginRequestTest is a test class for LoginRequest
 *
 * @see org.infy.idp.config.entities.LoginRequest
 *  
 */
public class LoginRequestTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public LoginRequestTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method LoginRequest(java.lang.String,java.lang.String).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see LoginRequest#LoginRequest(java.lang.String,java.lang.String)
	 *  
	 * 
	 */
	@Test
	public void testLoginRequest0() throws Throwable {
		LoginRequest testedObject = new LoginRequest("username3", "password2");
		testedObject.setUsername("username2");
		testedObject.setPassword("password1");
		assertEquals("username2", testedObject.getUsername()); // jtest_unverified
		assertEquals("password1", testedObject.getPassword()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method LoginRequest().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see LoginRequest#LoginRequest()
	 *  
	 * 
	 */
	@Test
	public void testLoginRequest4() throws Throwable {
		LoginRequest testedObject = new LoginRequest();
		assertEquals(null, testedObject.getUsername()); // jtest_unverified
		assertEquals(null, testedObject.getPassword()); // jtest_unverified
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
	 * Usage: java LoginRequestTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.config.entities.LoginRequestTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return LoginRequest.class;
	}
}
// JTEST_CURRENT_ID=-56409984.