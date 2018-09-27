/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd. 
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * HybridUserDetailsServiceTest is a test class for HybridUserDetailsService
 *
 * @see org.infy.idp.config.HybridUserDetailsService
 *  
 */

@RunWith(MockitoJUnitRunner.class)
public class HybridUserDetailsServiceTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	
	@Spy
	@InjectMocks
	private HybridUserDetailsService hybridUserDetailsService;
	
	@Spy
	@InjectMocks
	private UserService userService;
	
	public HybridUserDetailsServiceTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}


	/**
	 * Test for method loadUserByUsername(java.lang.String).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see HybridUserDetailsService#loadUserByUsername(java.lang.String)
	 *  
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testLoadUserByUsername0() throws Throwable {
		HybridUserDetailsService testedObject = new HybridUserDetailsService();
		UserDetails result = testedObject.loadUserByUsername("Str 1.2 #");

		// NullPointerException thrown
		// at
		// org.infy.idp.config.HybridUserDetailsService.loadUserByUsername(HybridUserDetailsService.java:61)
	}

	/**
	 * Test for method loadUserByUsername(java.lang.String).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see HybridUserDetailsService#loadUserByUsername(java.lang.String)
	 *  
	 * 
	 */
	@Test(expected = org.springframework.security.core.userdetails.UsernameNotFoundException.class)
	public void testLoadUserByUsername1() throws Throwable {
		HybridUserDetailsService testedObject = new HybridUserDetailsService();
		UserDetails result = testedObject.loadUserByUsername("");

		// org.springframework.security.core.userdetails.UsernameNotFoundException
		// thrown
		// at
		// org.infy.idp.config.HybridUserDetailsService.loadUserByUsername(HybridUserDetailsService.java:56)
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
	 * Utility main method. Runs the test cases defined in this test class.
	 * 
	 * Usage: java HybridUserDetailsServiceTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.config.HybridUserDetailsServiceTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return HybridUserDetailsService.class;
	}
}
// JTEST_CURRENT_ID=-637476410.