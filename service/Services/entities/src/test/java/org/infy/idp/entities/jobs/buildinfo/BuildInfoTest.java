/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.buildinfo;

import java.util.ArrayList;
import java.util.List;

import org.infy.idp.entities.jobs.common.RunScript;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * BuildInfoTest is a test class for BuildInfo
 *
 * @see org.infy.idp.entities.jobs.buildinfo.BuildInfo
 * 
 */
public class BuildInfoTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public BuildInfoTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method BuildInfo().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BuildInfo#BuildInfo()
	 * 
	 * 
	 */
	@Test
	public void testBuildInfo0() throws Throwable {
		BuildInfo testedObject = new BuildInfo();
		/*
		 * Remove Jira ALM testedObject.setJiraProjKey("jiraProjKey21");
		 * testedObject.setJiraAssigneeName("jiraAssigneeName21");
		 */
		testedObject.setJavaModules("javaModules21");
		testedObject.setEjbModules("ejbModules21");
		testedObject.setWebModules("webModules21");
		testedObject.setNexusType("nexusType21");
		testedObject.setNexusUrl("nexusUrl21");
		testedObject.setUserName("userName21");
		testedObject.setPassword("password21");
		testedObject.setSonarUrl("sonar_url21");
		testedObject.setSonarPassword("sonar_password21");
		testedObject.setSonarUserName("sonar_user21");
		ArrayList<SubModule> subModule = new ArrayList<>();
		SubModule sub = new SubModule();
		sub.setDefaultModule("module1");
		sub.setModuleName("module1");
		subModule.add(sub);
		testedObject.setSubModule(subModule);
		RunScript postBuildScript = new RunScript();
		testedObject.setPostBuildScript(postBuildScript);
		testedObject.setBuildtool("buildtool21");
		ArtifactToStage artifactToStage = new ArtifactToStage();
		testedObject.setArtifactToStage(artifactToStage);
		List<Module>  modules = new ArrayList<>();
		testedObject.setModules(modules);
		assertEquals(modules, testedObject.getModules()); // jtest_unverified
		assertEquals("sonar_url",testedObject.getSonarUrl());
		assertEquals("sonar_password",testedObject.getSonarPassword());
		assertEquals("sonar_user",testedObject.getSonarUserName());
		assertEquals(artifactToStage, testedObject.getArtifactToStage()); // jtest_unverified
		assertEquals(postBuildScript, testedObject.getPostBuildScript()); // jtest_unverified
		assertEquals("ejbModules21", testedObject.getEjbModules()); // jtest_unverified
		assertEquals("userName21", testedObject.getUserName()); // jtest_unverified
		assertEquals("javaModules21", testedObject.getJavaModules()); // jtest_unverified
		// assertEquals("jiraProjKey21", testedObject.getJiraProjKey()); //
		// jtest_unverified
		assertEquals("nexusType21", testedObject.getNexusType()); // jtest_unverified
		assertEquals("password21", testedObject.getPassword()); // jtest_unverified
		assertEquals("webModules21", testedObject.getWebModules()); // jtest_unverified
		assertEquals("buildtool21", testedObject.getBuildtool()); // jtest_unverified
		assertEquals("nexusUrl21", testedObject.getNexusUrl()); // jtest_unverified
		assertEquals(subModule, testedObject.getSubModule());
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method BuildInfo().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BuildInfo#BuildInfo()
	 * 
	 * 
	 */
	@Test
	public void testBuildInfo11() throws Throwable {
		BuildInfo testedObject = new BuildInfo();
		/*
		 * Remove Jira ALM testedObject.setJiraProjKey("jiraProjKey0");
		 * testedObject.setJiraAssigneeName("jiraAssigneeName0");
		 */
		testedObject.setJavaModules("javaModules0");
		testedObject.setEjbModules("ejbModules0");
		testedObject.setWebModules("webModules0");
		testedObject.setNexusType("nexusType0");
		testedObject.setNexusUrl("nexusUrl0");
		testedObject.setUserName("userName0");
		testedObject.setPassword("password0");
		testedObject.setPostBuildScript((RunScript) null);
		testedObject.setBuildtool("buildtool0");
		testedObject.setArtifactToStage((ArtifactToStage) null);
		testedObject.setModules((List) null);
		assertEquals(null, testedObject.getModules()); // jtest_unverified
		assertEquals(null, testedObject.getArtifactToStage()); // jtest_unverified
		assertEquals(null, testedObject.getPostBuildScript()); // jtest_unverified
		assertEquals("ejbModules0", testedObject.getEjbModules()); // jtest_unverified
		assertEquals("userName0", testedObject.getUserName()); // jtest_unverified
		assertEquals("javaModules0", testedObject.getJavaModules()); // jtest_unverified
		assertEquals("nexusType0", testedObject.getNexusType()); // jtest_unverified
		assertEquals("password0", testedObject.getPassword()); // jtest_unverified
		assertEquals("webModules0", testedObject.getWebModules()); // jtest_unverified
		assertEquals("buildtool0", testedObject.getBuildtool()); // jtest_unverified
		assertEquals("nexusUrl0", testedObject.getNexusUrl()); // jtest_unverified
	}

	/**
	 * Test for method BuildInfo().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BuildInfo#BuildInfo()
	 * 
	 * 
	 */
	@Test
	public void testBuildInfo12() throws Throwable {
		BuildInfo testedObject = new BuildInfo();
		assertEquals(null, testedObject.getModules()); // jtest_unverified
		assertEquals(null, testedObject.getArtifactToStage()); // jtest_unverified
		assertEquals(null, testedObject.getPostBuildScript()); // jtest_unverified
		assertEquals(null, testedObject.getEjbModules()); // jtest_unverified
		assertEquals(null, testedObject.getUserName()); // jtest_unverified
		assertEquals(null, testedObject.getJavaModules()); // jtest_unverified
		assertEquals(null, testedObject.getNexusType()); // jtest_unverified
		assertEquals(null, testedObject.getPassword()); // jtest_unverified
		assertEquals(null, testedObject.getWebModules()); // jtest_unverified
		assertEquals(null, testedObject.getBuildtool()); // jtest_unverified
		assertEquals(null, testedObject.getNexusUrl()); // jtest_unverified
	}

	/**
	 * Test for method getArtifactToStage().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BuildInfo#getArtifactToStage()
	 * 
	 * 
	 */
	@Test
	public void testGetArtifactToStage0() throws Throwable {
		BuildInfo testedObject = new BuildInfo();
		ArtifactToStage result = testedObject.getArtifactToStage();
		assertEquals(null, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}


	/**
	 * Test for method getModules().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BuildInfo#getModules()
	 * 
	 * 
	 */
	@Test
	public void testGetModules0() throws Throwable {
		BuildInfo testedObject = new BuildInfo();
		List result = testedObject.getModules();
		assertEquals(null, result); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method getPostBuildScript().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BuildInfo#getPostBuildScript()
	 * 
	 * 
	 */
	@Test
	public void testGetPostBuildScript0() throws Throwable {
		BuildInfo testedObject = new BuildInfo();
		RunScript result = testedObject.getPostBuildScript();
		assertEquals(null, result); // jtest_unverified
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
	 * Usage: java BuildInfoTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.buildInfo.BuildInfoTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class getTestedClass() {
		return BuildInfo.class;
	}
}
