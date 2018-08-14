package com.yakov.weber.calculator.presenter.calculate

import com.arellomobile.mvp.MvpView

interface CalculateView : MvpView{
    fun showResult(message:String)
}