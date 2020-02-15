package com.aperezs.adambiko.operations.entries

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aperezs.adambiko.common.base.BaseViewModel
import javax.inject.Inject

class EntriesViewModel @Inject constructor() : BaseViewModel() {

    var data = "data"

    var listData = MutableLiveData<List<String>>().also {
        it.value = listOf("Item uno", "Item dos", "Item tres", "Item cuatro", "Item cinco", "Item seis", "Item siete", "Item ocho")
    }

    fun printData() {
        Log.i("**DEBUGGABLE**", data)
    }

}
