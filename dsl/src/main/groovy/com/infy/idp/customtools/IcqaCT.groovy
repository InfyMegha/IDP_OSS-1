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
 * This class includes the method for adding IcqaCT customtool
 *
 */

class IcqaCT {

	/*
     * This function is used to add the commands to run IcqaCT
     */

	public static void invokeTool(context, moduleName) {
		String pmdReportDir = '%IDP_WS%/' + moduleName + PropReader.readProperty(Constants.REPORTNAMESFN,Constants.PMDREPORTNAME)

		StringBuilder sb = new StringBuilder()
		sb.append('%IDP_WS%/../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.PMDCTNM) + '/bin/pmd -shortnames -l java')
		sb.append('%IDP_WS%/../../tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/PMD5_0_4/InfosysCodeQualityAnalyserJava5.0.0/pmd5.4.0/bin/pmd -l java')
		sb.append('-R ' + Constants.ICQARULES + ' ')
		sb.append('-f ' + Constants.ICQAREPORTFORMAT + ' ')
		sb.append('-r ' + pmdReportDir + '/PMD_Report.html ')
		sb.append('-d %IDP_WS%/' + moduleName +  '/src')
		
		ConditionalXShell.invokeConditionalXShell(context, sb.toString())
	}
}
