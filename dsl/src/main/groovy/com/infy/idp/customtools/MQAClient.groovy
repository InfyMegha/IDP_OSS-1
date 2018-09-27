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
 * This class includes the method for adding MQAClient customtool
 *
 */

class MQAClient {

    /*
     * This function is used to add the commands to run MQAClient
     */

    public static void invokeTool(context, jsonData) {
        HashMap<String, String> data = performMapping()
        def command;
        command = """java -jar ${data.get('MQA_CUSTOM_TOOL_JAR')} ${data.get('MQAURL')} ${data.get('EMAILID')} ${
            data.get('APKFILEPATH')
        } ${data.get('APKFILENAME')}""";
        ExecuteCmd.invokeCmd(context, command, jsonData.basicInfo.buildServerOS)
    }

    /*
     * This function is used to perform mapping for adding MQAClient
     */

    private static Map<String, String> performMapping() {
       
        HashMap<String, String> data = new HashMap<String, String>();
        data.put('MQA_CUSTOM_TOOL_JAR', '%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN, Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN, 'MQACLIENT'))
        data.put('MQAURL', '') //JSON
        data.put('EMAILID', '') //JSON
        data.put('APKFILEPATH', '%IDP_WS%/<MSP_PROJECT NAME/apps/<mfp native android proj name>/android/native/bin/<mfp native android proj name>-debug.apk')
        //JSON
        data.put('APKFILENAME', '<mfp native android proj name>-debug.apk') //JSON
        return data;
    }
}
