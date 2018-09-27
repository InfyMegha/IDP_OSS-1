/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd. 
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.config;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * RevokeTokenEndpointTest is a test class for RevokeTokenEndpoint
 *
 * @see org.infy.idp.config.RevokeTokenEndpoint
 *  
 */
public class RevokeTokenEndpointTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public RevokeTokenEndpointTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method revokeToken(javax.servlet.http.HttpServletRequest).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see RevokeTokenEndpoint#revokeToken(javax.servlet.http.HttpServletRequest)
	 *  
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testRevokeToken0() throws Throwable {
		RevokeTokenEndpoint testedObject = new RevokeTokenEndpoint();
		testedObject.revokeToken((HttpServletRequest) null);
		// NullPointerException thrown
		// at
		// org.infy.idp.config.RevokeTokenEndpoint.revokeToken(RevokeTokenEndpoint.java:52)
	}


	/**
	 * Test for method RevokeTokenEndpoint().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see RevokeTokenEndpoint#RevokeTokenEndpoint()
	 *  
	 * 
	 */
	@Test
	public void testRevokeTokenEndpoint0() throws Throwable {
		RevokeTokenEndpoint testedObject = new RevokeTokenEndpoint();
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
	 * Usage: java RevokeTokenEndpointTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.config.RevokeTokenEndpointTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return RevokeTokenEndpoint.class;
	}
}
// JTEST_CURRENT_ID=1220404471.