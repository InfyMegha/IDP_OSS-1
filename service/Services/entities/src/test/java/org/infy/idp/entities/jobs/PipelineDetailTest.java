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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * PipelineDetailTest is a test class for PipelineDetail
 *
 * @see org.infy.idp.entities.jobs.PipelineDetail
 * 
 */
public class PipelineDetailTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public PipelineDetailTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method getSrNumber().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see PipelineDetail#getSrNumber()
	 * 
	 * 
	 */
	@Test
	public void testGetSrNumber() throws Throwable {
		PipelineDetail testedObject = new PipelineDetail();
		Integer result = testedObject.getSrNumber();
		assertNull(result);
	}

	/**
	 * Test for method PipelineDetail().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see PipelineDetail#PipelineDetail()
	 * 
	 * 
	 */
	@Test
	public void testPipelineDetailValues() throws Throwable {
		PipelineDetail testedObject = new PipelineDetail();
		testedObject.setCreationDate("creationDate12");
		testedObject.setPipelineName("pipelineName12");
		Integer srNumber = new Integer(5);
		testedObject.setSrNumber(srNumber);
		testedObject.setApplicationName("applicationName11");
		testedObject.setBuildTool("buildTool");
		List<String> permissions = new ArrayList<String>();
		permissions.add("permissions");
		testedObject.setPermissions(permissions);

		assertEquals(srNumber, testedObject.getSrNumber());
		assertEquals("applicationName11", testedObject.getApplicationName());
		assertEquals("pipelineName12", testedObject.getPipelineName());
		assertEquals("creationDate12", testedObject.getCreationDate());
		assertEquals(permissions, testedObject.getPermissions());
		assertEquals("buildTool", testedObject.getBuildTool());
	}

	/**
	 * Test for method PipelineDetail().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see PipelineDetail#PipelineDetail()
	 * 
	 * 
	 */
	@Test
	public void testPipelineDetailValues2() throws Throwable {
		PipelineDetail testedObject = new PipelineDetail();
		testedObject.setCreationDate("creationDate1");
		testedObject.setPipelineName("pipelineName1");
		testedObject.setSrNumber((Integer) null);
		testedObject.setApplicationName("applicationName0");
		testedObject.setBuildTool("buildTool");
		testedObject.setPermissions((List<String>) null);

		assertNull(testedObject.getSrNumber());
		assertEquals("applicationName0", testedObject.getApplicationName());
		assertEquals("pipelineName1", testedObject.getPipelineName());
		assertEquals("creationDate1", testedObject.getCreationDate());
		assertNull(testedObject.getPermissions());
		assertEquals("buildTool", testedObject.getBuildTool());
	}

	/**
	 * Test for method PipelineDetail().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see PipelineDetail#PipelineDetail()
	 * 
	 * 
	 */
	@Test
	public void testPipelineDetailNull() throws Throwable {
		PipelineDetail testedObject = new PipelineDetail();

		assertNull(testedObject.getSrNumber());
		assertNull(testedObject.getApplicationName());
		assertNull(testedObject.getPipelineName());
		assertNull(testedObject.getCreationDate());
		assertNull(testedObject.getPermissions());
		assertNull(testedObject.getBuildTool());
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
	 * Usage: java PipelineDetailTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.PipelineDetailTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<PipelineDetail> getTestedClass() {
		return PipelineDetail.class;
	}
}
// JTEST_CURRENT_ID=-880487442.