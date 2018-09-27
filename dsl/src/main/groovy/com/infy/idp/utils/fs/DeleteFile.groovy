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
 * This class has the method to delete file
 *
 */
class DeleteFile {

    /*
     * This method prepares the command to delete a file
     */

    public static void run(context, os, file) {

        def cmd

        if (os == Constants.WINDOWSOS) {
            cmd = 'del ' + file
        } else {
            cmd = 'rm -f ' + file
        }

        ExecuteCmd.invokeCmd(context, cmd, os)
    }
}
