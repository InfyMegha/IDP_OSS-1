/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.testing

import com.infy.idp.utils.*

/**
 *
 * This class has the method to add Oats testing tool
 *
 */

class Oats {

    /*
    * This method is used to add the steps to configure JMeter
    */

    public static void addSteps(context, jsonData, testStepElem) {


        String os = jsonData.basicInfo.buildServerOS
        String idpWS
        String oatsws
        if (os == Constants.WINDOWSOS) {
            idpWS = '%IDP_WS%/'
            oatsws = '%OATS_HOME%\\'

        } else {
            idpWS = '$IDP_WS/'
            oatsws = '$OATS_HOME\\'
        }

        def projectName = jsonData.buildInfo.modules.getAt(0).moduleName


        ExecuteCmd.invokeCmd(context, oatsws + "openScript\\runscript.bat " + "\"" + idpWS + projectName + "/" + testStepElem.testScript + "\" -resultReportFolder \"" + idpWS + "Oracle_TestReports\"", os)
    }


}
