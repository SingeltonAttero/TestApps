package com.yakov.weber.calculator.system.global

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface GroupDisposableComponent {

    val compositeDisposable: CompositeDisposable

    fun Disposable.bind()

    fun clear()
}