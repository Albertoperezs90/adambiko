package com.aperezs.adambiko.utils.edittext

import android.text.InputType
import android.widget.EditText

fun EditText.disableEdit() {
    inputType = InputType.TYPE_NULL
    setTextIsSelectable(false)
    setOnKeyListener { _, _, _ ->
        true
    }
}