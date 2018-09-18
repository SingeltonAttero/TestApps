package com.yakov.weber.calculator.presenter.flag.fragment

import com.arellomobile.mvp.MvpView
import java.io.InputStream

interface FlagFragmentView : MvpView {
    fun showCorrectAnswer(message: String, countRow: IntRange)
    fun showContainerAnswerButton(countRow: IntRange)
    fun showQuestionNumber(message: String)
    fun setFlagStream(stream: InputStream, nameFlag: String)
    fun showButtonFlagAnswer(listFlag: List<String>, countRow: IntRange)
    fun showRandomButtonCorrectAnswer(row: Int, column: Int, correctAnswer: String)
    fun startAnimate(animateOut: Boolean)
    fun showFinishDialog(totalCount: Int)
    fun showIncorrectAnswer(message: String = "")
}