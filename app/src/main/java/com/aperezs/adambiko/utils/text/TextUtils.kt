package com.aperezs.adambiko.utils.text

import android.content.res.Resources
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

fun String.formatDecimalWith(pattern: String = "##.00"): String {
    val df = DecimalFormat(pattern)
    val symbols = DecimalFormatSymbols.getInstance()
    symbols.decimalSeparator = '.'
    df.roundingMode = RoundingMode.FLOOR
    df.decimalFormatSymbols = symbols
    val maximumIntegers = pattern.getDigits().count()
    val digitsFromString = this.getDigits()
    val decimalsFromString = this.getDecimals()
    val stringDigitsFormatted = if (digitsFromString.length > maximumIntegers) digitsFromString.substring(0..maximumIntegers.dec()) else digitsFromString
    val digitsPlusDecimals = "$stringDigitsFormatted.${decimalsFromString ?: ""}"
    val doubleParse = digitsPlusDecimals.toDouble()
    return df.format(doubleParse)
}

fun String.getDigits(): String {
    val index = indexOfFirst { it == ',' || it == '.' }
    return if (index != -1) substring(0..index.dec()) else this
}

fun String.getDecimals(): String? {
    val index = indexOfFirst { it == ',' || it == '.' }
    return if (index != -1) substring(index.inc()..length.dec()) else null
}

fun getRandomStringFromArrayResources(resources: Resources, arrayResource: Int): String? {
    return resources.getStringArray(arrayResource).random()
}

fun EditText.appendCharacterAtTheEnd(character: Char) {
    doOnTextChanged { text, start, count, after ->

    }
}