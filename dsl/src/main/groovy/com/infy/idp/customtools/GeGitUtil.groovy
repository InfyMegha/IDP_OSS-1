/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package com.infy.idp.customtools

import com.infy.idp.utils.Constants
import com.infy.idp.utils.PropReader
import com.infy.idp.utils.ExecuteCmd

/**
 *
 * This class includes the method for adding GitUtil customtool
 *
 */

class GeGitUtil {


	/*
     * This function is used to add the commands to run GitUtil
     */

	public static void invokeTool(context, jsonData) {

		String idpWS = (jsonData.basicInfo.buildServerOS == Constants.WINDOWSOS) ? '%IDP_WS%/' : '$IDP_WS/'
		String pipelineBuildId = (jsonData.basicInfo.buildServerOS == Constants.WINDOWSOS) ? '%PIPELINE_BUILD_ID%' : '$PIPELINE_BUILD_ID'
		String utilJarPath = idpWS + '../..' + PropReader.readProperty(Constants.CUSTOMTOOLFN,Constants.CUSTOMTOOLPATH) + PropReader.readProperty(Constants.CUSTOMTOOLFN,'GEGITJAR')
		def basepath = jsonData.basicInfo.applicationName  + '_' + jsonData.basicInfo.pipelineName
		
		def listOfRepos = getRepoList(jsonData.code.scm, idpWS)		
		if (listOfRepos == '')
			return
		
		StringBuilder sb = new StringBuilder()
		sb.append('java -jar "')
		sb.append(utilJarPath)
		sb.append('" "' + listOfRepos + '" "')
		sb.append(basepath + '" ')
		sb.append(pipelineBuildId)

		ExecuteCmd.invokeCmd(context, sb.toString(), jsonData.basicInfo.buildServerOS)
	}

		
	private static String getRepoList(scmArr, idpWS) {
		
		def repoListStr = ''
		
		for(scmObj in scmArr) {
			
			if(scmObj.type != Constants.GITSCM)
				continue
				
			repoListStr += (idpWS + getRepoFromUrl(scmObj.url) + ',')
		}
		
		// remove last comma
		if(repoListStr.endsWith(','))
			repoListStr = repoListStr.substring(0, repoListStr.length()-1)
		
		return repoListStr
	}
	
	
	private static String getRepoFromUrl(gitUrl) {
		
		if(!gitUrl.endsWith(".git"))
			return ''
				
		if(gitUrl.toString().lastIndexOf('/') != -1)
			gitUrl = gitUrl.substring(gitUrl.lastIndexOf('/') + 1)
		
		return gitUrl.substring(0,gitUrl.lastIndexOf(".git"))		
	}
}
