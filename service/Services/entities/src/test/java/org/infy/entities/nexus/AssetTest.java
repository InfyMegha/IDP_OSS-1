/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.entities.nexus;

import org.infy.entities.triggerinputs.PackageTestCase;
import org.infy.idp.entities.nexus.Asset;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AssetTest extends PackageTestCase {
	public AssetTest() {

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
	 * 
	 * Test for get and set
	 * 
	 */
	@Test
	public void testAssetsValues() throws Throwable {

		org.infy.idp.entities.nexus.Asset testObject = new org.infy.idp.entities.nexus.Asset();
		testObject.setRepository("nexus");
		testObject.setDownloadUrl("http://url");
		testObject.setFormat("format");
		testObject.setId("123");
		testObject.setPath("D:/");
		assertEquals("nexus", testObject.getRepository());
		assertEquals("http://url", testObject.getDownloadUrl());
		assertEquals("format", testObject.getFormat());
		assertEquals("123", testObject.getId());
		assertEquals("D:/", testObject.getPath());

	}

	/**
	 * 
	 * Test for get and set
	 * 
	 */
	@Test
	public void testAssetsNull() throws Throwable {

		org.infy.idp.entities.nexus.Asset testObject = new org.infy.idp.entities.nexus.Asset();

		assertNull(testObject.getRepository());
		assertNull(testObject.getDownloadUrl());
		assertNull(testObject.getFormat());
		assertNull(testObject.getId());
		assertNull(testObject.getPath());

	}

	/**
	 * Utility main method. Runs the test cases defined in this test class.
	 * 
	 * Usage: java TestTest
	 * 
	 * @param args command line arguments are not needed
	 */
	public static void main(String[] args) {
		// junit.textui.TestRunner will print the test results to stdout.

		org.junit.runner.JUnitCore.main("org.infy.entities.nexus.AssetTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 */
	public Class<Asset> getTestedClass() {
		return Asset.class;
	}

}
