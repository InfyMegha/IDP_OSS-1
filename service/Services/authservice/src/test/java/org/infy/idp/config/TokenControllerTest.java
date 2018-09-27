/*
 * TokenControllerTest.java
 * Created by Jtest on 9/26/17 10:13:15 AM.
 */

package org.infy.idp.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TokenControllerTest is a test class for TokenController
 *
 * @see org.infy.idp.config.TokenController
 *  
 */
public class TokenControllerTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public TokenControllerTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method getTokens().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see TokenController#getTokens()
	 *  
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testGetTokens0() throws Throwable {
		TokenController testedObject = new TokenController();
		List result = testedObject.getTokens();

		// NullPointerException thrown
		// at
		// org.infy.idp.config.TokenController.getTokens(TokenController.java:72)
	}

	/**
	 * Test for method revokeRefreshToken(java.lang.String).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see TokenController#revokeRefreshToken(java.lang.String)
	 *  
	 * 
	 */
	@Test
	public void testRevokeRefreshToken0() throws Throwable {
		TokenController testedObject = new TokenController();
		String result = testedObject.revokeRefreshToken("Str 1.2 #");
		assertEquals("Str 1.2 #", result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method
	 * revokeToken(javax.servlet.http.HttpServletRequest,java.lang.String).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see TokenController#revokeToken(javax.servlet.http.HttpServletRequest,java.lang.String)
	 *  
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testRevokeToken0() throws Throwable {
		TokenController testedObject = new TokenController();
		testedObject.revokeToken((HttpServletRequest) null, "Str 1.2 #");

		// NullPointerException thrown
		// at
		// org.infy.idp.config.TokenController.revokeToken(TokenController.java:63)
	}

	/**
	 * Test for method TokenController().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see TokenController#TokenController()
	 *  
	 * 
	 */
	@Test
	public void testTokenController0() throws Throwable {
		TokenController testedObject = new TokenController();
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
	 * Usage: java TokenControllerTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.config.TokenControllerTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return TokenController.class;
	}
}
// JTEST_CURRENT_ID=-100799275.