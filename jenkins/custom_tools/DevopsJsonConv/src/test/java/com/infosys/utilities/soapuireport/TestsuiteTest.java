package com.infosys.utilities.soapuireport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.infosys.utilities.soapuireport.Testsuite.Properties;
import com.infosys.utilities.soapuireport.Testsuite.Properties.Property;

public class TestsuiteTest {

	@Test
	public void testEquals()
	{
		Testsuite testsuite=new Testsuite();
		
		testsuite.setErrors("value");
		testsuite.setFailures("value");
		testsuite.setName("value");
		testsuite.setTests("value");
		testsuite.setTime("value");
		
		assertEquals("value",testsuite.getErrors());
		assertEquals("value",testsuite.getFailures());
		assertEquals("value",testsuite.getName());
		assertEquals(0,testsuite.getProperties().size());
		assertEquals(0,testsuite.getTestcase().size());
		assertEquals("value",testsuite.getTests());
		assertEquals("value",testsuite.getTime());
		
		Properties properties=new Properties();
		assertEquals(0,properties.getProperty().size());
		
		Property property=new Property();
		
		property.setName("value");
		property.setValue("value");
	}
}
