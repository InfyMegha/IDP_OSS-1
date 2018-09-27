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
 * This class implements IPLuginBase interface to add CleareCaseSCM option in jenkins job
 *
 */
class ClearCaseSCM implements IPluginBase {

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

            if (scmArr.getAt(i).type == Constants.CLEARCASE && scmArr.getAt(i).clearcaseType == Constants.CCBASE) {

                indexToMap = i
                this.addOptions(context, this.performMapping(idpJobObj))
            }
        }
    }

    /*
     * This function implements performMapping method of IPluginBase interface
     */

    @Override
    public HashMap<String, String> performMapping(IDPJob idpJobObj) {

        HashMap<String, String> data = new HashMap<String, String>()
        def scmSection = null;
        if (idpJobObj.code != null && idpJobObj.code.scm != null) {
            scmSection = idpJobObj.code.scm.getAt(indexToMap)
        } else {
            scmSection = idpJobObj.tesAsset.scm.getAt(indexToMap)
        }


        data.put('branch', '')
        data.put('label', '')
        data.put('extractConfigSpec', false)
        data.put('configSpecFileName', '')
        data.put('refreshConfigSpec', true)
        data.put('refreshConfigSpecCommand', '')
        data.put('configSpec', scmSection.configSpec)
        data.put('viewTag', scmSection.snapshotViewName)
        data.put('useupdate', true)
        data.put('extractLoadRules', true)
        data.put('loadRules', scmSection.vobName)
        data.put('useOtherLoadRulesForPolling', false)
        data.put('loadRulesForPolling', '')
        data.put('usedynamicview', false)
        data.put('viewdrive', 'M:/')
        data.put('mkviewoptionalparam', '')
        data.put('filterOutDestroySubBranchEvent', true)
        data.put('doNotUpdateConfigSpec', true)
        data.put('rmviewonrename', false)
        data.put('excludedRegions', '')
        data.put('multiSitePollBuffer', '')
        data.put('useTimeRule', true)
        data.put('createDynView', false)
        data.put('viewPath', scmSection.snapshotViewName)
        data.put('changeset', 'UPDT')
        return data
    }

    /*
    * This function implements addOptions method of IPluginBase interface
    */

    @Override
    public void addOptions(context, HashMap<String, String> data) {
        context.with {
            clearCaseSCM {
                ClearCaseSCM.addGeneralBuildSettings(delegate, data)
                viewStorage { defaultViewStorage() }
            }
        }
    }

    /*
     * This methos is used to add general build setting for ClearCaseSCM in jenkins job
     */

    private static void addGeneralBuildSettings(context, data) {
        context.with {
            if (data.containsKey('branch')) branch(data.get('branch'))
            if (data.containsKey('label')) label(data.get('label'))
            if (data.containsKey('extractConfigSpec')) extractConfigSpec(data.get('extractConfigSpec').toBoolean())
            if (data.containsKey('configSpecFileName')) configSpecFileName(data.get('configSpecFileName'))
            if (data.containsKey('refreshConfigSpec')) refreshConfigSpec(data.get('refreshConfigSpec').toBoolean())
            if (data.containsKey('refreshConfigSpecCommand')) refreshConfigSpecCommand(data.get('refreshConfigSpecCommand'))
            if (data.containsKey('configSpec')) configSpec(data.get('configSpec'))
            if (data.containsKey('viewTag')) viewTag(data.get('viewTag'))
            if (data.containsKey('useupdate')) useupdate(data.get('useupdate').toBoolean())
            if (data.containsKey('extractLoadRules')) extractLoadRules(data.get('extractLoadRules').toBoolean())
            if (data.containsKey('loadRules')) loadRules(data.get('loadRules'))
            if (data.containsKey('useOtherLoadRulesForPolling')) useOtherLoadRulesForPolling(data.get('useOtherLoadRulesForPolling').toBoolean())
            if (data.containsKey('loadRulesForPolling')) loadRulesForPolling(data.get('loadRulesForPolling'))
            if (data.containsKey('usedynamicview')) usedynamicview(data.get('usedynamicview').toBoolean())
            if (data.containsKey('viewdrive')) viewdrive(data.get('viewdrive'))
            if (data.containsKey('mkviewoptionalparam')) mkviewoptionalparam(data.get('mkviewoptionalparam'))
            if (data.containsKey('filterOutDestroySubBranchEvent')) filterOutDestroySubBranchEvent(data.get('filterOutDestroySubBranchEvent').toBoolean())
            if (data.containsKey('doNotUpdateConfigSpec')) doNotUpdateConfigSpec(data.get('doNotUpdateConfigSpec').toBoolean())
            if (data.containsKey('rmviewonrename')) rmviewonrename(data.get('rmviewonrename').toBoolean())
            if (data.containsKey('excludedRegions')) excludedRegions(data.get('excludedRegions'))
            if (data.containsKey('multiSitePollBuffer')) multiSitePollBuffer(data.get('multiSitePollBuffer'))
            if (data.containsKey('useTimeRule')) useTimeRule(data.get('useTimeRule').toBoolean())
            if (data.containsKey('createDynView')) createDynView(data.get('createDynView').toBoolean())
            if (data.containsKey('viewPath')) viewPath(data.get('viewPath'))
            if (data.containsKey('changeset')) changeset(data.get('changeset'))


        }
    }

}
