package com.aperezs.adambiko.operations.entries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aperezs.adambiko.common.base.BaseViewModel
import com.aperezs.adambiko.operations.entries.model.EntryUI
import com.aperezs.adambiko.operations.entries.model.EntryUIMock
import com.aperezs.adambiko.storage.datasource.LocalDataSource
import javax.inject.Inject

class EntriesViewModel @Inject constructor(
    private val entryUIMock: EntryUIMock,
    private val localDataSource: LocalDataSource
) : BaseViewModel() {

    private val _entriesUI = MutableLiveData<List<EntryUI>>()
    val entriesUI: LiveData<List<EntryUI>>
        get() = _entriesUI

    private val _onNavigation = MutableLiveData<EntriesNavigation>()
    val onNavigation: LiveData<EntriesNavigation>
        get() = _onNavigation

    private var lastEntryRemoved: Pair<Int, EntryUI?>? = null
    private var isRestoring: Boolean = false
    private var entryUIIndex: Int = 0

    fun loadInitialData() {
        _entriesUI.postValue(entryUIMock.generateList(2))
    }

    fun addNewEntry() {
        _entriesUI.value = _entriesUI.value?.plus(entryUIMock.generate())
    }

    fun removeEntries(): Boolean {
        _entriesUI.value = emptyList()
        return true
    }

    fun cancelRemove() {
        if (!isRestoring) {
            isRestoring = true
            lastEntryRemoved?.let {
                val entries = _entriesUI.value?.toMutableList()
                entries?.add(lastEntryRemoved!!.first, lastEntryRemoved!!.second!!)
                lastEntryRemoved = null
                _entriesUI.value = entries
            }
            isRestoring = false
        }
    }

    fun removeEntry(position: Int) {
        val entries = _entriesUI.value?.toMutableList()
        lastEntryRemoved = position to entries?.get(position)
        entries?.removeAt(position)
        _entriesUI.value = entries
    }

    fun markAsDisabled(position: Int) {
        _entriesUI.value = _entriesUI.value?.apply { get(position).also { it.isDisabled = true } }
    }

    fun openOnFullScreen(drawableResource: Int) {
        _onNavigation.value = EntriesNavigation.FullScreen(drawableResource)
    }

    fun modifyEntry(entryUI: EntryUI) {
        entryUIIndex = _entriesUI.value?.indexOf(entryUI) ?: 0
        _onNavigation.value = EntriesNavigation.ModifyEntry(entryUI)
    }

    fun updateEntryData(entryUI: EntryUI) {
        _entriesUI.value = _entriesUI.value?.toMutableList()?.apply {
            removeAt(entryUIIndex)
            add(entryUIIndex, entryUI)
        }
    }
}
