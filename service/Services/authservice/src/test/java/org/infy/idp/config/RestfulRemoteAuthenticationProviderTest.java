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
 * RestfulRemoteAuthenticationProviderTest is a test class for
 * RestfulRemoteAuthenticationProvider
 *
 * @see org.infy.idp.config.RestfulRemoteAuthenticationProvider
 * 
 */
public class RestfulRemoteAuthenticationProviderTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public RestfulRemoteAuthenticationProviderTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

//	/**
//	 * Test for method
//	 * authenticate(org.springframework.security.core.Authentication).
//	 * 
//	 * @throws Throwable
//	 *             Tests may throw any Throwable
//	 *
//	 * @see RestfulRemoteAuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
//	 *  
//	 * 
//	 */
//	@Test(expected = NullPointerException.class)
//	public void testAuthenticate1() throws Throwable {
//		RestfulRemoteAuthenticationProvider testedObject = new RestfulRemoteAuthenticationProvider();
//		Authentication authentication = (Authentication) Stubs.makeStubObject(Authentication.class);
//		Authentication result = testedObject.authenticate(authentication);
//
//		// NullPointerException thrown
//		// at
//		// org.infy.idp.config.RestfulRemoteAuthenticationProvider.authenticate(RestfulRemoteAuthenticationProvider.java:52)
//	}

	/**
	 * Test for method RestfulRemoteAuthenticationProvider().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see RestfulRemoteAuthenticationProvider#RestfulRemoteAuthenticationProvider()
	 * 
	 * 
	 */
	@Test
	public void testRestfulRemoteAuthenticationProvider0() throws Throwable {
		RestfulRemoteAuthenticationProvider testedObject = new RestfulRemoteAuthenticationProvider();
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method supports(java.lang.Class).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see RestfulRemoteAuthenticationProvider#supports(java.lang.Class)
	 * 
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testSupports1() throws Throwable {
		RestfulRemoteAuthenticationProvider testedObject = new RestfulRemoteAuthenticationProvider();
		boolean result = testedObject.supports((Class) null);
		// NullPointerException thrown
		// at
		// org.infy.idp.config.RestfulRemoteAuthenticationProvider.supports(RestfulRemoteAuthenticationProvider.java:67)
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
	 * Usage: java RestfulRemoteAuthenticationProviderTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.config.RestfulRemoteAuthenticationProviderTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class getTestedClass() {
		return RestfulRemoteAuthenticationProvider.class;
	}
}
// JTEST_CURRENT_ID=-179215419.