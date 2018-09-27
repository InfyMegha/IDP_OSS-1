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
 * UserServiceTest is a test class for UserService
 *
 * @see org.infy.idp.config.UserService
 *  
 */
public class UserServiceTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public UserServiceTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method authenticate(java.lang.String,java.lang.String).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see UserService#authenticate(java.lang.String,java.lang.String)
	 *  
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testAuthenticate0() throws Throwable {
		UserService testedObject = new UserService();
		Response result = testedObject.authenticate("Str 1.2 #", "Mr. Bob Smith");

		// NullPointerException thrown
		// at org.infy.idp.config.UserService.authenticate(UserService.java:48)
	}

	/**
	 * Test for method loadUser(java.lang.String).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see UserService#loadUser(java.lang.String)
	 *  
	 * 
	 */
	@Test
	public void testLoadUser0() throws Throwable {
		UserService testedObject = new UserService();
		Response result = testedObject.loadUser("Str 1.2 #");
		assertNotNull(result); // jtest_unverified
		assertEquals(true, result.isOk()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method UserService().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see UserService#UserService()
	 *  
	 * 
	 */
	@Test
	public void testUserService0() throws Throwable {
		UserService testedObject = new UserService();
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
	 * Usage: java UserServiceTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.config.UserServiceTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return UserService.class;
	}
}
// JTEST_CURRENT_ID=1745267215.