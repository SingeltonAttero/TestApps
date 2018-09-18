package com.yakov.weber.calculator.ui.flag.fragment

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.AlertDialog
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.presenter.flag.fragment.FlagFragmentPresenter
import com.yakov.weber.calculator.presenter.flag.fragment.FlagFragmentView
import com.yakov.weber.calculator.toothpick.DI
import com.yakov.weber.calculator.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main_flag.*
import toothpick.Toothpick
import java.io.InputStream

class MainFlagFragment : BaseFragment(), FlagFragmentView, View.OnClickListener {

    companion object {
        private val TAG = MainFlagFragment::class.java.simpleName
        fun newInstance() = MainFlagFragment()
    }

    private lateinit var animation: Animation
    private var listContainerButton = arrayListOf<LinearLayout>()

    @InjectPresenter
    lateinit var presenter: FlagFragmentPresenter

    @ProvidePresenter
    fun flagFragmentPresenter(): FlagFragmentPresenter = Toothpick
            .openScope(DI.APP_FLAG)
            .getInstance(FlagFragmentPresenter::class.java)

    override val layoutRes: Int
        get() = R.layout.fragment_main_flag

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(false)
        presenter.loadNextFlag()
        initField()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    private fun initField() {
        animation = AnimationUtils.loadAnimation(activity, R.anim.snake_anim_button_flag)
        animation.repeatCount = 3
        listContainerButton.addAll(listOf(row1_button_container, row2_button_container, row3_button_container, row4_button_container))
        listContainerButton.forEach { container ->
            (0 until container.childCount)
                    .forEach { container.getChildAt(it).setOnClickListener(this) }
        }
    }

    override fun onClick(v: View) {
        val button = v as Button
        presenter.checkAnswer(button.text.toString())
        button.isEnabled = presenter.isEnabledButton
    }

    override fun startAnimate(animateOut: Boolean) {
        val animator: Animator
        val centerX = (container_main_flag_constraint.left + container_main_flag_constraint.right) / 2
        val centerY = (container_main_flag_constraint.top + container_main_flag_constraint.bottom) / 2
        val radius = Math.max(container_main_flag_constraint.height, container_main_flag_constraint.width).toFloat()
        if (animateOut) {
            animator = ViewAnimationUtils.createCircularReveal(container_main_flag_constraint,
                    centerX, centerY, radius, 0F)
            animator.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    presenter.loadNextFlag()
                }
            })
        } else {
            animator = ViewAnimationUtils.createCircularReveal(container_main_flag_constraint, centerX, centerY, 0F, radius)
        }
        animator.duration = 700
        animator.start()
    }

    override fun showRandomButtonCorrectAnswer(row: Int, column: Int, correctAnswer: String) {
        val correctButton = listContainerButton[row].getChildAt(column) as Button
        correctButton.text = correctAnswer
    }

    override fun showButtonFlagAnswer(listFlag: List<String>, countRow: IntRange) {
        countRow.forEach {
            for (column in 0 until listContainerButton[it].childCount) {
                val button = listContainerButton[it].getChildAt(column) as Button
                button.isEnabled = true
                val filename = listFlag[(it * 2) + column]
                button.text = filename
            }
        }
    }

    override fun setFlagStream(stream: InputStream, nameFlag: String) {
        flag_image_view.setImageDrawable(Drawable.createFromStream(stream, nameFlag))
        stream.close()
    }

    override fun showContainerAnswerButton(countRow: IntRange) {
        listContainerButton.forEach { it.visibility = View.GONE }
        countRow.forEach { listContainerButton[it].visibility = View.VISIBLE }
    }

    override fun showQuestionNumber(message: String) {
        question_number_text_view.text = message
        answer_text_view.text = null
    }

    override fun showCorrectAnswer(message: String, countRow: IntRange) {
        answer_text_view.text = message
        answer_text_view.setTextColor(ContextCompat.getColor(this.context!!, R.color.colorPrimary))
        disableButtons(countRow)
    }

    private fun disableButtons(countButton: IntRange) {
        countButton.forEach {
            val linearLayout = listContainerButton[it]
            for (i in 0 until linearLayout.childCount) {
                linearLayout.getChildAt(i).isEnabled = false
            }
        }
    }

    override fun showFinishDialog(totalCount: Int) {
        val dialog = AlertDialog.Builder(activity).apply {
            this.setMessage(getString(R.string.results, totalCount, (1000 / totalCount).toDouble()))
            this.setPositiveButton(R.string.reset_quiz) { _, _ -> presenter.resetQuiz() }
        }.create()
        dialog.setCancelable(false)
        dialog.show()
    }

    override fun showIncorrectAnswer(message: String) {
        flag_image_view.startAnimation(animation)
        answer_text_view.startAnimation(animation)
        answer_text_view.text = message
        answer_text_view.setTextColor(ContextCompat.getColor(this.context!!, R.color.red_error))
    }
}