/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.utils

/**
 *
 * This class has the method for prebuild adders
 *
 */

class PreBuildersAdder {

    static void addPreBuilders(context) {
        context.with {
            preBuildSteps {
                PreBuildersAdder.addAnt(delegate)
            }
        }
    }


    private static void addAnt(context) {
        context.with {
            ant {
                antInstallation('IDP_ANT')
                buildFile('${IDP_WS}/build.xml')
                targets(['TG_MAVEN_POM_EDITOR'])
            }
        }
    }
}
