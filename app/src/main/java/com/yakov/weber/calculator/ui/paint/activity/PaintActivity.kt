package com.yakov.weber.calculator.ui.paint.activity

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.paint.main.PaintMainActivityView
import com.yakov.weber.calculator.presenter.paint.main.PaintMainPresenter
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.base.BaseActivity
import com.yakov.weber.calculator.ui.paint.fragment.PaintFragment
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.toast
import toothpick.Toothpick

class PaintActivity : BaseActivity() , PaintMainActivityView {
    override val layoutRes: Int
        get() = R.layout.activity_paint

    @InjectPresenter
    lateinit var presenter:PaintMainPresenter

    @ProvidePresenter
    fun paintMainPresenter(): PaintMainPresenter = Toothpick
            .openScope(DI.APP_SCOPES)
            .getInstance(PaintMainPresenter::class.java)

    override fun setOrientationLayout() {
        val screenSize = resources.configuration.screenLayout or Configuration.SCREENLAYOUT_SIZE_MASK
        requestedOrientation = if (screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE){
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }else{
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

    }

    override fun showFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.paint_fragment_container, PaintFragment.newInstance())
                .setTransition(TRANSIT_FRAGMENT_FADE)
                .commit()
    }

    override fun setTitle(message: String) {
        toolbar.title = message
    }

    override fun setError(message: String) {
        toast(message)
    }

}
