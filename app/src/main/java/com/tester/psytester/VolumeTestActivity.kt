package com.tester.psytester

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.math.BigDecimal

class VolumeTestActivity : Test() {

    private lateinit var mp: MediaPlayer
    override fun afterSleepAct() {
        super.afterSleepAct()
        mp.start()
    }
    override fun toString(): String {
        return "Реакция на звук"
    }
    override fun finish() {
        super.finish()
        mp.stop()
    }

    override fun showResult():String {
        val mid=(middleTime/1000.0-0.20).round()
        val countOfMistakes=data.countOfMistakes
        Worker.controles.add(Control(this.toString(),mid.toString(),countOfMistakes.toString()))
        return "Среднее время: $mid\nКоличество ошибок:$countOfMistakes"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mp = MediaPlayer.create (this, R.raw.test)
        mp.isLooping=true
        relativeLayout {


                onClick {
                    if(isCreate)
                        mp.pause()

                    click()
                }

        }
    }
}
