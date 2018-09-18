package com.yakov.weber.calculator.models.flag.file

import android.content.Context
import com.yakov.weber.calculator.extent.printConstruction
import com.yakov.weber.calculator.models.flag.prefs.Prefs
import com.yakov.weber.calculator.models.global.SchedulersProvider
import io.reactivex.Completable
import java.io.InputStream
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class FlagFileRepository @Inject constructor(
    private val prefs: Prefs,
    private val context: Context,
    private val scheduler: SchedulersProvider
) {

    init {
        printConstruction()
    }

    fun guessRows () = prefs.choices.toInt()
    fun nameCounterFlag(): List<String> = prefs.regions.map { context.assets.list(it) }
                .flatMap { Iterable<String> { it.iterator() } }
                .map { it.replace(".png", "") }

    fun getInputStreamFlag(region: String, nextNameImage: String): InputStream = context
            .assets.open("$region/$nextNameImage.png")

    fun loadNextFlagProvider(): Completable = Completable.fromAction {}
            .subscribeOn(scheduler.newThread())
            .delay(1200, TimeUnit.MILLISECONDS)
            .observeOn(scheduler.ui())
}