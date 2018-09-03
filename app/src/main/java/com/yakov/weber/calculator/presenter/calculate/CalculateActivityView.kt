package com.yakov.weber.calculator.presenter.calculate

import com.arellomobile.mvp.MvpView

interface CalculateActivityView : MvpView {
    fun initCalculateFragment()
    fun setTitleToolbar(message: String)
}