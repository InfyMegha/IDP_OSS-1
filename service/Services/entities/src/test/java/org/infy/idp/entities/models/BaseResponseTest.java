/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * BaseResponseTest is a test class for BaseResponse
 *
 * @see org.infy.idp.entities.models.BaseResponse
 * 
 */
public class BaseResponseTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public BaseResponseTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method BaseResponse().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BaseResponse#BaseResponse()
	 * 
	 * 
	 */
	@Test
	public void testBaseResponseValues() throws Throwable {
		BaseResponse testedObject = new BaseResponse();
		testedObject.setErrorMessage("errorMessage12");
		testedObject.setStatusCode(100);
		testedObject.setStatus("status11");
		assertEquals("status11", testedObject.getStatus());
		assertEquals(100, testedObject.getStatusCode());
		assertEquals("errorMessage12", testedObject.getErrorMessage());
	}

	/**
	 * Test for method BaseResponse().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BaseResponse#BaseResponse()
	 * 
	 * 
	 */
	@Test
	public void testBaseResponseValues2() throws Throwable {
		BaseResponse testedObject = new BaseResponse();
		testedObject.setErrorMessage("errorMessage0");
		testedObject.setStatusCode(5);
		testedObject.setStatus((String) null);
		assertNull(testedObject.getStatus());
		assertEquals(5, testedObject.getStatusCode());
		assertEquals("errorMessage0", testedObject.getErrorMessage());
	}

	/**
	 * Test for method BaseResponse().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BaseResponse#BaseResponse()
	 * 
	 * 
	 */
	@Test
	public void testBaseResponse3() throws Throwable {
		BaseResponse testedObject = new BaseResponse();
		assertNull(testedObject.getStatus());
		assertEquals(0, testedObject.getStatusCode());
		assertNull(testedObject.getErrorMessage());
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
	 * Usage: java BaseResponseTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.models.BaseResponseTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class<BaseResponse> getTestedClass() {
		return BaseResponse.class;
	}
}
// JTEST_CURRENT_ID=-1133600427.