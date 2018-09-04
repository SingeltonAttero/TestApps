package com.yakov.weber.calculator.ui.flag.activity

import android.app.FragmentTransaction
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.flag.activity.FlagMainPresenter
import com.yakov.weber.calculator.presenter.flag.activity.FlagMainView
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.base.BaseActivity
import com.yakov.weber.calculator.ui.flag.fragment.MainFlagFragment

import kotlinx.android.synthetic.main.toolbar.*
import toothpick.Toothpick

class MainFlagActivity : BaseActivity(), FlagMainView {

    @InjectPresenter
    lateinit var presenter: FlagMainPresenter

    @ProvidePresenter
    fun flagMainPresenterProvider(): FlagMainPresenter = Toothpick
            .openScope(DI.APP_FLAG)
            .getInstance(FlagMainPresenter::class.java)

    override val layoutRes: Int
        get() = R.layout.activity_main_flag

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setContent()
    }

    override fun showText(message: String) {
    }

    override fun showFragment() {
        val fragment = MainFlagFragment.newInstance()
        supportFragmentManager.beginTransaction()
                .replace(R.id.container_flag_fragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
    }

    override fun setTitleToolbar(title: String) {
        setSupportActionBar(main_toolbar)
        main_toolbar.title = title
    }
}