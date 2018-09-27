/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.plugins.buildsteps

import com.infy.idp.interfaces.IPluginBase
import org.infy.idp.entities.jobs.IDPJob

/**
 *
 * This class implements IPLuginBase interface to configure job for nexus artifact upload ans download
 *
 */

class ArtifactResolver implements IPluginBase {
    /*
     * This function implements add method of IPluginBase interface
     */

    @Override
    public void add(context, IDPJob dataObj) {
        this.addOptions(context, this.performMapping(dataObj))
    }

    /*
     * This function implements performMapping method of IPluginBase interface
     */

    @Override
    public HashMap<String, String> performMapping(IDPJob dataObj) {

        HashMap<String, String> data = new HashMap<String, String>()

        data.put('enableRepoLogging', 'false')
        data.put('failOnError', 'true')
        data.put('releaseUpdatePolicy', 'never')
        data.put('snapshotUpdatePolicy', 'never')
        data.put('targetDirectory', 'toBeUnZipped')
        data.put('artifactId', dataObj.basicInfo.applicationName + '_' + dataObj.basicInfo.pipelineName)
        data.put('classifier', '')
        data.put('extension', 'zip')
        data.put('groupId', dataObj.basicInfo.applicationName + '.$ARTIFACT_ID')
        data.put('targetFileName', dataObj.basicInfo.applicationName + '_' + dataObj.basicInfo.pipelineName + '.zip')
        data.put('version', '$ARTIFACT_VERSION')

        return data
    }

    /*
     * This function implements addOptions method of IPluginBase interface
     */

    @Override
    public void addOptions(context, HashMap<String, String> data) {

        context.with {

            resolveArtifacts {

                ArtifactResolver.addArtifacts(delegate, data)
            }
        }
    }

    /*
     * This function configures the job for artiface upload and download on artifact repository manager tools.
     * This tools can be Nexus, Artifactory, etc
     */

    private static void addArtifacts(context, data) {

        context.with {

            if (data.containsKey('enableRepoLogging')) enableRepoLogging(data.get('enableRepoLogging').toBoolean())
            if (data.containsKey('failOnError')) failOnError(data.get('failOnError').toBoolean())
            if (data.containsKey('releaseUpdatePolicy')) releaseUpdatePolicy(data.get('releaseUpdatePolicy'))
            if (data.containsKey('snapshotUpdatePolicy')) snapshotUpdatePolicy(data.get('snapshotUpdatePolicy'))
            if (data.containsKey('targetDirectory')) targetDirectory(data.get('targetDirectory'))

            artifact {
                if (data.containsKey('artifactId')) artifactId(data.get('artifactId'))
                if (data.containsKey('classifier')) classifier(data.get('classifier'))
                if (data.containsKey('extension')) extension(data.get('extension'))
                if (data.containsKey('groupId')) groupId(data.get('groupId'))
                if (data.containsKey('targetFileName')) targetFileName(data.get('targetFileName'))
                if (data.containsKey('version')) version(data.get('version'))
            }
        }
    }
}
