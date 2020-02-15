package com.aperezs.adambiko.utils.random

import kotlin.random.Random


fun randomInteger(atLowest: Int = 0, atHighest: Int = 1) = (atLowest..atHighest).random()

fun randomDouble(atLowest: Double = 0.0, atHighest: Double = 1.0): Double {
    val rnd = Random(randomInteger(0, 500))
    return rnd.nextDouble(atLowest, atHighest)
}