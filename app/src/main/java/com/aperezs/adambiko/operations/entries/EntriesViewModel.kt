package com.aperezs.adambiko.operations.entries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aperezs.adambiko.common.base.BaseViewModel
import com.aperezs.adambiko.operations.entries.model.EntryUI
import com.aperezs.adambiko.operations.entries.model.EntryUIMock
import javax.inject.Inject

class EntriesViewModel @Inject constructor(
    private val entryUIMock: EntryUIMock
) : BaseViewModel() {

    private val _entriesUI = MutableLiveData<List<EntryUI>>()
    val entriesUI: LiveData<List<EntryUI>>
        get() = _entriesUI

    private val _onNavigation = MutableLiveData<EntriesNavigation>()
    val onNavigation: LiveData<EntriesNavigation>
        get() = _onNavigation

    fun loadInitialData() {
        _entriesUI.value = entryUIMock.generateList(2)
    }

    fun addNewEntry() {
        _entriesUI.value = _entriesUI.value?.plus(entryUIMock.generate())
    }

    fun removeEntries(): Boolean {
        _entriesUI.value = emptyList()
        return true
    }

    fun removeEntry(position: Int) {
        val entries = _entriesUI.value?.toMutableList()
        entries?.removeAt(position)
        _entriesUI.value = entries
    }

    fun markAsDisabled(position: Int) {
        _entriesUI.value = _entriesUI.value?.apply { get(position).also { it.isDisabled = true } }
    }

    fun openOnFullScreen(drawableResource: Int) {
        _onNavigation.value = EntriesNavigation.FullScreen(drawableResource)

    }
}
