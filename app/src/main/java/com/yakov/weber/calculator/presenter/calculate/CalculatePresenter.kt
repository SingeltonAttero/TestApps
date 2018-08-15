package com.yakov.weber.calculator.presenter.calculate

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.base.BasePresenter
import com.yakov.weber.calculator.system.ResManager
import javax.inject.Inject

@InjectViewState
class CalculatePresenter @Inject constructor(private val resManager: ResManager) : BasePresenter<CalculateView>(){

    fun initPresenter(){
        viewState.showResult("Hello")
    }

    fun bindTextSeekBar(percent:Int){
        viewState.showPercent(resManager.getString(R.string.percent,percent))
    }

    fun bindText(message:String){
        viewState.bindText(message)
    }
}