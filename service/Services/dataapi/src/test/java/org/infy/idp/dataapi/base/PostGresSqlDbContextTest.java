/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.idp.dataapi.base;

import org.infy.idp.utils.ConfigurationManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * PostGreSqlDbContextTest is a test class for PostGreSqlDbContext
 *
 * @see org.infy.idp.dataapi.PostGreSqlDbContext
 */
@RunWith(MockitoJUnitRunner.class)
public class PostGresSqlDbContextTest extends PackageTestCase {

	@InjectMocks
	private PostGreSqlDbContext postGreSqlDbContext;

	@Spy
	private ConfigurationManager configmanager;

	/**
	 * Constructor for test class.
	 *
	 */
	public PostGresSqlDbContextTest() {
		/*
		 * This constructor should not be modified. Any initialization code should be
		 * placed in the setUp() method instead.
		 */

	}

	@Test
	public void testGetConnection_CheckNull() throws Throwable {

		configmanager.setUrl("jdbc:postgresql://localhost:5400/IDP");
		assertNull(postGreSqlDbContext.getConnection());

	}

	/**
	 * Used to set up the test. This method is called by JUnit before each of the
	 * tests are executed.
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

		try {
			configmanager.setPostgresqldatabase("IDP");
			configmanager.setPostgresqlinitialsize("5");
			configmanager.setPostgresqlpassword("root");
			configmanager.setPostgresqlschemaname("public");
			configmanager.setPostgresqlusername("postgres");
			configmanager.setUrl("jdbc:postgresql://localhost:5432/IDP");

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * Used to clean up after the test. This method is called by JUnit after each of
	 * the tests have been completed.
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
	 * Usage: java PostGreSqlDbContextTest
	 * 
	 * @param args command line arguments are not needed
	 */
	public static void main(String[] args) {

		org.junit.runner.JUnitCore.main("org.infy.idp.dataapi.base.PostGreSqlDbContextTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 */
	public Class getTestedClass() {
		return PostGreSqlDbContext.class;
	}
}
