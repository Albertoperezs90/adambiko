package com.aperezs.adambiko.operations.entries.model

import android.os.Parcelable
import com.aperezs.adambiko.storage.model.EntryEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EntryUI(
    val avatar: Int,
    val quantity: String,
    val amount: String,
    var isDisabled: Boolean,
    val description: String,
    val firstValue: String,
    val secondValue: String,
    val thirdValue: String
) : Parcelable


fun EntryEntity.toEntryUI() = EntryUI(avatar, quantity, amount, isDisabled, description, firstValue, secondValue, thirdValue)