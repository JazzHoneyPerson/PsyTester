package com.tester.psytester

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.verticalLayout

 class ColorTestActivity : Test() {
     lateinit var lay: LinearLayout
    override fun afterSleepAct() {
        super.afterSleepAct()
        lay.setBackgroundColor(Color.RED)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lay=verticalLayout {

            setBackgroundColor(Color.WHITE)
            onClick {
                setBackgroundColor(Color.WHITE)
                click()
            }
        }


    }
}
