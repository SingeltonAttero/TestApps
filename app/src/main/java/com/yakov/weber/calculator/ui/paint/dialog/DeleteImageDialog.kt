package com.yakov.weber.calculator.ui.paint.dialog

import android.support.v7.app.AlertDialog
import com.yakov.weber.calculator.ui.base.BaseDialogFragment

class DeleteImageDialog : BaseDialogFragment() {
    override val builder: AlertDialog.Builder
        get() = AlertDialog.Builder(this.activity!!).apply {
            setTitle("TEST DELETE")
            setMessage("DELETE")
            setNegativeButton("NO", null)
            setPositiveButton("OK", null)
            setNeutralButton("SAVE", null)
        }
    override val simpleClassName: String
        get() = this::class.java.simpleName
}