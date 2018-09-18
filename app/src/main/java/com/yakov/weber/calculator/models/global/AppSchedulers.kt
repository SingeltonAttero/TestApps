package com.yakov.weber.calculator.models.global

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AppSchedulers : SchedulersProvider {
    override fun ui(): Scheduler = Schedulers.io()

    override fun newThread(): Scheduler = Schedulers.newThread()

    override fun io(): Scheduler = AndroidSchedulers.mainThread()
}