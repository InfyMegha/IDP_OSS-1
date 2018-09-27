/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.deploy

import com.infy.idp.creators.*
import com.infy.idp.utils.*

/**
 *
 * This class has the method to create the Copy Deploy job
 *
 */

class CopyDeploy {

    /*
     * This methos is used to create copy artifacts job
     */

    public static void copyArtifactsJobCreation(context, jsonData, basepath) {
        context.with {

            //Standard IDP Settings
            configure { it / canRoam(false) }
            concurrentBuild(true)
            keepDependencies(false)

            //Configurable Settings of Job
            addProperties(delegate)
            copyArtifacts(delegate, jsonData)

            //Optional settings of job
            String customWS = 'workspace/' + basepath + Constants.WORKSPACENAMEPOSTFIX
            if (customWS) customWorkspace('$IDP_WS')
        }
    }

    /*
     * This method is used to copy artifacts based on the pattern
     */

    public static void copyArtifacts(context, jsonData) {

        def src, dest

        switch (jsonData.code.technology.toString()) {
            case Constants.JAVAMAVENTECH:
                src = jsonData.buildInfo.modules.getAt(0).relativePath.toString().replace("pom.xml", "target/*.war")
                break
            case Constants.VBDOTNETTECH:
            case Constants.CSDOTNETTECH:
                src = ".\\*"
                break
        }
        dest = "D:\\temp\\"

        batchCopyCmd(context, src, dest)
    }

    /*
     * This method forms the copy command
     */

    private static void batchCopyCmd(context, src, dest) {
        context.with {
            steps {
                batchFile("xcopy /S /Y " + src + " " + dest)
            }
        }
    }

    /*
    * This method is used to add properties for parameterized job
    */

    private static void addProperties(context) {
        context.with {
            properties {
                PropertiesAdder.addGitLabConnection(delegate)
                PropertiesAdder.addRebuild(delegate)
                PropertiesAdder.addThrottleJobProperty(delegate)
                PropertiesAdder.addBuildDiscarder(delegate)
            }
            configure {
                it / 'properties' / 'hudson.model.ParametersDefinitionProperty' / 'parameterDefinitions' {
                    PropertiesAdder.addStringParam(delegate, 'IDP_WS', 'NA', 'CUSTOM Workspace')
                    PropertiesAdder.addStringParam(delegate, 'ARTIFACT_VERSION', 'NA', 'This will tell which has version has to be uploaded')
                    PropertiesAdder.addStringParam(delegate, 'ARTIFACT_ID', 'NA', 'This will tell in which folder it has to be uploaded')
                    PropertiesAdder.addNodeParam(delegate, 'SLAVE_NODE', ['ldaproleapp_Jmvn1_14Mr1_Slave'], '')
                }
            }
        }
    }
}
