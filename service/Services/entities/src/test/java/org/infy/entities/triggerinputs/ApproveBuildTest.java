/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.entities.triggerinputs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApproveBuildTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 */
	public ApproveBuildTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	@Test
	public void testApprovebuild() throws Throwable {
		ApproveBuild testObject = new ApproveBuild();
		testObject.setApprBuildNo("build1");
		testObject.setEnvName("sit");
		testObject.setModuleList("module1");
		testObject.setReleaseIdentifier("April2");
		testObject.setUserInfo("ciplatform");

		assertEquals("build1", testObject.getApprBuildNo());
		assertEquals("sit", testObject.getEnvName());
		assertEquals("module1", testObject.getModuleList());
		assertEquals("April2", testObject.getReleaseIdentifier());
		assertEquals("ciplatform", testObject.getUserInfo());
	}

	@Test
	public void testNullApproveBuild() throws Throwable {

		ApproveBuild testObject = new ApproveBuild();
		testObject.setApprBuildNo(null);
		testObject.setEnvName(null);
		testObject.setModuleList(null);
		testObject.setReleaseIdentifier(null);
		testObject.setUserInfo(null);

		assertNull(testObject.getApprBuildNo());
		assertNull(testObject.getEnvName());
		assertNull(testObject.getModuleList());
		assertNull(testObject.getReleaseIdentifier());
		assertNull(testObject.getUserInfo());

	}

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

	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.entities.triggerinputs.ApproveBuildTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 */

	@SuppressWarnings("rawtypes")
	public Class getTestedClass() {
		return ApproveBuild.class;
	}

}
