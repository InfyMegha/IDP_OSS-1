/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.plugins.scm

import com.infy.idp.creators.*
import com.infy.idp.interfaces.IPluginBase
import com.infy.idp.tools.*
import com.infy.idp.utils.*
import org.infy.idp.entities.jobs.IDPJob

/**
 *
 * This class implements IPLuginBase interface to add FileSystemSCM option in jenkins job
 *
 */

class FileSystemSCM implements IPluginBase {

    private indexToMap = -1

    /*
     * This function implements add method of IPluginBase interface
     */

    public void add(Object context, IDPJob idpJobObj) {

        def scmArr = idpJobObj.testAsset.scm

        for (int i = 0; i < scmArr.size(); i++) {
            if (scmArr.getAt(i).type == Constants.FILESYSTEMSCM) {
                indexToMap = i;
                this.addOptions(context, this.performMapping(idpJobObj));
            }
        }
    }

    /*
     * This function implements performMapping method of IPluginBase interface
     */

    public HashMap<String, String> performMapping(IDPJob idpJobObj) {

        HashMap<String, String> data = new HashMap<String, String>();
        def scmSection = idpJobObj.testAsset.scm.getAt(indexToMap)

        data.put('projectName', scmSection.projectName)
        data.put('workspaceName', 'Hudson-${JOB_NAME}-${NODE_NAME}')

        return data;
    }

    /*
    * This function implements addOptions method of IPluginBase interface
    */

    public void addOptions(context, HashMap<String, String> data) {

        context.with {

            configure {

                def mscm = it / scm / scms

                mscm << 'hudson.plugins.filesystem_scm.FSSCM'(plugin: 'filesystem_scm@1.20') {

                    if (data.containsKey('projectName')) path(data.get('projectName'))
                    clearWorkspace('false').asBoolean()
                    if (data.containsKey('workspaceName')) workspaceName(data.get('workspaceName'))
                }
            }
        }
    }
}
