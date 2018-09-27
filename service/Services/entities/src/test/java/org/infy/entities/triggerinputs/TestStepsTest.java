/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.entities.triggerinputs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStepsTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public TestStepsTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}
	
	@Test
	public void testTestSteps() throws Throwable{
		TestSteps testObject=new TestSteps();
		testObject.setStepName("step1");
		testObject.setToolName("selenium");
		assertEquals("step1",testObject.getStepName());
		assertEquals("selenium",testObject.getToolName());
	}
	
	
	@Test
	public void testNullTestSteps() throws Throwable{
		TestSteps testObject=new TestSteps();
		testObject.setStepName(null);
		testObject.setToolName(null);
		assertNull(testObject.getStepName());
		assertNull(testObject.getToolName());
	}
	
	
	@Before
	public void setUp() throws Exception {
		/*
		 * Add any necessary initialization code here (e.g., open a socket).
		 * Call Repository.putTemporary() to provide initialized instances of
		 * objects to be used when testing.
		 */
		super.setUp();
		// jtest.Repository.putTemporary("name", object);

	}

	/**
	 * Used to clean up after the test. This method is called by JUnit after
	 * each of the tests have been completed.
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
	
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.entities.triggerinputs.TestPlanListTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	
	@SuppressWarnings("rawtypes")
	public Class getTestedClass() {
		return SubModule.class;
	}


}
