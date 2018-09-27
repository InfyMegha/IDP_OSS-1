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
 * This class has the method to add steps and plugins
 *
 */

class StepsAdder {

    /*
     * This method is used to add the steps
     */

    static void addSteps(context, jsonData, jobType) {
        context.with {
            steps {
                if (jobType == "maven_upload") {

                    batchFile("xcopy /S /Y " + jsonData.Build.MavenProjDetails.RootPOMPath.toString().minus("/pom.xml").replaceAll("/", "\\\\") + "\\*.war D:\\temp\\")
                } else if (jobType == "maven_test") {
                    batchFile("mvn surefire:test -f " + jsonData.Build.MavenProjDetails.RootPOMPath)
                } else if (jobType == "freestyle_build") {
                    batchFile("D:\\Code_Share\\Job_Support_Files\\tinyjson_replace_class_file N")
                    batchFile("\"D:\\Code_Share\\GetNamespaceNames\\GetNamespaceNames\\bin\\Debug\\GetNamespaceNames.exe\" \"%WORKSPACE%\"")
                    batchFile("mkdir .nuget \nxcopy  \"D:\\Code_Share\\.nuget\\*.*\" .nuget \n.nuget\\NuGet.exe restore TinyJSON.sln")
                    addMSBuildSonarBegin(delegate)
                    addMSBuild(delegate)
                    msBuildSQRunnerEnd()
                    StringBuilder sb = new StringBuilder()
                    sb.append("FxCopCmd.exe /file:\"%workspace%\\TinyJSON\\bin\\Debug\\TinyJSON.dll\"")
                    sb.append(" /file:\"%workspace%\\Example\\bin\\Debug\\Example.exe\"")
                    sb.append(" /file:\"%workspace%\\UnitTests\\bin\\Debug\\UnitTests.dll\"")
                    sb.append(" /rule:\"C:\\Program Files (x86)\\Microsoft Visual Studio 12.0\\Team Tools\\Static Analysis Tools\\FxCop\\Rules\" /out:\"D:\\Code_Share\\temp.html\"")
                    sb.append("\nmove C:\\FxCop_NewReports\\Collapsed.txt \"%workspace%\"\\pqm_report_pmd.txt")
                    batchFile(sb.toString())

                } else if (jobType == "freestyle_upload") {
                    batchFile("xcopy /S /Y .\\* D:\\temp\\")
                } else if (jobType == "freestyle_test") {
                    batchFile("\"C:\\Program Files (x86)\\NUnit.org\\nunit-console\\nunit3-console.exe\" UnitTests\\bin\\Debug\\UnitTests.dll \nexit 0")
                }
            }
        }
    }

    /*
     * This method is used to add MSBuild Sonar Plugin configuration
     */

    private static void addMSBuildSonarBegin(context) {
        context.with {
            msBuildSQRunnerBegin {
                additionalArguments('')
                msBuildScannerInstallationName('Sonar MSBuild Analysis')
                projectKey("TinyJSON")
                projectName("TinyJSON")
                projectVersion("1.0")
                sonarInstallationName('JSonar')
            }
        }
    }

    /*
     * This method is used to add MSBuild option
     */

    private static void addMSBuild(context) {
        context.with {
            msBuild {
                args('')
                buildFile('TinyJSON.sln')
                continueOnBuildFailure(false)
                msBuildInstallation('MSBuild_Tools')
                passBuildVariables(false)
                unstableIfWarnings(false)
            }
        }
    }
    /*private static void addAnt(context){
      context.with {
        ant{
          targets(['zipFile'])
          antInstallation('IDP_ANT')
          buildFile('IDP_StaggingZip.xml')
          javaOpts(['&quot;-DAppScanInstallationFolder=$APPSCAN_INSTALLATION_FOLDER&quot;'])
        }
      }
    }

    private static void addNexusArtifactUploader(context){
      context.with {
        nexusArtifactUploader {
          nexusVersion('nexus3')
          protocol('http')
          nexusUrl('blrkec401075d:8081')
          groupId('ldaproleapp.$ARTIFACT_ID')
          version('$ARTIFACT_VERSION')
          repository('tg_hosted')
  //        artifacts {
  //          artifact {
  //            artifactId('ldaproleapp_Jmvn1_14Mr1')
  //            type('zip')
  //            classifier('')
  //            file('toBeUploaded/ldaproleapp_Jmvn1_14Mr1.zip')
  //          }
  //        }
          credentialsId('ldaproleapp_jmvn1_14mr1_Nexus_ciplatform')
        }
      }
    }

    private static void addXShellBuilder(context) {
      context.with {
        xShellBuilder {
          commandLine('java -jar ${IDP_WS}//..//..//tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/TG_NEXUS_ARTIFACT_INFO_UPLOAD/TG_NEXUS_ARTIFACT_INFO_UPLOAD/TGNexusArtifactInfoUpload.jar 1133 109 %ARTIFACT_ID% ldaproleapp %ARTIFACT_VERSION%')
          executeFromWorkingDir(false)
          regexToKill('')
          timeAllocated('')
        }
      }
    }*/
}
