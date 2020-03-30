package com.aperezs.adambiko.storage.datasource

import androidx.annotation.MainThread
import com.aperezs.adambiko.operations.entries.model.EntryUI
import com.aperezs.adambiko.storage.dao.EntryDAO
import com.aperezs.adambiko.storage.model.EntryEntity
import com.aperezs.adambiko.storage.model.toEntryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocalDataSource(private val entryDAO: EntryDAO) {

    private var entries: List<EntryEntity> = listOf()

    fun getAllEntries(onCompletion: (List<EntryEntity>) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            entries = entryDAO.getAllEntries()
            GlobalScope.launch(Dispatchers.Main) { onCompletion(entries) }
        }
    }

    fun insertEntry(entry: EntryUI, @MainThread onResult: () -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            entries = entries.toMutableList().apply { add(entry.toEntryEntity()) }
            entryDAO.insertEntry(entry.toEntryEntity())
            GlobalScope.launch(Dispatchers.Main) { onResult() }
        }
    }

    fun deleteEntry(position: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            entryDAO.deleteEntry(entries[position])
            entries = entries.toMutableList().apply { removeAt(position) }
        }
    }

    fun updateEntry(entry: EntryUI) {
        GlobalScope.launch(Dispatchers.IO) {
            entryDAO.updateEntry(entry.toEntryEntity())
        }
    }

    fun deleteAll() {
        GlobalScope.launch(Dispatchers.IO) {
            entries = listOf()
            entryDAO.deleteAll()
        }
    }
}