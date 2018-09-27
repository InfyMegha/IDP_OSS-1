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
 * This class has the method to add SCM steps
 *
 */
class ScmAdder {

    /*
     * This method is used to add SCM options
     */

    static void addSCM(context, scmType, jsonData) {
        context.with {
            scm {
                if (scmType.toString().compareToIgnoreCase("git") == 0) {
                    if (jsonData == "pipeline") {
                        ScmAdder.addGitSCM(delegate, "http://Jaskirat.S@infygit.ad.infosys.com/Jaskirat.S/IDP_SeedJobs.git", 'e37ce9e4-c94d-4d16-83ee-fbf75683bab3', ["GitLab", "http://infygit.ad.infosys.com/", "1.0"])
                    } else {
                        def jsonSCM = jsonData.Code.SCM
                        ScmAdder.addGitSCM(delegate, jsonSCM.GitRepoURL, 'e37ce9e4-c94d-4d16-83ee-fbf75683bab3', [jsonSCM.GitRepositoryBrowser, jsonSCM.GitLabURL, "1.0"])
                    }
                }
            }
        }
    }

    /*
     * This method is used to add Git SCM in jenkins job
     */

    private static void addGitSCM(context, repo, creds, repoBrowserDetails) {
        context.with {
            gitSCM {
                userRemoteConfigs {
                    userRemoteConfig {
                        name('')
                        refspec('')
                        credentialsId(creds)
                        url(repo)
                    }
                }
                branches {
                    branchSpec {
                        name('')
                    }
                }
                doGenerateSubmoduleConfigurations(false)
                gitTool('Default')
                if (repoBrowserDetails[0]) {
                    ScmAdder.addRepoBrowser(delegate, repoBrowserDetails)
                }
                ScmAdder.addGitExtensions(delegate)
            }
        }
    }

    /*
     * This method is used to configure git extension
     */

    private static void addGitExtensions(context) {
        context.with {
            extensions {

                cleanBeforeCheckout()
                cloneOption {
                    shallow(false)
                    noTags(false)
                    reference('')
                    timeout(60)
                    depth(0)
                    honorRefspec(false)
                }
            }
        }
    }

    /*
     * This method is used to configure git repository browsers
     */


    private static void addRepoBrowser(context, repoBrowserDetails) {
        context.with {
            browser {
                if (repoBrowserDetails[0].toString().toLowerCase() == "gitlab") {
                    gitLab {
                        repoUrl(repoBrowserDetails[1])
                        version(repoBrowserDetails[2])
                    }
                }
            }
        }
    }
}
