package com.tester.psytester

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import com.tester.psytester.R.styleable.SwipeFlingAdapterView

import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import android.widget.ArrayAdapter
import android.widget.Toast









class EvenOddTestActivity : Test() {
    override fun toString(): String {
        return "Распознавние четных чисел"
    }
    var flingContainer:SwipeFlingAdapterView?=null
    var i=0
    override val countOfTests: Int=12

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_even_odd_test)
        flingContainer = findViewById(R.id.frame) as SwipeFlingAdapterView
        val al = ArrayList<Int>()
        for(i in 0..countOfTests-1)
            al.add(Randomizer().randInt(0,100))
        val arrayAdapter = ArrayAdapter(this, R.layout.item, R.id.helloText, al)
        flingContainer!!.setAdapter(arrayAdapter)

        var lastNumber=0

        flingContainer!!.setFlingListener( object:SwipeFlingAdapterView.onFlingListener {
            override fun onScroll(scrollProgressPercent: Float) {
                val view = flingContainer!!.selectedView
            }

            override fun removeFirstObjectInAdapter() {
                Log.d("LIST", "removed object!")
                lastNumber=al[0]
                al.removeAt(0)
                arrayAdapter.notifyDataSetChanged()
            }

            override fun onLeftCardExit(dataObject: Any) {
                if(lastNumber%2==0)
                    data.countOfMistakes++
            }

            override fun onRightCardExit(dataObject: Any) {
                if(lastNumber%2!=0)
                    data.countOfMistakes++
            }

            override fun onAdapterAboutToEmpty(itemsInAdapter: Int) {
                if(al.size==0) {
                    click()
                    finish()
                }
            }
        })
        flingContainer!!.setOnItemClickListener { itemPosition, dataObject -> toast( "Clicked!") }

    }


    fun right(view:View) {
        flingContainer!!.getTopCardListener().selectRight()
    }


    fun left(view:View) {
        flingContainer!!.getTopCardListener().selectLeft()
    }



}


