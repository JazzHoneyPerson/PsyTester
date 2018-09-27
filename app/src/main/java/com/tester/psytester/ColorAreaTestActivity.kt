package com.tester.psytester

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.view.Gravity
import android.view.View
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.logging.Handler

class ColorAreaTestActivity :Test() {
    override fun toString(): String {
        return "Реакция на цвет в области экрана"
    }
    var imageView: ImageView?=null
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun afterSleepAct() {
        super.afterSleepAct()
        imageView!!.setImageDrawable(RandomPoint(imageView!!.maxWidth,imageView!!.maxHeight,Color.RED))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_area_test)
        imageView=findViewById(R.id.image)
    }


    fun onButton(v: View){
        if(isCreate){
            imageView!!.setImageDrawable(null)
            click()

        }
    }

}
