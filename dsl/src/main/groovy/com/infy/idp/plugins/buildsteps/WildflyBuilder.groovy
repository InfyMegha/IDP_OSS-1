/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.plugins.buildsteps

import com.infy.idp.interfaces.IPluginBase
import org.infy.idp.entities.jobs.IDPJob

/**
 *
 * This class implements IPLuginBase interface to configure job for WildflyBuilder
 *
 */

class WildflyBuilder implements IPluginBase {

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
        data.put("war", "");
        data.put("host", "");
        data.put("port", "");
        data.put("username", "");
        data.put("password", "");
        data.put("server", "");
        return data;
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    @Override
    public void addOptions(context, HashMap<String, String> data) {
        context.with {
            wildflyBuilder {
                WildflyBuilder.addGeneralBuildSettings(delegate, data)
            }
        }
    }

    /*
     * This method is used to add general build settings for Wildfly builder in jenkins job
     */
    private static void addGeneralBuildSettings(context, data) {
        context.with {
            if (data.containsKey("war")) war(data.get("war"));
            if (data.containsKey("host")) host(data.get("host"));
            if (data.containsKey("port")) port(data.get("port"));
            if (data.containsKey("username")) username(data.get("username"));
            if (data.containsKey("password")) password(data.get("password"));
            if (data.containsKey("server")) server(data.get("server"));
        }
    }
}
