/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.deployinfo;

import org.infy.entities.triggerinputs.PackageTestCase;
import org.infy.idp.entities.jobs.deployinfo.DeployDatabase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeployDatabaseTest extends PackageTestCase {

	public DeployDatabaseTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	@Test
	public void testDeployDatabase() throws Throwable {
		DeployDatabase db = new DeployDatabase();
		db.setDbpassword("admin123");
		db.setDbusername("admin");
		db.setRestorpassword("admin123");
		db.setRestorusername("admin");
		db.setScript("script");

		assertEquals("admin123", db.getDbpassword());
		assertEquals("admin", db.getDbusername());
		assertEquals("admin123", db.getRestorpassword());
		assertEquals("admin", db.getRestorusername());
		assertEquals("script", db.getScript());
	}

	@Test
	public void testNullDeployDatabase() throws Throwable {
		DeployDatabase db = new DeployDatabase();
		db.setDbpassword(null);
		db.setDbusername(null);
		db.setRestorpassword(null);
		db.setRestorusername(null);
		db.setScript(null);

		assertNull(db.getDbpassword());
		assertNull(db.getDbusername());
		assertNull(db.getRestorpassword());
		assertNull(db.getRestorusername());
		assertNull(db.getScript());
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
		/*
		 * Add any necessary cleanup code here (e.g., close a socket).
		 */
		super.tearDown();
	}

	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.deployInfo.DeployDatabaseTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 * 
	 */

	@SuppressWarnings("rawtypes")
	public Class getTestedClass() {
		return DeployDatabase.class;
	}
}
