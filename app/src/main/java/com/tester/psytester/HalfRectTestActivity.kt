package com.tester.psytester

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.widget.GridView
import org.jetbrains.anko.gridView
import org.jetbrains.anko.verticalLayout

class HalfRectTestActivity : Activity() {

    var gv: GridView? = null
    var countOfHalfs=2
    fun getContextAdapater():ContextAdapter{
        val height=getWindowManager().getDefaultDisplay().getHeight()
        val width=getWindowManager().getDefaultDisplay().getWidth()
        return ContextAdapter(this,countOfHalfs,height,width/2)
    }

    fun toSwitch(iteration:Int){
        if(iteration%2==0) {
            gv!!.getChildAt(0).setBackgroundColor(Color.RED)
            gv!!.getChildAt(1).setBackgroundColor(Color.WHITE)
        } else{
            gv!!.getChildAt(1).setBackgroundColor(Color.RED)
            gv!!.getChildAt(0).setBackgroundColor(Color.WHITE)
        }
        Freezer().waitFor(Runnable { toSwitch(iteration+1)},1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            gv=gridView {
                numColumns=countOfHalfs
                adapter=getContextAdapater()
            }
        }
        Freezer().waitFor(Runnable{toSwitch(0)},100)

    }
}
