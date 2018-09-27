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
 * This class includes the method for adding InReleaseDepJar customtool
 *
 */

class InReleaseDepJar {


    /*
     * This function is used to add the commands to run InReleaseDepJar
     */

    public static void invokeTool(context, jsonData) {
        HashMap<String, String> data = performMapping()
        def command;
        command = """java -jar ${data.get('INRELEASE_CUSTOM_TOOL_JAR')}/Deploy.jar ${data.get('INDNS')} ${
            data.get('INUSER')
        } ${data.get('INPASS')} ${data.get('OUTPUTPATH')} ${data.get('TESTXMLPATH')} ${data.get('PSPATH')} ${
            data.get('WEBSITENAME')
        } ${data.get('POWERSHELL')}""";
        ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
    }

    /*
     * This function is used to perform mapping for adding InReleaseDepJar
     */

    private static Map<String, String> performMapping() {
        
        HashMap<String, String> data = new HashMap<String, String>();
        data.put('INRELEASE_CUSTOM_TOOL_JAR', '%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN, Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN, 'DEPLOYMENTJAR'))
        data.put('INDNS', '') //JSON
        data.put('INUSER', '') //JSON
        data.put('INPASS', '') //JSON
        data.put('OUTPUTPATH', '%IDP_WS%')
        data.put('TESTXMLPATH', '%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN, Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN, 'INRELEASEXMLPATH'))
        data.put('PSPATH', '%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN, Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN, 'PSPATH'))
        data.put('WEBSITENAME', '') //JSON
        data.put('POWERSHELL', '%IDP_WS%')
        return data;
    }
}
