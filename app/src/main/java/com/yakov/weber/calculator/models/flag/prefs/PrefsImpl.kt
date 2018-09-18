package com.yakov.weber.calculator.models.flag.prefs

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.yakov.weber.calculator.R
import org.jetbrains.anko.defaultSharedPreferences
import javax.inject.Inject

class PrefsImpl @Inject constructor(private val context: Context) : Prefs {
    companion object {
        private const val CHOICES = "pref_number_of_choices"
        private const val REGION = "pref_region_to_include"
    }

    private inline fun SharedPreferences.edit(block: SharedPreferences.Editor.() -> Unit) {
        edit().apply { block() }.apply()
    }

    private val sharedPrefs by lazy {
        PreferenceManager.setDefaultValues(context, R.xml.preference, false)
        context.defaultSharedPreferences }

    override var choices: String
        get() = sharedPrefs.getString(CHOICES, "2")
        set(value) {
            sharedPrefs.edit { putString(CHOICES, value) }
        }
    override var regions: Set<String>
        get() = sharedPrefs.getStringSet(REGION, setOf(context.getString(R.string.default_region)))
        set(value) {
            sharedPrefs.edit { putStringSet(REGION, value) }
        }
}