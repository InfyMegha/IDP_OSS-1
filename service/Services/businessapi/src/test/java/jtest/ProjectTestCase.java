/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package jtest;


import org.junit.Assert;

/**
 * ProjectTestCase is an abstract unit test class for unit test classes in
 * project 'businessapi.jtest'.
 *  
 * @author Infosys
 */
public abstract class ProjectTestCase extends Assert {

	/**
	 * Constructs a test case for the test specified by the name argument.
	 * @param name the name of the test case
	 *  
	 */
	public ProjectTestCase() {

		/*
		 * This constructor should not be modified.  Any initialization code
		 * should be placed in the setUp() method instead.
		 */
	}

	/**
	 * Used to set up the test. This method is called by JUnit before each of
	 * the tests are executed.
	 * @see junit.framework.TestCase#setUp()
	 *  
	 */
	public void setUp() throws Exception {
		projectSetUp(this);
	}

	/**
	 * Used to set up any tests for this project. This method is called before each
	 * JUnit or other type of test is executed.
	 * @param test an instance object representing the current test
	 *  
	 */
	public static void projectSetUp(Object test) throws Exception {
		/*
		 * Add any necessary initialization code here (e.g., open a socket).
		 * Call Repository.putTemporary() to provide initialized instances of
		 * objects to be used when testing.
		 */
		//jtest.Repository.putTemporary("name", object);
	}

	/**
	 * Used to clean up after the test. This method is called by JUnit after
	 * each of the tests have been completed.
	 * @see junit.framework.TestCase#tearDown()
	 *  
	 */
	public void tearDown() throws Exception {
		projectTearDown(this);
	}

	/**
	 * Used to clean up any tests for this project. This method is called after each
	 * JUnit or other type of test is executed.
	 * @param test an instance object representing the current test
	 *  
	 */
	public static void projectTearDown(Object test) throws Exception {
		/*
		 * Add any necessary cleanup code here (e.g., close a socket).
		 */
	}

	/**
	 * Get the class object of the class which will be tested.
	 * @return the class which will be tested
	 *  
	 */
	public abstract Class getTestedClass();

}
