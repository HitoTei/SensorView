package com.example.sensorview.ui.sensor

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SensorDetailViewModel : ViewModel() {
    var sensorType: Int = -1
    var sensorManager: SensorManager? = null

    val sensorValue = MutableLiveData<List<Float>>()

    fun getSensor(): Sensor? {
        return sensorManager?.getDefaultSensor(sensorType)
    }
}