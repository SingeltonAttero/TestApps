package com.yakov.weber.calculator.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.widget.RxTextView
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.extent.alsoPrintDebug
import com.yakov.weber.calculator.extent.inflate
import kotlinx.android.synthetic.main.fragment_colculate.*

class CalculateFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.fragment_colculate)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RxTextView.textChangeEvents(edit_text_input)
                .skipInitialValue()
                .filter { it.text().length <= 10 }
                .subscribe { text_view_output_result.text = it.text().alsoPrintDebug("TAG_TIMBER") }

    }
}