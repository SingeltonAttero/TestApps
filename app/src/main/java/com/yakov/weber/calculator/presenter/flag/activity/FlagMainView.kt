package com.yakov.weber.calculator.presenter.flag.activity

import com.arellomobile.mvp.MvpView

interface FlagMainView : MvpView {
    fun setPhoneFragment()
    fun setSettingFragment()
    fun showText(message: String)
    fun setTitleToolbar(title: String)
}