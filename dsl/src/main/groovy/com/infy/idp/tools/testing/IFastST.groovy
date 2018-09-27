/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.testing

import com.infy.idp.plugins.buildsteps.HttpRequest
import com.infy.idp.plugins.publishers.ArchiveArtifacts
import com.infy.idp.utils.PropReader;

//import com.infy.idp.utils.XShell
//import com.infy.idp.utils.fs.DeleteDir
//import com.infy.idp.utils.Constants
/**
 *
 * This class has the method to add IFastST testing tool
 *
 */

class IFastST {

    /*
    * This method is used to add the steps to configure IFastST
    */

    public static void addSteps(context, sIFastURL, sFastestUser, jsonData, envIndex, stepIndex) {

        HttpRequest httpRequest1 = new HttpRequest()
        HttpRequest httpRequest2 = new HttpRequest()

        String pipelineName = jsonData.basicInfo.applicationName + '_' + jsonData.basicInfo.pipelineName

        String sSSOUser = jsonData.ssoId
        String projOwner = sSSOUser;

        if (sFastestUser != null && sFastestUser != '') {
            projOwner = sFastestUser
        }


        String server = PropReader.readProperty('Config.properties', 'JENKINS_HOSTNAME')


        String url = 'http://' + server + "/iFast_web/api/IAT/runstoreTestPlan";

        String projects = sIFastURL;
        List<String> projlist = new ArrayList<>();

        if (projects.startsWith(",")) {
            projects = projects.substring(1);
        }
        if (projects.endsWith(",")) {
            projects = projects.substring(0, projects.length() - 1);
        }
        /*uncomment to allow multiple projects in iFast, seperated by comma
        if (projects.contains(",")){
            String [] proj = projects.split(",");
            if (null != proj && proj.length>0){
                for (String i:proj){
                    projlist.add(i);
                }
            }
        }
        else if (!projects.isEmpty()) {

            projlist.add(projects);
        }
        */
        //comment below line if above part is uncommented
        projlist.add(projects);

        if (projlist.size() > 0) {

            String jsonStart1 = "{\"ProjectsToExecute\": ["
            String jsonStart2 = "{\"ProjectsToExecute\": ["
            String jsonEnd = "], \"ResultAs\": \"Link\",\"BuildID\": \"\${BUILD_NUMBER}\",\"PipelineID\": \"" + pipelineName + "\" }"

            for (String p : projlist) {
                p = p.trim();
                String json1 = "{\"CreatorUserName\": \"" + projOwner + "\",\"CurrentUserName\": \"" + sSSOUser + "\",\"ProjectName\": \"" + p + "\",\"SaveStatus\": \"yes\" },";
                String json2 = "{\"CreatorUserName\": \"" + projOwner + "\",\"CurrentUserName\": \"" + sSSOUser + "\",\"ProjectName\": \"" + p + "\",\"SaveStatus\": \"no\" },";
                jsonStart1 = jsonStart1 + json1;
                jsonStart2 = jsonStart2 + json2;
            }
            jsonStart1 = jsonStart1.substring(0, jsonStart1.length() - 1);
            jsonStart1 = jsonStart1 + jsonEnd;

            httpRequest2.setRequestBody(jsonStart1)


            jsonStart2 = jsonStart2.substring(0, jsonStart2.length() - 1);
            jsonStart2 = jsonStart2 + jsonEnd;

            httpRequest1.setRequestBody(jsonStart2)

        } else {
            httpRequest1.setRequestBody("")
            httpRequest2.setRequestBody("")
        }

        httpRequest1.setUrl(url)
        httpRequest2.setUrl(url)
        def envName = null
        def stepName = null
        /*if(jsonData.testAsset!=null && jsonData.testAsset.scm!=null){
            envName = jsonData.testInfo.testProcess.getAt(envIndex).processName
            stepName = jsonData.testInfo.testProcess.getAt(envIndex).testSteps.getAt(stepIndex).stepName
        }else{*/
        envName = jsonData.testInfo.testEnv.getAt(envIndex).envName
        stepName = jsonData.testInfo.testEnv.getAt(envIndex).testSteps.getAt(stepIndex).stepName



        httpRequest1.setOutputFile(envName + '_' + stepName + '_Fastest.json')
        httpRequest2.setOutputFile(envName + '_' + stepName + '_Fastest.txt')

        httpRequest1.setHttpMode("POST")
        httpRequest2.setHttpMode("POST")

        httpRequest1.setValidResponseCodes("100:399")
        httpRequest2.setValidResponseCodes("100:399")

        httpRequest1.setContentType("APPLICATION_JSON")
        httpRequest2.setContentType("APPLICATION_JSON")

        httpRequest1.add(context, jsonData)
        httpRequest2.add(context, jsonData)
    }

    /*
     * This method is used to add required publishers
     */

    public static void addPublishers(context, jsonData, envIndex, stepIndex) {

        def envName = null
        def stepName = null
        ArchiveArtifacts archiveArtifacts = new ArchiveArtifacts()
        
        envName = jsonData.testInfo.testEnv.getAt(envIndex).envName
        stepName = jsonData.testInfo.testEnv.getAt(envIndex).testSteps.getAt(stepIndex).stepName


        archiveArtifacts.setPattern(envName + '_' + stepName + '_Fastest.json,' + envName + '_' + stepName + '_Fastest.txt')
        archiveArtifacts.add(context, jsonData)
    }
}
