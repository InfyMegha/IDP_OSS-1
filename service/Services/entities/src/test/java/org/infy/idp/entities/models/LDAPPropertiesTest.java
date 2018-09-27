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
 * LDAPPropertiesTest is a test class for LDAPProperties
 *
 * @see org.infy.idp.entities.models.LDAPProperties
 * 
 */
public class LDAPPropertiesTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public LDAPPropertiesTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method LDAPProperties().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see LDAPProperties#LDAPProperties()
	 * 
	 * 
	 */
	@Test
	public void testLDAPPropertiesValues() throws Throwable {
		LDAPProperties testedObject = new LDAPProperties();
		testedObject.setLDAPBase("LDAPBase12");
		testedObject.setLDAPUrl("LDAPUrl12");
		testedObject.setLDAPSuffix("LDAPSuffix11");
		assertEquals("LDAPBase12", testedObject.getLDAPBase());
		assertEquals("LDAPUrl12", testedObject.getLDAPUrl());
		assertEquals("LDAPSuffix11", testedObject.getLDAPSuffix());
	}

	/**
	 * Test for method LDAPProperties().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see LDAPProperties#LDAPProperties()
	 * 
	 * 
	 */
	@Test
	public void testLDAPPropertiesValues2() throws Throwable {
		LDAPProperties testedObject = new LDAPProperties();
		testedObject.setLDAPBase("LDAPBase0");
		testedObject.setLDAPUrl("LDAPUrl0");
		testedObject.setLDAPSuffix((String) null);
		assertEquals("LDAPBase0", testedObject.getLDAPBase());
		assertEquals("LDAPUrl0", testedObject.getLDAPUrl());
		assertNull(testedObject.getLDAPSuffix());
	}

	/**
	 * Test for method LDAPProperties().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see LDAPProperties#LDAPProperties()
	 * 
	 * 
	 */
	@Test
	public void testLDAPPropertiesNull() throws Throwable {
		LDAPProperties testedObject = new LDAPProperties();
		assertEquals(null, testedObject.getLDAPBase());
		assertEquals(null, testedObject.getLDAPUrl());
		assertEquals(null, testedObject.getLDAPSuffix());
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
	 * Usage: java LDAPPropertiesTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.models.LDAPPropertiesTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<LDAPProperties> getTestedClass() {
		return LDAPProperties.class;
	}
}
// JTEST_CURRENT_ID=840403187.