package com.yakov.weber.calculator.system

import android.content.Context
import android.support.annotation.StringRes
import javax.inject.Inject

class ResManager @Inject constructor(private val context: Context) {
    fun getString(@StringRes resId: Int) = context.getString(resId)
    fun getString(@StringRes resId: Int, vararg formatArgs: Any?): String = context.getString(resId, *formatArgs)
}