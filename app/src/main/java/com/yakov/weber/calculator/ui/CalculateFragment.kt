package com.yakov.weber.calculator.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding2.widget.RxTextView
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.extent.alsoPrintDebug
import com.yakov.weber.calculator.extent.inflate
import com.yakov.weber.calculator.presenter.calculate.CalculatePresenter
import com.yakov.weber.calculator.presenter.calculate.CalculateView
import com.yakov.weber.calculator.toothpick.DI
import kotlinx.android.synthetic.main.fragment_colculate.*
import toothpick.Toothpick

class CalculateFragment : Fragment(), CalculateView {

    @InjectPresenter
    lateinit var presenter: CalculatePresenter
    @ProvidePresenter
    fun calculatePresenterProvider(): CalculatePresenter = Toothpick
            .openScope(DI.APP_SCOPE)
            .getInstance(CalculatePresenter::class.java)


    override fun showResult(message: String) {

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_colculate)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RxTextView.textChangeEvents(edit_text_input)
                .skipInitialValue()
                .filter { it.text().length <= 10 }
                .subscribe { text_view_output_result.text = it.text().alsoPrintDebug("TAG_TIMBER") }
    }
}