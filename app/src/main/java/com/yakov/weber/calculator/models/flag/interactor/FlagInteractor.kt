package com.yakov.weber.calculator.models.flag.interactor

import com.yakov.weber.calculator.models.flag.file.FlagFileRepository
import com.yakov.weber.calculator.models.flag.prefs.Prefs
import javax.inject.Inject

class FlagInteractor @Inject constructor(private val repository: FlagFileRepository,
                                         private val prefs: Prefs) {

    fun getRegions() = repository.nameCounterFlag()

}