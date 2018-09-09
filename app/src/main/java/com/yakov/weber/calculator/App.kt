package com.yakov.weber.calculator

import android.app.Application
import com.facebook.stetho.Stetho
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.toothpick.module.AppModule
import com.yakov.weber.calculator.toothpick.module.FlagModule
import timber.log.Timber
import timber.log.Timber.DebugTree
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initStetho()
        initToothpick()
        initAppScope()
    }

    private fun initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
            FactoryRegistryLocator.setRootRegistry(com.yakov.weber.calculator.FactoryRegistry())
            MemberInjectorRegistryLocator.setRootRegistry(com.yakov.weber.calculator.MemberInjectorRegistry())
        }
    }

    private fun initAppScope() {
        val appScopes = Toothpick.openScope(DI.APP_SCOPES)
        appScopes.installModules(AppModule(this))
        Toothpick.openScopes(DI.APP_SCOPES, DI.APP_FLAG).installModules(FlagModule())
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            val initializerBuilder = Stetho
                    .newInitializerBuilder(this)
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                    .build()
            Stetho.initialize(initializerBuilder)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}
