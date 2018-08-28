package com.yakov.weber.calculator.ui.main

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.main.MainActivityPresenter
import com.yakov.weber.calculator.presenter.main.MainActivityView
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.base.BaseActivity
import com.yakov.weber.calculator.ui.calculate.CalculateFragment
import kotlinx.android.synthetic.main.toolbar.*
import toothpick.Toothpick

class MainActivity : BaseActivity(), MainActivityView {

    override val layoutRes: Int
        get() = R.layout.activity_main

    @InjectPresenter
    lateinit var presenter:MainActivityPresenter

    @ProvidePresenter
    fun mainActivityPresenterProvider(): MainActivityPresenter =
            Toothpick.openScope(DI.APP_SCOPE)
                    .getInstance(MainActivityPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(main_toolbar)
        presenter.initFragmentMain()
    }

    override fun initMainFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment, MainFragment())
                .commit()
    }
}