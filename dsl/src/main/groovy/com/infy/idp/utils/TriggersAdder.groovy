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
 * This class has the method to add trigger steps
 *
 */

class TriggersAdder {

/*
 * this method can be used tp add trigger configurations
 */

    static void addTriggers(context, schedule, isPollSCM) {
        context.with {
            triggers {
                if (isPollSCM) {
                    TriggersAdder.addPollSCMTrigger(delegate, schedule)
                } else {
                    TriggersAdder.addCronTrigger(delegate, schedule)
                }
            }
        }
    }

    /*
     * this method can be used tp add Pool SCM trigger parameters
     */

    private static void addPollSCMTrigger(context, schedule) {
        context.with {
            pollSCM {
                scmpoll_spec(schedule)
                ignorePostCommitHooks(false)
            }
        }
    }

    private static void addCronTrigger(context, schedule) {
        context.with {
            cron {
                spec(schedule)
            }
        }
    }

}
