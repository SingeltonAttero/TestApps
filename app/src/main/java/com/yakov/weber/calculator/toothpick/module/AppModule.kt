package com.yakov.weber.calculator.toothpick.module

import android.content.Context
import timber.log.Timber
import toothpick.config.Module

class AppModule (context: Context) : Module() {
    init {
        Timber.d("Create Global dependencies...")
        bind(Context::class.java).toInstance(context)
    }
}