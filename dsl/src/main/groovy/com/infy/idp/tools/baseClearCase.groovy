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
 * This class has the method to clear base folder
 *
 */
class baseClearCase {

    /*
     * This method can be used to add base clear case option in jenkins
     */

    public static void addbaseClearCase(context, HashMap<String, String> data) {
        context.with {
            baseClearCase {
                BaseClearCase.addGeneralsettings(delegate, data)
                mkviewOptionalParameter('')
            }
        }
    }
    /*
     * This method is used to add general settings for baseclear case
     */

    private static void addGeneralsettings(context, data) {
        context.with {
            if (data.containsKey("loadRules")) loadRules(data.get("loadRules"));
            if (data.containsKey("viewName")) viewName(data.get("viewName"));
            if (data.containsKey("viewPath")) viewPath(data.get("viewPath"));
            if (data.containsKey("configSpec")) configSpec(data.get("configSpec"));
        }
    }
}



