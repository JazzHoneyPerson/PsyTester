package com.tester.psytester

class Tester {
    var mistakes=0
    var timer=Timer()
    var time=0.0
                

    var count=0
    private fun addTime(){
        time+=timer.currentTime/1000.0
    }
    fun startTimer(){
        timer.start()
    }
    fun stopTimer(){
        timer.stop()
        addTime()
        count++
    }

    fun addMistake(){
        mistakes++
    }



}