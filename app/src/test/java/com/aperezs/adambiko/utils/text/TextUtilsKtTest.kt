package com.aperezs.adambiko.utils.text

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class TextUtilsKtTest {

    @Test
    fun `Get digits should return digits only or empty if no string is given`() {
        val firstString = "12.23"
        val secondString = "12321,78"
        val thirdString = ""
        val fourString = "9281"

        val firstResult = firstString.getDigits()
        val secondResult = secondString.getDigits()
        val thirdResult = thirdString.getDigits()
        val fourResult = fourString.getDigits()

        assertEquals("12", firstResult)
        assertEquals("12321", secondResult)
        assertEquals("", thirdResult)
        assertEquals("9281", fourResult)
    }


    @Test
    fun `Get decimals should return decimals only or null if no decimal is found`() {
        val firstString = "12.23"
        val secondString = "12321,78"
        val thirdString = ""
        val fourString = "9281"

        val firstResult = firstString.getDecimals()
        val secondResult = secondString.getDecimals()
        val thirdResult = thirdString.getDecimals()
        val fourResult = fourString.getDecimals()

        assertEquals("23", firstResult)
        assertEquals("78", secondResult)
        assertNull(thirdResult)
        assertNull(fourResult)
    }

    @Test
    fun `Format decimal should return given string formatted with default pattern`() {
        val givenString = "674.23"

        val result = givenString.formatDecimalWith()

        assertEquals("67.23", result)
    }

    @Test
    fun `Format decimal should return as many digits and many decimals as supplied into pattern`() {
        val givenString = "2819282,121231"

        val result = givenString.formatDecimalWith("####.000")

        assertEquals("2819.121", result)
    }

    @Test
    fun `Format decimal should add decimals if were not supplied into given string`() {
        val givenString = "4342"

        val result = givenString.formatDecimalWith("###.000")

        assertEquals("434.000", result)
    }

}