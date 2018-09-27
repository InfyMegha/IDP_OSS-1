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
 * This class includes the method for adding Obfuscation customtool
 *
 */

class Obfuscation {

    /*
     * This function is used to add the commands to run Obfuscation
     */

    public static void invokeTool(context, jsonData) {
        HashMap<String, String> data = performMapping()
        def command;
        command = """java -jar ${data.get('CUSTOM_TOOL_JAR')} %IDP_WS%/${
            data.get('PROJ_NAME')
        }/Obfuscation.dox %IDP_WS%/${data.get('PROJ_NAME')}/Jar/${data.get('PROJ_NAME')}.Jar %IDP_WS%/${
            data.get('PROJ_NAME')
        }/ObfuscationJar ${data.get('RENAMING')} ${data.get('OPTIMIZATION')} ${data.get('CONTROL_FLOW')} ${
            data.get('ENCRYPTION')
        } ${data.get('PREMARK')} %IDP_WS%/${data.get('PROJ_NAME')}"""
        ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
    }

    /*
     * This function is used to perform mapping for adding Obfuscation
     */

    private static Map<String, String> performMapping() {
        
        HashMap<String, String> data = new HashMap<String, String>();
        data.put('CUSTOM_TOOL_JAR', '%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN, Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN, 'OBFUSCATIONJAR'))
        data.put('PROJ_NAME', '') //JSON
        data.put('RENAMING', '') //JSON
        data.put('OPTIMIZATION', '') //JSON
        data.put('CONTROL_FLOW', '') //JSON
        data.put('ENCRYPTION', '') //JSON
        data.put('PREMARK', '') //JSON
        return data;
    }

}
