/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.plugins.publishers

import com.infy.idp.interfaces.IPluginBase
import org.infy.idp.entities.jobs.IDPJob

/**
 *
 * This class implements IPLuginBase interface to deploy artifacts in an environment
 *
 */

class ArtifactDeployerPublisher implements IPluginBase {

    /*
     * This function implements add method of IPluginBase interface
     */

    @Override
    public void add(context, IDPJob dataObj) {
        this.addOptions(context, this.performMapping(dataObj));
    }

    /*
    * This function implements performMapping method of IPluginBase interface
    */

    @Override
    public HashMap<String, String> performMapping(IDPJob dataObj) {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("baseDir", "")
        data.put("cleanUp", "")
        data.put("deleteRemoteArtifacts", "")
        data.put("deleteRemoteArtifactsByScripts", "")
        data.put("excludes", "")
        data.put("failIfNoFiles", "")
        data.put("flatten", "")
        data.put("includes", "\$ARTIFACTS")
        data.put("remoteFileLocation", "")
        data.put("deployIfFailed", "false")
        return data;
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    @Override
    public void addOptions(context, HashMap<String, String> data) {
        context.with {
            ArtifactDeployerPublisher.publishArtifacts(delegate, data)

        }
    }

    /*
     * This method is used to publish the artifacts generated as a result of build
     * It configures jenkins deploy job to perform the operation
     */
    
    private static void publishArtifacts(context, data) {
        context.with {
            artifactDeployer {
                artifactsToDeploy {
                    if (data.containsKey("baseDir")) baseDir(data.get("baseDir"));
                    if (data.containsKey("cleanUp")) cleanUp(data.get("cleanUp").toBoolean());
                    if (data.containsKey("deleteRemoteArtifacts")) deleteRemoteArtifacts(data.get("deleteRemoteArtifacts").toBoolean());
                    if (data.containsKey("deleteRemoteArtifactsByScripts")) deleteRemoteArtifactsByScripts(data.get("deleteRemoteArtifactsByScripts"));
                    if (data.containsKey("excludes")) excludes(data.get("excludes"));
                    if (data.containsKey("failIfNoFiles")) failIfNoFiles(data.get("failIfNoFiles").toBoolean());
                    if (data.containsKey("flatten")) flatten(data.get("flatten").toBoolean());
                    if (data.containsKey("includes")) includes(data.get("includes"));
                    if (data.containsKey("remoteFileLocation")) remoteFileLocation(data.get("remoteFileLocation"));
                }
                if (data.containsKey("deployIfFailed")) deployIfFailed(data.get("deployIfFailed").toBoolean());

            }
        }
    }
}
