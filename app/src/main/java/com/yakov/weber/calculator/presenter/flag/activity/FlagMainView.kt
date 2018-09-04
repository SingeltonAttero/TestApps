package com.yakov.weber.calculator.presenter.flag.activity

import com.arellomobile.mvp.MvpView

interface FlagMainView : MvpView {
    fun showFragment()
    fun showText(message: String)
    fun setTitleToolbar(title: String)
}