/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.deploy

import com.infy.idp.plugins.publishers.*
import com.infy.idp.utils.*
import org.infy.idp.entities.jobs.IDPJob

/**
 *
 * This class has the method to create the Weblogic Deploy job
 *
 */
class WeblogicDeploy {
    def envIndex;
    def stepIndex;
    def static buildServer;

    /*
     * This method is used to add conditional steps
     */

    public void add(context, IDPJob dataObj) {
        this.addOptions(context, this.performMapping(dataObj));
    }

    /*
     * This method is used to app various options
     */

    public void addOptions(context, HashMap<String, String> data) {

        context.with {
            addSteps(delegate, data)
        }

    }

    /*
     * This method is used to add conditional steps
     */

    private static void addSteps(context, HashMap<String, String> data) {
        def targets = "undeploy deploy"
        def server = buildServer;
        context.with {
            steps {
                String cmd = "cd IDP_SCRIPTS \n checkWeblogicServer.bat " +
                        data.getAt("wlsHostname") + ":" +
                        data.getAt("wlsPort") + "/console" +
                        " " + data.getAt("wlsUsername") +
                        " " + data.getAt("wlsPassword");
                ExecuteCmd.invokeCmd(delegate, cmd, server)
                Ant.invokeAnt(delegate, targets, 'IDP_SCRIPTS/weblogic.xml', data)
            }
        }
    }

    /*
     * This method is used to perform mapping for weblogin deploy
     */

    public HashMap<String, String> performMapping(IDPJob dataObj) {

        def containerInfo = dataObj.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].deployToContainer;


        HashMap<String, String> data = new HashMap<String, String>();
        data.put("wlsUsername", containerInfo.userName);
        data.put("wlsPassword", containerInfo.password);
        data.put("wlsHostname", containerInfo.hostName);
        data.put("wlsPort", containerInfo.port);
        data.put("serverName", containerInfo.targetServerName);
        data.put("resourceName", containerInfo.resourceToBeDeployed);
        data.put("deployTarget", containerInfo.targetCellName);
        data.put("deployName", containerInfo.targetNodeName);



        return data;
    }

}
