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
* This class includes the method for adding Cobertura customtool
*
*/

class CoberturaCT {

	/*
	 * This function is used to add the commands to invoke cobertura.
	 * Cobertura is the tool for code coverage
	 */

	public static void invokeCobertura(context, os, moduleName) {
		String moduleDirPath;
		if (os.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
			moduleDirPath = '%IDP_WS%/' + moduleName
		}
		else{
			moduleDirPath = '$IDP_WS/' + moduleName
		}
		String instrumentDir = moduleDirPath + '/Cobertura_Instr'
		String jUnitDir = moduleDirPath + '/Junit_Report'
		String cobCovXmlDir = moduleDirPath + '/Cobertura_XMLReports'
		String cobCovSummaryXmlDir = moduleDirPath + '/Cobertura_SummaryXMLReports'
		String cobCovHtmlDir = moduleDirPath + '/Cobertura_HTMLReports'
		
		// Init Cobertura
		DeleteFile.run(context, os, 'cobertura.ser')
		DeleteDir.run(context, os, instrumentDir)
		DeleteDir.run(context, os, jUnitDir)
		ExecuteCmd.invokeCmd(context, 'mkdir "' + instrumentDir + '" || exit 0', os)
		ExecuteCmd.invokeCmd(context, 'mkdir "' + jUnitDir + '" || exit 0', os)
		ExecuteCmd.invokeCmd(context, 'mkdir "' + cobCovXmlDir + '" || exit 0', os)
		ExecuteCmd.invokeCmd(context, 'mkdir "' + cobCovSummaryXmlDir + '" || exit 0', os)
		ExecuteCmd.invokeCmd(context, 'mkdir "' + cobCovHtmlDir + '" || exit 0', os)
		
		// Instrumentation
		StringBuilder sb = new StringBuilder()
		if (os.compareToIgnoreCase(Constants.WINDOWSOS) == 0) {
			sb.append('%IDP_WS%/../../tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/Cobertura/cobertura-2.1.1/cobertura-instrument.bat ')
		}
		else{
			sb.append('$IDP_WS/../../tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/Cobertura/cobertura-2.1.1/cobertura-instrument.sh ')
		}
		sb.append('--basedir ' + moduleDirPath + '/src/bin ')
		sb.append('--destination ' + instrumentDir + ' ')
		sb.append('--ignore org.apache.log4j.* ')
		ExecuteCmd.invokeCmd(context, sb.toString(), os)	
	}
}
