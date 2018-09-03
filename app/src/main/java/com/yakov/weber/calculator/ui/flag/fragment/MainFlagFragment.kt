package com.yakov.weber.calculator.ui.flag.fragment

import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.ui.base.BaseFragment

class MainFlagFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFlagFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_main_flag
}