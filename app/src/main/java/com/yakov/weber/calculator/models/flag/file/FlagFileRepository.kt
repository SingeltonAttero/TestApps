package com.yakov.weber.calculator.models.flag.file

import android.content.Context
import com.yakov.weber.calculator.extent.printConstruction
import com.yakov.weber.calculator.models.flag.prefs.Prefs
import javax.inject.Inject

class FlagFileRepository @Inject constructor(
        private val prefs: Prefs,
        private val context: Context){

    init {
        printConstruction()
    }

    fun guessRows () = prefs.choices.toInt()
    fun nameCounterFlag(): List<String> = prefs.regions.map { context.assets.list(it) }
                .flatMap { Iterable<String>{it.iterator() }}
                .map { it.replace(".png","")}


}