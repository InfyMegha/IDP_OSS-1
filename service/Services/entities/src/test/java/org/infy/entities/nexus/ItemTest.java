/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package org.infy.entities.nexus;

import java.util.ArrayList;
import java.util.List;

import org.infy.entities.triggerinputs.PackageTestCase;
import org.infy.idp.entities.nexus.Asset;
import org.infy.idp.entities.nexus.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest extends PackageTestCase {
	public ItemTest() {

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
	public void testItemValues() throws Throwable {

		Item testObject = new Item();
		testObject.setRepository("nexus");
		Asset a = new Asset();
		a.setDownloadUrl("idpwinv05");
		List<Asset> as = new ArrayList<Asset>();
		as.add(a);
		testObject.setAssets(as);
		testObject.setGroup("group");
		testObject.setName("name");
		testObject.setFormat("format");
		testObject.setId("123");
		testObject.setVersion("1");

		assertEquals("nexus", testObject.getRepository());

		assertEquals("format", testObject.getFormat());
		assertEquals("123", testObject.getId());
		assertEquals("group", testObject.getGroup());
		assertEquals("name", testObject.getName());
		assertEquals("1", testObject.getVersion());
		assertEquals("idpwinv05", testObject.getAssets().get(0).getDownloadUrl());

	}

	/**
	 * 
	 * Test for get and set
	 * 
	 */
	@Test
	public void testItemNull() throws Throwable {

		Item testObject = new Item();

		assertNull(testObject.getRepository());
		assertNull(testObject.getFormat());
		assertNull(testObject.getId());
		assertNull(testObject.getGroup());
		assertNull(testObject.getName());
		assertNull(testObject.getVersion());
		assertNull(testObject.getAssets());

	}

	@Test
	public void testAsset() throws Throwable {
		Item testObj = new Item();
		Asset a = new Asset();
		a.setDownloadUrl("idpwinv05");
		List<Asset> as = new ArrayList<Asset>();
		as.add(a);
		testObj.setAssets(as);

		assertNotNull(testObj.getAssets());
		assertEquals("idpwinv05", testObj.getAssets().get(0).getDownloadUrl());
		assertNull(testObj.getAssets().get(0).getFormat());
		assertNull(testObj.getAssets().get(0).getRepository());
		assertNull(testObj.getAssets().get(0).getId());
		assertNull(testObj.getAssets().get(0).getPath());
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

		org.junit.runner.JUnitCore.main("org.infy.entities.triggerinputs.ItemTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 */
	public Class<Item> getTestedClass() {
		return Item.class;
	}
}
