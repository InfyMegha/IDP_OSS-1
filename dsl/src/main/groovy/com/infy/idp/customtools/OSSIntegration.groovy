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
* This class includes the method for adding OSSIntegration customtool
*
*/

class OSSIntegration{

	/*
    * This function is used to add the commands to run OSSIntegration
    */

	public static void invokeTool(context,jsonData,moduleIndex,appTeamEmails) {
		HashMap<String, String> data = performMapping(jsonData,moduleIndex,appTeamEmails)
		def command;
		command = """java -jar  ${data.get('OSS_CUSTOM_TOOL_JAR')} ${data.get('PROJECT_NAME')} ${data.get('OSS_FOLDER_PATH')} ${data.get('USER_MAIL_ID')} ${data.get('DISTRIBUTION_TYPE')} ${data.get('REPORT_MAILIDS')} ${data.get('OSS_HOME_EXE')} ${data.get('ANALYSIS_TYPE')} ${data.get('JOB_NAME')}"""
		ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
	}

	/*
	* This function is used to perform mapping for adding OSSIntegration
	*/

	private static Map<String,String> performMapping(jsonData,moduleIndex,appTeamEmails) {
	HashMap<String, String> data = new HashMap<String, String>();
	data.put('OSS_CUSTOM_TOOL_JAR','%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN,'OSS') ) 
	data.put('PROJECT_NAME',jsonData.buildInfo.modules[moduleIndex].projectName) //JSON
	data.put('OSS_FOLDER_PATH','%IDP_WS%/'+jsonData.buildInfo.modules[moduleIndex].moduleName+jsonData.buildInfo.modules[moduleIndex].relativePath)  //JSON
	if(appTeamEmails != null && appTeamEmails != '') appTeamEmails = ','+appTeamEmails;
	data.put('USER_MAIL_ID',jsonData.basicInfo.additionalMailRecipients.emailIds+appTeamEmails) //JSON
	data.put('DISTRIBUTION_TYPE',jsonData.buildInfo.modules[moduleIndex].distributionType) //JSON
	data.put('REPORT_MAILIDS',jsonData.buildInfo.modules[moduleIndex].mailRecipients) //JSON
	data.put('OSS_HOME_EXE','%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN,'OSSEXE')) 
	data.put('ANALYSIS_TYPE',jsonData.buildInfo.modules[moduleIndex].analysisType) //JSON
    data.put('JOB_NAME',jsonData.basicInfo.applicationName+'_'+jsonData.basicInfo.pipelineName)
	return data;
	}	
}
