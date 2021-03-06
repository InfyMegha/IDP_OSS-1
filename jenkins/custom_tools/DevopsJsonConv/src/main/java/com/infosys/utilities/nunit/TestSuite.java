/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.02 at 08:54:42 PM IST 
//


package com.infosys.utilities.nunit;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}environment" minOccurs="0"/>
 *         &lt;element ref="{}settings" minOccurs="0"/>
 *         &lt;element ref="{}properties" minOccurs="0"/>
 *         &lt;element ref="{}failure" minOccurs="0"/>
 *         &lt;element ref="{}test-case" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}test-suite" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="asserts" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="classname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="duration" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="end-time" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="fullname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="inconclusive" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="passed" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="result" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="runstate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="site" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="skipped" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="start-time" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="testcasecount" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="total" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "environment",
    "settings",
    "properties",
    "failure",
    "testCase",
    "testSuite"
})
@XmlRootElement(name = "test-suite")
public class TestSuite {

    protected Environment environment;
    protected Settings settings;
    protected Properties properties;
    protected Failure failure;
    @XmlElement(name = "test-case")
    protected List<TestCase> testCase;
    @XmlElement(name = "test-suite")
    protected List<TestSuite> testSuite;
    @XmlAttribute(name = "asserts")
    protected Byte asserts;
    @XmlAttribute(name = "classname")
    protected String classname;
    @XmlAttribute(name = "duration")
    protected Float duration;
    @XmlAttribute(name = "end-time")
    protected String endTime;
    @XmlAttribute(name = "failed")
    protected Byte failed;
    @XmlAttribute(name = "fullname")
    protected String fullname;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "inconclusive")
    protected Byte inconclusive;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "passed")
    protected Byte passed;
    @XmlAttribute(name = "result")
    protected String result;
    @XmlAttribute(name = "runstate")
    protected String runstate;
    @XmlAttribute(name = "site")
    protected String site;
    @XmlAttribute(name = "skipped")
    protected Byte skipped;
    @XmlAttribute(name = "start-time")
    protected String startTime;
    @XmlAttribute(name = "testcasecount")
    protected Byte testcasecount;
    @XmlAttribute(name = "total")
    protected Byte total;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the environment property.
     * 
     * @return
     *     possible object is
     *     {@link Environment }
     *     
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * Sets the value of the environment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Environment }
     *     
     */
    public void setEnvironment(Environment value) {
        this.environment = value;
    }

    /**
     * Gets the value of the settings property.
     * 
     * @return
     *     possible object is
     *     {@link Settings }
     *     
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     * Sets the value of the settings property.
     * 
     * @param value
     *     allowed object is
     *     {@link Settings }
     *     
     */
    public void setSettings(Settings value) {
        this.settings = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link Properties }
     *     
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link Properties }
     *     
     */
    public void setProperties(Properties value) {
        this.properties = value;
    }

    /**
     * Gets the value of the failure property.
     * 
     * @return
     *     possible object is
     *     {@link Failure }
     *     
     */
    public Failure getFailure() {
        return failure;
    }

    /**
     * Sets the value of the failure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Failure }
     *     
     */
    public void setFailure(Failure value) {
        this.failure = value;
    }

    /**
     * Gets the value of the testCase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the testCase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTestCase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TestCase }
     * 
     * 
     */
    public List<TestCase> getTestCase() {
        if (testCase == null) {
            testCase = new ArrayList<TestCase>();
        }
        return this.testCase;
    }

    /**
     * Gets the value of the testSuite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the testSuite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTestSuite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TestSuite }
     * 
     * 
     */
    public List<TestSuite> getTestSuite() {
        if (testSuite == null) {
            testSuite = new ArrayList<TestSuite>();
        }
        return this.testSuite;
    }

    /**
     * Gets the value of the asserts property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getAsserts() {
        return asserts;
    }

    /**
     * Sets the value of the asserts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setAsserts(Byte value) {
        this.asserts = value;
    }

    /**
     * Gets the value of the classname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassname() {
        return classname;
    }

    /**
     * Sets the value of the classname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassname(String value) {
        this.classname = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setDuration(Float value) {
        this.duration = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndTime(String value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the failed property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getFailed() {
        return failed;
    }

    /**
     * Sets the value of the failed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setFailed(Byte value) {
        this.failed = value;
    }

    /**
     * Gets the value of the fullname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets the value of the fullname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullname(String value) {
        this.fullname = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the inconclusive property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getInconclusive() {
        return inconclusive;
    }

    /**
     * Sets the value of the inconclusive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setInconclusive(Byte value) {
        this.inconclusive = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the passed property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getPassed() {
        return passed;
    }

    /**
     * Sets the value of the passed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setPassed(Byte value) {
        this.passed = value;
    }

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResult(String value) {
        this.result = value;
    }

    /**
     * Gets the value of the runstate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRunstate() {
        return runstate;
    }

    /**
     * Sets the value of the runstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRunstate(String value) {
        this.runstate = value;
    }

    /**
     * Gets the value of the site property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSite() {
        return site;
    }

    /**
     * Sets the value of the site property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSite(String value) {
        this.site = value;
    }

    /**
     * Gets the value of the skipped property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getSkipped() {
        return skipped;
    }

    /**
     * Sets the value of the skipped property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setSkipped(Byte value) {
        this.skipped = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTime(String value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the testcasecount property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getTestcasecount() {
        return testcasecount;
    }

    /**
     * Sets the value of the testcasecount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setTestcasecount(Byte value) {
        this.testcasecount = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setTotal(Byte value) {
        this.total = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
