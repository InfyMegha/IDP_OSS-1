/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package com.infy.idp.customtools

import com.infy.idp.utils.*

/**
*
* This class includes the method for adding FindBugs customtool
*
*/

class FindBugs{

	/*
	* This function is used to add the commands to run FindBugs
	*/

	public static void invokeTool(context, relativePath, os) {
		
		relativePath = relativePath.replace('\\', '/')
		def moduleDir 
		if(relativePath.contains('/')){
			moduleDir = relativePath.substring(0, relativePath.lastIndexOf('/'))
		}
		else{
			moduleDir = relativePath
		}
		
		def ctLoc;
		def command;
		if (os.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
			ctLoc = '%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.FBCTNM)
			ExecuteCmd.invokeCmd(context, 'mkdir "%IDP_WS%/' + moduleDir + '/FindBugsReports" || exit 0', os)
		}
		else{
			ctLoc = '$IDP_WS/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.FBCTNM)
			ExecuteCmd.invokeCmd(context, 'mkdir "$IDP_WS/' + moduleDir + '/FindBugsReports" || exit 0', os)
		}
		command = """${ctLoc}/bin/findbugs.bat -textui -xml -outputFile ${moduleDir}/FindBugsReports/report.xml ${moduleDir}/bin"""
		ExecuteCmd.invokeCmd(context, command, os)
	}
}
