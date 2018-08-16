package com.tester.psytester

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.verticalLayout

class VolumeTestActivity : Test() {

    private lateinit var mp: MediaPlayer
    override fun afterSleepAct() {
        super.afterSleepAct()
        mp.start()
    }

    override fun finish() {
        super.finish()
        mp.stop()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mp = MediaPlayer.create (this, R.raw.test)
        mp.isLooping=true
        verticalLayout {
            button ("Button"){
                onClick {
                    mp.pause()
                    click()
                }

            }
        }
    }
}
