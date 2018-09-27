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
 * This class includes the method for adding AppScanAutomator customtool
 *
 */

class AppScanAutomator{

	/*
	 *	 This function is used to invoke AppScanAutomator customtool of IDP.
	 *	 It will add the commands according to Build server OS( Windows/Linux) and add the customtool for the job
	 */

	public static void invokeTool(context, jsonData,testEnvIndex,testStepsIndex) {
		HashMap<String, String> data = performMapping(jsonData,testEnvIndex,testStepsIndex)
		def command;
		
		command = """java -jar ${data.get('CUSTOM_TOOL_JAR')} ${data.get('ENT_URL')} ${data.get('USERNAME')} ${data.get('PASSWORD')} ${data.get('JOB_NAME_UI')} ${data.get('IEDRIVER_PATH')}"""
		ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
	}

	/*
	 * This function performs the mapping for adding driver path and adding the customtool respective to the build server os.
	 * IDP supports two build server OS ( Windows and Linux)
	 */
	
	private static Map<String,String> performMapping(jsonData,testEnvIndex,testStepsIndex) {
		HashMap<String, String> data = new HashMap<String, String>();
		if (jsonData.basicInfo.buildServerOS.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
			data.put('CUSTOM_TOOL_JAR','%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN,'APPSCANAUTOMATOR'))
			data.put('IEDRIVER_PATH','%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN,'IEDRIVERPATH'))	
		}
		else{
			data.put('CUSTOM_TOOL_JAR','$IDP_WS/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN,'APPSCANAUTOMATOR'))
			data.put('IEDRIVER_PATH','$IDP_WS/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN,'IEDRIVERPATH'))	
		}
		data.put('ENT_URL',jsonData.testInfo.testEnv[testEnvIndex].testSteps[testStepsIndex].folderUrl) //JSON
		data.put('USERNAME',jsonData.testInfo.testEnv[testEnvIndex].testSteps[testStepsIndex].userName) //JSON
		data.put('PASSWORD',jsonData.testInfo.testEnv[testEnvIndex].testSteps[testStepsIndex].password) //JSON
		data.put('JOB_NAME_UI',jsonData.testInfo.testEnv[testEnvIndex].testSteps[testStepsIndex].projectName) //JSON
		return data;
	}	
}
