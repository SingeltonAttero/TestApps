package com.yakov.weber.calculator.toothpick.module

import android.content.Context
import com.yakov.weber.calculator.models.global.AppSchedulers
import com.yakov.weber.calculator.models.global.SchedulersProvider
import com.yakov.weber.calculator.system.ResManager
import timber.log.Timber
import toothpick.config.Module

class AppModule (context: Context) : Module() {
    init {
        Timber.d("Create Global dependencies...")
        bind(Context::class.java).toInstance(context)
        bind(ResManager::class.java).singletonInScope()
        bind(SchedulersProvider::class.java).toInstance(AppSchedulers())
    }
}