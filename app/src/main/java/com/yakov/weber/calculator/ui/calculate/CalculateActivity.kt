package com.yakov.weber.calculator.ui.calculate

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.calculate.CalculateActivityPresenter
import com.yakov.weber.calculator.presenter.calculate.CalculateActivityView
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.base.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*
import toothpick.Toothpick

class CalculateActivity : BaseActivity(), CalculateActivityView {

    override val layoutRes: Int
        get() = R.layout.activity_calculate

    @InjectPresenter
    lateinit var activityPresenter: CalculateActivityPresenter

    @ProvidePresenter
    fun calculateActivityPresenterProvider(): CalculateActivityPresenter = Toothpick
            .openScope(DI.APP_SCOPES)
            .getInstance(CalculateActivityPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPresenter.initFragment()
    }
    override fun initCalculateFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment, CalculateFragment())
                .commit()
    }
    override fun setTitleToolbar(message: String) {
        setSupportActionBar(main_toolbar)
        main_toolbar.title = message
    }
}
