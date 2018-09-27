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
 * AppNamesTest is a test class for AppNames
 *
 * @see org.infy.idp.entities.jobs.AppNames
 * 
 */
public class AppNamesTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public AppNamesTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method AppNames().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see AppNames#AppNames()
	 * 
	 * 
	 */
	@Test
	public void testAppNamesValues() throws Throwable {
		AppNames testedObject = new AppNames();
		List<String> applicationNames = new ArrayList<>();
		testedObject.setApplicationNames(applicationNames);

		assertEquals(applicationNames, testedObject.getApplicationNames());
	}

	/**
	 * Test for method AppNames().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see AppNames#AppNames()
	 * 
	 * 
	 */
	@Test
	public void testAppNamesNullValues() throws Throwable {
		AppNames testedObject = new AppNames();
		testedObject.setApplicationNames((List<String>) null);

		assertEquals(null, testedObject.getApplicationNames());
	}

	/**
	 * Test for method AppNames().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see AppNames#AppNames()
	 * 
	 * 
	 */
	@Test
	public void testAppNamesNull() throws Throwable {
		AppNames testedObject = new AppNames();
		assertEquals(null, testedObject.getApplicationNames());
	}

	/**
	 * Test for method getApplicationNames().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see AppNames#getApplicationNames()
	 * 
	 * 
	 */
	@Test
	public void testGetApplicationNamesNull() throws Throwable {
		AppNames testedObject = new AppNames();
		List<String> result = testedObject.getApplicationNames();
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
	 * Usage: java AppNamesTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.AppNamesTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<AppNames> getTestedClass() {
		return AppNames.class;
	}
}
// JTEST_CURRENT_ID=-1936523716.