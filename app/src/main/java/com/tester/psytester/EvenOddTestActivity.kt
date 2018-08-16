package com.tester.psytester

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import org.jetbrains.anko.*

class EvenOddTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(32)
            textView ("aa").lparams{
                gravity = Gravity.CENTER
                margin = dip(16)
            }
        }
    }
}
