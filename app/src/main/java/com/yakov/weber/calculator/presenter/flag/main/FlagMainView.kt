package com.yakov.weber.calculator.presenter.flag.main

import com.arellomobile.mvp.MvpView

interface FlagMainView : MvpView {
    fun showFragment()
    fun showText(message: String)
    fun setTitleToolbar(title: String)
}