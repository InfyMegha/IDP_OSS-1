/***********************************************************************************************
 *
 * Copyright 2018 Infosys Ltd.
 * Use of this source code is governed by MIT license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 ***********************************************************************************************/

package com.infy.idp.tools.testing

import com.infy.idp.plugins.buildsteps.MSBuild
import com.infy.idp.plugins.buildsteps.MSTestBuilder
import com.infy.idp.plugins.publishers.MSTestPublisher

/**
 *
 * This class has the method to add CodedUIFT testing tool
 *
 */
class CodedUIFT {

    /*
     * This method is used to add the steps to configure CodedUIFT
     */

    public static void addSteps(context, jsonData, envIndex, stepIndex) {
        def testStep = null;
        //IDP
        if (jsonData.testInfo.testEnv != null) {
            testStep = jsonData.testInfo.testEnv.getAt(envIndex).testSteps.getAt(stepIndex).test
        } else {
            //ICTP
            def processIndex = envIndex
            testStep = jsonData.testInfo.testProcess.getAt(processIndex).testSteps.getAt(stepIndex).test
        }
        MSBuild msBuild = new MSBuild()

        msBuild.setBuildFile(testStep.solName)
        msBuild.setMsBuildVersion(testStep.version)
        msBuild.setCmdArgs(testStep.args)

        msBuild.add(context, jsonData)

        MSTestBuilder msTestBuilder = new MSTestBuilder()

        def buildPrjctName = testStep.prjctName
        def testPrjctPath = buildPrjctName.lastIndexOf('/') == -1 ? '' : buildPrjctName.substring(0, buildPrjctName.lastIndexOf('/') + 1)
        def testPrjctName = buildPrjctName.lastIndexOf('/') == -1 ? buildPrjctName : buildPrjctName.substring(buildPrjctName.lastIndexOf('/') + 1)
        msTestBuilder.setTestFiles(testPrjctPath + 'bin/Debug/' + testPrjctName + '.dll')
        msTestBuilder.setTestOpFile(testPrjctPath + testPrjctName + '_CODEDUI_TestResult.trx')

        def testPrjctCatagory = testStep.unitTestCategory
        testPrjctCatagory = testPrjctCatagory == null ? '' : testPrjctCatagory
        msTestBuilder.setTestCat(testPrjctCatagory)

        def cmdArgs = testStep.testSettingFilePath
        cmdArgs = cmdArgs == null ? '' : cmdArgs
        msTestBuilder.setCmdArgs(cmdArgs)

        msTestBuilder.add(context, jsonData)
    }

    /*
     * This method is used to add required publishers
     */

    public static void addPublishers(context, jsonData, envIndex, stepIndex) {

        def testStep = null;
        //IDP
        if (jsonData.testInfo.testEnv != null) {
            testStep = jsonData.testInfo.testEnv.getAt(envIndex).testSteps.getAt(stepIndex).test
        } else {
            //ICTP
            def processIndex = envIndex
            testStep = jsonData.testInfo.testProcess.getAt(processIndex).testSteps.getAt(stepIndex).test
        }

        def buildPrjctName = testStep.prjctName
        def testPrjctPath = buildPrjctName.lastIndexOf('/') == -1 ? '' : buildPrjctName.substring(0, buildPrjctName.lastIndexOf('/') + 1)
        def testPrjctName = buildPrjctName.lastIndexOf('/') == -1 ? buildPrjctName : buildPrjctName.substring(buildPrjctName.lastIndexOf('/') + 1)

        MSTestPublisher msTestPublisher = new MSTestPublisher()
        msTestPublisher.setPattern('**/' + testPrjctPath + testPrjctName + '_CODEDUI_TestResult.trx')
        msTestPublisher.add(context, jsonData)
    }
}
