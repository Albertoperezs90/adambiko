package com.aperezs.adambiko.operations.entries.model

import android.content.res.Resources
import com.aperezs.adambiko.R
import com.aperezs.adambiko.utils.random.randomDouble
import com.aperezs.adambiko.utils.random.randomInteger
import com.aperezs.adambiko.utils.text.formatDecimalWith
import com.aperezs.adambiko.utils.text.getRandomStringFromArrayResources
import javax.inject.Inject

class EntryUIMock @Inject constructor(private val resources: Resources) {

    fun generate(quantity: Int): List<EntryUI> {
        val entries = mutableListOf<EntryUI>()
        repeat(quantity) {
            entries.add(
                EntryUI(
                    avatar = getRandomImage(),
                    quantity = randomInteger(10, 99).toString(),
                    amount = randomDouble(200.0, 500.0).toString().formatDecimalWith("000.00"),
                    description = getRandomStringFromArrayResources(resources, R.array.entry_description).orEmpty(),
                    firstValue = randomDouble(20.0, 40.0).toString().formatDecimalWith(),
                    secondValue = randomDouble(30.0, 55.0).toString().formatDecimalWith(),
                    thirdValue = randomDouble(75.0, 89.0).toString().formatDecimalWith()
                )
            )
        }
        return entries
    }

    private fun getRandomImage(): Int {
        val drawables = arrayOf(R.drawable.ic_boy_young, R.drawable.ic_boy_man, R.drawable.ic_girl_ancient, R.drawable.ic_girl_brown, R.drawable.ic_girl_red)
        return drawables.random()
    }


}