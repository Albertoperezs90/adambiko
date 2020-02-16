package com.aperezs.adambiko.operations.entries.model

import android.content.res.Resources
import com.aperezs.adambiko.R
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class EntryUIMockTest {

    private val resources: Resources = mock()

    private val entryUIMock = EntryUIMock(resources)

    @Before
    fun setUp() {
        whenever(resources.getStringArray(any())).thenReturn(generateArrayString())
    }

    @Test
    fun `Generate should return one EntryUI`() {
        val result = entryUIMock.generate()

        assertEquals(EntryUI::class.java.canonicalName, result::class.java.canonicalName)
    }

    @Test
    fun `Generate List should return atleast one entry`() {
        val result = entryUIMock.generateList(1)

        assertTrue(result.isNotEmpty())
    }

    @Test
    fun `Generate List should return many entries as quantity given`() {
        val result = entryUIMock.generateList(5)

        assertEquals(5, result.size)
    }

    @Test
    fun `Generate List should return empty list when quantity given is equal than zero`() {
        val result = entryUIMock.generateList(0)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `Generate List should return empty list when quantity given is lesser than zero`() {
        val result = entryUIMock.generateList(-1)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `Generate List should generate entries with avatar founded into drawables`() {
        val result = entryUIMock.generateList(200)

        val expectedDrawables = arrayOf(R.drawable.ic_boy_young, R.drawable.ic_boy_man, R.drawable.ic_girl_ancient, R.drawable.ic_girl_brown, R.drawable.ic_girl_red)
        assertTrue(result.all { entry -> expectedDrawables.any { it == entry.avatar } })
    }

    @Test
    fun `Generate List should generate entries with quantity attribute greater than 10 and lesser than 99`() {
        val result = entryUIMock.generateList(200)

        assertTrue(result.all { it.quantity.toInt() in 10..99 })
    }

    @Test
    fun `Generate List should generate entries with amount attribute greater than 200 and lesser than 500`() {
        val result = entryUIMock.generateList(200)

        assertTrue(result.all { it.amount.toDouble() in 200.0..500.0 })
    }

    @Test
    fun `Generate List should generate entries with description founded into array string`() {
        val result = entryUIMock.generateList(200)

        assertTrue(result.all { entry -> generateArrayString().any { it == entry.description } })
    }

    @Test
    fun `Generate List should generate entries with firstValue attribute greater than 20 and lesser than 40`() {
        val result = entryUIMock.generateList(200)

        assertTrue(result.all { it.firstValue.toDouble() in 20.0..40.0 })
    }

    @Test
    fun `Generate List should generate entries with secondValue attribute greater than 30 and lesser than 55`() {
        val result = entryUIMock.generateList(200)

        assertTrue(result.all { it.secondValue.toDouble() in 30.0..55.0 })
    }

    @Test
    fun `Generate List should generate entries with thirdValue attribute greater than 75 and lesser than 89`() {
        val result = entryUIMock.generateList(200)

        assertTrue(result.all { it.thirdValue.toDouble() in 75.0..89.0 })
    }


    private fun generateArrayString(): Array<String> {
        return arrayOf(
            "This is a description for adam biko app",
            "This app has been develop by @albertoperezs90",
            "Awesome app!",
            "I'm going to give 5 stars!",
            "Hope you like it as much I do!"
        )
    }

}