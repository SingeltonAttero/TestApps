package com.yakov.weber.calculator.models.flag.prefs

import android.content.SharedPreferences
import android.preference.PreferenceManager
import javax.inject.Inject

interface Prefs {
    var choices:String
    var regions:Set<String>

}