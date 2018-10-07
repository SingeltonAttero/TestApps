package com.yakov.weber.calculator.cicerone

import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.calculate.CalculateFragment
import com.yakov.weber.calculator.ui.flag.fragment.MainFlagFragment
import com.yakov.weber.calculator.ui.paint.fragment.PaintFragment
import kotlinx.android.synthetic.main.activity_cicerone.*
import org.jetbrains.anko.toast
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import toothpick.Toothpick
import javax.inject.Inject

class TestActivity : MvpAppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cicerone)
        Toothpick.inject(this, Toothpick.openScope(DI.APP_SCOPES))
        fragment_two.setOnClickListener { router.navigateTo(mainFlagFragment)}
        fragment_one.setOnClickListener { router.navigateTo(calculateFragment) }
        fragment_three.setOnClickListener { router.navigateTo("trw") }

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    private val navigator = object : SupportFragmentNavigator(supportFragmentManager, R.id.cicerone_container) {
        override fun exit() {
            finish()
        }

        override fun showSystemMessage(message: String) {
            toast(message)
        }

        override fun createFragment(screenKey: String?, data: Any?): Fragment = when (screenKey) {
            calculateFragment -> CalculateFragment()
            mainFlagFragment -> MainFlagFragment.newInstance()
            else -> PaintFragment()
        }
    }


}