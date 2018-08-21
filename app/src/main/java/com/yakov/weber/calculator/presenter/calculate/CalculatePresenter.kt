package com.yakov.weber.calculator.presenter.calculate

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.base.BasePresenter
import com.yakov.weber.calculator.system.ResManager
import javax.inject.Inject

@InjectViewState
class CalculatePresenter @Inject constructor(private val resManager: ResManager) : BasePresenter<CalculateView>(){




    fun initPresenter(default:Int){
        viewState.showPercent(resManager.getString(R.string.percent,default))
    }

    fun bindTextSeekBar(percent:Int){
        viewState.showPercent(resManager.getString(R.string.percent,percent))
    }

    fun calculate(amount:String,percent: String){
        if (!amount.isEmpty()){
            val chipResult = percent.toFloat() * (amount.toFloat() / 100)
            val totalResult = amount.toFloat() + chipResult
            viewState.showChip(resManager.getString(R.string.chip_result,chipResult))
            viewState.showResult(totalResult.toString())
        }

    }

    fun bindText(message:CharSequence){
        if (message.isEmpty())viewState.bindText("")
        viewState.bindText(message)
    }
}