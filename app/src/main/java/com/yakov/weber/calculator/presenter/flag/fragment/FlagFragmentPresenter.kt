package com.yakov.weber.calculator.presenter.flag.fragment

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.calculator.R
import com.yakov.weber.calculator.extent.printConstruction
import com.yakov.weber.calculator.models.flag.interactor.FlagInteractor
import com.yakov.weber.calculator.presenter.base.BasePresenter
import com.yakov.weber.calculator.system.ResManager
import javax.inject.Inject

@InjectViewState
class FlagFragmentPresenter @Inject constructor(
    private val interactor: FlagInteractor,
    private val resManager: ResManager
) : BasePresenter<FlagFragmentView>() {

    private var correctAnswer = ""
    private var correctAnswersCount = 0
    private var totalCount = 0
    private var fileNameList = mutableListOf<String>()

    var isEnabledButton: Boolean = true
        private set

    init {
        printConstruction()
        fileNameList = interactor.getSelectFlag()
    }

    override fun attachView(view: FlagFragmentView?) {
        super.attachView(view)
        viewState.showContainerAnswerButton(interactor.getGuessRowsRange())
    }

    fun resetQuiz() {
        fileNameList.clear()
        fileNameList = interactor.getSelectFlag()
        correctAnswer = ""
        correctAnswersCount = 0
        totalCount = 0
        loadNextFlag()
    }

    fun loadNextFlag() {
        val nextImage = fileNameList.removeAt(0)
        correctAnswer = nextImage
        viewState.showQuestionNumber(interactor.questNumber(correctAnswersCount + 1))
        val region = nextImage.substring(0, nextImage.indexOf("-"))
        viewState.setFlagStream(interactor.getImage(region, nextImage), nextImage)
        startAnimate(false)
        val correct = interactor.getAllCountryFlag().indexOf(correctAnswer)
        val listAllFlag = interactor.getAllCountryFlag()
        listAllFlag.shuffle()
        listAllFlag.add(listAllFlag.removeAt(correct))
        viewState.showButtonFlagAnswer(listAllFlag.map { interactor.getCounterName(it) }, interactor.getGuessRowsRange())
        viewState.showRandomButtonCorrectAnswer(interactor.randomNumber(interactor.getGuessRows()),
                interactor.randomNumber(2), interactor.getCounterName(correctAnswer))
    }

    fun checkAnswer(guess: String) {
        val answerLocal = interactor.getCounterName(correctAnswer)
        ++totalCount
        if (answerLocal == guess) {
            correctAnswersCount++
            viewState.showCorrectAnswer("$answerLocal!", interactor.getGuessRowsRange())
            when (correctAnswersCount) {
                FlagInteractor.FLAG_IN_COUNT -> {
                    isEnabledButton = false
                    viewState.showFinishDialog(totalCount)
                }
                else -> {
                    isEnabledButton = false
                    interactor.delayLoadFlag().subscribe {
                        viewState.startAnimate(true)
                    }.bind()
                }
            }
        } else {
            viewState.showIncorrectAnswer(resManager.getString(R.string.incorrect_answer))
            isEnabledButton = false
        }
    }

    private fun startAnimate(animateOut: Boolean) {
        if (correctAnswersCount == 0) return
        viewState.startAnimate(animateOut)
    }
}