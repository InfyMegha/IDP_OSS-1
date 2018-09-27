/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.getJob;

import org.infy.idp.entities.getjob.GetJob;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * GetJobTest is a test class for GetJob
 *
 * @see org.infy.idp.entities.getjob.GetJob
 *  
 */
public class GetJobTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public GetJobTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method GetJob().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see GetJob#GetJob()
	 *  
	 * 
	 */
	@Test
	public void testGetJobValues() throws Throwable {
		GetJob testedObject = new GetJob();
		testedObject.setBuildNumber("buildNumber12");
		testedObject.setApplicationName("applicationName12");
		testedObject.setPipelineName("pipelineName11");
		testedObject.setJenkinsBuildNumber("jenkinsBuildNumber");
		assertEquals("jenkinsBuildNumber" , testedObject.getJenkinsBuildNumber());
		assertEquals("buildNumber12",testedObject.getBuildNumber());
		assertEquals("applicationName12",testedObject.getApplicationName());
		assertEquals("pipelineName11",testedObject.getPipelineName());
	}
	
	/**
	 * Test for method GetJob().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see GetJob#GetJob()
	 *  
	 * 
	 */
	@Test
	public void testGetJobValues2() throws Throwable {
		GetJob testedObject = new GetJob();
		testedObject.setBuildNumber("buildNumber12");
		testedObject.setApplicationName("applicationName12");
		testedObject.setPipelineName("pipelineName11");
		testedObject.setJenkinsBuildNumber((String) null);
		assertNull(testedObject.getJenkinsBuildNumber());
		assertEquals("buildNumber12",testedObject.getBuildNumber());
		assertEquals("applicationName12",testedObject.getApplicationName());
		assertEquals("pipelineName11",testedObject.getPipelineName());
	}
	
	/**
	 * Test for method GetJob().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see GetJob#GetJob()
	 *  
	 * 
	 */
	@Test
	public void testGetJobNull() throws Throwable {
		GetJob testedObject = new GetJob();
		assertNull(testedObject.getJenkinsBuildNumber());
		assertNull(testedObject.getBuildNumber());
		assertNull(testedObject.getApplicationName());
		assertNull(testedObject.getPipelineName());
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
	 * Usage: java GetJobTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.getJob.GetJobTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return GetJob.class;
	}
}