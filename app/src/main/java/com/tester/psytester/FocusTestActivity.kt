package com.tester.psytester

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.GridView
import kotlinx.android.synthetic.main.grid_item.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class FocusTestActivity : Activity() {
    val countOfSymbols=100

    var tester=Tester()
    var arrowsAdapter: ContextAdapter? = null

    var symbols:Array<String>?=null
    var correctSymbol:String?=null
    var countOfCorrectSymbols=0
    var countOfMissing=0

    var gv: GridView? = null

    //override val countOfTests: Int=100

    override fun onBackPressed() {

    }
    fun getContentGridView(){
        for(i in 0..gv!!.childCount-1) {
            val child = gv!!.getChildAt(i)
            val symbol=symbols!![Randomizer().randInt(0,3)]
            if(symbol==correctSymbol)
                countOfCorrectSymbols++
            child.tvName.setText(symbol)
            child.setOnClickListener {
                if(correctSymbol!=child.tvName.text){
                    tester.addMistake()
                }
                else
                    countOfMissing--
                child.tvName.textResource=R.string.empty
            }
        }
        countOfMissing=countOfCorrectSymbols

    }
    fun changeWarningString(index:Int):Int{
        if(index==0)
            return R.string.focust_test_notation_up
        if(index==1)
            return R.string.focust_test_notation_down
        if(index==2)
            return R.string.focust_test_notation_right
        return R.string.focust_test_notation_left
    }

    fun writeResult():String{
        var timeText="Время выполнения: "+tester.time
        var percentOfMistakes="Процент ошибок: "+tester.mistakes*100/(countOfSymbols-countOfCorrectSymbols) + "%"
        val countOfMissin="Процент пропущенных: "+ countOfMissing*100/countOfCorrectSymbols+"%"
        Worker.controles.add(Control(this.toString(),tester.time.toString(),
                (tester.mistakes*100/(countOfSymbols-countOfCorrectSymbols)).toString(),
                (countOfMissing*100/countOfCorrectSymbols).toString()))
        return timeText+"\n"+percentOfMistakes+"\n"+countOfMissin
    }

    fun getContextAdapter():ContextAdapter{
        val height=getWindowManager().getDefaultDisplay().getHeight()
        val width=getWindowManager().getDefaultDisplay().getWidth()
        return ContextAdapter(this@FocusTestActivity,countOfSymbols,height/12,width/10)
    }

    override fun toString(): String {
        return "Сосредоточенность внимания"
    }
    override fun finish() {
        alert(writeResult()){
            okButton{
                super.finish()
            }
        }.show()
    }
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        symbols =resources.getStringArray(R.array.symbols)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val index=Randomizer().randInt(0,3)
        correctSymbol= symbols!![index]
        super.onCreate(savedInstanceState)

        verticalLayout {
            gv=gridView{
                numColumns=countOfSymbols/10
                adapter=getContextAdapter()
            }
            button("Закончить попытку"){
                onClick {
                    tester.stopTimer()
                    finish()
                }
                height= dip(200)
            }
            android.os.Handler().postDelayed({ getContentGridView()} ,(1000).toLong())
        }
        alert(changeWarningString(index)){
            okButton {
                tester.startTimer()
            }
        }.show()





}}
