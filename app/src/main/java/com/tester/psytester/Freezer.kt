package com.tester.psytester

import android.os.Handler

class Freezer {
    fun waitFor(runnable: Runnable,time:Long){
        Handler().postDelayed(runnable,time)
    }

}