package com.yakov.weber.calculator.ui.flag.fragment

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.flag.fragment.FlagFragmentPresenter
import com.yakov.weber.calculator.presenter.flag.fragment.FlagFragmentView
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main_flag.*
import toothpick.Toothpick

class MainFlagFragment : BaseFragment(), FlagFragmentView {

    @InjectPresenter
    lateinit var presenter: FlagFragmentPresenter

    @ProvidePresenter
    fun flagFragmentPresenter(): FlagFragmentPresenter = Toothpick
            .openScope(DI.APP_FLAG)
            .getInstance(FlagFragmentPresenter::class.java)

    companion object {
        fun newInstance() = MainFlagFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_main_flag

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun showError(message: String) {

    }
}