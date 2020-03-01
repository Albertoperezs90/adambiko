package com.aperezs.adambiko.storage.datasource

import com.aperezs.adambiko.operations.entries.model.EntryUI
import com.aperezs.adambiko.storage.dao.EntryDAO
import com.aperezs.adambiko.storage.model.EntryEntity
import com.aperezs.adambiko.storage.model.toEntryEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocalDataSource(private val entryDAO: EntryDAO) {

    private var entries: List<EntryEntity> = listOf()

    fun getAllEntries(onCompletion: (List<EntryEntity>) -> Unit) {
        GlobalScope.launch {
            entries = entryDAO.getAllEntries()
            onCompletion(entries)
        }
    }

    fun insertEntry(entry: EntryUI) {
        GlobalScope.launch {
            entryDAO.insertEntry(entry.toEntryEntity())
            entries = entries.toMutableList().apply { add(entry.toEntryEntity()) }
        }
    }

    fun deleteEntry(position: Int) {
        GlobalScope.launch {
            entryDAO.deleteEntry(entries[position])
            entries = entries.toMutableList().apply { removeAt(position) }
        }
    }

    fun updateEntry(entry: EntryUI) {
        GlobalScope.launch {
            entryDAO.updateEntry(entry.toEntryEntity())
        }
    }

    fun deleteAll() {
        GlobalScope.launch {
            entries = listOf()
            entryDAO.deleteAll()
        }
    }
}