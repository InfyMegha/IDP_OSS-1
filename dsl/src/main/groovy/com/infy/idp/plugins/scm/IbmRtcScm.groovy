/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.plugins.scm

import com.infy.idp.creators.*
import com.infy.idp.tools.*
import com.infy.idp.utils.*
import org.infy.idp.entities.jobs.IDPJob
import org.infy.idp.entities.jobs.code.Scm

/**
 *
 * This class implements IPLuginBase interface to add IBMRTCSCM option in jenkins job
 *
 */

class IbmRtcScm {

    private indexToMap = -1

    private HashMap<Integer, Scm> scmMap;


    public HashMap<Integer, Scm> getScmMap() {
        return scmMap;
    }

    public void setScmMap(HashMap<Integer, Scm> scmMap) {
        this.scmMap = scmMap;
    }

    /*
     * This function implements add method of IPluginBase interface
     */

    public void add(Object context, IDPJob idpJobObj) {

        def scmArr = null;
        if (idpJobObj.code != null && idpJobObj.code.scm != null) {
            scmArr = idpJobObj.code.scm
        } else {
            scmArr = idpJobObj.tesAsset.scm
        }


        for (Map.Entry<Integer, Scm> entry : this.scmMap.entrySet()) {
            int key = entry.getKey();
            if (scmArr.getAt(key).type == Constants.IBMRTCSCM) {
                indexToMap = key;
                this.addOptions(context, this.performMapping(idpJobObj));
            }


        }

    }

    /*
     * This function implements performMapping method of IPluginBase interface
     */

    public HashMap<String, String> performMapping(IDPJob idpJobObj) {

        HashMap<String, String> data = new HashMap<String, String>();
        def scmSection = idpJobObj.code.scm.getAt(indexToMap);

        //def scmSection = idpJobObj.code.scm.getAt(indexToMap)

        data.put('overrideGlobal', true)
        data.put('buildTool', PropReader.readProperty(Constants.CONFIGFN, 'IBMRTC'))
        data.put('serverURI', scmSection.url)
        data.put('timeout', 480)

        def credId = java.util.UUID.randomUUID().toString()
        AddCredentials.run(credId, scmSection.userName, scmSection.password)
        data.put('credentialsId', credId)

        data.put('buildType', scmSection.buildConfiguration)

        data.put('clearLoadDirectory', false)
        data.put('createFoldersForComponents', false)
        data.put('acceptBeforeLoad', true)
        data.put('generateChangelogWithGoodBuild', false)
        data.put('avoidUsingToolkit', false)

        data.put('buildStream', scmSection.branch)
        data.put('buildWorkspace', scmSection.repositoryWorkspace)
        data.put('buildDefinition', scmSection.buildDefinition)
        data.put('processArea', scmSection.projArea)
        data.put('loadDirectory', '')

        return data
    }

    /*
   * This function implements addOptions method of IPluginBase interface
   */

