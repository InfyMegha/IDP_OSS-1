/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.entities.triggerinputs;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuildTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 */
	public BuildTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method Build().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Build#Build()
	 * 
	 * 
	 */
	@Test
	public void testBuild0() throws Throwable {
		Build testedObject = new Build();
		testedObject.setGitBranches((List) null);
		testedObject.setModules((List) null);
		assertEquals(null, testedObject.getGitBranches()); // jtest_unverified
		assertEquals(null, testedObject.getModules()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method getGitBranches().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Build#getGitBranches()
	 * 
	 * 
	 */
	@Test
	public void testGetGitBranches0() throws Throwable {
		Build testedObject = new Build();
		List result = testedObject.getGitBranches();
		assertEquals(null, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method getModules().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Build#getModules()
	 * 
	 * 
	 */
	@Test
	public void testGetModules0() throws Throwable {
		Build testedObject = new Build();
		List result = testedObject.getModules();
		assertEquals(null, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	@Test
	public void testBuild() throws Throwable {
		Build testObject = new Build();
		testObject.setJobType("build");
		testObject.setWorkEnv("dev");
		ArrayList<ApproveBuild> listBuild = new ArrayList<>();
		ApproveBuild appBuild = new ApproveBuild();
		appBuild.setApprBuildNo("build1");
		appBuild.setEnvName("sit");
		appBuild.setModuleList("module1");
		appBuild.setReleaseIdentifier("April2");
		appBuild.setUserInfo("ciplatform");
		listBuild.add(appBuild);
		testObject.setApproveBuild(listBuild);
		SubModule subModule = new SubModule();
		subModule.setDefaultModule("module");
		subModule.setModuleName("module");
		ArrayList<SubModule> listModule = new ArrayList<>();
		listModule.add(subModule);
		testObject.setSubModules(listModule);
		ArrayList<String> listEnv = new ArrayList<>();
		listEnv.add("dev");
		listEnv.add("prod");

		testObject.setBuildEnv(listEnv);
		testObject.setGitTag("build1");
		testObject.setCodeAnalysis("sonar");
		testObject.setUnitTesting("pmd");
		testObject.setCast("sap");

		assertEquals("build", testObject.getJobType());
		assertEquals("dev", testObject.getWorkEnv());
		assertEquals(listBuild, testObject.getApproveBuild());
		assertEquals(listModule, testObject.getSubModules());
		assertEquals(listEnv, testObject.getBuildEnv());
		assertEquals("build1", testObject.getGitTag());
		assertEquals("sonar", testObject.getCodeAnalysis());
		assertEquals("pmd", testObject.getUnitTesting());
		assertEquals("sap", testObject.getCast());

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
	 * Usage: java BuildTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.entities.triggerinputs.BuildTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class getTestedClass() {
		return Build.class;
	}
}
// JTEST_CURRENT_ID=1660495169.