package com.example.sensorview.ui.sensor.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LightSensorDetail(value: List<Float>, modifier: Modifier = Modifier) {
    val lux = value[0]

    Column(modifier) {
        Text("Light")
        Text("$lux lx")
    }
}