/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.entities.triggerinputs;


import java.util.ArrayList;

import org.infy.idp.entities.jobs.TestPlans;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlanListTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public TestPlanListTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}
	
	@Test
	public void testAddTestPlanList() throws Throwable{
		TestPlanList testedObject=new TestPlanList();
		TestPlans testplan=new TestPlans();
		testplan.setTestPlanId(1912);
		testplan.setTestPlanName("plan1");
		ArrayList<TestPlans> testplans=new ArrayList<>();
		testplans.add(testplan);
		testedObject.setTestPlanList(testplans);
		assertEquals(testplans,testedObject.getTestPlanList());
		assertEquals(testplans.get(0).getTestPlanName(),testedObject.getTestPlanList().get(0).getTestPlanName());
		assertEquals(testplans.get(0).getTestPlanId(), testedObject.getTestPlanList().get(0).getTestPlanId());
		
	}
	
	@Test
	public void testAddNullTestPlanList() throws Throwable{
		TestPlanList testedObject=new TestPlanList();
		TestPlans testplan=null;
		
		ArrayList<TestPlans> testplans=new ArrayList<>();
		testplans.add(testplan);
		testedObject.setTestPlanList(testplans);
		assertEquals(testplans,testedObject.getTestPlanList());
		
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
		return TestPlanList.class;
	}

}
