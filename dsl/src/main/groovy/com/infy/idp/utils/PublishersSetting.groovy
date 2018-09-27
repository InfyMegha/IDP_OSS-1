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
 * This class has the method to add publisher settings
 *
 */

class PublishersSetting {

    /*
     * This method is used to add specific publishers
     */

    static void addPublishers(context, jobType) {
        context.with {
            publishers {
                if (jobType == "maven_scm") {
                    PublishersSetting.addDiscardBuildPublisher(delegate)
                } else if (jobType == "maven_build") {
                    PublishersSetting.addPmdReporter(delegate)
                }
            }
        }
    }

    /*
     * this method is used to add discard build publishers
     */

    private static void addDiscardBuildPublisher(context) {
        context.with {
            discardBuildPublisher {
                daysToKeep('30')
                intervalDaysToKeep('30')
                numToKeep('30')
                intervalNumToKeep('30')
                discardSuccess(false)
                discardUnstable(false)
                discardFailure(false)
                discardNotBuilt(false)
                discardAborted(false)
                minLogFileSize('-1')
                maxLogFileSize('-1')
                regexp('')
            }
        }
    }

    /*
     * this method is used to add pmd reporter publisher
     */

    private static void addPmdReporter(context) {
        context.with {
            pmdPublisher {
                canComputeNew(false)
                canRunOnFailed(false)
                failedTotalAll('')
                failedTotalHigh('')
                failedTotalLow('')
                failedTotalNormal('')
                healthy('')
                thresholdLimit('low')
                unHealthy('')
                unstableTotalAll('')
                unstableTotalHigh('')
                unstableTotalLow('')
                unstableTotalNormal('')
                useDeltaValues(false)
                useStableBuildAsReference(false)
            }
        }
    }
}
