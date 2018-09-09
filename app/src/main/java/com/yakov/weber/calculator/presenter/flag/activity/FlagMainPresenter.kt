package com.yakov.weber.calculator.presenter.flag.activity

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.models.flag.prefs.Prefs
import com.yakov.weber.calculator.presenter.base.BasePresenter
import com.yakov.weber.calculator.system.ResManager
import javax.inject.Inject

@InjectViewState
class FlagMainPresenter @Inject constructor(
        private val resManager: ResManager) : BasePresenter<FlagMainView>() {

    fun setContentPhone() {
        viewState.setTitleToolbar(resManager.getString(R.string.flag_quiz))
        viewState.setPhoneFragment()
    }

    fun setContentTable(){
        viewState.setTitleToolbar(resManager.getString(R.string.flag_quiz))
        viewState.setPhoneFragment()
        viewState.setSettingFragment()
    }

}