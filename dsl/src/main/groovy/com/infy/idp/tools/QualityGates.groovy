/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools


import com.infy.idp.creators.*
import com.infy.idp.utils.*

/**
 * This class has the methods to add qaulity gates for sonar
 */

class QualityGates {

    public static void qualityGatesPluginInvocation(context) {

        context.with {
            configure { project ->
                project / publishers / 'quality.gates.jenkins.QGPublisher'(plugin: 'quality-gates@2.5') {
                    jobConfigData {
                        projectKey('$SONARPROJECTKEY')
                        sonarInstanceName('JSonar')
                    }
                }
            }
        }
    }
}
