package com.tester.psytester

import android.os.Bundle
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton

open class Warning:Portrait() {
    open fun afterWarningAct(){}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        alert(R.string.dialog_message,R.string.dialog_title){
            okButton { afterWarningAct() }
        }.show()
    }


}