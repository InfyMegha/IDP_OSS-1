/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.deploy

import com.infy.idp.plugins.wrappers.ToolEnvBuildWrapper
import com.infy.idp.utils.*

/**
 *
 * This class has the method to create the Cloud Deploy job
 *
 */
class CloudDeploy {


    static String basepath

    /*
     * This method is used to add conditional steps
     */

    private static void addSteps(context, jsonData, index, i) {
        context.with {
            steps {


                def cmd2 = 'java -jar %CLOUD_UTILITY_HOME%/cloudCall.jar ' + PropReader.readProperty(Constants.CONFIGFN, 'CLOUD_SERV_URL') + ' ' + jsonData.basicInfo.applicationName + ' ' + jsonData.basicInfo.pipelineName + '_' + jsonData.deployInfo.deployEnv[index].envName + '_' + jsonData.deployInfo.deployEnv[index].deploySteps[i].stepName
                ExecuteCmd.invokeCmd(delegate, cmd2, jsonData.basicInfo.buildServerOS)


            }
        }
    }

    /*
     * This method is used to add required wrappers
     */

    private static void addWrappers(context) {
        def toolList = ',CLOUD_UTILITY_HOME'

        context.with {
            wrappers {
                (new ToolEnvBuildWrapper()).invokeToolEnvBuildWrapper(delegate, toolList)
            }
        }
    }

    /*
     * This method is used to create cloud deploy job
     */

    public static void cloudDeployJobCreation(context, jsonData, index, i) {
        context.with {

            //Standard IDP Settings
            configure { it / canRoam(false) }
            concurrentBuild(true)

            //Configurable Settings of Job
            //addProperties(delegate)
            addSteps(delegate, jsonData, index, i)
            //addPublishers(delegate,jsonData)
            addWrappers(delegate)

            //Optional settings of job

        }
    }


}
