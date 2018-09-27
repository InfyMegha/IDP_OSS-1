/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.triggerparameter;

import org.infy.entities.triggerinputs.PackageTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JobParamTriggerTest extends PackageTestCase {

	public JobParamTriggerTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	@Test
	public void testJobParamTrigger() throws Throwable {
		JobParamTrigger jp = new JobParamTrigger();
		jp.setJobParamName("job");
		jp.setJobParamSatic(true);
		jp.setJobParamValue("value");
		jp.setJobType("type");

		assertEquals("job", jp.getJobParamName());
		assertTrue(jp.getJobParamSatic());
		assertEquals("value", jp.getJobParamValue());
		assertEquals("type", jp.getJobType());
	}

	@Test
	public void testNullJobParamTrigger() throws Throwable {
		JobParamTrigger jp = new JobParamTrigger();
		jp.setJobParamName(null);
		jp.setJobParamSatic(null);
		jp.setJobParamValue(null);
		jp.setJobType(null);

		assertNull(jp.getJobParamName());
		assertNull(jp.getJobParamSatic());
		assertNull(jp.getJobParamValue());
		assertNull(jp.getJobType());
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

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.triggerparameter.JobParamTriggerTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */

	@SuppressWarnings("rawtypes")
	public Class getTestedClass() {
		return JobParamTrigger.class;
	}

}
