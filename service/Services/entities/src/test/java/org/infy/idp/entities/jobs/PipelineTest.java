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
 * PipelineTest is a test class for Pipeline
 *
 * @see org.infy.idp.entities.jobs.Pipeline
 * 
 */
public class PipelineTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public PipelineTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method getPipelineJson().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Pipeline#getPipelineJson()
	 * 
	 * 
	 */
	@Test
	public void testGetPipelineJsonNull() throws Throwable {
		Pipeline testedObject = new Pipeline();
		IDPJob result = testedObject.getPipelineJson();
		assertNull(result);
	}

	/**
	 * Test for method Pipeline().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Pipeline#Pipeline()
	 * 
	 * 
	 */
	@Test
	public void testPipelineValues() throws Throwable {
		Pipeline testedObject = new Pipeline();
		testedObject.setApplicationName("Ant22Dec");
		testedObject.setMethod("method21");
		testedObject.setPipelineName("pipelineName21");
		IDPJob pipelineJson = new IDPJob();
		testedObject.setPipelineJson(pipelineJson);
		assertEquals("method21", testedObject.getMethod());
		assertEquals(pipelineJson, testedObject.getPipelineJson());
		assertEquals("pipelineName21", testedObject.getPipelineName());
		assertEquals("Ant22Dec", testedObject.getApplicationName());
	}

	/**
	 * Test for method Pipeline().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Pipeline#Pipeline()
	 * 
	 * 
	 */
	@Test
	public void testPipelineValues2() throws Throwable {
		Pipeline testedObject = new Pipeline();
		testedObject.setMethod("method0");
		testedObject.setPipelineName("pipelineName0");
		testedObject.setPipelineJson((IDPJob) null);

		assertEquals("method0", testedObject.getMethod());
		assertNull(testedObject.getPipelineJson());
		assertEquals("pipelineName0", testedObject.getPipelineName());
	}

	/**
	 * Test for method Pipeline().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see Pipeline#Pipeline()
	 * 
	 * 
	 */
	@Test
	public void testPipelineNull() throws Throwable {
		Pipeline testedObject = new Pipeline();

		assertNull(testedObject.getMethod());
		assertNull(testedObject.getPipelineJson());
		assertNull(testedObject.getPipelineName());
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
	 * Usage: java PipelineTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.PipelineTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<Pipeline> getTestedClass() {
		return Pipeline.class;
	}
}
// JTEST_CURRENT_ID=-755842565.