/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.testing

import com.infy.idp.plugins.buildsteps.*

/**
 *
 * This class has the method to add ItawCT testing tool
 *
 */

class ItawCT {

    /*
    * This method is used to add the steps to configure ItawCT
    */

    public static void addSteps(context) {
        context.with {


            String path = "\$env:IDP_TEST_WS"
            String cmd = "powershell.exe " + path + '/' + 'itawComponent.ps1'
            Powershell powershell = new Powershell()
            powershell.add(delegate, cmd)
        }


    }
}



