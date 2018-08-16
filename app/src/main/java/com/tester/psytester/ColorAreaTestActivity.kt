package com.tester.psytester

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.Gravity
import android.widget.GridView
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.logging.Handler

class ColorAreaTestActivity :Test() {

     var gv: GridView? = null

    override fun afterSleepAct() {
        super.afterSleepAct()
        val child = gv!!.getChildAt(Randomizer().randInt(0, gv!!.childCount - 1))
        child.setBackgroundColor(Color.RED)

    }
    fun setOnClickGridView(){
        for(i in 0..gv!!.childCount-1) {
            val child = gv!!.getChildAt(i)
            child.setOnClickListener {
                val back = child.backgroundDrawable as ColorDrawable
                if (back.color == Color.RED) {
                    child.setBackgroundColor(Color.WHITE)
                    click()
                } else
                    data!!.countOfMistakes++
            }
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            gv=gridView{
                columnWidth=dip(30)
                horizontalSpacing=dip(0)
                verticalSpacing=dip(0)
                numColumns=-1
                adapter=Adapter(this@ColorAreaTestActivity,140,data)

            }.lparams{topMargin = dip(0);bottomMargin = dip(0)}
            android.os.Handler().postDelayed({ setOnClickGridView()} ,(minTimeToSleep*1000).toLong())
       }




    }

}
