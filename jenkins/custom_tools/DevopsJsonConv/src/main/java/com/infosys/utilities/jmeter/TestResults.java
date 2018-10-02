//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.18 at 02:39:31 AM IST 
//
package com.infosys.utilities.jmeter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "httpSample", "sample" })
@XmlRootElement(name = "testResults")
public class TestResults {
	@XmlElement(required = true)
	protected List<TestResults.HttpSample> httpSample;
	@XmlElement(required = true)
	protected List<TestResults.Sample> sample;
	@XmlAttribute(name = "version")
	protected BigDecimal version;

	public List<TestResults.HttpSample> getHttpSample() {
		if (httpSample == null) {
			httpSample = new ArrayList<TestResults.HttpSample>();
		}
		return this.httpSample;
	}

	public List<TestResults.Sample> getSample() {
		if (sample == null) {
			sample = new ArrayList<TestResults.Sample>();
		}
		return this.sample;
	}

	public BigDecimal getVersion() {
		return version;
	}

	public void setVersion(BigDecimal value) {
		this.version = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "assertionResult" })
	public static class HttpSample {
		@XmlElement(required = true)
		protected TestResults.HttpSample.AssertionResult assertionResult;
		@XmlAttribute(name = "t")
		protected Integer t;
		@XmlAttribute(name = "it")
		protected Integer it;
		@XmlAttribute(name = "lt")
		protected Integer lt;
		@XmlAttribute(name = "ct")
		protected Integer ct;
		@XmlAttribute(name = "ts")
		protected BigDecimal ts;
		@XmlAttribute(name = "s")
		protected Boolean s;
		@XmlAttribute(name = "lb")
		protected String lb;
		@XmlAttribute(name = "rc")
		protected String rc;
		@XmlAttribute(name = "rm")
		protected String rm;
		@XmlAttribute(name = "tn")
		protected String tn;
		@XmlAttribute(name = "dt")
		protected String dt;
		@XmlAttribute(name = "by")
		protected Integer by;
		@XmlAttribute(name = "sby")
		protected Integer sby;
		@XmlAttribute(name = "ng")
		protected Integer ng;
		@XmlAttribute(name = "na")
		protected Integer na;

		public TestResults.HttpSample.AssertionResult getAssertionResult() {
			return assertionResult;
		}

		public void setAssertionResult(TestResults.HttpSample.AssertionResult value) {
			this.assertionResult = value;
		}

		public Integer getT() {
			return t;
		}

		public void setT(Integer value) {
			this.t = value;
		}

		public Integer getIt() {
			return it;
		}

		public void setIt(Integer value) {
			this.it = value;
		}

		public Integer getLt() {
			return lt;
		}

		public void setLt(Integer value) {
			this.lt = value;
		}

		public Integer getCt() {
			return ct;
		}

		public void setCt(Integer value) {
			this.ct = value;
		}

		public BigDecimal getTs() {
			return ts;
		}

		public void setTs(BigDecimal value) {
			this.ts = value;
		}

		public Boolean isS() {
			return s;
		}

		public void setS(Boolean value) {
			this.s = value;
		}

		public String getLb() {
			return lb;
		}

		public void setLb(String value) {
			this.lb = value;
		}

		public String getRc() {
			return rc;
		}

		public void setRc(String value) {
			this.rc = value;
		}

		public String getRm() {
			return rm;
		}

		public void setRm(String value) {
			this.rm = value;
		}

		public String getTn() {
			return tn;
		}

		public void setTn(String value) {
			this.tn = value;
		}

		public String getDt() {
			return dt;
		}

		public void setDt(String value) {
			this.dt = value;
		}

		public Integer getBy() {
			return by;
		}

		public void setBy(Integer value) {
			this.by = value;
		}

		public Integer getSby() {
			return sby;
		}

		public void setSby(Integer value) {
			this.sby = value;
		}

		public Integer getNg() {
			return ng;
		}

		public void setNg(Integer value) {
			this.ng = value;
		}

		public Integer getNa() {
			return na;
		}

		public void setNa(Integer value) {
			this.na = value;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "name", "failure", "error" })
		public static class AssertionResult {
			@XmlElement(required = true)
			protected String name;
			protected boolean failure;
			protected boolean error;

			public String getName() {
				return name;
			}

			public void setName(String value) {
				this.name = value;
			}

			public boolean isFailure() {
				return failure;
			}

			public void setFailure(boolean value) {
				this.failure = value;
			}

			public boolean isError() {
				return error;
			}

			public void setError(boolean value) {
				this.error = value;
			}
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class Sample {
		@XmlAttribute(name = "t")
		protected Integer t;
		@XmlAttribute(name = "it")
		protected Integer it;
		@XmlAttribute(name = "lt")
		protected Integer lt;
		@XmlAttribute(name = "ct")
		protected Integer ct;
		@XmlAttribute(name = "ts")
		protected BigDecimal ts;
		@XmlAttribute(name = "s")
		protected Boolean s;
		@XmlAttribute(name = "lb")
		protected String lb;
		@XmlAttribute(name = "rc")
		protected String rc;
		@XmlAttribute(name = "rm")
		protected String rm;
		@XmlAttribute(name = "tn")
		protected String tn;
		@XmlAttribute(name = "dt")
		protected String dt;
		@XmlAttribute(name = "by")
		protected Integer by;
		@XmlAttribute(name = "sby")
		protected Integer sby;
		@XmlAttribute(name = "ng")
		protected Integer ng;
		@XmlAttribute(name = "na")
		protected Integer na;

		public Integer getT() {
			return t;
		}

		public void setT(Integer value) {
			this.t = value;
		}

		public Integer getIt() {
			return it;
		}

		public void setIt(Integer value) {
			this.it = value;
		}

		public Integer getLt() {
			return lt;
		}

		public void setLt(Integer value) {
			this.lt = value;
		}

		public Integer getCt() {
			return ct;
		}

		public void setCt(Integer value) {
			this.ct = value;
		}

		public BigDecimal getTs() {
			return ts;
		}

		public void setTs(BigDecimal value) {
			this.ts = value;
		}

		public Boolean isS() {
			return s;
		}

		public void setS(Boolean value) {
			this.s = value;
		}

		public String getLb() {
			return lb;
		}

		public void setLb(String value) {
			this.lb = value;
		}

		public String getRc() {
			return rc;
		}

		public void setRc(String value) {
			this.rc = value;
		}

		public String getRm() {
			return rm;
		}

		public void setRm(String value) {
			this.rm = value;
		}

		public String getTn() {
			return tn;
		}

		public void setTn(String value) {
			this.tn = value;
		}

		public String getDt() {
			return dt;
		}

		public void setDt(String value) {
			this.dt = value;
		}

		public Integer getBy() {
			return by;
		}

		public void setBy(Integer value) {
			this.by = value;
		}

		public Integer getSby() {
			return sby;
		}

		public void setSby(Integer value) {
			this.sby = value;
		}

		public Integer getNg() {
			return ng;
		}

		public void setNg(Integer value) {
			this.ng = value;
		}

		public Integer getNa() {
			return na;
		}

		public void setNa(Integer value) {
			this.na = value;
		}
	}
}
