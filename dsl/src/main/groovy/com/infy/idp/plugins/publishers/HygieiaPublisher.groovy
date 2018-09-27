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
 * This class implements IPLuginBase interface to publish Hygieia reports
 *
 */

class HygieiaPublisher implements IPluginBase {
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
        data.put("hygieiaBuild_publishBuildStart", true);
        data.put("hygieiaSonar_publishBuildStart", true);
        data.put("publishTestStart", false);
        data.put("publishEvenBuildFails", false);
        data.put("testFileNamePattern", "");
        data.put("testResultsDirectory", "");
        data.put("testType", "");
        data.put("testApplicationName", "");
        data.put("testEnvironmentName", "");
        data.put("artifactDirectory", "");
        data.put("artifactName", "");
        data.put("artifactGroup", "");
        data.put("artifactVersion", "");
        data.put("hygieiaSonar_publishBuildStart", true);
        data.put("ceQueryIntervalInSeconds", "");
        data.put("ceQueryMaxAttempts", "");
        data.put("hygieiaDeploy_artifactDirectory", "");
        data.put("hygieiaDeploy_artifactName", "");
        data.put("hygieiaDeploy_artifactGroup", "");
        data.put("hygieiaDeploy_artifactVersion", "");
        data.put("applicationName", "");
        data.put("environmentName", "");
        data.put("publishDeployStart", true);


        return data;
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    @Override
    public void addOptions(context, HashMap<String, String> data) {
        context.with {
            hygieiaPublisher {
                if (data.containsKey("hygieiaBuild_publishBuildStart")) {
                    HygieiaPublisher.addHygieiaBuild(delegate, data)
                }
                if (data.containsKey("publishTestStart") && data.containsKey("publishEvenBuildFails") && data.containsKey("testFileNamePattern") && data.containsKey("testResultsDirectory") && data.containsKey("testType") && data.containsKey("testApplicationName") && data.containsKey("testEnvironmentName")) {
                    HygieiaPublisher.addHygieiaTest(delegate, data)
                }
                if (data.containsKey("artifactDirectory") && data.containsKey("artifactName") && data.containsKey("artifactGroup") && data.containsKey("artifactVersion")) {

                    HygieiaPublisher.addHygieiaArtifact(delegate, data)
                }
                if (data.containsKey("hygieiaSonar_publishBuildStart") && data.containsKey("ceQueryIntervalInSeconds") && data.containsKey("ceQueryMaxAttempts")) {

                    HygieiaPublisher.addHygieiaSonar(delegate, data)
                }
                if (data.containsKey("hygieiaDeploy_artifactDirectory") && data.containsKey("hygieiaDeploy_artifactName") && data.containsKey("hygieiaDeploy_artifactGroup") && data.containsKey("hygieiaDeploy_artifactVersion") && data.containsKey("applicationName") && data.containsKey("environmentName") && data.containsKey("publishDeployStart")) {

                    HygieiaPublisher.addHygieiaDeploy(delegate, data)
                }


            }
        }
    }

    /*
     * This method is used to add Hygieie build in jenkins job
     */

    private static void addHygieiaBuild(context, data) {
        context.with {
            hygieiaBuild {
                if (data.containsKey("hygieiaBuild_publishBuildStart")) publishBuildStart(data.get("hygieiaBuild_publishBuildStart").toBoolean());
            }
        }
    }

    /*
     * This method is used to add Hygieia test steps in jenkins job
     */

    private static void addHygieiaTest(context, data) {
        context.with {
            hygieiaTest {
                if (data.containsKey("publishTestStart")) publishTestStart(data.get("publishTestStart").toBoolean());
                if (data.containsKey("publishEvenBuildFails")) publishEvenBuildFails(data.get("publishEvenBuildFails").toBoolean());
                if (data.containsKey("testFileNamePattern")) testFileNamePattern(data.get("testFileNamePattern"));
                if (data.containsKey("testResultsDirectory")) testResultsDirectory(data.get("testResultsDirectory"));
                if (data.containsKey("testType")) testType(data.get("testType"));
                if (data.containsKey("testApplicationName")) testApplicationName(data.get("testApplicationName"));
                if (data.containsKey("testEnvironmentName")) testEnvironmentName(data.get("testEnvironmentName"));
            }
        }
    }

    /*
     * This method is used to add Hygieia artifacts
     */

    private static void addHygieiaArtifact(context, data) {
        context.with {
            hygieiaArtifact {

                if (data.containsKey("artifactDirectory")) artifactDirectory(data.get("artifactDirectory"));
                if (data.containsKey("artifactName")) artifactName(data.get("artifactName"));
                if (data.containsKey("artifactGroup")) artifactGroup(data.get("artifactGroup"));
                if (data.containsKey("artifactVersion")) artifactVersion(data.get("artifactVersion"));
            }
        }
    }

    /*
     * This method is used to add Hygieia Sonar
     */

    private static void addHygieiaSonar(context, data) {
        context.with {
            hygieiaSonar {

                if (data.containsKey("hygieiaSonar_publishBuildStart")) publishBuildStart(data.get("hygieiaSonar_publishBuildStart").toBoolean());
                if (data.containsKey("ceQueryIntervalInSeconds")) ceQueryIntervalInSeconds(data.get("ceQueryIntervalInSeconds"));
                if (data.containsKey("ceQueryMaxAttempts")) ceQueryMaxAttempts(data.get("ceQueryMaxAttempts"));

            }
        }
    }

    /*
     * This methos is used to add Hygieia Deploy option in jenkins job
     */

    private static void addHygieiaDeploy(context, data) {
        context.with {
            hygieiaDeploy {
                if (data.containsKey("hygieiaDeploy_artifactDirectory")) artifactDirectory(data.get("hygieiaDeploy_artifactDirectory"));
                if (data.containsKey("hygieiaDeploy_artifactName")) artifactName(data.get("hygieiaDeploy_artifactName"));
                if (data.containsKey("hygieiaDeploy_artifactGroup")) artifactGroup(data.get("hygieiaDeploy_artifactGroup"));
                if (data.containsKey("hygieiaDeploy_artifactVersion")) artifactVersion(data.get("hygieiaDeploy_artifactVersion"));
                if (data.containsKey("applicationName")) applicationName(data.get("applicationName"));
                if (data.containsKey("environmentName")) environmentName(data.get("environmentName"));
                if (data.containsKey("publishDeployStart")) publishDeployStart(data.get("publishDeployStart").toBoolean());
            }
        }
    }
}
