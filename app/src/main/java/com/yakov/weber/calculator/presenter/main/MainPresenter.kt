package com.yakov.weber.calculator.presenter.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.yakov.weber.calculator.presenter.base.BasePresenter
import javax.inject.Inject
@StateStrategyType(SkipStrategy::class)
@InjectViewState
class MainPresenter @Inject constructor() : BasePresenter<MainView>()