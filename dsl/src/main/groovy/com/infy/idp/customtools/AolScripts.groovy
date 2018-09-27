/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package com.infy.idp.customtools

import com.infy.idp.utils.*

class AolScripts{

	public static void invokeTool(context, jsonData, moduleIndex,loadfile) {
		HashMap<String, String> data = performMapping(jsonData,moduleIndex,loadfile)
		def command;
		if (jsonData.basicInfo.buildServerOS.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
		command = """cd ${data.get('ORACLE_PROJECT_FOLDER')}
mkdir AOL_SCRIPTS
copy /Y \"${data.get('CUSTOM_TOOL_PATH')}/AOL_SCRIPTS/AOL_SCRIPTS\" \"${data.get('ORACLE_PROJECT_FOLDER')}/AOL_SCRIPTS\" 
copy \"${data.get('ORACLE_PROJECT_FOLDER')}/${data.get('LOAD_FILE')}\" \"${data.get('ORACLE_PROJECT_FOLDER')}/AOL_SCRIPTS\" """
		}
		else{
		command = """cd ${data.get('ORACLE_PROJECT_FOLDER')}
mkdir AOL_SCRIPTS
cp /Y '${data.get('CUSTOM_TOOL_PATH')}/AOL_SCRIPTS/AOL_SCRIPTS' '${data.get('ORACLE_PROJECT_FOLDER')}/AOL_SCRIPTS'
cp /Y '${data.get('ORACLE_PROJECT_FOLDER')}/${data.get('LOAD_FILE')}' '${data.get('ORACLE_PROJECT_FOLDER')}/AOL_SCRIPTS'"""
		}
		ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
	}
	
	private static Map<String,String> performMapping(jsonData,moduleIndex,loadfile) {
		HashMap<String, String> data = new HashMap<String, String>();
		if (jsonData.basicInfo.buildServerOS.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
			data.put('CUSTOM_TOOL_PATH','%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH))
			data.put('ORACLE_PROJECT_FOLDER','%IDP_WS%/'+jsonData.buildInfo.modules[moduleIndex].moduleName)  //PROJECT NAME -> JSON
			data.put('LOAD_FILE',loadfile)  //PROJECT NAME -> JSON
		}
		else{
			data.put('CUSTOM_TOOL_PATH','$IDP_WS/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH))
			data.put('ORACLE_PROJECT_FOLDER','$IDP_WS/'+jsonData.buildInfo.modules[moduleIndex].moduleName)  //PROJECT NAME -> JSON
			data.put('LOAD_FILE',loadfile)
			}
		return data;
	}
}
