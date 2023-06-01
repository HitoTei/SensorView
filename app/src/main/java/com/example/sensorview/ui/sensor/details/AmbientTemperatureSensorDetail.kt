package com.example.sensorview.ui.sensor.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AmbientTemperatureSensorDetail(value: List<Float>, modifier: Modifier = Modifier) {
    val temperature = value[0]
    Column(modifier) {
        Text("Temperature")
        Text("$temperature °C")
    }
}