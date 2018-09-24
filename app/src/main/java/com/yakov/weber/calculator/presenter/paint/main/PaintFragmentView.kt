package com.yakov.weber.calculator.presenter.paint.main

import com.arellomobile.mvp.MvpView

interface PaintFragmentView : MvpView {
    fun showColorDialog(tagFragment:String)
    fun showWidthDialog(tagFragment:String)
    fun showDeleteDialog(tagFragment:String)
    fun showError(message:String = "")
    fun bindCustomView(visible:Boolean = true)
}