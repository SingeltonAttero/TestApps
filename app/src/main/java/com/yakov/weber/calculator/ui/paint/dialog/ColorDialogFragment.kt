package com.yakov.weber.calculator.ui.paint.dialog

import android.support.v7.app.AlertDialog
import com.yakov.weber.calculator.R

import com.yakov.weber.calculator.ui.base.BaseDialogFragment

class ColorDialogFragment : BaseDialogFragment() {

    override val builder: AlertDialog.Builder
        get() = AlertDialog.Builder(this.activity!!).apply {
                setView(R.layout.dialog_color)
                setPositiveButton("Ok",null)
        }

    override val simpleClassName: String
        get() = this::class.java.simpleName

}