/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.applicationinfo;

import org.infy.idp.entities.jobs.applicationinfo.EnvironmentOwnerDetail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * EnvironmentOwnerDetailTest is a test class for EnvironmentOwnerDetail
 *
 * @see org.infy.idp.entities.jobs.applicationinfo.EnvironmentOwnerDetail
 * 
 */
public class EnvironmentOwnerDetailTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public EnvironmentOwnerDetailTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method EnvironmentOwnerDetail().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see EnvironmentOwnerDetail#EnvironmentOwnerDetail()
	 * 
	 * 
	 */
	@Test
	public void testEnvironmentOwnerDetailValues() throws Throwable {
		EnvironmentOwnerDetail testedObject = new EnvironmentOwnerDetail();
		testedObject.setEnvironmentName("environmentName12");
		testedObject.setEnvironmentOwners("environmentOwners12");
		testedObject.setdBOwners("dBOwners11");
		testedObject.setSystemId("systemId");
		testedObject.setQa("qa");
		testedObject.setClient("client");
		testedObject.setHostName("hostName");
		testedObject.setInstanceNumber("instanceNumber");
		testedObject.setUserName("userName");
		testedObject.setLanguage("language");
		testedObject.setPassword("password");

		assertEquals("dBOwners11", testedObject.getdBOwners());
		assertEquals("environmentName12", testedObject.getEnvironmentName());
		assertEquals("environmentOwners12", testedObject.getEnvironmentOwners());
		assertEquals("systemId", testedObject.getSystemId());
		assertEquals("qa", testedObject.getQa());
		assertEquals("client", testedObject.getClient());
		assertEquals("hostName", testedObject.getHostName());
		assertEquals("instanceNumber", testedObject.getInstanceNumber());
		assertEquals("userName", testedObject.getUserName());
		assertEquals("language", testedObject.getLanguage());
		assertEquals("password", testedObject.getPassword());
	}

	/**
	 * Test for method EnvironmentOwnerDetail().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see EnvironmentOwnerDetail#EnvironmentOwnerDetail()
	 * 
	 * 
	 */
	@Test
	public void testEnvironmentOwnerDetailNull() throws Throwable {
		EnvironmentOwnerDetail testedObject = new EnvironmentOwnerDetail();
		assertNull(testedObject.getdBOwners());
		assertNull(testedObject.getEnvironmentName());
		assertNull(testedObject.getEnvironmentOwners());
		assertNull(testedObject.getSystemId());
		assertNull(testedObject.getQa());
		assertNull(testedObject.getClient());
//		assertNull(testedObject.getLandscapeType());
		assertNull(testedObject.getHostName());
		assertNull(testedObject.getInstanceNumber());
		assertNull(testedObject.getUserName());
		assertNull(testedObject.getLanguage());
		assertNull(testedObject.getPassword());
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
	 * Usage: java EnvironmentOwnerDetailTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.applicationInfo.EnvironmentOwnerDetailTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class getTestedClass() {
		return EnvironmentOwnerDetail.class;
	}
}
// JTEST_CURRENT_ID=257293771.