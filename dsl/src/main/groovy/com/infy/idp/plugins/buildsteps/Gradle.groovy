/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.plugins.buildsteps

import com.infy.idp.interfaces.IPluginBase
import org.infy.idp.entities.jobs.IDPJob

/**
 *
 * This class implements IPLuginBase interface to configure job gradle
 *
 */

class Gradle implements IPluginBase {

    private String tasksVal = ''
    private String rootBuildScriptDir = ''
    private String buildFile = 'build.gradle'
    private String systemProperties = ''

    public void setTasksVal(String tasksVal) {
        this.tasksVal = tasksVal
    }

    public void setRootBuildScriptDir(String rootBuildScriptDir) {
        this.rootBuildScriptDir = rootBuildScriptDir;
    }

    public void setBuildFile(String buildFile) {
        this.buildFile = buildFile;
    }

    public void setSystemProperties(String systemProperties) {
        this.systemProperties = systemProperties;
    }

    /*
     * This function implements add method of IPluginBase interface
     */

    @Override
    public void add(context, IDPJob dataObj) {
        this.addOptions(context, this.performMapping(dataObj))
    }

    /*
     * This function implements performMapping method of IPluginBase interface
     */

    @Override
    public HashMap<String, String> performMapping(IDPJob dataObj) {

        HashMap<String, String> data = new HashMap<String, String>()

        data.put('buildFile', this.buildFile)

        data.put('gradleName', '(Default)')
        data.put('makeExecutable', true)

        data.put('passAllAsSystemProperties', false)
        data.put('passAllAsProjectProperties', false)
        data.put('rootBuildScriptDir', this.rootBuildScriptDir)
        data.put('switches', '')
        data.put('tasks', this.tasksVal)
        data.put('useWorkspaceAsHome', false)
        data.put('useWrapper', true)
        data.put('wrapperLocation', '')
        data.put('projectProperties', '')
        data.put('systemProperties', this.systemProperties)

        return data
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    @Override
    public void addOptions(jobContext, HashMap<String, String> data) {

        Gradle.addGeneralBuildSettings(jobContext, data)

    }

    /*
     * This function is used to add general build setting for the gradle technology
     */

    private static void addGeneralBuildSettings(jobContext, data) {

        jobContext.with {


            configure {

                it / builders << 'hudson.plugins.gradle.Gradle' {

                    if (data.containsKey('buildFile')) buildFile(data.get('buildFile'))
                    if (data.containsKey('gradleName')) gradleName(data.get('gradleName'))
                    if (data.containsKey('makeExecutable')) makeExecutable(data.get('makeExecutable'))
                    if (data.containsKey('rootBuildScriptDir')) rootBuildScriptDir(data.get('rootBuildScriptDir'))
                    if (data.containsKey('switches')) switches(data.get('switches'))
                    if (data.containsKey('tasks')) tasks(data.get('tasks'))
                    if (data.containsKey('useWorkspaceAsHome')) useWorkspaceAsHome(data.get('useWorkspaceAsHome'))
                    if (data.containsKey('useWrapper')) useWrapper(data.get('useWrapper'))
                    if (data.containsKey('wrapperLocation')) wrapperLocation(data.get('wrapperLocation'))
                    if (data.containsKey('passAllAsSystemProperties')) passAllAsSystemProperties(data.get('passAllAsSystemProperties'))
                    if (data.containsKey('passAllAsProjectProperties')) passAllAsProjectProperties(data.get('passAllAsProjectProperties'))
                    if (data.containsKey('projectProperties')) projectProperties(data.get('projectProperties'))
                    if (data.containsKey('systemProperties')) systemProperties(data.get('systemProperties'))
                }
            }
        }
    }
}
