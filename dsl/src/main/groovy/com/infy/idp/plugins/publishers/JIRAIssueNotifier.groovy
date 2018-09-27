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
 * This class implements IPLuginBase interface to notify the users for JIRA Issues
 *
 */

class JIRAIssueNotifier implements IPluginBase {

    private String assignee = ''
    private String projectKey = ''


    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

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
        data.put("assignee", this.assignee);
        data.put("component", "");
        data.put("projectkey", this.projectKey);
        data.put("testDescription", "");
        return data;
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    @Override
    public void addOptions(context, HashMap<String, String> data) {
        context.with {
            publisher {
                createJiraIssue {
                    if (data.containsKey("assignee")) assignee(data.get("assignee"))
                    if (data.containsKey("component")) component(data.get("component"))
                    if (data.containsKey("projectkey")) projectKey(data.get("projectkey"))
                    if (data.containsKey("testDescription")) testDescription(data.get("testDescription"))
                }
            }
        }
    }
}
