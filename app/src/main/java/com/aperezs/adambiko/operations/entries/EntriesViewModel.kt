package com.aperezs.adambiko.operations.entries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aperezs.adambiko.common.base.BaseViewModel
import com.aperezs.adambiko.operations.entries.model.EntryUI
import com.aperezs.adambiko.operations.entries.model.EntryUIMock
import com.aperezs.adambiko.operations.entries.model.toEntryUI
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
        localDataSource.getAllEntries { entries ->
            val entriesSorted = entries.sortedBy { it.id }
            _entriesUI.postValue(entriesSorted.map { it.toEntryUI() })
        }
    }

    fun addNewEntry() {
        val newEntry = entryUIMock.generate()
        localDataSource.insertEntry(newEntry)
        _entriesUI.value = _entriesUI.value?.plus(newEntry)
    }

    fun removeEntries(): Boolean {
        localDataSource.deleteAll()
        _entriesUI.value = emptyList()
        return true
    }

    fun cancelRemove() {
        if (!isRestoring) {
            isRestoring = true
            lastEntryRemoved?.let {
                val entries = _entriesUI.value?.toMutableList()
                entries?.add(lastEntryRemoved!!.first, lastEntryRemoved!!.second!!)
                localDataSource.insertEntry(lastEntryRemoved!!.second!!)
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
        localDataSource.deleteEntry(position)
        _entriesUI.value = entries
    }

    fun toggleDisable(position: Int) {
        val disableEntry = _entriesUI.value?.get(position)
        disableEntry?.let { entry ->
            entry.isDisabled = !entry.isDisabled
            localDataSource.updateEntry(entry)
            _entriesUI.value = _entriesUI.value?.apply { get(position).also { it.isDisabled = disableEntry.isDisabled} }
        }
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
            localDataSource.updateEntry(entryUI)
            removeAt(entryUIIndex)
            add(entryUIIndex, entryUI)
        }
    }
}
