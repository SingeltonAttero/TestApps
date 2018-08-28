package com.yakov.weber.calculator.presenter.main

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.calculator.presenter.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter @Inject constructor() : BasePresenter<MainActivityView>() {
    fun initFragmentMain(){
        viewState.initMainFragment()
    }
}