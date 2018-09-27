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

class EclipseImporter {

    /*
     * This function is used to add the commands to run RPT
     */

    public static void invokeTool(context, jsonData) {
        HashMap<String, String> data = performMapping()
        def command;
        command = """java -jar ${data.get('CUSTOM_TOOL_JAR')} ${data.get('RPT_PROJECT_NAME')} ${
            data.get('CUSTOM_TOOL_GROOVY_JAR')
        } ${data.get('CUSTOM_TOOL_XML_PATH')} ${data.get('WORKSPACE')}/eclipse_import.xml""";
        ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
    }

    /*
     * This function is used to perform mapping for adding Eclipse importer
     */

    private static Map<String, String> performMapping() {

        HashMap<String, String> data = new HashMap<String, String>();
        data.put('CUSTOM_TOOL_JAR', '%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN, Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN, 'PROJECT_IMPORTER'))
        data.put('CUSTOM_TOOL_XML_PATH', '%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN, Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN, 'OLDXMLPATH'))
        data.put('CUSTOM_TOOL_GROOVY_JAR', '%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN, Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN, 'GROOVY_JAR'))
        data.put('RPT_PROJECT_NAME', '')
        data.put('WORKSPACE', '')
        return data;
    }
}
