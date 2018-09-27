/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.triggerparameter;

import org.infy.entities.triggerinputs.PackageTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApproveBuildParamsTest extends PackageTestCase {

	public ApproveBuildParamsTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	@Test
	public void testApproveBuild() throws Throwable {
		ApproveBuildParams ap = new ApproveBuildParams();
		ap.setApplicationName("app");
		ap.setApprBuildNo("1");
		ap.setApprComment("comment");
		ap.setApprInput("input");
		ap.setEnvName("dev");
		ap.setJobType("type");
		ap.setPipelineName("pipeline");
		ap.setUserName("admin");

		assertEquals("app", ap.getApplicationName());
		assertEquals("1", ap.getApprBuildNo());
		assertEquals("comment", ap.getApprComment());
		assertEquals("input", ap.getApprInput());
		assertEquals("dev", ap.getEnvName());
		assertEquals("type", ap.getJobType());
		assertEquals("pipeline", ap.getPipelineName());
		assertEquals("admin", ap.getUserName());
	}

	@Test
	public void testNullApproveBuild() throws Throwable {
		ApproveBuildParams ap = new ApproveBuildParams();
		ap.setApplicationName(null);
		ap.setApprBuildNo(null);
		ap.setApprComment(null);
		ap.setApprInput(null);
		ap.setEnvName(null);
		ap.setJobType(null);
		ap.setPipelineName(null);
		ap.setUserName(null);

		assertNull(ap.getApplicationName());
		assertNull(ap.getApprBuildNo());
		assertNull(ap.getApprComment());
		assertNull(ap.getApprInput());
		assertNull(ap.getEnvName());
		assertNull(ap.getJobType());
		assertNull(ap.getPipelineName());
		assertNull(ap.getUserName());
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

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.triggerparameter.ApproveBuildParamsTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */

	@SuppressWarnings("rawtypes")
	public Class getTestedClass() {
		return ApproveBuildParams.class;
	}

}
