/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package com.infy.idp.customtools

import com.infy.idp.creators.*
import com.infy.idp.utils.*
import com.infy.idp.utils.fs.*

/**
 *
 * This class includes the method for adding InReleaseDepJar customtool
 *
 */

class MavenPomEditorCT {

	/*
	* This function is used to add the commands to run MavenPomEditorCT
	*/

	public static void invokeTool(context, moduleName, os) {
		
		StringBuilder sb = new StringBuilder();
		String moduleDirPath;
		String instrumentDir;
		
		if (os.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
			moduleDirPath= '%IDP_WS%/' + moduleName
			instrumentDir = moduleDirPath + '/Cobertura_Instr'
			sb.append('%IDP_WS%/../../tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/Cobertura/cobertura-2.1.1/cobertura-instrument.bat ')
		}
		else{
			moduleDirPath= '$IDP_WS/' + moduleName
			instrumentDir = moduleDirPath + '/Cobertura_Instr'
			sb.append('$IDP_WS/../../tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/Cobertura/cobertura-2.1.1/cobertura-instrument.sh ')
		}
		
		sb.append('--basedir ' + moduleDirPath + '/src/bin ')
		sb.append('--destination ' + instrumentDir + ' ')
		sb.append('--ignore org.apache.log4j.* ')
		ExecuteCmd.invokeCmd(context, sb.toString(), os)
	}
}
