/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.plugins.buildsteps

import com.infy.idp.interfaces.IPluginBase
import jenkins.model.*
import org.infy.idp.entities.jobs.IDPJob

/**
 *
 * This class implements IPLuginBase interface to configure HPALM
 *
 */

class HPRunFromALMBuilder implements IPluginBase {

    private String serverName;
    private String domain;
    private String projectName;
    private String userName;
    private String password;
    private String testSuiteName;
    private String timeout = '60';


    private String almServerName
    private String almUserName
    private String almPassword
    private String almDomain
    private String almProject
    private String almTestSets
    private String almRunResultsMode
    private String almRunMode = 'RUN_LOCAL'
    private String almRunHost


    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTestSuiteName() {
        return testSuiteName;
    }

    public void setTestSuiteName(String testSuiteName) {
        this.testSuiteName = testSuiteName;
    }

    /*
     * This function implements add method of IPluginBase interface
     */

    @Override
    public void add(Object context, IDPJob dataObj) {
        this.addOptions(context, this.performMapping(dataObj));
    }

    /*
    * This function implements performMapping method of IPluginBase interface
    */

    @Override
    public HashMap<String, String> performMapping(IDPJob dataObj) {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("almServerName", this.serverName);
        data.put("almUserName", this.userName);
        data.put("almPassword", this.password);
        data.put("almProject", this.projectName);
        data.put("almServerUrl", this.serverName);
        data.put("almDomain", this.domain);
        data.put("almTestSets", this.testSuiteName);
        data.put("almRunResultsMode", "");
        data.put("almTimeout", this.timeout);
        data.put("almRunMode", "Run Locally");
        data.put("almRunHost", "");
        return data;
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    public void addOptions(context, HashMap<String, String> data) {
        context.with {
            runFromAlmBuilder {

                if (data.containsKey("almServerName")) almServerName(data.get("almServerName"));
                if (data.containsKey("almUserName")) almUserName(data.get("almUserName"));
                if (data.containsKey("almPassword")) almPassword(data.get("almPassword"));
                if (data.containsKey("almProject")) almProject(data.get("almProject"));
                if (data.containsKey("almDomain")) almDomain(data.get("almDomain"));
                if (data.containsKey("almProject")) almProject(data.get("almProject"));
                if (data.containsKey("almTestSets")) almTestSets(data.get("almTestSets"));
                if (data.containsKey("almRunMode")) almRunMode(data.get("almRunMode"));
                if (data.containsKey("almTimeout")) almTimeout(data.get("almTimeout"));
                if (data.containsKey("almRunHost")) almRunHost(data.get("almRunHost"));
                if (data.containsKey("almRunResultsMode")) almRunResultsMode(data.get("almRunResultsMode"));
            }
        }
    }

}
