/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * LoginInfoTest is a test class for LoginInfo
 *
 * @see org.infy.idp.entities.models.LoginInfo
 * 
 */
public class LoginInfoTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public LoginInfoTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method
	 * LoginInfo(int,java.lang.String,java.lang.String,java.lang.String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see LoginInfo#LoginInfo(int,java.lang.String,java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test
	public void testLoginInfoValues() throws Throwable {
		LoginInfo testedObject = new LoginInfo(858, "username25", "status25", "role24");
		testedObject.setId(2147483647);
		testedObject.setUsername("username24");
		testedObject.setStatus("status24");
		testedObject.setRole("role23");
		assertEquals("status24", testedObject.getStatus());
		assertEquals("username24", testedObject.getUsername());
		assertEquals("role23", testedObject.getRole());
		assertEquals(2147483647, testedObject.getId());
	}

	/**
	 * Test for method
	 * LoginInfo(int,java.lang.String,java.lang.String,java.lang.String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see LoginInfo#LoginInfo(int,java.lang.String,java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test
	public void testLoginInfoValues2() throws Throwable {
		LoginInfo testedObject = new LoginInfo(5, "username0", "status0", "role0");
		testedObject.setId(-10);
		testedObject.setUsername("username1");
		testedObject.setStatus("status1");
		testedObject.setRole((String) null);
		assertEquals("status1", testedObject.getStatus());
		assertEquals("username1", testedObject.getUsername());
		assertNull(testedObject.getRole());
		assertEquals(-10, testedObject.getId());
	}

	/**
	 * Test for method
	 * LoginInfo(int,java.lang.String,java.lang.String,java.lang.String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see LoginInfo#LoginInfo(int,java.lang.String,java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test
	public void testLoginInfoValues3() throws Throwable {
		LoginInfo testedObject = new LoginInfo(100, "username11", "status11", "role11");
		assertEquals("status11", testedObject.getStatus());
		assertEquals("username11", testedObject.getUsername());
		assertEquals("role11", testedObject.getRole());
		assertEquals(100, testedObject.getId());
	}

	/**
	 * Test for method
	 * LoginInfo(int,java.lang.String,java.lang.String,java.lang.String).
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see LoginInfo#LoginInfo(int,java.lang.String,java.lang.String,java.lang.String)
	 * 
	 * 
	 */
	@Test
	public void testLoginInfoNull() throws Throwable {
		LoginInfo testedObject = new LoginInfo(0, (String) null, (String) null, (String) null);
		assertNull(testedObject.getStatus());
		assertNull(testedObject.getUsername());
		assertNull(testedObject.getRole());
		assertEquals(0, testedObject.getId());
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
		/*
		 * Add any necessary cleanup code here (e.g., close a socket).
		 */
		super.tearDown();
	}

	/**
	 * Utility main method. Runs the test cases defined in this test class.
	 * 
	 * Usage: java LoginInfoTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.models.LoginInfoTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<LoginInfo> getTestedClass() {
		return LoginInfo.class;
	}
}
// JTEST_CURRENT_ID=-1905004294.