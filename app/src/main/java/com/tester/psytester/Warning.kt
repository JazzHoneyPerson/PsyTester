package com.tester.psytester

import android.os.Bundle
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton

open class Warning:Portrait() {
    var isCreate=false
    var warningStringId=R.string.dialog_message
    open fun afterWarningAct(){isCreate=true}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        alert(warningStringId,R.string.dialog_title){
            okButton { afterWarningAct() }
            
        }.show()
    }


}