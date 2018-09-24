package com.yakov.weber.calculator.presenter.paint.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.yakov.weber.calculator.models.paint.interactor.PaintInteractor
import com.yakov.weber.calculator.presenter.base.BasePresenter
import com.yakov.weber.calculator.system.ResManager
import javax.inject.Inject

@InjectViewState
class PaintFragmentPresenter @Inject constructor(private val resManager: ResManager,
                                                 private val interactor:PaintInteractor) : BasePresenter<PaintFragmentView>() {
    val colorDialog = "ColorDialog"
    val widthDialog = "WidthDialog"
    val deleteDialog = "DeleteDialog"
    private var  dialogVisible:Boolean = true

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun clickFragment(fragmentTag:String){
        when(fragmentTag){
            colorDialog -> { viewState.showColorDialog(fragmentTag) }
            widthDialog -> {viewState.showWidthDialog(fragmentTag)}
            deleteDialog -> {viewState.showDeleteDialog(fragmentTag)}
        }
    }

    fun calculateTheAcceleration(current: Float) {
        interactor.theAcceleration(current)
    }

}