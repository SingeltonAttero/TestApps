package com.yakov.weber.calculator.ui.calculate

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.ui.base.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class CalculateActivity : BaseActivity() {
    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(main_toolbar)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment, CalculateFragment())
                .commit()
    }
}
