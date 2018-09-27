package com.tester.psytester

import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton

data class DataOfTest(var countOfMistakes:Int,var isCorrectItem:Boolean=false)
open class Test:ActivityWithTimer() {


    var data=DataOfTest(0)
    var count=0


    open fun showResult():String {
        val mid=middleTime/1000.0-0.25
        val countOfMistakes=data.countOfMistakes*100/(countOfTests)
        Worker.controles.add(Control(this.toString(),mid.toString(),countOfMistakes.toString()))
        return "Среднее время: $mid\nПроцент ошибок:$countOfMistakes%"
    }

    override fun onBackPressed() {

    }
    override fun finish() {
        isCreate=false
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