package com.yakov.weber.calculator.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yakov.weber.calculator.R
import kotlinx.android.synthetic.main.toolbar.*

class CalculateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment, CalculateFragment())
                .commit()
    }
}
