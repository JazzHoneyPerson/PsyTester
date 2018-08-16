package com.tester.psytester

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat.getColor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.tester.psytester.R.attr.background
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.backgroundDrawable
import org.jetbrains.anko.backgroundResource

class Adapter(context: Context, size:Int,dataOfTest: DataOfTest):BaseAdapter() {
    var context:Context?=null
    var size:Int=0
    var color:Int=0
    var test:Test?=null
    var dataOfTest:DataOfTest=DataOfTest(0)
    //var count:Int=0
    init{
        this.context=context
        this.size=size
        this.dataOfTest=dataOfTest
        this.test=Test()
    }

    override fun getCount(): Int {
        return size
    }
    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflator.inflate(R.layout.grid_view, null)


        view.setBackgroundColor(Color.WHITE)
        return view
    }
}