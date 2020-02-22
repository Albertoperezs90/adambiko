package com.aperezs.adambiko.operations.modify

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.aperezs.adambiko.common.base.BaseViewModel
import com.aperezs.adambiko.operations.entries.model.EntryUI
import javax.inject.Inject

class ModifyEntryViewModel @Inject constructor() : BaseViewModel() {

    private var entry = MutableLiveData<EntryUI>()

    val firstValue: LiveData<String> = Transformations.map(entry) { it.firstValue }
    val amount: LiveData<String> = Transformations.map(entry) { it.amount }
    val secondValue: LiveData<String> = Transformations.map(entry) { it.secondValue }
    val thirdValue: LiveData<String> = Transformations.map(entry) { it.thirdValue }

    fun initializeEntry(entryUI: EntryUI) {
        entry.value = entryUI
    }
}