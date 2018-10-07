package com.yakov.weber.calculator.toothpick.module

import android.content.Context
import com.yakov.weber.calculator.models.global.AppSchedulers
import com.yakov.weber.calculator.models.global.SchedulersProvider
import com.yakov.weber.calculator.system.ResManager
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber
import toothpick.config.Module

class AppModule (context: Context) : Module() {
    init {
        Timber.d("Create Global dependencies...")
        bind(Context::class.java).toInstance(context)
        bind(ResManager::class.java).singletonInScope()
        bind(SchedulersProvider::class.java).toInstance(AppSchedulers())

        //cicerone
        val  cicerone = Cicerone.create()
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)
        bind(Router::class.java).toInstance(cicerone.router)
    }
}