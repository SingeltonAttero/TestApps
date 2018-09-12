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
        private val resManager: ResManager) : BasePresenter<FlagFragmentView>() {

    private var correctAnswer = ""
    private var correctAnswersCount = 0
    private var totalCount = 0

    init {
        printConstruction()
    }

    override fun attachView(view: FlagFragmentView?) {
        super.attachView(view)
        viewState.showContainerAnswerButton(interactor.getGuessRowsRange())
    }

    fun loadNextFlag() {
        val nextImage = interactor.getSelectFlag().removeAt(0)
        correctAnswer = nextImage
        viewState.showQuestionNumber(interactor.questNumber(correctAnswersCount))

        correctAnswersCount++

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
            viewState.showCorrectAnswer("$answerLocal!")
            if (correctAnswersCount == FlagInteractor.FLAG_IN_COUNT) {
                viewState.showFinishDialog(totalCount)
            } else {
                interactor.delayLoadFlag().subscribe {
                    viewState.startAnimate(true)
                }.bind()
            }
        } else {
            viewState.showIncorrectAnswer(resManager.getString(R.string.incorrect_answer))
           //TODO test
            if (totalCount % 2 == 0)loadNextFlag()
            if (correctAnswersCount == FlagInteractor.FLAG_IN_COUNT) {
                viewState.showFinishDialog(totalCount)
            }
            // end
        }

    }

    private fun startAnimate(animateOut: Boolean) {
        if (correctAnswersCount == 1) return
        viewState.startAnimate(animateOut)

    }

}