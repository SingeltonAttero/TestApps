package com.yakov.weber.calculator.ui.main

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.main.MainPresenter
import com.yakov.weber.calculator.presenter.main.MainView
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.base.BaseFragment
import com.yakov.weber.calculator.ui.calculate.CalculateActivity
import com.yakov.weber.calculator.ui.flag.activity.MainFlagActivity
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.support.v4.startActivity
import toothpick.Toothpick

class MainFragment : BaseFragment(), MainView {

    override val layoutRes: Int
        get() = R.layout.fragment_main

    @InjectPresenter
    lateinit var presenter: MainPresenter
    @ProvidePresenter
    fun mainPresenterProvider(): MainPresenter = Toothpick.openScope(DI.APP_SCOPES)
            .getInstance(MainPresenter::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_calculate_app.setOnClickListener { presenter.openAppCalculate() }
        button_flag_quiz_app.setOnClickListener { presenter.openAppFlag() }
    }

    override fun openCalculateApp() {
        startActivity<CalculateActivity>()
    }

    override fun openActivityFlag() {
        startActivity<MainFlagActivity>()
    }
}