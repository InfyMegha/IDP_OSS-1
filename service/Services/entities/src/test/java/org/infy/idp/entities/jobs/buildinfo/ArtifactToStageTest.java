/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.buildinfo;

import org.infy.idp.entities.jobs.buildinfo.ArtifactRepo;
import org.infy.idp.entities.jobs.buildinfo.ArtifactToStage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ArtifactToStageTest is a test class for ArtifactToStage
 *
 * @see org.infy.idp.entities.jobs.buildinfo.ArtifactToStage
 * 
 */
public class ArtifactToStageTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public ArtifactToStageTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method ArtifactToStage().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see ArtifactToStage#ArtifactToStage()
	 * 
	 * 
	 */
	@Test
	public void testArtifactToStage0() throws Throwable {
		ArtifactToStage testedObject = new ArtifactToStage();
		testedObject.setFlattenFileStructure("flattenFileStructure12");
		testedObject.setArtifact("artifact11");
		ArtifactRepo artifactRepo = new ArtifactRepo();
		artifactRepo.setRepoName("idp_Nexus");
		artifactRepo.setRepoPassword("admin123");
		artifactRepo.setRepoURL("idpwinv05:8081");
		artifactRepo.setRepoUsername("admin");
		testedObject.setArtifactRepo(artifactRepo);
		testedObject.setArtifactRepoName("idp_Nexus");
		testedObject.setnuspecFilePath("file1");
		testedObject.setnexusAPIKey("123456");
		assertEquals("artifact11", testedObject.getArtifact()); // jtest_unverified
		assertEquals("flattenFileStructure12", testedObject.getFlattenFileStructure()); // jtest_unverified
		assertEquals(artifactRepo, testedObject.getArtifactRepo());
		assertEquals("idp_Nexus", testedObject.getArtifactRepoName());
		assertEquals("file1", testedObject.getnuspecFilePath());
		assertEquals("123456", testedObject.getnexusAPIKey());
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method ArtifactToStage().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see ArtifactToStage#ArtifactToStage()
	 * 
	 * 
	 */
	@Test
	public void testArtifactToStage2() throws Throwable {
		ArtifactToStage testedObject = new ArtifactToStage();
		testedObject.setFlattenFileStructure("flattenFileStructure0");
		testedObject.setArtifact((String) null);
		assertEquals(null, testedObject.getArtifact()); // jtest_unverified
		assertEquals("flattenFileStructure0", testedObject.getFlattenFileStructure()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method ArtifactToStage().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see ArtifactToStage#ArtifactToStage()
	 * 
	 * 
	 */
	@Test
	public void testArtifactToStage3() throws Throwable {
		ArtifactToStage testedObject = new ArtifactToStage();
		assertEquals(null, testedObject.getArtifact()); // jtest_unverified
		assertEquals(null, testedObject.getFlattenFileStructure()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
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
	 * Usage: java ArtifactToStageTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.buildInfo.ArtifactToStageTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class getTestedClass() {
		return ArtifactToStage.class;
	}
}
