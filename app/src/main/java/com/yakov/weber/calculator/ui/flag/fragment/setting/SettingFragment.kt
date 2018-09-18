package com.yakov.weber.calculator.ui.flag.fragment.setting

import android.os.Bundle
import android.preference.PreferenceFragment
import com.yakov.weber.calculator.R

class SettingFragment : PreferenceFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preference)
    }
}
