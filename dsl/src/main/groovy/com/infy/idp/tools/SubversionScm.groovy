/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools


import com.infy.idp.creators.*
import com.infy.idp.utils.*

/**
 *  This class has the method to add subversion SCM
 */
class SubversionScm {

    /*
     * This method can be used to add Subversion Git SCM
     */

    public static void addGitSCM(context, jsonData) {

        //Configurable Settings of Job
        addGitProperties(context, jsonData)

        addGitScmSection(context)

    }

    private static void addGitScmSection(context) {

        context.with { scm {} }
    }

    /*
     * this method can be used to add git properties
     */

    private static void addGitProperties(context, jsonData) {
        context.with {
            properties {
                PropertiesAdder.addGitLabConnection(delegate)
                PropertiesAdder.addRebuild(delegate)
                PropertiesAdder.addThrottleJobProperty(delegate)
            }
            configure {
                it / 'properties' / 'hudson.model.ParametersDefinitionProperty' / 'parameterDefinitions' {
                    PropertiesAdder.addStringParam(delegate, 'IDP_WS', 'NA', 'CUSTOM Workspace')
                    PropertiesAdder.addStringParam(delegate, 'SCM_BRANCH', jsonData.code.scm.getAt(0).gitDefaultBranch, 'This parameter describe the branch for SCM to be executed')
                    PropertiesAdder.addNodeParam(delegate, 'SLAVE_NODE', ['ldaproleapp_Jmvn1_14Mr1_Slave'], '')
                }
            }
        }
    }
}
