/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.testing

import com.infy.idp.creators.*
import com.infy.idp.customtools.*
import com.infy.idp.plugins.buildsteps.*
import com.infy.idp.plugins.publishers.*
import com.infy.idp.plugins.wrappers.*
import com.infy.idp.tools.*
import com.infy.idp.utils.*
import com.infy.idp.utils.fs.*

/**
 *
 * This class has the method to add RIT testing tool
 *
 */
class RIT {

    static String basepath

    /*
    * This method is used to add the steps to configure RIT
    */

    private static void addSteps(context, jsonData, processIndex, stepIndex) {

        def testEnvElem = jsonData.testInfo.testProcess.getAt(processIndex)
        def testStepElem = testEnvElem.testSteps.getAt(stepIndex).test

        String command = '';
        if (jsonData.basicInfo.buildServerOS.equalsIgnoreCase(Constants.WINDOWSOS)) {
            command = 'C: \n'
        } else {
            command = 'cd '
        }

        context.with {
            steps {
                String RITCommand = 'C: ' + '\n' + 'cd "%RCL_LOG_CONFIG_PATH%"' + '\n' + 'runTests -noHTTP -environment ' + jsonData.preTestInfo.virtualization.environment + ' -project ' + testStepElem.projectName + ' -run ' + testStepElem.testSuiteName
                ExecuteCmd.invokeCmd(delegate, RITCommand, jsonData.basicInfo.buildServerOS)
            }
        }
    }

    /*
     * This method is used to create test job with RIT configuration detials
     */

    public static void RITJobCreation(context, jsonData, processIndex, stepIndex) {

        context.with {
            //Standard IDP Settings
            configure { it / canRoam(false) }
            concurrentBuild(true)

            //addProperties(delegate)
            addSteps(context, jsonData, processIndex, stepIndex)
            //addWrappers(delegate,jsonData)

            //Optional settings of job
            String customWS = 'workspace/' + basepath + Constants.WORKSPACENAMEPOSTFIX
            if (customWS) customWorkspace('$IDP_WS')
        }
    }


}	
	


