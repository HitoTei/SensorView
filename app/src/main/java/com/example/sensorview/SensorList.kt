package com.example.sensorview

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SensorList(sensorManager: SensorManager, onTileClick: (Int) -> Unit, modifier: Modifier) {
    sensorManager.getSensorList(Sensor.TYPE_ALL)
    Column(modifier.verticalScroll(rememberScrollState())) {
        for (sensor in sensorManager.getSensorList(Sensor.TYPE_ALL)) {
            Button(onClick = { onTileClick(sensor.type) }) {
                Text(text = sensor.name)
            }
        }
    }
}
