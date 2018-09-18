package com.yakov.weber.calculator.ui.flag.activity

import android.app.FragmentTransaction
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.flag.activity.FlagMainPresenter
import com.yakov.weber.calculator.presenter.flag.activity.FlagMainView
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.base.BaseActivity
import com.yakov.weber.calculator.ui.flag.activity.setting.SettingsActivity
import com.yakov.weber.calculator.ui.flag.fragment.MainFlagFragment
import com.yakov.weber.calculator.ui.flag.fragment.setting.SettingFragment

import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.startActivity
import toothpick.Toothpick

class MainFlagActivity : BaseActivity(), FlagMainView {

    @InjectPresenter
    lateinit var presenter: FlagMainPresenter
    private var isPhoneDevice = true

    @ProvidePresenter
    fun flagMainPresenterProvider(): FlagMainPresenter = Toothpick
            .openScope(DI.APP_FLAG)
            .getInstance(FlagMainPresenter::class.java)

    override val layoutRes: Int
        get() = R.layout.activity_main_flag

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenSize = resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK
        val screenOrientation = resources.configuration.orientation
        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE && Configuration.ORIENTATION_LANDSCAPE == screenOrientation ||
                screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE && Configuration.ORIENTATION_LANDSCAPE == screenOrientation) {
            isPhoneDevice = false
        }
        requestedOrientation = if (isPhoneDevice) {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        } else {
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
    }

    override fun showText(message: String) {
    }

    override fun onStart() {
        super.onStart()

        if (isPhoneDevice) {
            presenter.setContentPhone()
        } else {
            presenter.setContentTable()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val orientation = resources.configuration.orientation
        return if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            MenuInflater(this).inflate(R.menu.menu_flag_main, menu)
            true
        } else {
            super.onCreateOptionsMenu(menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_settings -> {
                startActivity<SettingsActivity>()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun setSettingFragment() {
        fragmentManager.beginTransaction()
                .replace(R.id.container_setting_flag_fragment, SettingFragment())
                .commit()
    }

    override fun setPhoneFragment() {
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