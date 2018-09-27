package com.tester.psytester

import java.util.*

class Timer {
    var lastTime:Long=0
    var currentTime:Long=0
    fun start(){
        lastTime= Date().time
    }
    fun stop(){
        currentTime=Date().time-lastTime
    }
    fun reset(){
        lastTime=0
    }
}