/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.getJob;

import java.util.ArrayList;
import java.util.List;

import org.infy.idp.entities.ge.jenkins.Performance;
import org.infy.idp.entities.ge.jenkins.SonarAnalysisInfo;
import org.infy.idp.entities.ge.jenkins.TestAnalysis;
import org.infy.idp.entities.getjob.GetResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * GetResponseTest is a test class for GetResponse
 *
 * @see org.infy.idp.entities.getjob.GetResponse
 *  
 */
public class GetResponseTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public GetResponseTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method getFunctionalTest().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see GetResponse#getFunctionalTest()
	 *  
	 * 
	 */
	@Test
	public void testGetFunctionalTestNull() throws Throwable {
		GetResponse testedObject = new GetResponse();
		List<TestAnalysis> result = testedObject.getFunctionalTest();
		assertNull(result);
	}

	/**
	 * Test for method GetResponse().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see GetResponse#GetResponse()
	 *  
	 * 
	 */
	@Test
	public void testGetResponseValues() throws Throwable {
		GetResponse testedObject = new GetResponse();
		testedObject.setMainJob("mainJob22");
		SonarAnalysisInfo sonar = new SonarAnalysisInfo();
		testedObject.setSonar(sonar);
		List<TestAnalysis> functionalTest = new ArrayList<TestAnalysis>();
		testedObject.setFunctionalTest(functionalTest);
		testedObject.setDashboard("dashboard21");
		testedObject.setPipelineStatus("pipelineStatus");
		List<Performance> performanceTest = new ArrayList<Performance>();
		testedObject.setPerformanceTest(performanceTest);
		
		assertEquals("pipelineStatus",testedObject.getPipelineStatus());
		assertEquals(performanceTest, testedObject.getPerformanceTest());
		assertEquals("mainJob22",testedObject.getMainJob());
		assertEquals("dashboard21",testedObject.getDashboard());
		assertEquals(sonar, testedObject.getSonar());
		assertEquals(functionalTest, testedObject.getFunctionalTest());
	}

	/**
	 * Test for method GetResponse().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see GetResponse#GetResponse()
	 *  
	 * 
	 */
	@Test
	public void testGetResponseNull() throws Throwable {
		GetResponse testedObject = new GetResponse();
		
		assertNull(testedObject.getPipelineStatus());
		assertNull(testedObject.getPerformanceTest());
		assertNull(testedObject.getMainJob());
		assertNull(testedObject.getDashboard());
		assertNull(testedObject.getSonar());
		assertNull(testedObject.getFunctionalTest());
	}
	/**
	 * Test for method getSonar().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see GetResponse#getSonar()
	 *  
	 * 
	 */
	@Test
	public void testGetSonarNull() throws Throwable {
		GetResponse testedObject = new GetResponse();
		SonarAnalysisInfo result = testedObject.getSonar();
		assertNull(result);
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
	 * Usage: java GetResponseTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.getJob.GetResponseTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class<GetResponse> getTestedClass() {
		return GetResponse.class;
	}
}
// JTEST_CURRENT_ID=1852964865.