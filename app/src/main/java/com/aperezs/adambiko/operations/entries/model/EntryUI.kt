package com.aperezs.adambiko.operations.entries.model

data class EntryUI(
    val avatar: Int,
    val quantity: String,
    val amount: String,
    var isDisabled: Boolean,
    val description: String,
    val firstValue: String,
    val secondValue: String,
    val thirdValue: String
)