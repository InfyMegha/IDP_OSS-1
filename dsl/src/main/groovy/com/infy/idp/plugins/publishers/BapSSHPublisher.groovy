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
 * This class implements IPLuginBase interface to publish artifacts ovber SSH
 *
 */

class BapSSHPublisher implements IPluginBase {
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
        data.put("configName", "");
        data.put("verbose", false);
        data.put("useWorkspaceInPromotion", false);
        data.put("usePromotionTimestamp", false);

        data.put("sourceFiles", "");
        data.put("excludes", "");
        data.put("remoteDirectory", "");
        data.put("removePrefix", "");
        data.put("remoteDirectorySDF", false);
        data.put("flatten", false);
        data.put("execCommand", 'rm -r IDP_PigData');
        data.put("execTimeout", 120000);
        data.put("usePty", false);
        data.put("noDefaultExcludes", false);
        data.put("makeEmptyDirs", true);
        data.put("patternSeparator", "[, ]+");
        data.put("useAgentForwarding", true);


        data.put("retries", 50);
        data.put("retryDelay", 50);
        data.put("label", "");
        data.put("username", "");
        data.put("encryptedPassphrase", "");
        data.put("key", "");
        data.put("keyPath", "");
        data.put("continueOnError", false);
        data.put("failOnError", false);
        data.put("alwaysPublishFromMaster", false);
        data.put("masterNodeName", "");
        data.put("parameterName", "");

        return data;
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    public void addOptions(context, HashMap<String, String> data) {
        context.with {
            bapSshPublisherPlugin {

                BapSSHPublisher.addPublishers(delegate, data)
                BapSSHPublisher.addGeneralBuildSettings(delegate, data)
                if (data.containsKey("parameterName")) {
                    BapSSHPublisher.addparamPublish(delegate, data)

                }
            }
        }
    }

    /*
     * This method is used to configure jenkins job for publishing artifacts over SSH
     */

    private static void addPublishers(context, data) {
        context.with {
            publishers {
                BapSSHPublisher.addbapSshPublisher(delegate, data);
            }
        }
    }

    /*
     * This method adds the option for publishing artifacts over SSH
     */

    private static void addbapSshPublisher(context, data) {
        context.with {
            bapSshPublisher {
                if (data.containsKey("configName")) configName(data.get("configName"));
                if (data.containsKey("verbose")) verbose(data.get("verbose").toBoolean());
                BapSSHPublisher.addtransfers(delegate, data);
                if (data.containsKey("useWorkspaceInPromotion")) useWorkspaceInPromotion(data.get("useWorkspaceInPromotion").toBoolean());
                if (data.containsKey("usePromotionTimestamp")) usePromotionTimestamp(data.get("usePromotionTimestamp").toBoolean());
                BapSSHPublisher.addsshRetry(delegate, data);
                BapSSHPublisher.addsshlabel(delegate, data);
                BapSSHPublisher.addsshcredentials(delegate, data);

            }
        }
    }

    /*
     * This method is used to configure jenkins job for artifacts transfer
     */

    private static void addtransfers(context, data) {
        context.with {
            transfers {
                BapSSHPublisher.addbapSshtransfer(delegate, data);
            }
        }
    }

    /*
     * This method is used to add SSH transfer options in jenkins job
     */

    private static void addbapSshtransfer(context, data) {
        context.with {
            bapSshTransfer {
                if (data.containsKey("sourceFiles")) sourceFiles("");
                if (data.containsKey("excludes")) excludes(data.get("excludes"));
                if (data.containsKey("remoteDirectory")) remoteDirectory(data.get("remoteDirectory"));
                if (data.containsKey("removePrefix")) removePrefix(data.get("removePrefix"));
                if (data.containsKey("remoteDirectorySDF")) remoteDirectorySDF(data.get("remoteDirectorySDF").toBoolean());
                if (data.containsKey("flatten")) flatten(data.get("flatten").toBoolean());
                if (data.containsKey("execCommand")) execCommand(data.get("execCommand"));
                if (data.containsKey("execTimeout")) execTimeout(data.get("execTimeout"));
                if (data.containsKey("usePty")) usePty(data.get("usePty").toBoolean());
                if (data.containsKey("noDefaultExcludes")) noDefaultExcludes(data.get("noDefaultExcludes").toBoolean());
                if (data.containsKey("makeEmptyDirs")) makeEmptyDirs(data.get("makeEmptyDirs").toBoolean());
                if (data.containsKey("patternSeparator")) patternSeparator(data.get("patternSeparator"));
                if (data.containsKey("useAgentForwarding")) useAgentForwarding(data.get("useAgentForwarding").toBoolean());
            }
        }
    }

    /*
     * This method is used to retry SSH transfer if it fails
     */

    private static void addsshRetry(context, data) {
        context.with {
            sshRetry {
                if (data.containsKey("retries")) retries(data.get("retries"));
                if (data.containsKey("retryDelay")) retryDelay(data.get("retryDelay"));

            }
        }
    }

    /*
     * This method is used to add SSH label in jenkins job
     */

    private static void addsshlabel(context, data) {
        context.with {
            sshLabel {
                if (data.containsKey("label")) label(data.get("label"));

            }
        }
    }

    /*
     * This method is used to add credentials for remote machine connection
     */

    private static void addsshcredentials(context, data) {
        context.with {
            sshCredentials {
                if (data.containsKey("username")) username(data.get("username"));
                if (data.containsKey("encryptedPassphrase")) encryptedPassphrase(data.get("encryptedPassphrase"));
                if (data.containsKey("key")) key(data.get("key"));
                if (data.containsKey("keyPath")) keyPath(data.get("keyPath"));
            }
        }
    }

    /*
     * This method is used to add general settings for SSH transfer
     */

    private static void addGeneralBuildSettings(context, data) {
        context.with {
            if (data.containsKey("continueOnError")) continueOnError(data.get("continueOnError").toBoolean());
            if (data.containsKey("failOnError")) failOnError(data.get("failOnError").toBoolean());
            if (data.containsKey("alwaysPublishFromMaster")) alwaysPublishFromMaster(data.get("alwaysPublishFromMaster").toBoolean());
            if (data.containsKey("masterNodeName")) masterNodeName(data.get("masterNodeName"));

        }
    }

    /*
     * This method is used to add parameter for SSH transfer in jenkins job
     */

    private static void addparamPublish(context, data) {
        context.with {
            paramPublish {
                if (data.containsKey("parameterName")) parameterName(data.get("parameterName"));
            }
        }
    }
}
