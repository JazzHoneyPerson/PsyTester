package com.tester.psytester

import android.os.Handler

open class RandomSleeping:Warning(){
    val maxTimeToSleep=1
    val minTimeToSleep=1

    var sleep=true
    open fun afterSleepAct() {
        sleep=false
    }
    fun sleep(value:Int)
    {
        sleep=true
        Handler().postDelayed({ afterSleepAct()} ,(value*1000).toLong())
    }

    fun sleepRandom(){
        val randValue=Randomizer().randInt(minTimeToSleep,maxTimeToSleep)

        sleep(randValue)
    }

}