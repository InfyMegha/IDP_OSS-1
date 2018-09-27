/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.testing

import com.infy.idp.plugins.publishers.ArchiveArtifacts
import com.infy.idp.plugins.publishers.TestNG
import com.infy.idp.utils.Maven

/**
 *
 * This class has the method to add ITopsFT testing tool
 *
 */
class ITopsFT {

    /*
    * This method is used to add the steps to configure ITopsFT
    */

    public static void addSteps(context, pomPath, appUrl, mvnProperties) {

        if (appUrl)
            pomPath += (' -Durl=' + appUrl)

        Maven.invokeMaven(context, 'clean integration-test', pomPath, prepareMapFromString(mvnProperties))
        //Maven.invokeMaven(context, 'clean integration-test', pomPath, [test:10])
    }

    /*
     * This method is used to prepare map from string
     */

    public static Map<String, Integer> prepareMapFromString(String propString) {

        Map<String, String> myMap = new HashMap<String, Integer>()
        String[] pairs = propString.split(",")

        for (int i = 0; i < pairs.length; i++) {

            String pair = pairs[i];
            String[] keyValue = pair.split("=");
            myMap.put(keyValue[0], keyValue[1]);
        }

        return myMap
    }

    /*
     * This method is used to add required publishers
     */

    public static void addPublishers(context, jsonData) {

        TestNG testNG = new TestNG()
        testNG.setPattern('**/testng-results.xml')
        testNG.add(context, jsonData)

        ArchiveArtifacts archiveArtifacts = new ArchiveArtifacts()
        archiveArtifacts.setPattern('target/*.csv,target/*.pdf,**/testng-results.xml')
        archiveArtifacts.add(context, jsonData)
    }
}
