package com.yakov.weber.calculator.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.yakov.weber.calculator.extent.inflate
import com.yakov.weber.calculator.system.global.GroupDisposableComponent
import com.yakov.weber.calculator.system.global.GroupDisposableComponentImpl

abstract class BaseFragment : MvpAppCompatFragment(), GroupDisposableComponent by GroupDisposableComponentImpl(){

    abstract val layoutRes: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(layoutRes)
    }

    protected open fun restoreState(bundle:Bundle){}

    override fun onDestroyView() {
        super.onDestroyView()
        clear()
    }

}