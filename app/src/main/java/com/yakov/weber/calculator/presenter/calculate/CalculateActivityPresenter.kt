package com.yakov.weber.calculator.presenter.calculate

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.base.BasePresenter
import com.yakov.weber.calculator.system.ResManager
import javax.inject.Inject

@InjectViewState
class CalculateActivityPresenter @Inject constructor(private val resManager: ResManager) : BasePresenter<CalculateActivityView>() {
    fun initFragment() {
        viewState.initCalculateFragment()
        viewState.setTitleToolbar(resManager.getString(R.string.calculate_app))
    }
}