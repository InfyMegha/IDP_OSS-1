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
 * This class includes the method for adding TGNexusArtifactInfoUpload customtool
 *
 */

class TGNexusArtifactInfoUpload {

    /*
    * This function is used to add the commands to run TGNexusArtifactInfoUpload customtool
    */

    public static void invokeTool(context, jsonData) {
        HashMap<String, String> data = performMapping()
        def command;
        command = """java -jar  ${data.get('NEXUS_CUSTOM_TOOL_JAR')} ${data.get('PIPELINE_ID')} ${
            data.get('APPLICATION_ID')
        } %ARTIFACT_ID% ${data.get('ARTIFACT_GROUP_ID')} %ARTIFACT_VERSION%""";
        ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
    }

    /*
	* This function is used to perform mapping for adding TGNexusArtifactInfoUpload customtool
	*/

    private static Map<String, String> performMapping() {
        
        HashMap<String, String> data = new HashMap<String, String>();
        data.put('NEXUS_CUSTOM_TOOL_JAR', '')
        data.put('PIPELINE_ID', '')
        data.put('APPLICATION_ID', '')
        data.put('ARTIFACT_GROUP_ID', '')
        return data;
    }
}
