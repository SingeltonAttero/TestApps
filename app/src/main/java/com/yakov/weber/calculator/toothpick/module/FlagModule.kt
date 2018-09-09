package com.yakov.weber.calculator.toothpick.module

import com.yakov.weber.calculator.models.flag.prefs.Prefs
import com.yakov.weber.calculator.models.flag.prefs.PrefsImpl
import timber.log.Timber
import toothpick.config.Module

class FlagModule : Module() {
    init {
        Timber.d("Create Global dependencies...")
        bind(Prefs::class.java).to(PrefsImpl::class.java).singletonInScope()
    }
}