package com.yakov.weber.calculator.models.flag.file

import android.content.Context
import android.graphics.drawable.Drawable
import com.yakov.weber.calculator.extent.printConstruction
import com.yakov.weber.calculator.models.flag.prefs.Prefs
import java.io.InputStream
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

    fun getInputStreamFlag(region:String,nextNameImage:String): InputStream = context
            .assets.open("$region/$nextNameImage.png")


}