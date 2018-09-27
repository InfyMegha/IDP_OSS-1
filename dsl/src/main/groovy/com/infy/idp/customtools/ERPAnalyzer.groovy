/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package com.infy.idp.customtools

import com.infy.idp.utils.*

/**
 *
 * This class includes the method for adding ERPAnalyzer customtool
 *
 */

class ERPAnalyzer {

    /*
     * This function is used to add the commands to run ERPAnalyzer
     */

    public static void invokeTool(context, jsonData, erp) {
        HashMap<String, String> data = performMapping(erp)
        def command;
        command = """java -jar ${data.get('CUSTOM_TOOL_PATH')}/ERP_Commandline.jar ${data.get('ORACLE_PROJECT_NAME')} ${
            data.get('CUSTOM_TOOL_PATH')
        }/ERP_Metrics.xml 0 ${data.get('JOB_LOCATION')}/CodeAnalysisReports 0 ${
            data.get('CUSTOM_TOOL_PATH')
        }/config.properties"""
        ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
    }

    /*
     * This function is used to perform mapping for adding ERPAnalyzer
     */

    private static Map<String, String> performMapping(erp) {

        HashMap<String, String> data = new HashMap<String, String>();
        data.put('CUSTOM_TOOL_PATH', '%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN, Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN, 'ERPANALYZER'))
        data.put('JOB_LOCATION', '%IDP_WS%')
        data.put('ORACLE_PROJECT_NAME', '%IDP_WS%/' + erp)
        return data;
    }
}
