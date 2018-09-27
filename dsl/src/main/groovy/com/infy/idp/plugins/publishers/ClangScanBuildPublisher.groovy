/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.plugins.publishers

import com.infy.idp.interfaces.IPluginBase
import org.infy.idp.entities.jobs.IDPJob

/**
 *
 * This class implements IPLuginBase interface to publish artifacts ovber SSH
 *
 */

class ClangScanBuildPublisher implements IPluginBase {

    /*
     * This function implements add method of IPluginBase interface
     */

    @Override
    public void add(Object context, IDPJob dataObj) {
        this.addOptions(context, this.performMapping(dataObj))
    }

    /*
     * This function implements performMapping method of IPluginBase interface
     */

    @Override
    public HashMap<String, String> performMapping(IDPJob dataObj) {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("bugThreshold", 50);
        data.put("clangexcludedpaths", "");
        data.put("markBuildUnstableWhenThresholdIsExceeded", true);
        //data.put("reportFolderName","");
        return data;
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    @Override
    public void addOptions(Object context, HashMap<String, String> data) {
        context.with {
            configure {
                def rep = it / publishers
                rep << 'jenkins.plugins.clangscanbuild.publisher.ClangScanBuildPublisher'(plugin: "clang-scanbuild-plugin@1.5") {
                    if (data.containsKey("bugThreshold")) bugThreshold(data.get("bugThreshold"));
                    if (data.containsKey("clangexcludedpaths")) clangexcludedpaths(data.get("clangexcludedpaths"));
                    if (data.containsKey("markBuildUnstableWhenThresholdIsExceeded")) markBuildUnstableWhenThresholdIsExceeded(data.get("markBuildUnstableWhenThresholdIsExceeded"));
                    if (data.containsKey("reportFolderName")) reportFolderName(data.get("reportFolderName"));
                }
            }
        }
    }
}
