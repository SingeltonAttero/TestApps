package com.yakov.weber.calculator.ui.base

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.Menu
import com.arellomobile.mvp.MvpAppCompatActivity
import com.yakov.weber.calculator.R
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : MvpAppCompatActivity() {

    protected abstract val layoutRes: Int
    val toolbar: ActionBar
        get() = this.supportActionBar!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        setSupportActionBar(main_toolbar)
        toolbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        toolbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white)
        return super.onCreateOptionsMenu(menu)
    }
}