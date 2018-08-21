package com.yakov.weber.calculator.presenter.calculate

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.base.BasePresenter
import com.yakov.weber.calculator.system.ResManager
import javax.inject.Inject

@InjectViewState
class CalculatePresenter @Inject constructor(val resManager: ResManager) : BasePresenter<CalculateView>(){

    private var defaultPercent = 0.1F
    private var amountDigits = 0.0F


    fun initPresenter(default:Int){
        viewState.showPercent(default.toString())
        defaultPercent = (default / 100).toFloat()
    }

    fun bindTextSeekBar(percent:Int){
        viewState.showPercent(resManager.getString(R.string.percent,percent))
    }

    fun calculate(){
        val resultTip = amountDigits * defaultPercent
        val resultTotal = resultTip + amountDigits
        viewState.showChip(resultTip.toString())
        viewState.showResult(resultTotal.toString())
    }

    fun bindText(message:CharSequence){
        amountDigits = message.toString().toFloat()
        viewState.bindText(message)
    }
}