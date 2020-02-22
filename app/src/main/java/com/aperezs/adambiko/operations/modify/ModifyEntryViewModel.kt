package com.aperezs.adambiko.operations.modify

import com.aperezs.adambiko.common.base.BaseViewModel
import com.aperezs.adambiko.operations.entries.model.EntryUI
import javax.inject.Inject

class ModifyEntryViewModel @Inject constructor() : BaseViewModel() {

    private lateinit var entry: EntryUI

    fun initializeEntry(entryUI: EntryUI) {
        entry = entryUI
    }
}