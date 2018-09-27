/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * EnvNameTest is a test class for EnvName
 *
 * @see org.infy.idp.entities.jobs.EnvName
 * 
 */
public class EnvNameTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public EnvNameTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method EnvName().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see EnvName#EnvName()
	 * 
	 * 
	 */
	@Test
	public void testEnvNameValues() throws Throwable {
		EnvName testedObject = new EnvName();
		List<String> EnvNames = new ArrayList<String>();
		testedObject.setEnvNames(EnvNames);

		assertEquals(EnvNames, testedObject.getEnvNames());
	}

	/**
	 * Test for method EnvName().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see EnvName#EnvName()
	 * 
	 * 
	 */
	@Test
	public void testEnvNameNullValues() throws Throwable {
		EnvName testedObject = new EnvName();
		testedObject.setEnvNames((List<String>) null);
		assertNull(testedObject.getEnvNames());
	}

	/**
	 * Test for method EnvName().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see EnvName#EnvName()
	 * 
	 * 
	 */
	@Test
	public void testEnvNameNull() throws Throwable {
		EnvName testedObject = new EnvName();

		assertEquals(null, testedObject.getEnvNames());
	}

	/**
	 * Test for method getEnvNames().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see EnvName#getEnvNames()
	 * 
	 * 
	 */
	@Test
	public void testGetEnvNamesNull() throws Throwable {
		EnvName testedObject = new EnvName();
		List<String> result = testedObject.getEnvNames();

		assertEquals(null, result);
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
	 * Usage: java EnvNameTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.EnvNameTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<EnvName> getTestedClass() {
		return EnvName.class;
	}
}