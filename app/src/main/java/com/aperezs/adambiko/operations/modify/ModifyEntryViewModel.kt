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
    val description: LiveData<String> = Transformations.map(entry) { it.description }
    val secondValue: LiveData<String> = Transformations.map(entry) { it.secondValue }
    val thirdValue: LiveData<String> = Transformations.map(entry) { it.thirdValue }

    private var firstValueMutable = MutableLiveData<String>()
    private var amountMutable = MutableLiveData<String>()

    var quantity = MutableLiveData<String>()

    var totalAmount = MutableLiveData<String>()

    fun initializeEntry(entryUI: EntryUI) {
        entry.value = entryUI
        quantity.value = entry.value?.quantity
    }

    fun increaseQuantity() {
        val quantityStringified = quantity.value
        if (quantityStringified != null && quantityStringified.isNotBlank()){
            val newEntry = quantityStringified.toDouble().inc().toString()
            entry.value?.copy(quantity = newEntry)
            quantity.value = newEntry
        }
    }

    fun decreaseQuantity() {
        val newEntry = quantity.value
        if (newEntry != null && newEntry.isNotBlank()) {
            val decQuantity = newEntry.toDouble().dec()
            if (decQuantity > 0) {
                val quantityToString = decQuantity.toString()
                entry.value?.copy(quantity = quantityToString)
                quantity.value = quantityToString
            }
        }
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

    fun getEntryUIData(): EntryUI {
        return entry.value!!
    }
}