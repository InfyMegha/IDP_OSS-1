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
// Generated on: 2017.08.04 at 01:13:43 PM IST 
//


package com.infosys.utilities.qualitia;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the qualitia package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: qualitia
     * 
     */
    

    /**
     * Create an instance of {@link QualitiaTest }
     * 
     */
    public QualitiaTest createReport() {
        return new QualitiaTest();
    }

    /**
     * Create an instance of {@link QualitiaTest.Suite }
     * 
     */
    public QualitiaTest.Suite createReportSuite() {
        return new QualitiaTest.Suite();
    }

    /**
     * Create an instance of {@link QualitiaTest.Suite.TCs }
     * 
     */
    public QualitiaTest.Suite.TCs createReportSuiteTCs() {
        return new QualitiaTest.Suite.TCs();
    }

    /**
     * Create an instance of {@link QualitiaTest.Suite.TCs.TC }
     * 
     */
    public QualitiaTest.Suite.TCs.TC createReportSuiteTCsTC() {
        return new QualitiaTest.Suite.TCs.TC();
    }

    /**
     * Create an instance of {@link QualitiaTest.Suite.TCs.TC.TCIteration }
     * 
     */
    public QualitiaTest.Suite.TCs.TC.TCIteration createReportSuiteTCsTCTCIteration() {
        return new QualitiaTest.Suite.TCs.TC.TCIteration();
    }

}
