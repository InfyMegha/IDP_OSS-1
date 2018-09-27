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
 * This class implements IPLuginBase interface to publish Robot reports
 *
 */

class RobotPublisher implements IPluginBase {

    private String opPath = ''

    public void setOpPath(String opPath) {
        this.opPath = opPath;
    }

    /*
     * This function implements add method of IPluginBase interface
     */

    public void add(context, IDPJob idpJobObj) {
        this.addOptions(context, this.performMapping(idpJobObj));
    }

    /*
     * This function implements performMapping method of IPluginBase interface
     */

    public HashMap<String, String> performMapping(IDPJob idpJobObj) {
        IDPJob job = idpJobObj
        HashMap<String, String> data = new HashMap<String, String>()

        data.put('disableArchiveOutput', false)
        data.put('logFileName', 'log.html')
        data.put('onlyCritical', true)
        data.put('otherFiles', '')
        data.put('outputFileName', 'output.xml')
        data.put('outputPath', this.opPath)
        data.put('passThreshold', 0)
        data.put('reportFileName', 'report.html')
        data.put('unstableThreshold', 0)

        return data;
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    public void addOptions(context, HashMap<String, String> data) {

        context.with {

            publishRobotFrameworkReports {

                if (data.containsKey('disableArchiveOutput')) disableArchiveOutput(data.get('disableArchiveOutput'))
                if (data.containsKey('logFileName')) logFileName(data.get('logFileName'))
                if (data.containsKey('onlyCritical')) onlyCritical(data.get('onlyCritical'))
                if (data.containsKey('otherFiles')) otherFiles(data.get('otherFiles'))
                if (data.containsKey('outputFileName')) outputFileName(data.get('outputFileName'))
                if (data.containsKey('outputPath')) outputPath(data.get('outputPath'))
                if (data.containsKey('passThreshold')) passThreshold(data.get('passThreshold'))
                if (data.containsKey('reportFileName')) reportFileName(data.get('reportFileName'))
                if (data.containsKey('unstableThreshold')) unstableThreshold(data.get('unstableThreshold'))
            }
        }
    }
}
