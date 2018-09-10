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

    fun questNumber() = resManager.getString(R.string.question, 1, FLAG_IN_COUNT)
    private fun getAllCountryFlag() = repository.nameCounterFlag()
    fun getSelectFlag(): List<String> {
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
        return listSelect.toList()
    }

    fun getGuessRows() = 0 until (repository.guessRows() / 2)
}