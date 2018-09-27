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

import org.infy.idp.entities.jobs.applicationinfo.ApplicationInfo;
import org.infy.idp.entities.jobs.applicationinfo.EnvironmentOwnerDetail;
import org.infy.idp.entities.jobs.applicationinfo.SlavesDetail;
import org.infy.idp.entities.jobs.buildinfo.ArtifactToStage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ApplicationInfoTest is a test class for ApplicationInfo
 *
 * @see org.infy.idp.entities.jobs.applicationinfo.ApplicationInfo
 * 
 */
public class ApplicationInfoTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public ApplicationInfoTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method ApplicationInfo().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see ApplicationInfo#ApplicationInfo()
	 * 
	 * 
	 */
	@Test
	public void testApplicationInfoValues() throws Throwable {
		ApplicationInfo testedObject = new ApplicationInfo();
		testedObject.setApplicationName("applicationName11");
		testedObject.setDevelopers("developers11");
		testedObject.setPipelineAdmins("pipelineAdmins11");
		testedObject.setReleaseManager("releaseManager11");
		List<EnvironmentOwnerDetail> environmentOwnerDetails = new ArrayList<EnvironmentOwnerDetail>();
		testedObject.setEnvironmentOwnerDetails(environmentOwnerDetails);
		List<SlavesDetail> slavesDetails = new ArrayList<SlavesDetail>();
		testedObject.setSlavesDetails(slavesDetails);
		ArtifactToStage stageArtifact = new ArtifactToStage();
		testedObject.setArtifactToStage(stageArtifact);

		assertEquals(environmentOwnerDetails, testedObject.getSlavesDetails());
		assertEquals(environmentOwnerDetails, testedObject.getEnvironmentOwnerDetails());
		assertEquals("developers11", testedObject.getDevelopers());
		assertEquals("releaseManager11", testedObject.getReleaseManager());
		assertEquals("pipelineAdmins11", testedObject.getPipelineAdmins());
		assertEquals("applicationName11", testedObject.getApplicationName());
		assertEquals(stageArtifact, testedObject.getArtifactToStage());
	}

	/**
	 * Test for method ApplicationInfo().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see ApplicationInfo#ApplicationInfo()
	 * 
	 * 
	 */
	@Test
	public void testApplicationInfoNull() throws Throwable {
		ApplicationInfo testedObject = new ApplicationInfo();
		assertNull(testedObject.getSlavesDetails());
		assertNull(testedObject.getEnvironmentOwnerDetails());
		assertNull(testedObject.getDevelopers());
		assertNull(testedObject.getReleaseManager());
		assertNull(testedObject.getPipelineAdmins());
		assertNull(testedObject.getApplicationName());
		assertNull(testedObject.getArtifactToStage());
	}

	/**
	 * Test for method getEnvironmentOwnerDetails().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see ApplicationInfo#getEnvironmentOwnerDetails()
	 * 
	 * 
	 */
	@Test
	public void testGetEnvironmentOwnerDetailsNull() throws Throwable {
		ApplicationInfo testedObject = new ApplicationInfo();
		List<EnvironmentOwnerDetail> result = testedObject.getEnvironmentOwnerDetails();
		assertNull(result);
	}

	/**
	 * Test for method getSlavesDetails().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see ApplicationInfo#getSlavesDetails()
	 * 
	 * 
	 */
	@Test
	public void testGetSlavesDetailsNull() throws Throwable {
		ApplicationInfo testedObject = new ApplicationInfo();
		List<SlavesDetail> result = testedObject.getSlavesDetails();
		assertNull(result);
	}

	/**
	 * Test for method getSlavesDetails().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see ApplicationInfo#getSlavesDetails()
	 * 
	 * 
	 */
	@Test
	public void testGetArtifactToStageNull() throws Throwable {
		ApplicationInfo testedObject = new ApplicationInfo();
		ArtifactToStage result = testedObject.getArtifactToStage();
		assertNull(result);
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
	 * Usage: java ApplicationInfoTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.applicationInfo.ApplicationInfoTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<ApplicationInfo> getTestedClass() {
		return ApplicationInfo.class;
	}
}
