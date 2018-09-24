package com.yakov.weber.calculator.ui.paint.fragment

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorEventListener2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.paint.main.PaintFragmentPresenter
import com.yakov.weber.calculator.presenter.paint.main.PaintFragmentView
import com.yakov.weber.calculator.system.view.PaintView
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.base.BaseFragment
import com.yakov.weber.calculator.ui.paint.dialog.ChangeColorDialog
import com.yakov.weber.calculator.ui.paint.dialog.ChangeWidthDialog
import com.yakov.weber.calculator.ui.paint.dialog.DeleteImageDialog
import kotlinx.android.synthetic.main.fragment_paint.*
import org.jetbrains.anko.support.v4.toast
import toothpick.Toothpick

class PaintFragment : BaseFragment(), PaintFragmentView {

    companion object {
        const val SAVE_IMAGE_PERMISSION_REQUEST_CODE = 1
        fun newInstance() = PaintFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_paint

    private val paintView: PaintView
        get() = paint_view

    @InjectPresenter
    lateinit var presenter: PaintFragmentPresenter

    @ProvidePresenter
    fun paintFragmentPresenterProvide(): PaintFragmentPresenter = Toothpick
            .openScope(DI.APP_SCOPES)
            .getInstance(PaintFragmentPresenter::class.java)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

    }

    val sensorEventListener: SensorEventListener
        get() = object : SensorEventListener{
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }

            override fun onSensorChanged(event: SensorEvent?) {
                val x = event?.values?.get(0)
                val y = event?.values?.get(1)
                val z = event?.values?.get(2)
                presenter.calculateTheAcceleration((x?.times(x) ?: 0F) + (y?.times(y) ?: 0F) + (z?.times(z) ?: 0F))
            }

        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.change_color -> {
                presenter.clickFragment(presenter.colorDialog)
            }
            R.id.line_width_paint -> {
                presenter.clickFragment(presenter.widthDialog)
            }
            R.id.remove_paint -> {
                presenter.clickFragment(presenter.deleteDialog)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_paint, menu)
    }

    override fun showColorDialog(tagFragment: String) {
        ChangeColorDialog().show(fragmentManager, tagFragment)
    }

    override fun showWidthDialog(tagFragment: String) {
        ChangeWidthDialog().show(fragmentManager, tagFragment)
    }

    override fun showDeleteDialog(tagFragment: String) {
        DeleteImageDialog().show(fragmentManager, tagFragment)
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun bindCustomView(visible: Boolean) {

    }
}