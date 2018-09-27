/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.testing

import com.infy.idp.plugins.publishers.ArchiveArtifacts
import com.infy.idp.utils.Constants
import com.infy.idp.utils.ExecuteCmd
import com.infy.idp.utils.PropReader
import com.infy.idp.utils.fs.DeleteDir

/**
 *
 * This class has the method to add QualitiaFT testing tool
 *
 */
class QualitiaFT {

    /*
     * This method is used to add the steps to configure QualitiaFT
     */

    public static void addSteps(context, os, rootDir, xmlPath, browserName, ssoId, projectVersion, projectName) {

        String srcDir = rootDir
        String idpWS
        if (os == Constants.WINDOWSOS) {
            idpWS = '%IDP_WS%/'
        } else {
            idpWS = '$IDP_WS/'
        }

        if (srcDir && srcDir.startsWith('/'))
            srcDir = srcDir.substring(1, srcDir.length())

        if (srcDir && srcDir.endsWith('/'))
            srcDir = srcDir.substring(0, srcDir.length() - 1)

        if (xmlPath && xmlPath.startsWith('/'))
            xmlPath = xmlPath.substring(1, xmlPath.length())

        if (xmlPath && xmlPath.endsWith('/'))
            xmlPath = xmlPath.substring(0, xmlPath.length() - 1)

        xmlPath = srcDir + '/' + xmlPath

        String browserPath

        switch (browserName) {
            case Constants.CHROME:
                browserPath = PropReader.readProperty('GE.properties', 'CHROMEBROWSERDRIVER')
                break
            case Constants.IE:
                browserPath = PropReader.readProperty('GE.properties', 'IEBROWSERDRIVER')
                break
            case Constants.FIREFOX:
                browserPath = PropReader.readProperty('GE.properties', 'FIREFOXBROWSERDRIVER')
        }

        DeleteDir.run(context, os, '"' + idpWS + srcDir + '/QualitiaOutput"')
        ExecuteCmd.invokeCmd(context, 'mkdir "' + idpWS + srcDir + '/QualitiaOutput"', os)
        ExecuteCmd.invokeCmd(context, 'cd "' + idpWS + srcDir + '" \n java -jar "qualitia-offline-3.9.4.jar" xmlpath="' + idpWS + xmlPath + '" logPath="' + idpWS + srcDir + '/QualitiaOutput' + '" ChromeDriverPath="' + browserPath + '" UserName="' + ssoId + '" BuildNum="' + projectVersion + '" ReleaseNum="' + projectVersion + '" ProjectName="' + projectName + '"', os)
    }

    /*
     * This method is used to add required publishers
     */

    public static void addPublishers(context, jsonData, envIndex, stepIndex) {

        String srcDir = null
        String projectName = null
        String projectVersion = null

        srcDir = jsonData.testInfo.testEnv.getAt(envIndex).testSteps.getAt(stepIndex).test.rootDir
        projectName = jsonData.testInfo.testEnv.getAt(envIndex).testSteps.getAt(stepIndex).test.projectName
        projectVersion = jsonData.testInfo.testEnv.getAt(envIndex).testSteps.getAt(stepIndex).test.version



        if (srcDir && srcDir.startsWith('/'))
            srcDir = srcDir.substring(1, srcDir.length())

        if (srcDir && srcDir.endsWith('/'))
            srcDir = srcDir.substring(0, srcDir.length() - 1)

        ArchiveArtifacts archiveArtifacts = new ArchiveArtifacts()
        archiveArtifacts.setPattern(srcDir + '/QualitiaOutput/${SYSTEM_NAME}/' + jsonData.ssoId + '/' + projectName + '/' + projectVersion + '/' + projectVersion + '/' + 'IterationNumber_1/**')
        archiveArtifacts.add(context, jsonData)
    }
}
