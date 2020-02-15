package com.aperezs.adambiko.operations.entries.model

import androidx.annotation.DrawableRes

data class EntryUI(
    val avatar: DrawableRes,
    val quantity: String,
    val amount: String,
    val description: String,
    val firstValue: String,
    val secondValue: String,
    val thirdValue: String
)