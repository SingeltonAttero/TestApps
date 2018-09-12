package com.yakov.weber.calculator.models.global

import io.reactivex.Scheduler

interface SchedulersProvider {
    fun ui(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler
}