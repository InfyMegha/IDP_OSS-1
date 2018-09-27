/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DownloadArtifactInputsTest is a test class for DownloadArtifactInputs
 *
 * @see org.infy.idp.entities.jobs.DownloadArtifactInputs
 * 
 */
public class DownloadArtifactInputsTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public DownloadArtifactInputsTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method DownloadArtifactInputs().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see DownloadArtifactInputs#DownloadArtifactInputs()
	 * 
	 * 
	 */
	@Test
	public void testDownloadArtifactInputsValues() throws Throwable {
		DownloadArtifactInputs testedObject = new DownloadArtifactInputs();
		testedObject.setJobName("jobName12");
		testedObject.setSubJobName("subJobName12");
		testedObject.setBuildNumber("buildNumber11");

		assertEquals("buildNumber11", testedObject.getBuildNumber());
		assertEquals("subJobName12", testedObject.getSubJobName());
		assertEquals("jobName12", testedObject.getJobName());
	}

	/**
	 * Test for method DownloadArtifactInputs().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see DownloadArtifactInputs#DownloadArtifactInputs()
	 * 
	 * 
	 */
	@Test
	public void testDownloadArtifactInputsValues2() throws Throwable {
		DownloadArtifactInputs testedObject = new DownloadArtifactInputs();
		testedObject.setJobName("jobName0");
		testedObject.setSubJobName("subJobName0");
		testedObject.setBuildNumber((String) null);

		assertNull(testedObject.getBuildNumber());
		assertEquals("subJobName0", testedObject.getSubJobName());
		assertEquals("jobName0", testedObject.getJobName());
	}

	/**
	 * Test for method DownloadArtifactInputs().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see DownloadArtifactInputs#DownloadArtifactInputs()
	 * 
	 * 
	 */
	@Test
	public void testDownloadArtifactInputsNull() throws Throwable {
		DownloadArtifactInputs testedObject = new DownloadArtifactInputs();

		assertNull(testedObject.getBuildNumber());
		assertNull(testedObject.getSubJobName());
		assertNull(testedObject.getJobName());
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
	 * Usage: java DownloadArtifactInputsTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.DownloadArtifactInputsTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<DownloadArtifactInputs> getTestedClass() {
		return DownloadArtifactInputs.class;
	}
}
// JTEST_CURRENT_ID=119686104.