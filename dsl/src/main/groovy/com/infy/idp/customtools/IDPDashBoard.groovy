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
 * This class includes the method for adding IDPDashBoard customtool
 *
 */

class IDPDashBoard {

    /*
     * This function is used to add the commands to run IDPDashBoard
     */

    public static void invokeTool(context, jsonData) {
        HashMap<String, String> data = performMapping()
        def command;

        command = """Java -jar ${data.get('DASHBOARD_UTILITY_PATH')}/IDP_DashBoard_Report_Fetch.jar ${
            data.get('JENKINS_SERVER')
        } ${data.get('JENKINS_NAME')} ${data.get('JENKINS_PASSWORD')} ${data.get('JENKINS_WORKSPACE')} ${
            data.get('BUILD_NUMBER')
        } pmd:PMD_Report.xml checkstyle_report.xml fb:findbugs.xml cob:coverage.xml pqm:pqm_report_pmd.txt ${
            data.get('JUNIT_PATH')
        } soapui:Reports ${data.get('SELENIUM_PROJECT_NAME')} fxcop:AnalysisResult.xml mstest:TestResult.trx ${
            data.get('SINGLE_VIEW_REPORT_PARAM')
        } STAGE:\$STAGE""";
        ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS);

        command = """Java -jar ${data.get('DASHBOARD_UTILITY_PATH')}/IDP_DashBoard_Report_ConversionV1.jar ${
            data.get('JENKINS_WORKSPACE')
        }/../IDP_REPORTS PROD ${data.get('JOB_NAME')} ${data.get('APPLICATION_NAME')} custom ${
            data.get('SONAR_STATUS')
        } ${data.get('BUILD_NUMBER')} ${data.get('MODULES_LIST')} ${data.get('PIPELINE_ID')} ${
            data.get('JOB_STATUS')
        } ${data.get('TECHNOLOGY')} GIT:${data.get('GIT_ROOT_URL')}${data.get('GIT_URL')}${data.get('GIT_USERNAME')}${
            data.get('GIT_PASSWORD_ENCRYPTED')
        } STAGE:\$STAGE""";
        ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS);
    }

    /*
     * This function is used to perform mapping for adding IDPDashBoard
     */

    private static Map<String, String> performMapping() {
        
        HashMap<String, String> data = new HashMap<String, String>();
        data.put('DASHBOARD_UTILITY_PATH', '')
        data.put('JENKINS_SERVER', '')
        data.put('JENKINS_NAME', '')
        data.put('JENKINS_PASSWORD', '')
        data.put('JENKINS_WORKSPACE', '')
        data.put('BUILD_NUMBER', '')
        data.put('JUNIT_PATH', '')
        data.put('SELENIUM_PROJECT_NAME', '')
        data.put('SINGLE_VIEW_REPORT_PARAM', '')

        data.put('JOB_NAME', '')
        data.put('APPLICATION_NAME', '')
        data.put('SONAR_STATUS', '')
        data.put('MODULES_LIST', '')
        data.put('PIPELINE_ID', '')
        data.put('JOB_STATUS', '')
        data.put('TECHNOLOGY', '')
        data.put('GIT_ROOT_URL', '')
        data.put('GIT_URL', '')
        data.put('GIT_USERNAME', '')
        data.put('GIT_PASSWORD_ENCRYPTED', '')
        return data;
    }
}
