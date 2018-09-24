package com.yakov.weber.calculator.presenter.paint.main

import com.arellomobile.mvp.MvpView

interface PaintMainActivityView : MvpView {
    fun showFragment()
    fun setTitle(message:String)
    fun setError(message: String = "")
    fun setOrientationLayout()
}