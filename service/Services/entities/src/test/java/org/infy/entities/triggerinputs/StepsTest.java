/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.entities.triggerinputs;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StepsTest extends PackageTestCase{
	
	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public StepsTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}
	
	@Test
	public void testSteps() throws Throwable{
		Steps testObject=new Steps();
		TestSteps testSteps=new TestSteps();
		testObject.setEnvName("dev");
		ArrayList<String> deploySteps=new ArrayList<>();
		ArrayList<TestSteps> testStep=new ArrayList<>();
		deploySteps.add("step1");
		deploySteps.add("step2");
		testObject.setDeploySteps(deploySteps);
		testSteps.setStepName("stepTest");
		testSteps.setToolName("rft");
		testStep.add(testSteps);
		testObject.setTestSteps(testStep);
		
		assertEquals("dev",testObject.getEnvName());
		assertEquals(deploySteps,testObject.getDeploySteps());
		assertEquals(testStep,testObject.getTestSteps());
		
	}
	
	
	
	@Test
	public void testNullSteps() throws Throwable{
		Steps testObject=new Steps();
		TestSteps testSteps=new TestSteps();
		testObject.setEnvName(null);
		ArrayList<String> deploySteps=null;
		ArrayList<TestSteps> testStep=null;
		testSteps.setStepName(null);
		testSteps.setToolName(null);
		testObject.setDeploySteps(deploySteps);
		testObject.setTestSteps(testStep);
		
		assertNull(testObject.getEnvName());
		assertNull(testObject.getDeploySteps());
		assertNull(testObject.getTestSteps());

		
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

		org.junit.runner.JUnitCore.main("org.infy.entities.triggerinputs.StepsTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	
	@SuppressWarnings("rawtypes")
	public Class getTestedClass() {
		return Steps.class;
	}
	

}
