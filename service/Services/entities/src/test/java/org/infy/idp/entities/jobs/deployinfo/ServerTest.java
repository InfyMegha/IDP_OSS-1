/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.entities.jobs.deployinfo;

import org.infy.idp.entities.jobs.deployinfo.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ServerTest is a test class for Server
 *
 * @see org.infy.idp.entities.jobs.deployinfo.Server
 *  
 */
public class ServerTest extends PackageTestCase {

	/**
	 * Constructor for test class.
	 *
	 *  
	 */
	public ServerTest() {
		/*
		 * This constructor should not be modified. Any initialization code
		 * should be placed in the setUp() method instead.
		 */

	}

	/**
	 * Test for method Server().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see Server#Server()
	 *  
	 * 
	 */
	@Test
	public void testServer0() throws Throwable {
		Server testedObject = new Server();
		testedObject.setHost("host12");
		testedObject.setDbName("dbName12");
		testedObject.setHostUserName("hostUserName12");
		testedObject.setHostPassword("hostPassword12");
		testedObject.setDbOwner("dbOwner12");
		testedObject.setRepo("repo12");
		testedObject.setDatFilePath("datFilePath12");
		testedObject.setDbNameOfIndex("dbNameOfIndex12");
		testedObject.setHostName("hostName12");
		testedObject.setSrcPath("srcPath12");
		testedObject.setDestinationPath("destinationPath12");
		testedObject.setUserName("userName12");
		testedObject.setPassword("password12");
		testedObject.setServerName("serverName11");
		assertEquals("host12", testedObject.getHost()); // jtest_unverified
		assertEquals("hostName12", testedObject.getHostName()); // jtest_unverified
		assertEquals("dbName12", testedObject.getDbName()); // jtest_unverified
		assertEquals("hostUserName12", testedObject.getHostUserName()); // jtest_unverified
		assertEquals("hostPassword12", testedObject.getHostPassword()); // jtest_unverified
		assertEquals("dbOwner12", testedObject.getDbOwner()); // jtest_unverified
		assertEquals("repo12", testedObject.getRepo()); // jtest_unverified
		assertEquals("srcPath12", testedObject.getSrcPath()); // jtest_unverified
		assertEquals("password12", testedObject.getPassword()); // jtest_unverified
		assertEquals("dbNameOfIndex12", testedObject.getDbNameOfIndex()); // jtest_unverified
		assertEquals("userName12", testedObject.getUserName()); // jtest_unverified
		assertEquals("datFilePath12", testedObject.getDatFilePath()); // jtest_unverified
		assertEquals("serverName11", testedObject.getServerName()); // jtest_unverified
		assertEquals("destinationPath12", testedObject.getDestinationPath()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method Server().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see Server#Server()
	 *  
	 * 
	 */
	@Test
	public void testServer2() throws Throwable {
		Server testedObject = new Server();
		testedObject.setHost("host0");
		testedObject.setDbName("dbName0");
		testedObject.setHostUserName("hostUserName0");
		testedObject.setHostPassword("hostPassword0");
		testedObject.setDbOwner("dbOwner0");
		testedObject.setRepo("repo0");
		testedObject.setDatFilePath("datFilePath0");
		testedObject.setDbNameOfIndex("dbNameOfIndex0");
		testedObject.setHostName("hostName0");
		testedObject.setSrcPath("srcPath0");
		testedObject.setDestinationPath("destinationPath0");
		testedObject.setUserName("userName0");
		testedObject.setPassword("password0");
		testedObject.setServerName((String) null);
		assertEquals("host0", testedObject.getHost()); // jtest_unverified
		assertEquals("hostName0", testedObject.getHostName()); // jtest_unverified
		assertEquals("dbName0", testedObject.getDbName()); // jtest_unverified
		assertEquals("hostUserName0", testedObject.getHostUserName()); // jtest_unverified
		assertEquals("hostPassword0", testedObject.getHostPassword()); // jtest_unverified
		assertEquals("dbOwner0", testedObject.getDbOwner()); // jtest_unverified
		assertEquals("repo0", testedObject.getRepo()); // jtest_unverified
		assertEquals("srcPath0", testedObject.getSrcPath()); // jtest_unverified
		assertEquals("password0", testedObject.getPassword()); // jtest_unverified
		assertEquals("dbNameOfIndex0", testedObject.getDbNameOfIndex()); // jtest_unverified
		assertEquals("userName0", testedObject.getUserName()); // jtest_unverified
		assertEquals("datFilePath0", testedObject.getDatFilePath()); // jtest_unverified
		assertEquals(null, testedObject.getServerName()); // jtest_unverified
		assertEquals("destinationPath0", testedObject.getDestinationPath()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
	}

	/**
	 * Test for method Server().
	 * 
	 * @throws Throwable
	 *             Tests may throw any Throwable
	 *
	 * @see Server#Server()
	 *  
	 * 
	 */
	@Test
	public void testServer3() throws Throwable {
		Server testedObject = new Server();
		assertEquals(null, testedObject.getHost()); // jtest_unverified
		assertEquals(null, testedObject.getHostName()); // jtest_unverified
		assertEquals(null, testedObject.getDbName()); // jtest_unverified
		assertEquals(null, testedObject.getHostUserName()); // jtest_unverified
		assertEquals(null, testedObject.getHostPassword()); // jtest_unverified
		assertEquals(null, testedObject.getDbOwner()); // jtest_unverified
		assertEquals(null, testedObject.getRepo()); // jtest_unverified
		assertEquals(null, testedObject.getSrcPath()); // jtest_unverified
		assertEquals(null, testedObject.getPassword()); // jtest_unverified
		assertEquals(null, testedObject.getDbNameOfIndex()); // jtest_unverified
		assertEquals(null, testedObject.getUserName()); // jtest_unverified
		assertEquals(null, testedObject.getDatFilePath()); // jtest_unverified
		assertEquals(null, testedObject.getServerName()); // jtest_unverified
		assertEquals(null, testedObject.getDestinationPath()); // jtest_unverified
		// No exception thrown
		// jtest_unverified
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
		/*
		 * Add any necessary cleanup code here (e.g., close a socket).
		 */
		super.tearDown();
	}

	/**
	 * Utility main method. Runs the test cases defined in this test class.
	 * 
	 * Usage: java ServerTest
	 * 
	 * @param args
	 *            command line arguments are not needed
	 *  
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.idp.entities.jobs.deployInfo.ServerTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 *  
	 */
	public Class getTestedClass() {
		return Server.class;
	}
}
// JTEST_CURRENT_ID=126936383.