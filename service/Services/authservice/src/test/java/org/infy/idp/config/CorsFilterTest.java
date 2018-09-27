/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd. 
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at 
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * CorsFilterTest is a test class for CorsFilter
 *
 * @see org.infy.idp.config.CorsFilter
 *  
 */

public class CorsFilterTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	
	
	
	public CorsFilterTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method destroy().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see CorsFilter#destroy()
	 *  
	 * 
	 */
	@Test
	public void testDestroy0() throws Throwable {
		CorsFilter testedObject = new CorsFilter();
		testedObject.destroy();
		// No exception thrown
		// jtest_unverified
	}

	
	/**
	 * Test for method
	 * doFilter(javax.servlet.ServletRequest,javax.servlet.ServletResponse,javax
	 * .servlet.FilterChain).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see CorsFilter#doFilter(javax.servlet.ServletRequest,javax.servlet.ServletResponse,javax.servlet.FilterChain)
	 * @author rajaprabu.dharmaraj
	 * 
	 */
	@Test
	public void testDoFilter_ifCondition() throws Throwable {
		CorsFilter testedObject = new CorsFilter();
//		testedObject
		HttpServletRequest servletRequest = mock(HttpServletRequest.class);
		HttpServletResponse servletResponse = mock(HttpServletResponse.class);
		FilterChain filterChain = mock(FilterChain.class);
		
		when(servletRequest.getMethod()).thenReturn("OPTIONS");
		
		testedObject.doFilter(servletRequest, servletResponse, filterChain);

		// jtest.NoSuchValueException thrown
	}
	
	/**
	 * Test for method
	 * doFilter(javax.servlet.ServletRequest,javax.servlet.ServletResponse,javax
	 * .servlet.FilterChain).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see CorsFilter#doFilter(javax.servlet.ServletRequest,javax.servlet.ServletResponse,javax.servlet.FilterChain)
	 * @author rajaprabu.dharmaraj
	 * 
	 */
	@Test
	public void testDoFilter_elseCondition() throws Throwable {
		CorsFilter testedObject = new CorsFilter();
				
		HttpServletRequest servletRequest = mock(HttpServletRequest.class);
		HttpServletResponse servletResponse = mock(HttpServletResponse.class);
		FilterChain filterChain = mock(FilterChain.class);
		
		testedObject.doFilter(servletRequest, servletResponse, filterChain);

		
	}
	

	/**
	 * Test for method init(javax.servlet.FilterConfig).
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see CorsFilter#init(javax.servlet.FilterConfig)
	 *  
	 * 
	 */

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
	 * Usage: java CorsFilterTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.config.CorsFilterTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return CorsFilter.class;
	}
}
// JTEST_CURRENT_ID=-1497715408.