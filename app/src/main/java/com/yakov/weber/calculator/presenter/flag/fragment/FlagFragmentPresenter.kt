package com.yakov.weber.calculator.presenter.flag.fragment

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.extent.printConstruction
import com.yakov.weber.calculator.models.flag.interactor.FlagInteractor
import com.yakov.weber.calculator.presenter.base.BasePresenter
import com.yakov.weber.calculator.system.ResManager
import javax.inject.Inject

@InjectViewState
class FlagFragmentPresenter @Inject constructor(
       private val interactor: FlagInteractor,
       private val resManager: ResManager) : BasePresenter<FlagFragmentView>() {


    init {
        printConstruction()
    }

    override fun attachView(view: FlagFragmentView?) {
        super.attachView(view)
        viewState.showQuestionNumber(interactor.questNumber())
        viewState.showContainerAnswerButton(interactor.getGuessRows())
        viewState.showError(interactor.getSelectFlag().toString())
    }
}