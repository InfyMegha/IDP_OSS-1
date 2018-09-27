/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.testing

import com.infy.idp.plugins.publishers.ArchiveArtifacts
import com.infy.idp.plugins.wrappers.ToolEnvBuildWrapper
import com.infy.idp.utils.Ant


/**
 *
 * This class has the method to add AcceleraFT testing tool
 *
 */
class AcceleraFT {

    /*
     * This method is used to add the steps to configure acceleraFT
     */

    public static void addSteps(context, acceleraProjectLoc, scriptFilePath) {

        if (acceleraProjectLoc && acceleraProjectLoc.startsWith('/'))
            acceleraProjectLoc = acceleraProjectLoc.substring(1, acceleraProjectLoc.length())

        if (acceleraProjectLoc && acceleraProjectLoc.endsWith('/'))
            acceleraProjectLoc = acceleraProjectLoc.substring(0, acceleraProjectLoc.length() - 1)

        if (scriptFilePath && scriptFilePath.startsWith('/'))
            scriptFilePath = scriptFilePath.substring(1, scriptFilePath.length())

        if (scriptFilePath && scriptFilePath.endsWith('/'))
            scriptFilePath = scriptFilePath.substring(0, scriptFilePath.length() - 1)

        Ant.invokeAnt(context, '', scriptFilePath)
        // XShell.invokeXShell(context, acceleraProjectLoc+'/'+batchFileName)
    }

    /*
     * This method is used to add required publishers
     */

    public static void addPublishers(context, jsonData, envIndex, stepIndex) {

        ArchiveArtifacts archiveArtifacts = new ArchiveArtifacts()

        archiveArtifacts.setPattern(jsonData.testInfo.testEnv.getAt(envIndex).testSteps.getAt(stepIndex).test.path + '/Reports/results/**')

        archiveArtifacts.add(context, jsonData)
    }

    /*
     * This method is used to add required publishers
     */

    public static void addWrappers(context) {


        def tools = 'ANT_HOME'

        if (tools) {
            (new ToolEnvBuildWrapper()).invokeToolEnvBuildWrapper(context, tools)
        }

    }

}
