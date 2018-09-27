/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package com.infy.idp.plugins.buildsteps

import com.infy.idp.utils.*

/**
 *
 * This class is used to configure Checkmarx tool
 * It is also a bean for adding the same tool
 */

class Checkmarx {

    private String user
    private String pass
    private String projectKey
    private String teamName
    private String scanPreset
    private String directory
    private Boolean incremental = false
    private Boolean scaneSchedule = false
    private int scanCycle = 10;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getScanPreset() {
        return scanPreset;
    }

    public void setScanPreset(String scanPreset) {
        this.scanPreset = scanPreset;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public Boolean getIncremental() {
        return incremental;
    }

    public void setIncremental(String incremental) {
        if (incremental != null && incremental.equalsIgnoreCase("on"))
            this.incremental = true;
    }

    public Boolean getScaneSchedule() {
        return scaneSchedule;
    }

    public void setScaneSchedule(Boolean scaneSchedule) {
        this.scaneSchedule = scaneSchedule;
    }

    public int getScanCycle() {
        return scanCycle;
    }

    public void setScanCycle(int scanCycle) {
        this.scanCycle = scanCycle;
    }

    public void add(context) {
        this.addOptions(context, this.performMapping())
    }

    /*
     * This function is used to perform mapping for adding checkmarx details in jenkins job
     */

    public HashMap<String, String> performMapping() {

        HashMap<String, String> data = new HashMap<String, String>()

        /////////////Add real time data//////////////////////////
        data.put('serverURL', PropReader.readProperty(Constants.CONFIGFN, Constants.CHECKMARX_SERVER_URL))
        if (getUser() != null && getUser() != "") {
            data.put('user', getUser())
            data.put('password', getPass())
            data.put('useOwnServerCredentials', true)
        } else {
            data.put('useOwnServerCredentials', false)
        }
        data.put('projKey', getProjectKey())
        data.put('projectId', 0)
        data.put('teamName', getTeamName())
        data.put('scanPreset', getScanPreset())
        data.put('jobStatusOnError', 'GLOBAL')
        data.put('directory', getDirectory())
        data.put('incremental', getIncremental())
        data.put('scaneSchedule', getScaneSchedule())
        data.put('scanCycle', getScanCycle())
        data.put('buildStep', '')
        return data
    }

    /*
     * This function is udes to add options based on the mapped data
     */

    public void addOptions(context, HashMap<String, String> data) {
        context.with {
            cxScanBuilder {
                if (data.containsKey('useOwnServerCredentials')) useOwnServerCredentials(data.get('useOwnServerCredentials'))
                if (data.containsKey('serverURL')) serverUrl(data.get('serverURL'))
                if (data.containsKey('user')) username(data.get('user'))
                if (data.containsKey('password')) password(hudson.util.Secret.fromString(data.get('password')).encryptedValue)
                if (data.containsKey('projKey')) projectName(data.get('projKey'))
                if (data.containsKey('projectId')) projectId(data.get('projectId'))
                if (data.containsKey('buildStep')) buildStep(data.get('buildStep'))
                if (data.containsKey('teamName')) groupId(data.get('teamName'))
                if (data.containsKey('scanPreset')) preset(data.get('scanPreset'))
                if (data.containsKey('jobStatusOnError')) jobStatusOnError(data.get('jobStatusOnError'))
                //if(data.containsKey('presetspecified')) presetSpecified(data.get('scanPreset').toBoolean())
                if (data.containsKey('directory')) excludeFolders(data.get('directory'))
                if (data.containsKey('incremental')) incremental(data.get('incremental').toBoolean())
                if (data.containsKey('scaneSchedule')) fullScansScheduled(data.get('scaneSchedule').toBoolean())
                if (data.containsKey('scanCycle')) fullScanCycle(data.get('scanCycle'))

                sourceEncoding('Default Configuration')
                skipSCMTriggers(false)
                waitForResultsEnabled(false)
                vulnerabilityThresholdEnabled(false)
                //highThreshold(Integer value)
                //mediumThreshold(Integer value)
                //lowThreshold(Integer value)
                osaEnabled(false)
                generatePdfReport(false)
                //thresholdSettings(String value)
                //vulnerabilityThresholdResult(String value)
                avoidDuplicateProjectScans(false)
                thisBuildIncremental(false)
            }
        }
    }

}
