package com.yakov.weber.calculator.presenter.flag.fragment

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.calculator.extent.printConstruction
import com.yakov.weber.calculator.models.flag.interactor.FlagInteractor
import com.yakov.weber.calculator.presenter.base.BasePresenter
import com.yakov.weber.calculator.system.ResManager
import java.util.*
import javax.inject.Inject

@InjectViewState
class FlagFragmentPresenter @Inject constructor(
        private val interactor: FlagInteractor,
        private val resManager: ResManager) : BasePresenter<FlagFragmentView>() {

    private var correctAnswer = ""
    private var correctAnswersCount = 0

    init {
        printConstruction()
    }

    override fun attachView(view: FlagFragmentView?) {
        super.attachView(view)
        viewState.showContainerAnswerButton(interactor.getGuessRowsRange())
        loadNextFlag()

    }

    fun loadNextFlag() {
        val nextImage = interactor.getSelectFlag().removeAt(0)
        correctAnswer = nextImage
        viewState.showQuestionNumber(interactor.questNumber(correctAnswersCount))
        correctAnswersCount++

        val region = nextImage.substring(0, nextImage.indexOf("-"))
        viewState.setFlagStream(interactor.getImage(region, nextImage), nextImage)
        // TODO test
        val correct = interactor.getAllCountryFlag().indexOf(correctAnswer)
        val listAllFlag = interactor.getAllCountryFlag()
        listAllFlag.shuffle()
        listAllFlag.add(interactor.getAllCountryFlag().removeAt(correct))
        viewState.showButtonFlagAnswer(listAllFlag.map { interactor.getCounterName(it) }, interactor.getGuessRowsRange())
        viewState.showRandomButtonCorrectAnswer(interactor.randomNumber(interactor.getGuessRows()),
                interactor.randomNumber(2), interactor.getCounterName(correctAnswer))

    }

}