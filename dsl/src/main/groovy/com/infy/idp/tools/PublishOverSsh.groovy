/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools

import com.infy.idp.creators.*
import com.infy.idp.utils.*

/**
 *
 * This class has the method to publish artifacts over SSH
 *
 */
class PublishOverSsh {

    public static void publishOverSshPluginInvocation(context, jsonData) {


        context.with {

            steps {

                bapSshBuilderPlugin {

                    publishers {
                        PublishOverSsh.addBapSshPublisher(delegate);
                    }
                }
            }
        }
    }

    public static void publishOverSshPluginInvocation(context) {

        context.with {

            transfers {

                bapSshTransfer {

                    // Files to upload to a server.
                    sourceFiles('')

                    // Exclude files from the Transfer set.
                    excludes('')

                    // Optional destination folder.
                    remoteDirectory('')

                    // First part of the file path that should not be created on the remote server.
                    removePrefix('')

                    // Select this to include the timestamp in the remote directory.
                    remoteDirectorySDF(false)

                    // Only create files on the server, don&apos;t create directories (except for the remote directory, if present) All files that have been selected to transfer must have unique filenames.
                    flatten(false)

                    // A command to execute on the remote server This command will be executed on the remote server after any files are transferred.
                    execCommand('cd')

                    // Timeout in milliseconds for the Exec command Set to zero to disable.
                    execTimeout(120000)

                    // Exec the command in a pseudo tty This will enable the execution of sudo commands that require a tty (and possibly help in other scenarios too.)
                    usePty(false)

                    noDefaultExcludes(false)

                    // The default behaviour of this plugin is to match files, and then create any directories required to preserve the paths to the files.
                    makeEmptyDirs(false)

                    // The regular expression that is used to separate the Source files and Exclude files patterns.
                    patternSeparator('[, ]+')

                }
            }
        }
    }


    private static void addBapSshPublisher(context) {
        context.with {
            bapSshPublisher {

                // Select an SSH configuration from the list configured in the global configuration of this Jenkins.
                configName('localhost')

                // Select to enable an obscene amount of information to the Jenkins console - only really useful to help track down problems
                verbose(false)

                transferSetAdder(delegate)

                // Set the root directory for the Source files to the workspace By default this plugin uses the artifacts directory (where archived artifacts are stored).
                useWorkspaceInPromotion(false)

                // Use the build time of the promotion when the remote directory is a date format By default this plugin uses the time of the original build (the one that is being promoted) when formatting the remote directory.
                usePromotionTimestamp(false)

                // If publishing to this server or command execution fails, try again.
                sshRetry {

                    // The number of times to retry this server in the event of failure
                    retries(0)

                    // The time to wait, in milliseconds, before attempting another transfer
                    retryDelay(0)
                }

                // Set the label for this Server instance - for use with Parameterized publishing Expand the help for Parameterized publishing for more details
                sshLabel {

                    // Set the label for this Server instance - for use with Parameterized publishing Expand the help for Parameterized publishing for more details
                    label('')
                }

                // Set the credentials to use with this connection.
                sshCredentials {
                    // The username to connect with.
                    username('$PIGUSERNAME')

                    // The passphrase for the private key, or the password for password authentication if no Key or Path to key is configured.
                    encryptedPassphrase('$PIGPASSWORD')

                    // The private key.
                    key('')

                    // The path to the private key.
                    keyPath('')
                }

                // Select to continue publishing to the other servers after a problem with a previous server
                continueOnError(false)

                // Select to mark the build as a failure if there is a problem publishing to a server.
                failOnError(false)

                // Select to publish from the Jenkins master.
                alwaysPublishFromMaster(false)

                // Set the NODE_NAME for the master Jenkins.
                masterNodeName('')

                paramPublish {
                    // The name of the parameter or environment variable that will contain the expression for matching the labels.
                    parameterName('')
                }
            }
        }
    }
}


