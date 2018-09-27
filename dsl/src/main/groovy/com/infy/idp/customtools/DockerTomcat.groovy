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
* This class includes the method for adding Docker/Tomcat customtool
*
*/

class DockerTomcat{

	/*
	 * This function is used to add the configuration for docker or tomcat deployment
	 */

	public static void invokeTool(context, jsonData) {
		HashMap<String, String> data = performMapping(jsonData)
		def command;
		command = """cd /
cp -r ${data.get('JAVA_HOME')} ${data.get('CUSTOM_TOOL_PATH')}
cd ${data.get('CUSTOM_TOOL_PATH')}
find . -maxdepth 1 -type d -name ""jdk*"" | xargs -I '{}' mv '{}' jdk
docker build -t ${data.get('JOBNAME')}_tomcatimage
docker run -d -p ${data.get('TOMCAT_HOSTNAME')}:${data.get('TOMCAT_PORT')} ${data.get('JOBNAME')}_tomcatimage"""
		ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
	}
	
	private static Map<String,String> performMapping(jsonData) {
	def env = System.getenv()
	HashMap<String, String> data = new HashMap<String, String>();
	data.put('JAVA_HOME',env['JAVA_HOME'])
	data.put('TOMCAT_HOSTNAME','')  //JSON
	data.put('TOMCAT_PORT','')  //JSON
	data.put('CUSTOM_TOOL_PATH','%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN,'DOCKER'))
	data.put('JOBNAME',jsonData.basicInfo.applicationName+'_'+jsonData.basicInfo.pipelineName)
    return data;
	}
	
}
