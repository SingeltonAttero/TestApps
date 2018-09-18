package com.yakov.weber.calculator.ui.paint.fragment

import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.ui.base.BaseFragment

class PaintFragment : BaseFragment() {

    companion object {
        fun newInstance() = PaintFragment()
    }
    override val layoutRes: Int
        get() = R.layout.fragment_paint
}