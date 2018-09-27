/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.basicinfo;

import java.util.ArrayList;
import java.util.List;

import org.infy.idp.entities.jobs.basicinfo.BuildInterval;
import org.infy.idp.entities.jobs.basicinfo.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * BuildIntervalTest is a test class for BuildInterval
 *
 * @see org.infy.idp.entities.jobs.basicinfo.BuildInterval
 * 
 */
public class BuildIntervalTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public BuildIntervalTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method BuildInterval().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BuildInterval#BuildInterval()
	 * 
	 * 
	 */
	@Test
	public void testBuildInterval0() throws Throwable {
		BuildInterval testedObject = new BuildInterval();
		testedObject.setPollSCM("pollSCM12");
		testedObject.setBuildInterval("buildIntrvl12");
		testedObject.setBuildIntervalValue("buildIntervalValue11");
		testedObject.setBuildAtSpecificInterval("buildAtSpecificInterval");
		testedObject.setProjectKey("projectKey");
		Event event = new Event();
		List<Event> eventList = new ArrayList<>();
		eventList.add(event);
		testedObject.setEvent(eventList);
		testedObject.setAppServer("appServer");
		testedObject.setBuildInterval("buildInterval");
		testedObject.setClientID("clientID");
		testedObject.setLang("lang");
		testedObject.setSolmanpassword("solmanpassword");
		testedObject.setSolmanuserName("solmanuserName");

		assertEquals("appServer", testedObject.getAppServer());
		assertEquals("buildInterval", testedObject.getBuildInterval());
		assertEquals("clientID", testedObject.getClientID());
		assertEquals("lang", testedObject.getLang());
		assertEquals("solmanpassword", testedObject.getSolmanpassword());
		assertEquals("solmanuserName", testedObject.getSolmanuserName());
		assertEquals("pollSCM12", testedObject.getPollSCM());
		assertEquals("buildIntrvl12", testedObject.getBuildInterval());
		assertEquals("buildIntervalValue11", testedObject.getBuildIntervalValue());
		assertEquals("buildAtSpecificInterval", testedObject.getBuildAtSpecificInterval());
		assertEquals("projectKey", testedObject.getProjectKey());
		assertEquals(eventList, testedObject.getEvent());
	}

	/**
	 * Test for method BuildInterval().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BuildInterval#BuildInterval()
	 * 
	 * 
	 */
	@Test
	public void testBuildIntervalValues2() throws Throwable {
		BuildInterval testedObject = new BuildInterval();
		testedObject.setPollSCM("pollSCM0");
		testedObject.setBuildInterval("buildIntrvl0");
		testedObject.setBuildIntervalValue((String) null);
		assertEquals("pollSCM0", testedObject.getPollSCM());
		assertEquals("buildIntrvl0", testedObject.getBuildInterval());
		assertEquals(null, testedObject.getBuildIntervalValue());
	}

	/**
	 * Test for method BuildInterval().
	 * 
	 * @throws Throwable Tests may throw any Throwable
	 *
	 * @see BuildInterval#BuildInterval()
	 * 
	 * 
	 */
	@Test
	public void testBuildIntervalNull() throws Throwable {
		BuildInterval testedObject = new BuildInterval();

		assertNull(testedObject.getPollSCM());
		assertNull(testedObject.getBuildInterval());
		assertNull(testedObject.getBuildIntervalValue());
		assertNull(testedObject.getBuildAtSpecificInterval());
		assertNull(testedObject.getProjectKey());
		assertNull(testedObject.getEvent());
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
	 * Usage: java BuildIntervalTest
	 * 
	 * @param args command line arguments are not needed
	 * 
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.basicInfo.BuildIntervalTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */
	public Class getTestedClass() {
		return BuildInterval.class;
	}
}