    public void addOptions(context, HashMap<String, String> data) {

        context.with {

            configure {

                def bType
                if (data.containsKey('buildType')) bType = data.get('buildType')

                def mscm = it / scm / scms

                mscm << 'com.ibm.team.build.internal.hjplugin.RTCScm'(plugin: 'teamconcert@1.2.0.1') {

                    if (data.containsKey('overrideGlobal')) overrideGlobal(data.get('overrideGlobal'))
                    if (data.containsKey('buildTool')) buildTool(data.get('buildTool'))
                    if (data.containsKey('serverURI')) serverURI(data.get('serverURI'))
                    if (data.containsKey('timeout')) timeout(data.get('timeout'))
                    if (data.containsKey('credentialsId')) credentialsId(data.get('credentialsId'))

                    if (bType == Constants.IBMRTCSTREAM) {

                        buildType {

                            if (data.containsKey('buildType')) value('buildStream')
                            if (data.containsKey('buildStream')) buildStream(data.get('buildStream'))
                            if (data.containsKey('processArea')) processArea(data.get('processArea'))

                            if (data.containsKey('loadDirectory')) loadDirectory(data.get('loadDirectory'))

                            if (data.containsKey('clearLoadDirectory')) clearLoadDirectory(data.get('clearLoadDirectory'))
                            if (data.containsKey('createFoldersForComponents')) createFoldersForComponents(data.get('createFoldersForComponents'))
                            if (data.containsKey('acceptBeforeLoad')) acceptBeforeLoad(data.get('acceptBeforeLoad'))
                            if (data.containsKey('generateChangelogWithGoodBuild')) generateChangelogWithGoodBuild(data.get('generateChangelogWithGoodBuild'))

                        }

                        if (data.containsKey('buildType')) buildTypeStr('buildStream')
                        if (data.containsKey('buildStream')) buildStream(data.get('buildStream'))
                        if (data.containsKey('processArea')) processArea(data.get('processArea'))

                        if (data.containsKey('loadDirectory')) loadDirectory(data.get('loadDirectory'))
                    } else if (bType == Constants.IBMRTCBWS) {

                        buildType {

                            if (data.containsKey('buildType')) value('buildWorkspace')
                            if (data.containsKey('buildWorkspace')) buildWorkspace(data.get('buildWorkspace'))

                            if (data.containsKey('loadDirectory')) loadDirectory(data.get('loadDirectory'))

                            if (data.containsKey('clearLoadDirectory')) clearLoadDirectory(data.get('clearLoadDirectory'))
                            if (data.containsKey('createFoldersForComponents')) createFoldersForComponents(data.get('createFoldersForComponents'))
                            if (data.containsKey('acceptBeforeLoad')) acceptBeforeLoad(data.get('acceptBeforeLoad'))
                            if (data.containsKey('generateChangelogWithGoodBuild')) generateChangelogWithGoodBuild(data.get('generateChangelogWithGoodBuild'))
                        }

                        if (data.containsKey('buildType')) buildTypeStr('buildWorkspace')
                        if (data.containsKey('buildWorkspace')) buildWorkspace(data.get('buildWorkspace'))

                        if (data.containsKey('loadDirectory')) loadDirectory(data.get('loadDirectory'))
                    } else if (bType == Constants.IBMRTCBD) {

                        buildType {

                            if (data.containsKey('buildType')) value('buildDefinition')
                            if (data.containsKey('buildDefinition')) buildDefinition(data.get('buildDefinition'))

                            if (data.containsKey('clearLoadDirectory')) clearLoadDirectory(data.get('clearLoadDirectory'))
                            if (data.containsKey('createFoldersForComponents')) createFoldersForComponents(data.get('createFoldersForComponents'))
                            if (data.containsKey('acceptBeforeLoad')) acceptBeforeLoad(data.get('acceptBeforeLoad'))
                            if (data.containsKey('generateChangelogWithGoodBuild')) generateChangelogWithGoodBuild(data.get('generateChangelogWithGoodBuild'))
                        }

                        if (data.containsKey('buildType')) buildTypeStr('buildDefinition')
                        if (data.containsKey('buildDefinition')) buildDefinition(data.get('buildDefinition'))
                    }

                    if (data.containsKey('clearLoadDirectory')) clearLoadDirectory(data.get('clearLoadDirectory'))
                    if (data.containsKey('createFoldersForComponents')) createFoldersForComponents(data.get('createFoldersForComponents'))
                    if (data.containsKey('acceptBeforeLoad')) acceptBeforeLoad(data.get('acceptBeforeLoad'))
                    if (data.containsKey('generateChangelogWithGoodBuild')) generateChangelogWithGoodBuild(data.get('generateChangelogWithGoodBuild'))
                    if (data.containsKey('avoidUsingToolkit')) avoidUsingToolkit(data.get('avoidUsingToolkit'))

                }
            }
        }
    }
}
