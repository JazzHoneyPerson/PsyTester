package com.tester.psytester

import android.os.Handler

open class RandomSleeping:Warning(){
    open val maxTimeToSleep=2
    open val minTimeToSleep=4

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