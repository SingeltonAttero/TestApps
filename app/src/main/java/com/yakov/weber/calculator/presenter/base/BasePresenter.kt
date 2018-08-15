package com.yakov.weber.calculator.presenter.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.yakov.weber.calculator.system.global.GroupDisposableComponent
import com.yakov.weber.calculator.system.global.GroupDisposableComponentImpl

open class BasePresenter<V : MvpView> : MvpPresenter<V>(), GroupDisposableComponent by GroupDisposableComponentImpl() {

    override fun onDestroy() {
        super.onDestroy()
        clear()
    }


}