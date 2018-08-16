package com.tester.psytester

import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

class TestingActivity : ActivityWithTimer() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            button("a"){
                onClick {
                    if(!sleep)
                    {
                        toast((middleTime/1000.0).toString())
                        timerClick()
                    }
                }
            }

        }
        //setContentView(R.layout.activity_testing)
    }
}
