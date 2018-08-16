package com.tester.psytester

import android.os.Bundle
import java.util.*

open class ActivityWithTimer:RandomSleeping() {
    var lastTime:Long=0
    var middleTime:Long=0
    var countOfTests=5

    override fun afterWarningAct() {
        super.afterWarningAct()
        sleepRandom()
    }

    override fun afterSleepAct() {
        super.afterSleepAct()
        lastTime=Date().time
    }
    fun fixTime():Long {
        val currentTime=Date().time
        val diff=currentTime-lastTime
        return diff
    }
    fun timerClick(){
        middleTime+=fixTime()/countOfTests
        sleepRandom()
    }
}