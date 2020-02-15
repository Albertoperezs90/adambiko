package com.aperezs.adambiko.utils.random

import org.junit.Assert.assertTrue
import org.junit.Test

class RandomUtilsKtTest {


    @Test
    fun `Random integer should return integers between valid range`() {
        val zeroToOne = randomInteger()
        assertTrue((zeroToOne in 0..1))

        val negativeToPositive = randomInteger(-50, 150)
        assertTrue((negativeToPositive in -50..150))
    }

    @Test(expected = NoSuchElementException::class)
    fun `Should throw NoSuchElementException if range integer is not valid`() {
        randomInteger(50, 20)
    }


    @Test
    fun `Random double should return doubles between valid range`() {
        val zeroToOne = randomDouble()
        assertTrue((zeroToOne in 0.0..1.0))

        val fiftyToTwoHundred = randomDouble(50.0, 200.00)
        assertTrue((fiftyToTwoHundred in 50.0..200.0))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Should throw IllegalArgumentException if range double is not valid`() {
        randomDouble(200.0, 20.0)
    }

}