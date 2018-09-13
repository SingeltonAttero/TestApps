package com.yakov.weber.calculator.models.flag.interactor

import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.models.flag.file.FlagFileRepository
import com.yakov.weber.calculator.system.ResManager
import java.security.SecureRandom
import javax.inject.Inject

class FlagInteractor @Inject constructor(private val repository: FlagFileRepository,
                                         private val resManager: ResManager) {

    companion object {
        const val FLAG_IN_COUNT = 10
    }

    private val random = SecureRandom()

    fun getAllCountryFlag() = repository.nameCounterFlag().toMutableList()

    fun questNumber(counter:Int) = resManager.getString(R.string.question, counter, FLAG_IN_COUNT)

    fun getGuessRows() = repository.guessRows() / 2

    fun getGuessRowsRange() = 0 until (repository.guessRows() / 2)

    fun getCounterName(name:String) = name.substring(name.indexOf("-") + 1).replace("_"," ")

    fun randomNumber(bound:Int) = random.nextInt(bound)

    fun delayLoadFlag() = repository.loadNextFlagProvider()

    fun getSelectFlag(): MutableList<String> {
        val listSelect = mutableListOf<String>()
        var flagCounter = 1
        val sizeAllFlag = getAllCountryFlag().size
        while (flagCounter <= FLAG_IN_COUNT) {
            val randomIndex = random.nextInt(sizeAllFlag)
            val fileName = getAllCountryFlag()[randomIndex]
            if (!listSelect.contains(fileName)) {
                listSelect.add(fileName)
                ++flagCounter
            }
        }
        return listSelect
    }

    fun getImage(region:String,nameImage:String) = repository.getInputStreamFlag(region,nameImage)
}