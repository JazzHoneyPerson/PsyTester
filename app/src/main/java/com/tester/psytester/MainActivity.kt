package com.tester.psytester

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.tester.psytester.Worker.Companion.refresh
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {
    var editText:EditText?=null
    private val customStyle = { v: Any ->
        when (v) {
            is Button -> v.textSize = 26f
            is EditText -> v.textSize = 24f
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        verticalLayout {
            var a=alert{
                titleResource=R.string.dialog_title

            }


            editText=editText {
                hintResource = R.string.FIO

            }

            button("Реакция на цвет"){
                onClick {

                    goToTest(a,NewColorTestActivity::class.java,R.string.color_activity_notation)

                }
            }
            button("Реакция на звук"){
                onClick {
                    goToTest(a,VolumeTestActivity::class.java,R.string.volume_activity_notation)
                }
            }
            button("Реакция на цвет в области экрана"){
                onClick {
                    goToTest(a,ColorAreaTestActivity::class.java,R.string.color_area_activity_notation)
                }
            }
            button("Распознавание четных чисел"){
                onClick {
                    goToTest(a,EvenOddTestActivity::class.java,R.string.even_odd_notation)
                }
            }
            button("Распознавание цвета"){
                onClick {
                    goToTest(a,ColorRecognitionTestActivity::class.java,R.string.color_area_recognition_activity_notation)
                }
            }
            button("Сосредоточенность внимания") {
                onClick {
                    goToTest(a, FocusTestActivity::class.java, R.string.focus_test_notation)
                }
            }
            button("Сохранить результаты"){
                onClick {
                    ApachePOIExcelWrite.main()
                    Worker.refresh()
                    toast("Сохранено")
                }
            }
            button("Сбросить результаты"){
                onClick {
                    Worker.refresh()
                    toast("Результаты удалены")
                }
            }

        }

    }
    fun goToTest(a:AlertBuilder<DialogInterface>,test:Class<*>, messageResource:Int) {
        a.messageResource = messageResource
        Worker.name=editText!!.text.toString()

        a.okButton {
            val intent = Intent(this, test)
            startActivity(intent)
        }
        a.show()
    }

}

