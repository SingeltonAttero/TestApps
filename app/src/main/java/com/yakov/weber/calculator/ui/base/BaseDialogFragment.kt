package com.yakov.weber.calculator.ui.base

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import com.yakov.weber.calculator.system.global.GroupDisposableComponent
import com.yakov.weber.calculator.system.global.GroupDisposableComponentImpl
import timber.log.Timber

abstract class BaseDialogFragment : MvpAppCompatDialogFragment(), GroupDisposableComponent by GroupDisposableComponentImpl() {

    abstract val builder: AlertDialog.Builder
    abstract val simpleClassName: String

    private fun log(message: String) {
        Timber.w("$message $simpleClassName")
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        log("onCreateDialog")
        return builder.create()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        log("onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        log("onDetach")
        clear()
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        log("onDismiss")
    }
}