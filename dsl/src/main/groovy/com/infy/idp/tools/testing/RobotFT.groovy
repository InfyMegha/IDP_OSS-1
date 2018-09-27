/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.testing

import com.infy.idp.plugins.publishers.ArchiveArtifacts
import com.infy.idp.plugins.publishers.RobotPublisher
import com.infy.idp.utils.Constants
import com.infy.idp.utils.ExecuteCmd

//import com.infy.idp.utils.XShell
/**
 *
 * This class has the method to add RobotFT testing tool
 *
 */
class RobotFT {

    /*
     * This method is used to add the steps to configure RobotFT
     */

    public static void addSteps(context, testScriptPath, argFileName, os) {

        String srcDir = testScriptPath

        if (srcDir.contains('/') && srcDir.contains('.robot'))
            srcDir = srcDir.substring(0, srcDir.lastIndexOf('/'))

        String idpWS = (os == Constants.WINDOWSOS) ? '%IDP_WS%/' : '$IDP_WS/'
        srcDir = idpWS + srcDir
        String opDir = srcDir + '/reports'

        String cmd

        if (argFileName) {
            cmd = 'cd "' + srcDir + '"\n robot --nostatusrc --outputdir "' + opDir + '" --argumentfile "' + srcDir + '/' + argFileName + '" "' + srcDir + '"'
        } else {
            cmd = 'robot --nostatusrc --outputdir "' + opDir + '" "' + srcDir + '"'
        }

        ExecuteCmd.invokeCmd(context, cmd, os)
    }

    /*
    * This method is used to add required publishers
    */

    public static void addPublishers(context, jsonData, envIndex, stepIndex) {

        String srcDir = null


        srcDir = jsonData.testInfo.testEnv.getAt(envIndex).testSteps.getAt(stepIndex).test.rootDir


        if (srcDir.contains('/') && srcDir.contains('.robot'))
            srcDir = srcDir.substring(0, srcDir.lastIndexOf('/'))

        String opDir = srcDir + '/reports'

        RobotPublisher rp = new RobotPublisher()
        rp.setOpPath(opDir)
        rp.add(context, jsonData)

        ArchiveArtifacts archiveArtifacts = new ArchiveArtifacts()
        archiveArtifacts.setPattern(opDir + '/**')
        archiveArtifacts.add(context, jsonData)
    }
}
