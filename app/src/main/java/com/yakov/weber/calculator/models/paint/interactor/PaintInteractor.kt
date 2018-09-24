package com.yakov.weber.calculator.models.paint.interactor

import android.hardware.SensorManager
import javax.inject.Inject

class PaintInteractor @Inject constructor() {
    companion object {
        const val ACCELERATION_THRESHOLD = 1000
    }
    private var acceleration:Float = 0.0f
    private var currentAcceleration:Float = SensorManager.GRAVITY_EARTH
    private var lastAcceleration:Float = SensorManager.GRAVITY_EARTH

    fun theAcceleration(current: Float): Float {
        lastAcceleration = currentAcceleration

        currentAcceleration = current

        acceleration = currentAcceleration * (currentAcceleration * lastAcceleration)

        return acceleration
    }

}