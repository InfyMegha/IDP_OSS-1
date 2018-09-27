/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.models;

import org.infy.idp.entities.models.GitHubBrachModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * GitHubBrachModelTest is a test class for GitHubBrachModel
 *
 * @see org.infy.idp.entities.models.GitHubBrachModel
 * 
 */
public class GitHubBranchModelTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public GitHubBranchModelTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	@Test
	public void testGitHubBrachModelValues() throws Throwable {
		GitHubBrachModel testObj = new GitHubBrachModel("repoUrl", "username", "pwd", "projectUrl", "proxy", "port");
		testObj.setRepoUrl("repoUrl");
		testObj.setUsername("username");
		testObj.setPwd("pwd");
		testObj.setProjectUrl("projectUrl");
		testObj.setProxy("proxy");
		testObj.setPort("port");

		assertEquals("repoUrl", testObj.getRepoUrl());
		assertEquals("username", testObj.getUsername());
		assertEquals("pwd", testObj.getPwd());
		assertEquals("projectUrl", testObj.getProjectUrl());
		assertEquals("proxy", testObj.getProxy());
		assertEquals("port", testObj.getPort());
	}

	/**
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see GitHubBrachModel#GitHubBrachModel()
	 * 
	 * 
	 */
	@Test
	public void testGitHubBrachModelNull() throws Throwable {
		GitHubBrachModel testedObject = new GitHubBrachModel();
		assertNull(testedObject.getUsername());
		assertNull(testedObject.getPort());
		assertNull(testedObject.getProjectUrl());
		assertNull(testedObject.getProxy());
		assertNull(testedObject.getPwd());
		assertNull(testedObject.getRepoUrl());
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
	 * Usage: java GitHubBrachModelTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.models.GitHubBrachModelTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<GitHubBrachModel> getTestedClass() {
		return GitHubBrachModel.class;
	}
}
