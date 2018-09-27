/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.plugins.buildsteps

import com.infy.idp.creators.*
import com.infy.idp.interfaces.IPluginBase
import com.infy.idp.utils.*

/**
 *
 * This class implements IPLuginBase interface to configure job for Xunit
 *
 */

class XUnit implements IPluginBase {

    /*
     * This function implements add method of IPluginBase interface
     */

    public void add(Object context) {
        this.addOptions(context, this.performMapping());
    }

    /*
    * This function implements performMapping method of IPluginBase interface
    */

    public HashMap<String, String> performMapping() {

        HashMap<String, String> data = new HashMap<String, String>();

        data.put('pattern', 'xunit.xml');
        data.put('skipNoTestFiles', 'false');
        data.put('failIfNotNew', 'true');
        data.put('deleteOutputFiles', 'true');
        data.put('stopProcessingIfError', 'true');

        data.put('unstableThresholdFailed', '');
        data.put('unstableNewThresholdFailed', '');
        data.put('failureThresholdFailed', '');
        data.put('failureNewThresholdFailed', '');

        data.put('unstableThresholdSkipped', '');
        data.put('unstableNewThresholdSkipped', '');
        data.put('failureThresholdSkipped', '');
        data.put('failureNewThresholdSkipped', '');

        data.put('thresholdMode', 1)
        data.put('testTimeMargin', 3000)

        return data;
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    public void addOptions(context, HashMap<String, String> data) {

        context.with {

            xUnitBuilder {

                tools {

                    jUnitType {
                        if (data.containsKey('pattern')) pattern(data.get('pattern'))
                        if (data.containsKey('skipNoTestFiles')) skipNoTestFiles(data.get('skipNoTestFiles').toBoolean())
                        if (data.containsKey('failIfNotNew')) failIfNotNew(data.get('failIfNotNew').toBoolean())
                        if (data.containsKey('deleteOutputFiles')) deleteOutputFiles(data.get('deleteOutputFiles').toBoolean())
                        if (data.containsKey('stopProcessingIfError')) stopProcessingIfError(data.get('stopProcessingIfError').toBoolean())
                    }
                }

                thresholds {

                    failedThreshold {
                        if (data.containsKey('unstableThresholdFailed')) unstableThreshold(data.get('unstableThresholdFailed'))
                        if (data.containsKey('unstableNewThresholdFailed')) unstableNewThreshold(data.get('unstableNewThresholdFailed'))
                        if (data.containsKey('failureThresholdFailed')) failureThreshold(data.get('failureThresholdFailed'))
                        if (data.containsKey('failureNewThresholdFailed')) failureNewThreshold(data.get('failureNewThresholdFailed'))
                    }

                    skippedThreshold {
                        if (data.containsKey('unstableThresholdSkipped')) unstableThreshold(data.get('unstableThresholdSkipped'))
                        if (data.containsKey('unstableNewThresholdSkipped')) unstableNewThreshold(data.get('unstableNewThresholdSkipped'))
                        if (data.containsKey('failureThresholdSkipped')) failureThreshold(data.get('failureThresholdSkipped'))
                        if (data.containsKey('failureNewThresholdSkipped')) failureNewThreshold(data.get('failureNewThresholdSkipped'))
                    }
                }

                if (data.containsKey('thresholdMode')) thresholdMode(Integer.parseInt(data.get('thresholdMode')))
                if (data.containsKey('testTimeMargin')) testTimeMargin(data.get('testTimeMargin'))
            }
        }
    }
}
