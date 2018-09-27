/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package com.infy.idp.tools


import org.infy.idp.entities.jobs.IDPJob;
import com.infy.idp.creators.*
import com.infy.idp.interfaces.IPluginBase;
import com.infy.idp.utils.*


class IdpManaPlugin implements IPluginBase {

	public void add(Object context, IDPJob idpJobObj) {
		this.addOptions(context, this.performMapping(idpJobObj));
	}

	public HashMap<String, String> performMapping(IDPJob idpJobObj) {

		HashMap<String, String> data = new HashMap<String, String>();

		data.put('appName', idpJobObj.basicInfo.applicationName)
		data.put('env', 'DEV')
		data.put('fetchJarLoc', '$IDP_WS/../../tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/IdpReportsFetchUtility.jar')
		data.put('convertJarLoc', '$IDP_WS/../../tools/com.cloudbees.jenkins.plugins.customtools.CustomTool/IdpManaJsonConversion.jar')
		data.put('projWsLoc', '$IDP_WS')
		data.put('prefixAppNameFlag', 'N')
		data.put('jenDtls', 'blrkec401189d:8080, salman:password')
		// data.put('projLoc', '')
		data.put('reportNames', 'pqm_report.pmd.txt')
		data.put('sonarDtls', 'chdsez400283d:9000, ' + idpJobObj.basicInfo.applicationName)
		// data.put('tfsPath', )

		return data;
	}

	public void addOptions(context, HashMap<String,String> data) {

		context.with {

			configure {

				def pubs = it / publishers

				pubs << 'com.infosys.idpmanaintegration.IdpManaIntegration' (plugin:"idp-mana-integration@2.3.0")  {

					kvPairs {
						
						if(data.containsKey('appName')) addKV(delegate, 'appName', data.get('appName'))
						if(data.containsKey('env')) addKV(delegate, 'env', data.get('env'))
						if(data.containsKey('fetchJarLoc')) addKV(delegate, 'fetchJarLoc', data.get('fetchJarLoc'))
						if(data.containsKey('convertJarLoc')) addKV(delegate, 'convertJarLoc', data.get('convertJarLoc'))
						if(data.containsKey('projWsLoc')) addKV(delegate, 'projWsLoc', data.get('projWsLoc'))
						if(data.containsKey('prefixAppNameFlag')) addKV(delegate, 'prefixAppNameFlag', data.get('prefixAppNameFlag'))
						if(data.containsKey('jenDtls')) addKV(delegate, 'jenDtls', data.get('jenDtls'))
						if(data.containsKey('projLoc')) addKV(delegate, 'projLoc', data.get('projLoc'))
						if(data.containsKey('reportNames')) addKV(delegate, 'reportNames', data.get('reportNames'))
						if(data.containsKey('sonarDtls')) addKV(delegate, 'sonarDtls', data.get('sonarDtls'))
						if(data.containsKey('tfsPath')) addKV(delegate, 'tfsPath', data.get('tfsPath'))
					}
				}
			}
		}
	}

	public void addKV(context, k, v) {

		context.with {

			'com.infosys.idpmanaintegration.PropertyBean' {
				key(k)
				val(v)
			}
		}
	}
}
