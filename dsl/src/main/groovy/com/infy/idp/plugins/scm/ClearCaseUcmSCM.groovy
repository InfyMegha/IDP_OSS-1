/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.plugins.scm

import com.infy.idp.interfaces.IPluginBase
import com.infy.idp.utils.Constants
import org.infy.idp.entities.jobs.IDPJob

/**
 *
 * This class implements IPLuginBase interface to add CleareCaseUCMSCM option in jenkins job
 *
 */

class ClearCaseUcmSCM implements IPluginBase {

    private indexToMap = -1

    /*
     * This function implements add method of IPluginBase interface
     */

    @Override
    public void add(Object context, IDPJob idpJobObj) {

        def scmArr = null;
        if (idpJobObj.code != null && idpJobObj.code.scm != null) {
            scmArr = idpJobObj.code.scm
        } else {
            scmArr = idpJobObj.tesAsset.scm
        }
        for (int i = 0; i < scmArr.size(); i++) {

            if (scmArr.getAt(i).type == Constants.CLEARCASE && scmArr.getAt(i).clearcaseType == Constants.CCUCM) {

                indexToMap = i
                this.addOptions(context, this.performMapping(idpJobObj))
            }
        }
    }

    /*
     * This function implements performMapping method of IPluginBase interface
     */

    @Override
    public HashMap<String, String> performMapping(IDPJob dataObj) {

        HashMap<String, String> data = new HashMap<String, String>()
        def scmSection = null;
        if (idpJobObj.code != null && idpJobObj.code.scm != null) {
            scmSection = idpJobObj.code.scm.getAt(indexToMap)
        } else {
            scmSection = idpJobObj.tesAsset.scm.getAt(indexToMap)
        }
        data.put('stream', scmSection.developmentStreamName)
        data.put('loadrules', scmSection.vobName)
        data.put('viewTag', scmSection.snapshotViewName)
        data.put('usedynamicview', false)
        data.put('viewdrive', 'M:/')
        data.put('mkviewoptionalparam', '')
        data.put('filterOutDestroySubBranchEvent', true)
        data.put('useUpdate', true)
        data.put('rmviewonrename', false)
        data.put('excludedRegions', '')
        data.put('multiSitePollBuffer', '')
        data.put('overrideBranchName', '')
        data.put('createDynView', false)
        data.put('freezeCode', false)
        data.put('recreateView', false)
        data.put('allocateViewName', false)
        data.put('viewPath', scmSection.snapshotViewName)
        data.put('useManualLoadRules', true)
        data.put('changeset', 'ALL')
        data.put('buildFoundationBaseline', false)

        return data
    }

    /*
    * This function implements addOptions method of IPluginBase interface
    */

    @Override
    public void addOptions(context, HashMap<String, String> data) {
        context.with {
            clearCaseUcmSCM {
                ClearCaseUcmSCM.addGeneralBuildSettings(delegate, data)
                viewStorage {
                    defaultViewStorage()

                }
            }
        }
    }

    /*
     * This methos is used to add general build setting for ClearCaseUCMSCM in jenkins job
     */

    private static void addGeneralBuildSettings(context, data) {
        context.with {
            if (data.containsKey('stream')) stream(data.get('stream'))
            if (data.containsKey('loadrules')) loadrules(data.get('loadrules'))
            if (data.containsKey('viewTag')) viewTag(data.get('viewTag'))
            if (data.containsKey('usedynamicview')) usedynamicview(data.get('usedynamicview').toBoolean())
            if (data.containsKey('viewdrive')) viewdrive(data.get('viewdrive'))
            if (data.containsKey('mkviewoptionalparam')) mkviewoptionalparam(data.get('mkviewoptionalparam'))
            if (data.containsKey('filterOutDestroySubBranchEvent')) filterOutDestroySubBranchEvent(data.get('filterOutDestroySubBranchEvent').toBoolean())
            if (data.containsKey('useUpdate')) useUpdate(data.get('useUpdate').toBoolean())
            if (data.containsKey('rmviewonrename')) rmviewonrename(data.get('rmviewonrename').toBoolean())
            if (data.containsKey('excludedRegions')) excludedRegions(data.get('excludedRegions'))
            if (data.containsKey('multiSitePollBuffer')) multiSitePollBuffer(data.get('multiSitePollBuffer'))
            if (data.containsKey('overrideBranchName')) overrideBranchName(data.get('overrideBranchName'))
            if (data.containsKey('createDynView')) createDynView(data.get('createDynView').toBoolean())
            if (data.containsKey('freezeCode')) freezeCode(data.get('freezeCode').toBoolean())
            if (data.containsKey('recreateView')) recreateView(data.get('recreateView').toBoolean())
            if (data.containsKey('allocateViewName')) allocateViewName(data.get('allocateViewName').toBoolean())
            if (data.containsKey('viewPath')) viewPath(data.get('viewPath'))
            if (data.containsKey('useManualLoadRules')) useManualLoadRules(data.get('useManualLoadRules').toBoolean())
            if (data.containsKey('changeset')) changeset(data.get('changeset'))
            if (data.containsKey('buildFoundationBaseline')) buildFoundationBaseline(data.get('buildFoundationBaseline').toBoolean())

        }
    }

}
