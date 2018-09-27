/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/

package com.infy.idp.plugins.buildsteps


import org.infy.idp.entities.jobs.IDPJob
import com.infy.idp.interfaces.IPluginBase;

/**
 *
 * This class implements IPLuginBase interface to configure ClangScanBuild in build job
 *
 */

class ClangScanBuild implements IPluginBase{

    /*
	 * This function implements add method of IPluginBase interface
	 */

  @Override
  public void add(context, IDPJob dataObj) {
    this.addOptions(context, this.performMapping(dataObj));
  }

    /*
	 * This function implements performMapping method of IPluginBase interface
	 */

  @Override
  public HashMap<String, String> performMapping(IDPJob dataObj) {
    HashMap<String, String> data = new HashMap<String, String>();
    data.put("clangInstallationName","\$IOSCODEANALYSISTARGET")
    data.put("configuration","Debug")
    data.put("scanBuildArgs","")
    data.put("scheme","\$SCHEME")
    data.put("targetSdk","iphonesimulator")
    data.put("workspace","\$WORKSPACE")
    data.put("xcodeBuildArgs","")
    return data;
  }

    /*
	 * This function implements addOptions method of IPluginBase interface
	 */

  @Override
  public void addOptions(context, HashMap<String, String> data) {
    context.with{
      clangScanBuild  {
        ClangScanBuild.addClangScanBuild(delegate, data);
      }
    }
  }

    /*
	 * This function configures the job for adding ClangScanBuild
	 */

  private static void addClangScanBuild(context,data){
    context.with{
      if(data.containsKey("clangInstallationName")) clangInstallationName(data.get("clangInstallationName"));
      if(data.containsKey("configuration")) configuration(data.get("configuration"));
      if(data.containsKey("scanBuildArgs")) scanBuildArgs(data.get("scanBuildArgs"));
      if(data.containsKey("scheme")) scheme(data.get("scheme"));
      if(data.containsKey("targetSdk")) targetSdk(data.get("targetSdk"));
      if(data.containsKey("workspace")) workspace(data.get("workspace"));
      if(data.containsKey("xcodeBuildArgs")) xcodeBuildArgs(data.get("xcodeBuildArgs"));
    }
  }
}
