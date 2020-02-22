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

    private var firstValueMutable = MutableLiveData<String>()
    private var amountMutable = MutableLiveData<String>()

    var totalAmount = MutableLiveData<String>()

    fun initializeEntry(entryUI: EntryUI) {
        entry.value = entryUI
    }

    fun updateFirstValue(value: String) {
        firstValueMutable.value = value
        calculateTotalAmount()
    }

    fun updateAmountValue(amount: String) {
        amountMutable.value = amount
        calculateTotalAmount()
    }

    private fun calculateTotalAmount() {
        val firstValue = firstValueMutable.value?.let {
            if (it.isNotBlank()) {
                it.toFloat()
            } else {
                0f
            }
        } ?: 0f
        val amountValue = amountMutable.value?.let {
            if (it.isNotBlank()) {
                it.toFloat()
            } else {
                0f
            }
        } ?: 0f

        totalAmount.value = (firstValue + amountValue).toString()
    }
}