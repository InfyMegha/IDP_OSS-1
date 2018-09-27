/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs;

import java.util.ArrayList;
import java.util.List;

import org.infy.idp.entities.jobs.common.AntProperties;
import org.infy.idp.entities.jobs.common.RunScript;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * RunScriptTest is a test class for RunScript
 *
 * @see org.infy.idp.entities.jobs.RunScript
 * 
 */
public class RunScriptTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public RunScriptTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method getPort().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see RunScript#getPort()
	 * 
	 * 
	 */
	@Test
	public void testGetPort() throws Throwable {
		RunScript testedObject = new RunScript();
		Integer result = testedObject.getPort();
		assertNull(result);
	}

	/**
	 * Test for method RunScript().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see RunScript#RunScript()
	 * 
	 * 
	 */
	@Test
	public void testRunScriptValues() throws Throwable {
		RunScript testedObject = new RunScript();
		testedObject.setScriptType("scriptType12");
		testedObject.setFlattenFilePath("flattenFilePath12");
		Integer port = new Integer(5);
		testedObject.setPort(port);
		testedObject.setHost("host12");
		testedObject.setUserName("userName12");
		testedObject.setPassword("password12");
		testedObject.setScript("script12");
		testedObject.setPathToFiles("pathToFiles12");
		testedObject.setDestinationDir("destinationDir12");
		testedObject.setArchiveLogs("archiveLogs12");
		testedObject.setTool("tool12");
		testedObject.setScriptFilePath("scriptFilePath12");
		testedObject.setTargets("targets11");
		testedObject.setType("type");
		testedObject.setSshKey("sshKey");
		testedObject.setSshPathToKey("sshPathToKey");
		testedObject.setJavaOptions("javaOptions");
		List<String> dependentPipelineList = new ArrayList<String>();
		dependentPipelineList.add("depPipeline");
		testedObject.setDependentPipelineList(dependentPipelineList);
		List<AntProperties> antPropertiesArr = new ArrayList<>();
		AntProperties antProp = new AntProperties();
		antPropertiesArr.add(antProp);
		testedObject.setAntPropertiesArr(antPropertiesArr);

		assertEquals("host12", testedObject.getHost());
		assertEquals(port, testedObject.getPort());
		assertEquals("script12", testedObject.getScript());
		assertEquals("targets11", testedObject.getTargets());
		assertEquals("scriptType12", testedObject.getScriptType());
		assertEquals("password12", testedObject.getPassword());
		assertEquals("pathToFiles12", testedObject.getPathToFiles());
		assertEquals("archiveLogs12", testedObject.getArchiveLogs());
		assertEquals("tool12", testedObject.getTool());
		assertEquals("userName12", testedObject.getUserName());
		assertEquals("destinationDir12", testedObject.getDestinationDir());
		assertEquals("scriptFilePath12", testedObject.getScriptFilePath());
		assertEquals("flattenFilePath12", testedObject.getFlattenFilePath());
		assertEquals("type", testedObject.getType());
		assertEquals("sshKey", testedObject.getSshKey());
		assertEquals("sshPathToKey", testedObject.getSshPathToKey());
		assertEquals("javaOptions", testedObject.getJavaOptions());
		assertEquals(dependentPipelineList, testedObject.getDependentPipelineList());
		assertEquals(antPropertiesArr, testedObject.getAntPropertiesArr());

	}

	/**
	 * Test for method RunScript().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see RunScript#RunScript()
	 * 
	 * 
	 */
	@Test
	public void testRunScript3() throws Throwable {
		RunScript testedObject = new RunScript();

		assertNull(testedObject.getHost());
		assertNull(testedObject.getPort());
		assertNull(testedObject.getScript());
		assertNull(testedObject.getTargets());
		assertNull(testedObject.getScriptType());
		assertNull(testedObject.getPassword());
		assertNull(testedObject.getPathToFiles());
		assertNull(testedObject.getArchiveLogs());
		assertNull(testedObject.getTool());
		assertNull(testedObject.getUserName());
		assertNull(testedObject.getDestinationDir());
		assertNull(testedObject.getScriptFilePath());
		assertNull(testedObject.getFlattenFilePath());
		assertNull(testedObject.getType());
		assertNull(testedObject.getSshKey());
		assertNull(testedObject.getSshPathToKey());
		assertNull(testedObject.getJavaOptions());
		assertNull(testedObject.getDependentPipelineList());
		assertNull(testedObject.getAntPropertiesArr());

	}

	/**
	 * Used to set up the test. This method is called by JUnit before each of the
	 * tests are executed.
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
	 * Usage: java RunScriptTest
	 * 
	 * @param args command line arguments are not needed
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.RunScriptTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<RunScript> getTestedClass() {
		return RunScript.class;
	}
}
// JTEST_CURRENT_ID=538687635.