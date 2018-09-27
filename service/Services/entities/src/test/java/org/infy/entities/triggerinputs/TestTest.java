/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/


package org.infy.entities.triggerinputs;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestTest is a test class for Test
 *
 * @see org.infy.entities.triggerinputs.Test
 *  
 */
public class TestTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public TestTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Used to set up the test. This method is called by JUnit before each of
	 * the tests are executed.
	 * 
	 *  
	 */
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
	
	
	/**
	 * 
	 * Test for get and set
	 * 
	 */
	@Test
	public void testGetSet() throws Throwable{
		
		org.infy.entities.triggerinputs.Test testObject= new org.infy.entities.triggerinputs.Test();
		List<String> testEnv = null;
		testObject.setTestEnv(testEnv);
		assertEquals(null,testObject.getTestEnv());
		
	}
	
	
	/**
	 * Utility main method. Runs the test cases defined in this test class.
	 * 
	 * Usage: java TestTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.entities.triggerinputs.TestTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return Test.class;
	}
}
// JTEST_CURRENT_ID=-812123781.