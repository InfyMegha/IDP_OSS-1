//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.03 at 11:18:42 AM IST 
//
package com.infosys.utilities.junit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "properties", "testcase", "systemOut", "systemErr" })
@XmlRootElement(name = "testsuite")
public class Testsuite {
	@XmlElement(required = true)
	protected Testsuite.Properties properties;
	protected List<Testsuite.Testcase> testcase;
	@XmlElement(name = "system-out", required = true)
	protected Object systemOut;
	@XmlElement(name = "system-err", required = true)
	protected Object systemErr;
	@XmlAttribute(name = "tests")
	protected Byte tests;
	@XmlAttribute(name = "failures")
	protected Byte failures;
	@XmlAttribute(name = "name")
	protected String name;
	@XmlAttribute(name = "time")
	protected Float time;
	@XmlAttribute(name = "errors")
	protected Byte errors;
	@XmlAttribute(name = "skipped")
	protected Byte skipped;

	public Testsuite.Properties getProperties() {
		return properties;
	}

	public void setProperties(Testsuite.Properties value) {
		this.properties = value;
	}

	public List<Testsuite.Testcase> getTestcase() {
		if (testcase == null) {
			testcase = new ArrayList<Testsuite.Testcase>();
		}
		return this.testcase;
	}

	public Object getSystemOut() {
		return systemOut;
	}

	public void setSystemOut(Object value) {
		this.systemOut = value;
	}

	public Object getSystemErr() {
		return systemErr;
	}

	public void setSystemErr(Object value) {
		this.systemErr = value;
	}

	public Byte getTests() {
		return tests;
	}

	public void setTests(Byte value) {
		this.tests = value;
	}

	public Byte getFailures() {
		return failures;
	}

	public void setFailures(Byte value) {
		this.failures = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public Float getTime() {
		return time;
	}

	public void setTime(Float value) {
		this.time = value;
	}

	public Byte getErrors() {
		return errors;
	}

	public void setErrors(Byte value) {
		this.errors = value;
	}

	public Byte getSkipped() {
		return skipped;
	}

	public void setSkipped(Byte value) {
		this.skipped = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "property" })
	public static class Properties {
		protected List<Testsuite.Properties.Property> property;

		public List<Testsuite.Properties.Property> getProperty() {
			if (property == null) {
				property = new ArrayList<Testsuite.Properties.Property>();
			}
			return this.property;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		public static class Property {
			@XmlAttribute(name = "name", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			protected String name;
			@XmlAttribute(name = "value", required = true)
			protected String value;

			public String getName() {
				return name;
			}

			public void setName(String value) {
				this.name = value;
			}

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "error", "failure", "skipped" })
	public static class Testcase {
		protected Testsuite.Testcase.Error error;
		protected Testsuite.Testcase.Failure failure;
		protected Testsuite.Testcase.Skipped skipped;
		@XmlAttribute(name = "name", required = true)
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		@XmlSchemaType(name = "token")
		protected String name;
		@XmlAttribute(name = "classname", required = true)
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		@XmlSchemaType(name = "token")
		protected String classname;
		@XmlAttribute(name = "time", required = true)
		protected String time;

		public Testsuite.Testcase.Error getError() {
			return error;
		}

		public void setError(Testsuite.Testcase.Error value) {
			this.error = value;
		}

		public Testsuite.Testcase.Failure getFailure() {
			return failure;
		}

		public void setFailure(Testsuite.Testcase.Failure value) {
			this.failure = value;
		}

		public Testsuite.Testcase.Skipped getSkipped() {
			return skipped;
		}

		public void setSkipped(Testsuite.Testcase.Skipped skipped) {
			this.skipped = skipped;
		}

		public String getName() {
			return name;
		}

		public void setName(String value) {
			this.name = value;
		}

		public String getClassname() {
			return classname;
		}

		public void setClassname(String value) {
			this.classname = value;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String value) {
			this.time = value;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = {})
		public static class Skipped {
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "value" })
		public static class Error {
			@XmlValue
			protected String value;
			@XmlAttribute(name = "message")
			protected String message;
			@XmlAttribute(name = "type", required = true)
			protected String type;

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}

			public String getMessage() {
				return message;
			}

			public void setMessage(String value) {
				this.message = value;
			}

			public String getType() {
				return type;
			}

			public void setType(String value) {
				this.type = value;
			}
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "value" })
		public static class Failure {
			@XmlValue
			protected String value;
			@XmlAttribute(name = "message")
			protected String message;
			@XmlAttribute(name = "type", required = true)
			protected String type;

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}

			public String getMessage() {
				return message;
			}

			public void setMessage(String value) {
				this.message = value;
			}

			public String getType() {
				return type;
			}

			public void setType(String value) {
				this.type = value;
			}
		}
	}
}
