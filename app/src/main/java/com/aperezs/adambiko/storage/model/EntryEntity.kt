package com.aperezs.adambiko.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aperezs.adambiko.operations.entries.model.EntryUI

@Entity(tableName = "entry")
data class EntryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val avatar: Int,
    val quantity: String,
    val amount: String,
    var isDisabled: Boolean,
    val description: String,
    val firstValue: String,
    val secondValue: String,
    val thirdValue: String
)


fun EntryUI.toEntryEntity() = EntryEntity(id, avatar, quantity, amount, isDisabled, description, firstValue, secondValue, thirdValue)