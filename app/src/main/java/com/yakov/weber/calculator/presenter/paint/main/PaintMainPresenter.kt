package com.yakov.weber.calculator.presenter.paint.main

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.base.BasePresenter
import com.yakov.weber.calculator.system.ResManager
import javax.inject.Inject

@InjectViewState
class PaintMainPresenter @Inject constructor(private val resManager: ResManager) : BasePresenter<PaintMainActivityView>() {

    override fun attachView(view: PaintMainActivityView?) {
        super.attachView(view)
        viewState.setTitle(resManager.getString(R.string.draftsman))
        viewState.showFragment()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setOrientationLayout()
    }

}