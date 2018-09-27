package com.tester.psytester

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.grid_item.view.*

class ContextAdapter(context: Context, countOfItems: Int, height:Int, width:Int): BaseAdapter() {
    var context: Context?=null
    var height:Int=0
    var width:Int=0
    var countOfItems=0
    init {
        this.context = context
        this.height=height
        this.width=width
        this.countOfItems=countOfItems
    }

    override fun getCount(): Int {
        return countOfItems
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflator.inflate(R.layout.grid_item, null)

        itemView.layoutParams=LinearLayout.LayoutParams(width,height)
        
        return itemView
    }
}