/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd. 
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.config;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * AuthorizationServerApplicationTest is a test class for
 * AuthorizationServerApplication
 *
 * @see org.infy.idp.config.AuthorizationServerApplication
 *  
 */
//@RunWith(MockitoJUnitRunner.class)
public class AuthorizationServerApplicationTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	
//	@InjectMocks
//	private ServiceInstanceRestController ServiceInstanceRestController;
//	
//	@Spy
//	private DiscoveryClient discoveryClient;
	
	public AuthorizationServerApplicationTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}


	/**
	 * Test for method serviceInstancesByApplicationName(java.lang.String).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see ServiceInstanceRestController#serviceInstancesByApplicationName(java.lang.String)
	 *  
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testServiceInstancesByApplicationName0() throws Throwable {
		ServiceInstanceRestController testedObject = new ServiceInstanceRestController();
		List result = testedObject.serviceInstancesByApplicationName("applicationName");

		// NullPointerException thrown
		// at
		// org.infy.idp.config.ServiceInstanceRestController.serviceInstancesByApplicationName(AuthorizationServerApplication.java:64)
	}

	
	
//	
//	@Test
//	public void testServiceInstancesByApplicationName_Success() throws Throwable {
//		//ServiceInstanceRestController testedObject = new ServiceInstanceRestController();
//		List result = ServiceInstanceRestController.serviceInstancesByApplicationName("RajaprabuUnitTest");
//
//		}

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
	 * Utility main method. Runs the test cases defined in this test class.
	 * 
	 * Usage: java AuthorizationServerApplicationTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.config.AuthorizationServerApplicationTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return AuthorizationServerApplication.class;
	}
}
// JTEST_CURRENT_ID=1991477135.