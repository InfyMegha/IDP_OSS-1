/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.deploy

import com.infy.idp.plugins.publishers.*
import com.infy.idp.utils.*
import com.infy.idp.utils.fs.*

/**
 *
 * This class has the method to create the Spring boot Deploy job
 *
 */

class SpringBootDeployment {

    static String basepath

    /*
     * This method is used to add conditional steps
     */

    public static void add(context, jsonData, envIndex, stepIndex, basepath, envVar) {
        this.basepath = basepath
        context.with {
            prepareSpringBootDeployBat(jsonData, envIndex, stepIndex, envVar)
            prepareSpringBootDeployAntXml(jsonData, envIndex, stepIndex, envVar)
            steps {
                def port = jsonData.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].port
                String deployStepName = jsonData.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].stepName
                String envName = jsonData.deployInfo.deployEnv[envIndex].envName
                String command = ''

                if (jsonData.basicInfo.buildServerOS.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
                    command = 'FOR /F "tokens=5 delims= " %%P IN (\'netstat -a -n -o ^|findstr :' + port + '\') DO TaskKill.exe /PID %%P /T /F \n'
                    command += 'exit /b 0'
                } else {
                    prepareSpringBootProcessKillShell(jsonData, envIndex, stepIndex, envVar)
                    command = 'cd ..\n'
                    command += 'chmod 777 $IDP_WS\n'
                    command += 'cd $IDP_WS\n'
                    command += './' + basepath + '_' + envName + '_' + deployStepName + '_spring_boot_process_kill.sh'
                }

                if (jsonData.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].port) {
                    ExecuteCmd.invokeCmd(delegate, command, jsonData.basicInfo.buildServerOS)
                    Ant.invokeAnt(delegate, 'springBoot', basepath + '_' + envName + '_' + deployStepName + '_spring_boot_deploy.xml')
                }
            }

            publishers {

            }
            addWrappers(delegate, jsonData, envIndex, stepIndex)
        }
    }

    /*
     * This method is used to prepare spring boot deploy bat file
     */

    private static void prepareSpringBootDeployBat(jsonData, envIndex, stepIndex, envVar) {

        String deployStepName = jsonData.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].stepName
        String envName = jsonData.deployInfo.deployEnv[envIndex].envName

        def artifactPath = jsonData.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].pathToFiles
        def port = jsonData.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].port
        def extraParamaters = jsonData.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].parameters

        String fileContent = 'java -jar ' + artifactPath + ' --server.port=' + port

        if (extraParamaters && !extraParamaters.equalsIgnoreCase(''))
            fileContent += ' ' + extraParamaters

        def jHome = envVar.JENKINS_HOME
        def fileName = ''
        if (jsonData.basicInfo.buildServerOS.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
            fileName = jHome + '/userContent/' + basepath + '_' + envName + '_' + deployStepName + '_spring_boot_execute.bat'
        } else {
            fileName = jHome + '/userContent/' + basepath + '_' + envName + '_' + deployStepName + '_spring_boot_execute.sh'
        }

        WriteFile.run(fileName, fileContent)
    }

    /*
     * This method is used to add required wrappers
     */

    public static void addWrappers(context, jsonData, envIndex, stepIndex) {

        //def toolList = getListOfTools(jsonData.buildInfo.modules)
        def copyPattern = filesToCopy(jsonData, envIndex, stepIndex)

        context.with {

            wrappers {

                //(new ToolEnvBuildWrapper()).invokeToolEnvBuildWrapper(delegate, toolList)

                if (copyPattern != '')
                    CopyToSlave.invokeCopyToSlave(delegate, copyPattern)
            }
        }
    }

    /*
     * This method is used to copy files from jenkins master to slave
     */

    private static String filesToCopy(jsonData, envIndex, stepIndex) {

        String copyPattern = ''
        String deployStepName = jsonData.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].stepName
        String envName = jsonData.deployInfo.deployEnv[envIndex].envName
        String execFileName = basepath + '_' + envName + '_' + deployStepName + '_spring_boot_execute'
        String confFileName = basepath + '_' + envName + '_' + deployStepName + '_spring_boot_deploy.xml'
        String processKillFileName = basepath + '_' + envName + '_' + deployStepName + '_spring_boot_process_kill.sh'

        if (jsonData.basicInfo.buildServerOS.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
            copyPattern += (execFileName + '.bat,' + confFileName + ',')
        } else {
            copyPattern += (execFileName + '.sh,' + confFileName + ',' + processKillFileName + ',')
        }

        return copyPattern
    }

    /*
     * This method is used to prepare spring boot deploy Ant file
     */

    private static void prepareSpringBootDeployAntXml(jsonData, envIndex, stepIndex, envVar) {

        String fileContent = ReadFile.run('/ant_templates/spring_boot_deploy.xml')
        String deployStepName = jsonData.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].stepName
        String envName = jsonData.deployInfo.deployEnv[envIndex].envName
        String fileName = basepath + '_' + envName + '_' + deployStepName + '_spring_boot_execute'

        fileContent = fileContent.replace('$PNAME', basepath)
        fileContent = fileContent.replace('$Bat_Path', '.')

        if (jsonData.basicInfo.buildServerOS.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
            fileContent = fileContent.replace('$COMMAND', '/c ' + fileName + '.bat')
            fileContent = fileContent.replace('$EXECUTABLE', 'cmd.exe')
            fileContent = fileContent.replace('$OS', 'windows')
        } else {
            fileContent = fileContent.replace('$COMMAND', '/c ' + fileName + '.sh')
            fileContent = fileContent.replace('$EXECUTABLE', 'sh')
            fileContent = fileContent.replace('$OS', 'linux')
        }

        def jHome = envVar.JENKINS_HOME
        WriteFile.run(jHome + '/userContent/' + basepath + '_' + envName + '_' + deployStepName + '_spring_boot_deploy.xml', fileContent)
    }

    /*
     * This method is used to prepare spring boot process kill shell file
     */

    private static void prepareSpringBootProcessKillShell(jsonData, envIndex, stepIndex, envVar) {

        String deployStepName = jsonData.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].stepName
        String envName = jsonData.deployInfo.deployEnv[envIndex].envName
        String port = jsonData.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].port

        String fileContent = ReadFile.run('/ant_templates/spring_boot_process_kill_linux.sh')

        fileContent = fileContent.replace('$PORT', port)

        def jHome = envVar.JENKINS_HOME

        String fileName = jHome + '/userContent/' + basepath + '_' + envName + '_' + deployStepName + '_spring_boot_process_kill.sh'

        WriteFile.run(fileName, fileContent)
    }
}
