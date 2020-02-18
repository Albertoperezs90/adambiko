package com.aperezs.adambiko.operations.fullscren

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aperezs.adambiko.common.base.BaseViewModel
import javax.inject.Inject

class FullScreenViewModel @Inject constructor() : BaseViewModel() {

    private val _onLoadResource = MutableLiveData<Int>()
    val onLoadResource: LiveData<Int>
        get() = _onLoadResource

    fun loadDrawableResource(drawableResource: Int) {
        _onLoadResource.value = drawableResource
    }
}