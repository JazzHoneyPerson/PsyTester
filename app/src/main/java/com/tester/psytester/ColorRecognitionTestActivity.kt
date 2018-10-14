package com.tester.psytester

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.R.attr.layout_constraintBottom_toBottomOf
import android.view.View
import android.widget.ImageView



class ColorRecognitionTestActivity : Test() {

    override fun toString(): String {
        return "Распознавание цвета"
    }
    var imageView:ImageView?=null
    var currentColor=0
    override val minTimeToSleep: Int=0
    override val maxTimeToSleep: Int=0
    override val countOfTests: Int=10

    fun randColor()= if(Randomizer().randInt(0,1)==0) Color.RED else Color.GREEN

    override fun showResult():String {
        val mid=(middleTime/1000.0-0.2).round()
        val countOfMistakes=data.countOfMistakes*100/(countOfTests+1)
        Worker.controles.add(Control(this.toString(),mid.toString(),countOfMistakes.toString()))
        return "Среднее время: $mid\nПроцент ошибок:$countOfMistakes%"
    }
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun afterSleepAct() {
        super.afterSleepAct()
        currentColor=randColor()
        imageView!!.setImageDrawable(RandomPoint(imageView!!.maxWidth,imageView!!.maxHeight,currentColor))

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_recognition_test)
        imageView=findViewById(R.id.image)
        //imageView!!.setImageResource(R.drawable.ic_launcher_background)
    }
    fun onRed(v: View) {
        if(isCreate) {
            if (currentColor != Color.RED)
                data.countOfMistakes++
            click()
        }

    }
    fun onGreen(v: View) {
        if(isCreate) {
            if (currentColor != Color.GREEN)
                data.countOfMistakes++
            click()
        }
    }

}
