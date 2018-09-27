/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.utils

import com.infy.idp.creators.*

import static com.infy.idp.utils.Constants.*

/**
 *
 * This class has the method to add ConditionalXShell statement
 *
 */
class ConditionalXShell {

    /*
    * this method is used to invoke conditional XShell commands
    */

    public static void invokeConditionalXShell(context, cmd) {

        context.with {

            xShellBuilder {

                // Sets the shell command.
                commandLine(cmd)
                executeFromWorkingDir(false)
                regexToKill('')
                timeAllocated('')
            }
        }
    }
}
