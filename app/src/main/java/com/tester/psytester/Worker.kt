package com.tester.psytester
data class Control( val nameTest:String, val time:String, val countOfMistakes:String,val countOfMissed:String="")
{
    fun toStringArray(): ArrayList<String> {
        return arrayListOf(nameTest,time,countOfMistakes,countOfMissed)
    }

}
class Worker()
{
    companion object {
        var controles: ArrayList<Control> = ArrayList()
        var name=""
        fun refresh()
        {
            controles=ArrayList()
            name=""
        }
    }

}