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
 * This class has the method to add PostBuild SSH wrapper
 *
 */
class BapSshPostBuildWrapper {

    private String postBuildSshCmd = ''
    private String postBuildSrcFiles = ''

    /*
     * This method is used to update post build commands for SSH
     */

    public void updatePostBuildSshCmd(tool) {
        if (tool == Constants.BDPIG) {
            this.postBuildSshCmd += 'cd IDP_PigData/pig/\n unzip -o *.zip\n if [ -d IDP_PigData/pig/src/test/resources/output ]\n then rm -r IDP_PigData/pig/src/test/resources/output\n fi\n cd src/test/resources/\n pig -x local pigunittest.pig\n'
        } else if (tool == Constants.BDHIVE) {
            this.postBuildSshCmd += 'cd IDP_HiveData/hive/ \n unzip -o *.zip \n cd src/test/resources/scripts \n hadoop fs -rmr create_table.sql \n hadoop fs -put create_table.sql \n hive -f create_table.sql \n'
        } else if (tool == Constants.BDSCALA) {
            this.postBuildSshCmd += 'cd IDP_scala_files \n hadoop fs -rm -r users.txt \n hadoop fs -put users.txt \n hadoop fs -rm -r transactions.txt \n hadoop fs -put transactions.txt \n /usr/hdp/2.3.4.0-3485/spark/bin/spark-submit --class main.scala.ExampleJob --master yarn-cluster ScalaBuild-0.0.1-SNAPSHOT.jar users.txt transactions.txt Scala1_job25 \n'
        } else {
            this.postBuildSshCmd += tool
        }
    }

    /*
     * This method is used to update post build source files
     */

    public void updatePostBuildSrcFiles(tool) {
        if (tool == Constants.BDPIG) {
            this.postBuildSrcFiles += ',IDP_PigData/pig/*.zip'
        } else if (tool == Constants.BDHIVE) {
            this.postBuildSrcFiles += ',IDP_HiveData/hive/*.zip'
        } else if (tool == Constants.BDSCALA) {
            this.postBuildSrcFiles += ',IDP_scala_files/*'
        } else {
            this.postBuildSrcFiles += tool
        }
    }

    /*
     * This method is used to invoke post build SSH wrapper
     */

    public void invokeBapSshPostBuildWrapper(context, moduleSection) {

        context.with {

            bapSshPostBuildWrapper {

                publishers {
                    addBapSshPublisher(delegate, moduleSection)

                }
                continueOnError(false)
                failOnError(false)
                alwaysPublishFromMaster(false)
                masterNodeName("")

                paramPublish {

                    // The name of the parameter or environment variable that will contain the expression for matching the labels.
                    parameterName("")
                }
            }
        }
    }

    /*
     * This method is used to add SSH publisher
     */

    private static void addBapSshPublisher(context, moduleSection) {
        context.with {
            bapSshPublisher {
                // Select an SSH configuration from the list configured in the global configuration of this Jenkins.
                configName(moduleSection.hostName)

                // Select to enable an obscene amount of information to the Jenkins console - only really useful to help track down problems
                verbose(false)

                transfers {

                    bapSshTransfer {

                        // Files to upload to a server.
                        sourceFiles(postBuildSrcFiles)

                        // Exclude files from the Transfer set.
                        excludes("")

                        // Optional destination folder.
                        remoteDirectory("")

                        // First part of the file path that should not be created on the remote server.
                        removePrefix("")

                        // Select this to include the timestamp in the remote directory.
                        remoteDirectorySDF(false)

                        // Only create files on the server, don&apos;t create directories (except for the remote directory, if present) All files that have been selected to transfer must have unique filenames.
                        flatten(false)

                        // A command to execute on the remote server This command will be executed on the remote server after any files are transferred.
                        execCommand(postBuildSshCmd)

                        // Timeout in milliseconds for the Exec command Set to zero to disable.
                        execTimeout(120000)

                        // Exec the command in a pseudo tty This will enable the execution of sudo commands that require a tty (and possibly help in other scenarios too.)
                        usePty(false)

                        noDefaultExcludes(false)

                        // The default behaviour of this plugin is to match files, and then create any directories required to preserve the paths to the files.
                        makeEmptyDirs(true)

                        // The regular expression that is used to separate the Source files and Exclude files patterns.
                        patternSeparator("[, ]+")

                        // Exec the command using Agent Forwarding Allows a chain of ssh connections to forward key challenges back to the original agent, thus eliminating the need for using a password or public/private keys for these connections.
                        useAgentForwarding(true)
                    }
                }

                // Set the root directory for the Source files to the workspace By default this plugin uses the artifacts directory (where archived artifacts are stored).
                useWorkspaceInPromotion(false)

                // Use the build time of the promotion when the remote directory is a date format By default this plugin uses the time of the original build (the one that is being promoted) when formatting the remote directory.
                usePromotionTimestamp(false)

                // If publishing to this server or command execution fails, try again.
                sshRetry {

                    // The number of times to retry this server in the event of failure
                    retries(50)

                    // The time to wait, in milliseconds, before attempting another transfer
                    retryDelay(50)
                }

                // Set the label for this Server instance - for use with Parameterized publishing Expand the help for Parameterized publishing for more details
                sshLabel {

                    // Set the label for this Server instance - for use with Parameterized publishing Expand the help for Parameterized publishing for more details
                    label("")
                }

                // Set the credentials to use with this connection.
                sshCredentials {

                    // The username to connect with.
                    username(moduleSection.userName)

                    // The passphrase for the private key, or the password for password authentication if no Key or Path to key is configured.
                    encryptedPassphrase(hudson.util.Secret.fromString(moduleSection.password).encryptedValue)

                    // The private key.
                    key("")

                    // The path to the private key.
                    keyPath("")
                }
            }
        }
    }
}
