package com.tester.psytester

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {
    private val customStyle = { v: Any ->
        when (v) {
            is Button -> v.textSize = 26f
            is EditText -> v.textSize = 24f
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            var a=alert{
                titleResource=R.string.dialog_title
            }


            editText {
                hintResource = R.string.FIO
            }
            button("Реакция на цвет"){
                onClick {
                    goToTest(a,ColorTestActivity::class.java,R.string.color_activity_notation)
                }
            }
            button("Реакция на звук"){
                onClick {
                    goToTest(a,VolumeTestActivity::class.java,R.string.volume_activity_notation)
                }
            }
            button("Слови красный квадрат"){
                onClick {
                    goToTest(a,ColorAreaTestActivity::class.java,R.string.dialog_message)
                }
            }
            button("тестирование"){
                onClick {
                    goToTest(a,EvenOddTestActivity::class.java,R.string.dialog_message)
                }
            }



        }.applyRecursively(customStyle)
    }
    fun goToTest(a:AlertBuilder<DialogInterface>,test:Class<*>, messageResource:Int) {
        a.messageResource = messageResource
        a.okButton {
            val intent = Intent(this, test)
            startActivity(intent)
        }
        a.show()
    }

}

