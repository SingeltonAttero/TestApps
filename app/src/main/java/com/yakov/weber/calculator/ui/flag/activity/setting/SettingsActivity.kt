package com.yakov.weber.calculator.ui.flag.activity.setting

import android.os.Bundle
import android.preference.PreferenceActivity
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.flag.fragment.setting.SettingFragment
import toothpick.Toothpick

class SettingsActivity : PreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toothpick.openScope(DI.APP_FLAG)
        fragmentManager.beginTransaction()
                .replace(android.R.id.content, SettingFragment())
                .commit()
    }
}
