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
 * This class includes the method for adding TGPomBDEditor customtool
 *
 */

class TGPomBDEditor {

    /*
    * This function is used to add the commands to run TGPomBDEditor customtool
    */

    public static void invokeTool(context, jsonData) {
        HashMap<String, String> data = performMapping()
        def command;

        command = """java -jar ${data.get('CUSTOM_TOOL_JAR')}/TG_Pom_BD_Editor/TG_Pom_BD_Editor.jar ${
            data.get('POM_FILE_PATH')
        }"""
        switch (data.get('STACK')) {
            case ['hive', 'scala']:
                command += """ package"""
                break
            case 'pig':
                command += """ packagecobertura"""
                break
        }
        ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
    }

    /*
	* This function is used to perform mapping for adding TGPomBDEditor customtool
	*/

    private static Map<String, String> performMapping() {
       
        HashMap<String, String> data = new HashMap<String, String>();
        data.put('CUSTOM_TOOL_JAR', '%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN, Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN, 'TGPOMEDITOR'))
        data.put('POM_FILE_PATH', '') //JSON
        data.put('STACK', '') //JSON

        return data;
    }
}
