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
import org.infy.idp.entities.nexus.Item;
import org.infy.idp.entities.nexus.Nexus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NexusTest extends PackageTestCase {
	public NexusTest() {

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
	public void testNexusValues() throws Throwable {

		Nexus testObject = new Nexus();
		testObject.setContinuationToken("wdfawf");
		Item a = new Item();
		a.setRepository("idpwinv05");
		List<Item> as = new ArrayList<Item>();
		as.add(a);
		testObject.setItems(as);

		assertEquals("idpwinv05", testObject.getItems().get(0).getRepository());
		assertEquals("wdfawf", testObject.getContinuationToken());
	}

	@Test
	public void testNexusNull() throws Throwable {

		Nexus testObject = new Nexus();

		assertNull(testObject.getItems());
		assertNull(testObject.getContinuationToken());
	}

	@Test
	public void testItem() throws Throwable {

		Nexus testObject = new Nexus();
		Item a = new Item();
		a.setRepository("idpwinv05");
		List<Item> as = new ArrayList<Item>();
		as.add(a);
		testObject.setItems(as);

		assertNotNull(testObject.getItems());
		assertEquals("idpwinv05", testObject.getItems().get(0).getRepository());
		assertNull(testObject.getItems().get(0).getFormat());
		assertNull(testObject.getItems().get(0).getGroup());
		assertNull(testObject.getItems().get(0).getId());
		assertNull(testObject.getItems().get(0).getName());
		assertNull(testObject.getItems().get(0).getVersion());
		assertNull(testObject.getItems().get(0).getAssets());

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

		org.junit.runner.JUnitCore.main("org.infy.entities.nexus.NexusTest");
	}

	/**
	 * Get the class object of the class which will be tested.
	 * 
	 * @return the class which will be tested
	 */
	public Class<Nexus> getTestedClass() {
		return Nexus.class;
	}
}
