package com.yakov.weber.calculator.ui.paint.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.ui.base.BaseFragment
import com.yakov.weber.calculator.ui.paint.dialog.ChangeColorDialog
import com.yakov.weber.calculator.ui.paint.dialog.ChangeWidthDialog
import com.yakov.weber.calculator.ui.paint.dialog.DeleteImageDialog

class PaintFragment : BaseFragment() {

    companion object {
        fun newInstance() = PaintFragment()
    }
    override val layoutRes: Int
        get() = R.layout.fragment_paint

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.change_color -> { ChangeColorDialog().show(fragmentManager, "ColorDialog") }
            R.id.line_width_paint -> { ChangeWidthDialog().show(fragmentManager, "WidthDialog") }
            R.id.remove_paint -> { DeleteImageDialog().show(fragmentManager, "DeleteDialog") }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_paint, menu)
    }
}