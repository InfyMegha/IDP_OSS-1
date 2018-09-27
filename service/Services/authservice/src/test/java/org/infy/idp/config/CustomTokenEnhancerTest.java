/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd. 
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.config;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

/**
 * CustomTokenEnhancerTest is a test class for CustomTokenEnhancer
 *
 * @see org.infy.idp.config.CustomTokenEnhancer
 *  
 */
public class CustomTokenEnhancerTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public CustomTokenEnhancerTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method CustomTokenEnhancer().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see CustomTokenEnhancer#CustomTokenEnhancer()
	 *  
	 * 
	 */
	@Test
	public void testCustomTokenEnhancer0() throws Throwable {
		CustomTokenEnhancer testedObject = new CustomTokenEnhancer();
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method
	 * enhance(org.springframework.security.oauth2.common.OAuth2AccessToken,org.
	 * springframework.security.oauth2.provider.OAuth2Authentication).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see CustomTokenEnhancer#enhance(org.springframework.security.oauth2.common.OAuth2AccessToken,org.springframework.security.oauth2.provider.OAuth2Authentication)
	 *  
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testEnhance0() throws Throwable {
		CustomTokenEnhancer testedObject = new CustomTokenEnhancer();
		OAuth2Request storedRequest = new OAuth2Request((Map) null, "Str 1.2 #", (Collection) null, false, (Set) null,
				(Set) null, "redirectUri0", (Set) null, (Map) null);
		OAuth2Authentication authentication = new OAuth2Authentication(storedRequest, (Authentication) null);
		OAuth2AccessToken result = testedObject.enhance((OAuth2AccessToken) null, authentication);
		// NullPointerException thrown
		// at
		// org.infy.idp.config.CustomTokenEnhancer.enhance(CustomTokenEnhancer.java:38)
	}

	/**
	 * Test for method
	 * enhance(org.springframework.security.oauth2.common.OAuth2AccessToken,org.
	 * springframework.security.oauth2.provider.OAuth2Authentication).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see CustomTokenEnhancer#enhance(org.springframework.security.oauth2.common.OAuth2AccessToken,org.springframework.security.oauth2.provider.OAuth2Authentication)
	 *  
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testEnhance1() throws Throwable {
		CustomTokenEnhancer testedObject = new CustomTokenEnhancer();
		OAuth2AccessToken result = testedObject.enhance((OAuth2AccessToken) null, (OAuth2Authentication) null);
		// NullPointerException thrown
		// at
		// org.infy.idp.config.CustomTokenEnhancer.enhance(CustomTokenEnhancer.java:37)
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
	 * Usage: java CustomTokenEnhancerTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.config.CustomTokenEnhancerTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return CustomTokenEnhancer.class;
	}
}
// JTEST_CURRENT_ID=-2038153937.