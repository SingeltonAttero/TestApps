package com.yakov.weber.calculator.ui.calculate

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding2.widget.RxSeekBar
import com.jakewharton.rxbinding2.widget.RxTextView
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.calculate.CalculatePresenter
import com.yakov.weber.calculator.presenter.calculate.CalculateView
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.base.BaseFragment
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.fragment_colculate.*
import toothpick.Toothpick
import javax.inject.Singleton

class CalculateFragment : BaseFragment(), CalculateView {

    override val layoutRes: Int
        get() = R.layout.fragment_colculate

    @InjectPresenter
    lateinit var presenter: CalculatePresenter

    @Singleton
    @ProvidePresenter
    fun calculatePresenterProvider(): CalculatePresenter = Toothpick
            .openScope(DI.APP_SCOPE)
            .getInstance(CalculatePresenter::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.initPresenter(percent_seek_bar.progress)
        RxTextView.textChangeEvents(edit_text_input)
                .skipInitialValue()
                .filter { it.text().length < 10 }
                .subscribe ({
                    presenter.bindText(it.text())
                    presenter.calculate(text_view_output_result.text.toString(),percent_seek_bar.progress.toString())
                },{
                    it.printStackTrace()
                }).bind()

         RxSeekBar.userChanges(percent_seek_bar)
                .skipInitialValue()
                .subscribe ({
                    presenter.bindTextSeekBar(it)
                    presenter.calculate(edit_text_input.text.toString(),percent_seek_bar.progress.toString())
                },{
                    it.printStackTrace()
                }).bind()
    }

    override fun showResult(message: String) {
        text_view_result_total.text = message
    }

    override fun showPercent(message: String) {
        percent_text_view.text = message
    }

    override fun showChip(message: String) {
        text_view_result_tip.text = message
    }

    override fun bindText(message: CharSequence) {
        text_view_output_result.text = message
    }



}