/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.entities.triggerinputs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnvironmentObjTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 * 
	 */
	public EnvironmentObjTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	@Test
	public void testEnvObj() throws Throwable {
		EnvironmentObj testObject = new EnvironmentObj();
		testObject.setBizCheck("checked");
		testObject.setEnvName("dev");
		assertEquals("checked", testObject.getBizCheck());
		assertEquals("dev", testObject.getEnvName());
	}

	@Test
	public void testNullEnvObj() throws Throwable {
		EnvironmentObj testObject = new EnvironmentObj();
		testObject.setBizCheck(null);
		testObject.setEnvName(null);
		assertNull(testObject.getBizCheck());
		assertNull(testObject.getEnvName());
	}

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

		org.junit.runner.JUnitCore.main("org.infy.entities.triggerinputs.EnvironmentObjTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */

	@SuppressWarnings("rawtypes")
	public Class getTestedClass() {
		return EnvironmentObj.class;
	}

}
