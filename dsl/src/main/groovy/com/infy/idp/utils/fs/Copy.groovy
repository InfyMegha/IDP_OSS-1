/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.utils.fs

import com.infy.idp.utils.*

/**
 *
 * This class has the method to add copy commands
 *
 */

class Copy {
    /*
     * This method can be used to prepare commands for copy
     */

    public static void run(context, os, loc) {

        def cmd

        if (os == Constants.WINDOWSOS) {
            cmd = 'copy ' + loc
        } else {
            cmd = 'cp ' + loc
        }

        ExecuteCmd.invokeCmd(context, cmd, os)
    }
}
