package com.tester.psytester

import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton

data class DataOfTest(var countOfMistakes:Int,var isCorrectItem:Boolean=false)
open class Test:ActivityWithTimer() {


    var data=DataOfTest(0)
    var count=0

    fun showResult():String {
        val mid=middleTime/1000.0
        val countOfMistakes=data.countOfMistakes
        return "Среднее время: $mid\nКоличество ошибок:$countOfMistakes"
    }

    override fun finish() {
        alert(showResult()){okButton {super.finish()}}.show()
    }

    open fun isCorrect():Boolean {
        return !sleep
    }

    fun click() {
        if(isCorrect()) {
            if (count == countOfTests)
                finish()
            else {
                //continiue()
                count++
                timerClick()
            }
        }
        else
            data.countOfMistakes++
    }

}