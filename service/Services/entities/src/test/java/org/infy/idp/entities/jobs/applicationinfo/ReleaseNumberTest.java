/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.applicationinfo;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ReleaseNumberTest is a test class for ReleaseNumber
 *
 * @see org.infy.idp.entities.jobs.applicationinfo.ReleaseNumber
 * 
 */
public class ReleaseNumberTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public ReleaseNumberTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}


	@Test
	public void testReleaseNumberValues() throws Throwable {

		ReleaseNumber testedObject = new ReleaseNumber();
		List<String> releaseList = new ArrayList<>();
		testedObject.setReleaseNumbers(releaseList);

		assertEquals(releaseList, testedObject.getReleaseNumbers());
	}

	/**
	 * Test for method ReleaseNumber().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see ReleaseNumber#ReleaseNumber()
	 * 
	 * 
	 */
	@Test
	public void testReleaseNumberNull() throws Throwable {
		ReleaseNumber testedObject = new ReleaseNumber();

		assertNull(testedObject.getReleaseNumbers());
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
