package com.yakov.weber.calculator.presenter.calculate

import com.arellomobile.mvp.MvpView

interface CalculateView : MvpView {
    fun showResult(message: String)
    fun showPercent(message:String)
    fun showChip(message:String)
    fun bindText(message:CharSequence)
}