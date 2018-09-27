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
 * This class has the method to delete dirrectory
 *
 */
class DeleteDir {

    /*
     * This method prepares the command to delete a directory
     */

    public static void run(context, os, dir) {

        def cmd

        if (os == Constants.WINDOWSOS) {
            cmd = 'rd /s /q ' + dir
        } else {
            cmd = 'rm -rf ' + dir
        }

        ExecuteCmd.invokeCmd(context, cmd, os)
    }
}
