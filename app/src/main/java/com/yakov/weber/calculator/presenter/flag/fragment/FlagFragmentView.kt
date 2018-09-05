package com.yakov.weber.calculator.presenter.flag.fragment

import com.arellomobile.mvp.MvpView

interface FlagFragmentView : MvpView {
    fun showError(message: String)
}