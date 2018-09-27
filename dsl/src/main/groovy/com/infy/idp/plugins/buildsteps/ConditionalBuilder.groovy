/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package com.infy.idp.plugins.buildsteps

import com.infy.idp.creators.*
import com.infy.idp.interfaces.IPluginBase
import com.infy.idp.utils.*
import org.infy.idp.entities.jobs.IDPJob

/**
 *
 * This class implements IPLuginBase interface to configure conditional build steps in jenkins job
 *
 */

class ConditionalBuilder implements IPluginBase {

    /*
	 * This function implements add method of IPluginBase interface
	 */

    @Override
    public void add(context, IDPJob dataObj) {
        this.addOptions(context, this.performMapping());
    }

    /*
	 * This function implements performMapping method of IPluginBase interface
	 */

    public HashMap<String, String> performMapping() {

        HashMap<String, String> data = new HashMap<String, String>();
        data.put("expression", "(.)*(;MODULENAME;){1}(.)*")
        data.put("label", "MODULE_LIST")
        return data;
    }

    /*
	 * This function implements addOptions method of IPluginBase interface
	 */

    public void addOptions(context, HashMap<String, String> data) {
        context.with {
            conditionalBuilder {
                ConditionalBuilder.addrunCondition(delegate, data);
                ConditionalBuilder.addrunner(delegate);
            }
        }
    }

    /*
     * This function is used to add the regex condition based on which the build should run
     */

    private static void addrunCondition(context, data) {
        context.with {
            runCondition {
                ConditionalBuilder.addexpressionCondition(delegate, data);
            }


        }
    }

    /*
     * This function adds the expression in jenkins job
     */

    private static void addexpressionCondition(context, data) {
        context.with {
            expressionCondition {
                if (data.containsKey("expression")) expression(data.get("expression"));
                if (data.containsKey("label")) label(data.get("label"));
            }
        }
    }

    /*
     * This method implements the addruneer method for the builder
     */
    private static void addrunner(context) {
        context.with {
            runner {

            }
        }
    }
}


