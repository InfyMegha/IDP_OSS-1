/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.plugins.publishers

import com.infy.idp.interfaces.IPluginBase
import jenkins.model.*
import org.infy.idp.entities.jobs.IDPJob

/**
 *
 * This class implements IPLuginBase interface to publish reports over SSH
 *
 */

class PublishOverSSH implements IPluginBase {

    def envIndex;
    def stepIndex;

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
        def containerInfo = dataObj.deployInfo.deployEnv[envIndex].deploySteps[stepIndex].deployToContainer;
        data.put('sourceFiles', containerInfo.resourceToBeDeployed)
        data.put('remoteDirectory', containerInfo.deployedFolder)
        def foldername = containerInfo.resourceToBeDeployed.replace("\\", "/").split('/')[containerInfo.resourceToBeDeployed.replace("\\", "/").split('/').length - 1].replace('.nar', '')
        if (containerInfo.narOS == 'linux') {
            data.put('execCommand', 'nifi.sh stop; rm -r ' + containerInfo.deployedFolder + '/' + foldername + '; nifi.sh start;')
        }

        data.put('configName', containerInfo.serverManagerURL)
        data.put('username', containerInfo.userName)
        data.put('password', containerInfo.password)
        return data;
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    @Override
    public void addOptions(context, HashMap<String, String> data) {
        def group = (data.get('configName') =~ /http:\/\/(.*):(.*)/)
        addHost(data.get('configName'), group[0][1], data.get('username'))
        context.with {
            bapSshPublisherPlugin {
                continueOnError(false)
                failOnError(false)
                alwaysPublishFromMaster(false)
                masterNodeName('')
                paramPublish {
                    parameterName('')
                }

                addBapSSHPublisher(delegate, data)
            }
        }
    }

    /*
     * This method is used to add SSH publisher configuration in jenkins job
     */

    private void addBapSSHPublisher(context, HashMap<String, String> data) {
        context.with {
            publishers {
                bapSshPublisher {
                    verbose(false)
                    useWorkspaceInPromotion(false)
                    usePromotionTimestamp(false)
                    sshRetry {
                        retries(3)
                        retryDelay(10000)
                    }
                    sshLabel {
                        label('')
                    }
                    transfers {
                        bapSshTransfer {
                            sourceFiles(data.get('sourceFiles'))
                            remoteDirectory(data.get('remoteDirectory'))
                            execCommand(data.get('execCommand'))
                            excludes('')
                            removePrefix('')
                            remoteDirectorySDF(false)
                            flatten(true)
                            execTimeout(120000)
                            usePty(false)
                            noDefaultExcludes(false)
                            makeEmptyDirs(false)
                            patternSeparator('[, ]+')
                        }
                    }
                    configName(data.get('configName'))
                    sshCredentials {
                        username(data.get('username'))
                        encryptedPassphrase(hudson.util.Secret.fromString(data.get('password')).encryptedValue)
                        key('')
                        keyPath('')
                    }
                }
            }
        }
    }

    /*
     * This method is used to add the host machine where reports are to be published
     */

    private void addHost(name, hostname, username) {
        def inst = Jenkins.getInstance()
        def publish_ssh = inst.getDescriptor("jenkins.plugins.publish_over_ssh.BapSshPublisherPlugin")
        publish_ssh.removeHostConfiguration(name)
        def configuration = publish_ssh.class.classLoader.loadClass("jenkins.plugins.publish_over_ssh.BapSshHostConfiguration").newInstance(name, hostname, username, '', '/', 22, 300000, false, '', '', false)
        publish_ssh.addHostConfiguration(configuration)
        publish_ssh.save()
    }
}
