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
// Generated on: 2017.12.12 at 03:15:49 PM IST 
//


package com.infosys.utilities.oats;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.infosys.Utils.OATS package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.infosys.Utils.OATS
     * 
     */
    

    /**
     * Create an instance of {@link Script }
     * 
     */
    public Script createScript() {
        return new Script();
    }

    /**
     * Create an instance of {@link Script.I18NProperty }
     * 
     */
    public Script.I18NProperty createScriptI18NProperty() {
        return new Script.I18NProperty();
    }

    /**
     * Create an instance of {@link Script.Initialize }
     * 
     */
    public Script.Initialize createScriptInitialize() {
        return new Script.Initialize();
    }

    /**
     * Create an instance of {@link Script.Finish }
     * 
     */
    public Script.Finish createScriptFinish() {
        return new Script.Finish();
    }

}
