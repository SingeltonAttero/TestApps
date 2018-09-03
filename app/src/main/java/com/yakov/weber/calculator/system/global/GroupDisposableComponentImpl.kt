package com.yakov.weber.calculator.system.global

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class GroupDisposableComponentImpl : GroupDisposableComponent {

    override val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    override fun Disposable.bind() {
        compositeDisposable.add(this)
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}