package com.yakov.weber.calculator.system

import android.content.Context
import android.support.annotation.StringRes
import java.io.InputStream
import javax.inject.Inject

class ResManager @Inject constructor(private val context: Context) {
    fun getString(@StringRes resId: Int): String = context.getString(resId)
    fun getString(@StringRes resId: Int, vararg formatArgs: Any?): String = context.getString(resId, *formatArgs)
    fun getAsset(name: String): InputStream = context.assets.open(name)
}