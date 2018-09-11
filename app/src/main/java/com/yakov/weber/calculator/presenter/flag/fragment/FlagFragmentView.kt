package com.yakov.weber.calculator.presenter.flag.fragment

import android.content.res.AssetManager
import com.arellomobile.mvp.MvpView
import java.io.InputStream

interface FlagFragmentView : MvpView {
    fun showError(message: String)
    fun showContainerAnswerButton(countRow:IntRange)
    fun showQuestionNumber(message: String)
    fun setFlagStream(stream: InputStream,nameFlag:String)
    fun showButtonFlagAnswer(listFlag:List<String>,countRow:IntRange)
    fun showRandomButtonCorrectAnswer(row:Int,column:Int,correctAnswer:String)
}