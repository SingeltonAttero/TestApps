package com.yakov.weber.calculator.ui.paint.activity

import android.os.Bundle
import android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import android.view.Menu
import android.view.MenuItem
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.ui.base.BaseActivity
import com.yakov.weber.calculator.ui.paint.fragment.PaintFragment
import kotlinx.android.synthetic.main.toolbar.*

class PaintActivity : BaseActivity() {
    override val layoutRes: Int
        get() = R.layout.activity_paint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.title = getString(R.string.draftsman)
        supportFragmentManager.beginTransaction()
                .replace(R.id.paint_fragment_container, PaintFragment.newInstance())
                .setTransition(TRANSIT_FRAGMENT_FADE)
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        main_toolbar.inflateMenu(R.menu.menu_paint)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.change_color -> { onBackPressed() }
        }

        return super.onOptionsItemSelected(item)
    }
}
