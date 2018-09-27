/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.ge.jenkins;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * SonarAPITest is a test class for SonarAPI
 *
 * @see org.infy.idp.entities.ge.jenkins.SonarAPI
 *  
 */
public class SonarAPITest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public SonarAPITest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method getComponentKeys().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see SonarAPI#getComponentKeys()
	 *  
	 * 
	 */
	@Test
	public void testGetComponentKeysNull() throws Throwable {
		SonarAPI testedObject = new SonarAPI();
		List<String> result = testedObject.getComponentKeys();
		assertNull(result);
	}

	/**
	 * Test for method SonarAPI().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see SonarAPI#SonarAPI()
	 *  
	 * 
	 */
	@Test
	public void testSonarAPIValues() throws Throwable {
		SonarAPI testedObject = new SonarAPI();
		List<String> componentKeys = new ArrayList<String>();
		testedObject.setComponentKeys(componentKeys);
		assertEquals(componentKeys, testedObject.getComponentKeys());
	}

	/**
	 * Test for method SonarAPI().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see SonarAPI#SonarAPI()
	 *  
	 * 
	 */
	@Test
	public void testSonarAPINullValue() throws Throwable {
		SonarAPI testedObject = new SonarAPI();
		testedObject.setComponentKeys((List<String>) null);
		assertNull(testedObject.getComponentKeys());
	}

	/**
	 * Test for method SonarAPI().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see SonarAPI#SonarAPI()
	 *  
	 * 
	 */
	@Test
	public void testSonarAPINull() throws Throwable {
		SonarAPI testedObject = new SonarAPI();
		assertNull(testedObject.getComponentKeys());
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
	 * Usage: java SonarAPITest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.ge.jenkins.SonarAPITest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class<SonarAPI> getTestedClass() {
		return SonarAPI.class;
	}
}
// JTEST_CURRENT_ID=-240035571.