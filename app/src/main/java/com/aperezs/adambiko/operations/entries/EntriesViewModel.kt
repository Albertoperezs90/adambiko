package com.aperezs.adambiko.operations.entries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aperezs.adambiko.common.base.BaseViewModel
import com.aperezs.adambiko.operations.entries.model.EntryUI
import com.aperezs.adambiko.operations.entries.model.EntryUIMock
import javax.inject.Inject

class EntriesViewModel @Inject constructor(private val entryUIMock: EntryUIMock) : BaseViewModel() {

    private val _entriesUI = MutableLiveData<List<EntryUI>>()
    val entriesUI: LiveData<List<EntryUI>>
        get() = _entriesUI


    fun loadInitialData() {
        _entriesUI.value = entryUIMock.generateList(2)
    }

    fun addNewEntry() {
        _entriesUI.value = _entriesUI.value?.plus(entryUIMock.generate())
    }
}
