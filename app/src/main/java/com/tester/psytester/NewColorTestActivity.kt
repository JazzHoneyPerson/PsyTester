package com.tester.psytester

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class NewColorTestActivity : AppCompatActivity() {

    val minTime=1
    val maxTime=3
    val countOfTest=4
    var count=0
    val ok=false
    var tester=Tester()
    var lay: LinearLayout? =null
    var currentColor=Color.WHITE
    override fun onBackPressed() {

    }
    override fun toString(): String {
        return "Реакция на цвет"
    }
    fun randTime()=(Randomizer().randInt(minTime,maxTime)*1000).toLong()
    fun writeResult():String{
        var middleTimeString="Средннее время:"+((tester.time/(countOfTest+1)*1000).toInt()/1000.0-0.25)
        var percentOfMistakes="Количество ошибок:"+tester.mistakes
        Worker.controles.add(Control(this.toString(),
                ((tester.time/(countOfTest+1)*1000).toInt()/1000.0-0.25).toString(),
                tester.mistakes.toString()))
        return middleTimeString+"\n"+percentOfMistakes
    }
    override fun finish() {
        alert(writeResult()){
            okButton {
                super.finish()
            }
        }.show()
    }
    fun putRedBackground(){

        currentColor=Color.RED

        lay!!.setBackgroundColor(Color.RED)
        tester.startTimer()
    }

    fun studentClick(){
        if(currentColor==Color.WHITE) {
            tester.addMistake()
        } else  {
            tester.stopTimer()
            lay!!.setBackgroundColor(Color.WHITE)
            currentColor=Color.WHITE
            if(count>=countOfTest) {
                finish()
            }
            else {
                count++
                Freezer().waitFor(Runnable { putRedBackground() }, randTime())
            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lay=verticalLayout {
            setBackgroundColor(currentColor)
            onClick{
                studentClick()
            }
        }
        alert(R.string.dialog_message){
            okButton {
                Freezer().waitFor(Runnable{putRedBackground()},randTime())
            }
        }.show()
    }
}
