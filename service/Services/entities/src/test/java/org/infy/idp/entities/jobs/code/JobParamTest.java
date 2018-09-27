/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.code;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JobParamTest is a test class for JobParam
 *
 * @see org.infy.idp.entities.jobs.code.Code
 * 
 */
public class JobParamTest extends PackageTestCase {

	public JobParamTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	@Test
	public void testJobParamValues() throws Throwable {
		JobParam testedObject = new JobParam();
		testedObject.setJobParamName("ParameterName");
		testedObject.setJobParamSatic(true);
		testedObject.setJobParamValue("ParameterValue");
		testedObject.setJobType("jobType");

		assertEquals("ParameterName", testedObject.getJobParamName());
		assertEquals("ParameterValue", testedObject.getJobParamValue());
		assertEquals("jobType", testedObject.getJobType());
		assertTrue(testedObject.getJobParamSatic());
	}

	@Test
	public void testJobParamNullValues() throws Throwable {
		JobParam testedObject = new JobParam();
		testedObject.setJobParamName(null);
		testedObject.setJobParamSatic(null);
		testedObject.setJobParamValue(null);
		testedObject.setJobType(null);

		assertNull(testedObject.getJobParamName());
		assertNull(testedObject.getJobParamValue());
		assertNull(testedObject.getJobType());
		assertNull(testedObject.getJobParamSatic());
	}

	@Test
	public void testJobParamNull() throws Throwable {
		JobParam testedObject = new JobParam();
		assertNull(testedObject.getJobParamName());
		assertNull(testedObject.getJobParamValue());
		assertNull(testedObject.getJobType());
		assertNull(testedObject.getJobParamSatic());
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

	@After
	public void tearDown() throws Exception {
		/*
		 * Add any necessary cleanup code here (e.g., close a socket).
		 */
		super.tearDown();
	}

	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.code.JobParamTest");
	}

	public Class<JobParam> getTestedClass() {
		return JobParam.class;
	}
}