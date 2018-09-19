package com.yakov.weber.calculator.extent

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import timber.log.Timber

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)

fun <T> T.alsoPrintDebug(message: String = "LoggerTimber"): T = this.also { Timber.d("$message...$this") }

inline fun <reified T> T.printConstruction() = Timber.d("Construction ${T::class.java.simpleName}")