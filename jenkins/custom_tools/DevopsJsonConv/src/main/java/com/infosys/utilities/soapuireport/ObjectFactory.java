/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.10 at 05:51:59 PM IST 
//


package com.infosys.utilities.soapuireport;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.infosys.Utils.SoapUIReport package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.infosys.Utils.SoapUIReport
     * 
     */
    

    /**
     * Create an instance of {@link Testsuite }
     * 
     */
    public Testsuite createTestsuite() {
        return new Testsuite();
    }

    /**
     * Create an instance of {@link Testsuite.Testcase }
     * 
     */
    public Testsuite.Testcase createTestsuiteTestcase() {
        return new Testsuite.Testcase();
    }

    /**
     * Create an instance of {@link Testsuite.Properties }
     * 
     */
    public Testsuite.Properties createTestsuiteProperties() {
        return new Testsuite.Properties();
    }

    /**
     * Create an instance of {@link NewDataSet }
     * 
     */
    public NewDataSet createNewDataSet() {
        return new NewDataSet();
    }

    /**
     * Create an instance of {@link Testsuite.Testcase.Failure }
     * 
     */
    public Testsuite.Testcase.Failure createTestsuiteTestcaseFailure() {
        return new Testsuite.Testcase.Failure();
    }

    /**
     * Create an instance of {@link Testsuite.Properties.Property }
     * 
     */
    public Testsuite.Properties.Property createTestsuitePropertiesProperty() {
        return new Testsuite.Properties.Property();
    }

}
