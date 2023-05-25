package com.example.sensorview

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SensorList(sensorManager: SensorManager, onSensorClick: (Int) -> Unit, modifier: Modifier) {
    sensorManager.getSensorList(Sensor.TYPE_ALL)
    Column(modifier) {
        for (sensor in sensorManager.getSensorList(Sensor.TYPE_ALL)) {
            Button(onClick = { onSensorClick(sensor.type) }) {
                Text(text = sensor.name)
            }
        }
    }
}
