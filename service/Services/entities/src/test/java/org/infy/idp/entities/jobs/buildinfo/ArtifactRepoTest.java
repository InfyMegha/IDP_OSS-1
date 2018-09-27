/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.buildinfo;

import org.infy.entities.triggerinputs.PackageTestCase;
import org.infy.idp.entities.jobs.buildinfo.ArtifactRepo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArtifactRepoTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public ArtifactRepoTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	@Test
	public void testArtifactRepo() throws Throwable {
		ArtifactRepo artifact = new ArtifactRepo();
		artifact.setRepoName("idp_Nexus");
		artifact.setRepoPassword("admin123");
		artifact.setRepoURL("idpwinv05:8081");
		artifact.setRepoUsername("admin");

		assertEquals("idp_Nexus", artifact.getRepoName());
		assertEquals("admin123", artifact.getRepoPassword());
		assertEquals("idpwinv05:8081", artifact.getRepoURL());
		assertEquals("admin", artifact.getRepoUsername());
	}

	@Test
	public void testNullArtifactRepo() throws Throwable {
		ArtifactRepo artifact = new ArtifactRepo();
		artifact.setRepoName(null);
		artifact.setRepoPassword(null);
		artifact.setRepoURL(null);
		artifact.setRepoUsername(null);

		assertNull(artifact.getRepoName());
		assertNull(artifact.getRepoPassword());
		assertNull(artifact.getRepoURL());
		assertNull(artifact.getRepoUsername());
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
		/*
		 * Add any necessary cleanup code here (e.g., close a socket).
		 */
		super.tearDown();
	}

	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.buildInfo.ArtifactRepoTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */

	@SuppressWarnings("rawtypes")
	public Class getTestedClass() {
		return ArtifactRepo.class;
	}
}
