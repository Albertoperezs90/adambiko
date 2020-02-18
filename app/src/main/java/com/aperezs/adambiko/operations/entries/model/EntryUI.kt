package com.aperezs.adambiko.operations.entries.model

import android.graphics.drawable.Drawable

data class EntryUI(
    val avatar: Drawable?,
    val quantity: String,
    val amount: String,
    val description: String,
    val firstValue: String,
    val secondValue: String,
    val thirdValue: String
)