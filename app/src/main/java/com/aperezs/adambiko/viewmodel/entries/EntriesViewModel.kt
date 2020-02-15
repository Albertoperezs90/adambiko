package com.aperezs.adambiko.viewmodel.entries

import android.util.Log
import com.aperezs.adambiko.viewmodel.base.BaseViewModel
import javax.inject.Inject

class EntriesViewModel @Inject constructor() : BaseViewModel() {

    var data = "data"

    fun printData() {
        Log.i("**DEBUGGABLE**", data)
    }

}
