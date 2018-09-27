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

/**
*
* This class includes the method for adding CheckStyle customtool
*
*/

class CheckStyle {

	/*
	 * This function is used to add the command in order to invoke the checkstyle at run time
	 */

	public static void invokeCheckStyle(context, relativePath, os) {
		
		relativePath = relativePath.replace('\\', '/')
		
		def moduleDir 
		if(relativePath.contains('/')){
			moduleDir = relativePath.substring(0, relativePath.lastIndexOf('/'))
		}
		else{
			moduleDir = relativePath
		}
					
		String csReportDir;		
		StringBuilder sb = new StringBuilder();
		if (os.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
			csReportDir = '%IDP_WS%/' + moduleDir + '/CheckStyleReports'
			sb.append('java -jar "%IDP_WS%/../../tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/CheckStyle/checkstyle-6.17/checkstyle-6.17-all.jar" ')
			sb.append('-c "%IDP_WS%/../../tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/CheckStyle/checkstyle-6.17/' + Constants.CSCONFIGFN + '" ')
			sb.append('-f "' + Constants.CSREPORTFORMAT + '" ')
			sb.append('-o "' + csReportDir + '/checkstyle_report.xml" ')
			sb.append('"%IDP_WS%/' + moduleDir + '" || exit 0')
		}
		else{
			csReportDir = '$IDP_WS/' + moduleDir + '/CheckStyleReports'
			sb.append('java -jar "$IDP_WS/../../tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/CheckStyle/checkstyle-6.17/checkstyle-6.17-all.jar" ')
			sb.append('-c "$IDP_WS/../../tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/CheckStyle/checkstyle-6.17/' + Constants.CSCONFIGFN + '" ')
			sb.append('-f "' + Constants.CSREPORTFORMAT + '" ')
			sb.append('-o "' + csReportDir + '/checkstyle_report.xml" ')
			sb.append('"$IDP_WS/' + moduleDir + '" || exit 0')
		}
		
		ExecuteCmd.invokeCmd(context, 'mkdir "' + csReportDir + '" || exit 0', os)
		ExecuteCmd.invokeCmd(context, sb.toString(), os)
	}
}
