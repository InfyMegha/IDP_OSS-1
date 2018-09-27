/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.utils

/**
 *
 * This class has the method to add PreBuild SSH wrapper
 *
 */
class BapSshPreBuildWrapper {

    private String preBuildSshCmd = ''

    /*
     * This method is used to update pre build commands for SSH
     */

    public void updatePreBuildSshCmd(tool) {
        if (tool == Constants.BDPIG)
            this.preBuildSshCmd += 'if [ -d IDP_PigData ] then rm -r IDP_PigData fi\n'
        else if (tool == Constants.BDHIVE)
            this.preBuildSshCmd += 'if [ -d IDP_HiveData ] then rm -r IDP_HiveData fi\n'
        else if (tool == Constants.BDSCALA)
            this.preBuildSshCmd += 'if [ -d IDP_scala_files ] then rm -r IDP_scala_files fi\n'
    }

    /*
     * This method is used to invoke pre build SSH wrapper
     */

    public void invokeBapSshPreBuildWrapper(context, moduleSection) {

        context.with {

            bapSshPreBuildWrapper {

                BapSshPreBuildWrapper.addPublishers(delegate, moduleSection)
                BapSshPreBuildWrapper.addGeneralBuildSettings(delegate)
                BapSshPreBuildWrapper.addParamPublish(delegate)
            }
        }
    }

    /*
     * This method is used to add required publisher
     */

    private void addPublishers(context, moduleSection) {

        context.with {

            publishers {

                BapSshPreBuildWrapper.addBapSshPublisher(delegate, moduleSection);
            }
        }
    }

    /*
     * This method is used to add SSH publisher
     */

    private void addBapSshPublisher(context, moduleSection) {

        context.with {

            bapSshPublisher {

                configName(moduleSection.hostName)
                verbose(false)

                BapSshPreBuildWrapper.addTransfers(delegate);

                useWorkspaceInPromotion(false)
                usePromotionTimestamp(false)

                BapSshPreBuildWrapper.addSshRetry(delegate);
                BapSshPreBuildWrapper.addSshLabel(delegate);
                BapSshPreBuildWrapper.addSshCredentials(delegate, moduleSection);
            }
        }
    }

    /*
     * This method is used to add transfer option
     */

    private void addTransfers(context) {

        context.with {

            transfers {

                BapSshPreBuildWrapper.addBapSshTransfer(delegate);
            }
        }
    }

    /*
     * This method is used to add SSH transfer option
     */

    private void addBapSshTransfer(context) {

        context.with {

            bapSshTransfer {

                sourceFiles('')
                excludes('')
                remoteDirectory('')
                removePrefix('')
                remoteDirectorySDF(false)
                flatten(false)
                execCommand(preBuildSshCmd)
                execTimeout(120000)
                usePty(false)
                noDefaultExcludes(false)
                makeEmptyDirs(true)
                patternSeparator('[, ]+')
                useAgentForwarding(true)
            }
        }
    }

    /*
     * This method is used to add general settings
     */

    private void addGeneralBuildSettings(context) {

        context.with {

            continueOnError(false)
            failOnError(false)
            alwaysPublishFromMaster(false)
            masterNodeName('')
        }
    }

    /*
     * This method is used add parameter publisher
     */

    private void addParamPublish(context) {

        context.with {

            paramPublish {

                parameterName('')
            }
        }
    }

    /*
     * this method is used to configure SSH retry option
     */

    private void addSshRetry(context) {

        context.with {

            sshRetry {

                retries(50)
                retryDelay(50)
            }
        }
    }

    /*
     * This method is used to add SSH label
     */

    private void addSshLabel(context) {

        context.with {

            sshLabel {

                label('')
            }
        }
    }

    /*
     * This method is used to add SSh credentials
     */

    private void addSshCredentials(context, moduleSection) {

        context.with {

            sshCredentials {

                username(moduleSection.userName)
                encryptedPassphrase(hudson.util.Secret.fromString(moduleSection.password).encryptedValue)
                key('')
                keyPath('')
            }
        }
    }
}
