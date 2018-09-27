/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.testing;

import com.infy.idp.plugins.buildsteps.HPRunFromALMBuilder;

/**
 *
 * This class has the method to add HpAlmFT testing tool
 *
 */
public class HpAlmFT {

    /*
     * This method is used to add the steps to configure HpAlmFT
     */

    public static void addSteps(context, jsonData, envIndex, stepIndex) {

        context.with {

            steps {
                def testEnvElem = null
                def testStepElem = null


                testEnvElem = jsonData.testInfo.testEnv.getAt(envIndex)
                testStepElem = testEnvElem.testSteps.getAt(stepIndex).test



                HPRunFromALMBuilder hpAlm = new HPRunFromALMBuilder();
                hpAlm.setServerName(testStepElem.serverName);
                hpAlm.setDomain(testStepElem.domain);
                hpAlm.setProjectName(testStepElem.projectName);
                hpAlm.setUserName(testStepElem.userName);
                hpAlm.setPassword(testStepElem.password);
                hpAlm.setTestSuiteName(testStepElem.testSuiteName);
                hpAlm.setTimeout(testStepElem.timeout.toString());
                hpAlm.add(delegate, jsonData);

            }
        }
    }


}
