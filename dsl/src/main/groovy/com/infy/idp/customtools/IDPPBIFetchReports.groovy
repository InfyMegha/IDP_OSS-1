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
 * This class includes the method for adding IDPPBIFetchReports customtool
 *
 */

class IDPPBIFetchReports {

    /*
     * This function is used to add the commands to run IDPPBIFetchReports
     */

    public static void invokeTool(context, jsonData) {
        HashMap<String, String> data = performMapping()
        def command;
        command = """Java -jar ${data.get('PBI_CUSTOM_TOOL_PATH')}/IDP_PBI_FETCH_REPORTS.jar ${
            data.get('SERVER_NAME')
        } ${data.get('SERVER_PORT')} ${data.get('JOB_NAME')}_admin ${data.get('USERNAME')}_<creationDate> ${
            data.get('SLAVE_WORKSPACE_PATH')
        }""";
        if (data.get("SELECT_CODE_ANALYSIS") == 'Y') command += """ pmd:PMD_Report.xml cs:checkstyle_report.xml fb:findbugs.xml"""
        if (data.get("SELECT_UNIT_TESTING") == 'Y') command += """ test:TESTS-TestSuites.xml"""
        if (data.get("SELECT_CODE_COVERAGE") == 'Y') command += """ cob:coverage.xml"""
        if (data.get("SELECT_JMETER") == 'Y') command += """ jm:${data.get('JMETER_FILE_NAME')}_result.jtl"""
        ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
    }

    /*
    * This function is used to perform mapping for adding IDPPBIFetchReports
    */

    private static Map<String, String> performMapping() {
        
        HashMap<String, String> data = new HashMap<String, String>();
        data.put('PBI_CUSTOM_TOOL_PATH', '')
        data.put('SERVER_NAME', '')
        data.put('SERVER_PORT', '')
        data.put('JOB_NAME', '')
        data.put('USERNAME', '')
        data.put('SLAVE_WORKSPACE_PATH', '')
        data.put('SELECT_CODE_ANALYSIS', '')
        data.put('SELECT_UNIT_TESTING', '')
        data.put('SELECT_CODE_COVERAGE', '')
        data.put('SELECT_JMETER', '')
        data.put('JMETER_FILE_NAME', '')
        return data;
    }
}
