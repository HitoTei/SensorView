package com.example.sensorview.ui.sensor

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun PressureSensorDetail(value: List<Float>, modifier: Modifier = Modifier) {
    val pressure = value[0]

    Column(modifier) {
        Text("Pressure")
        Text("$pressure hPa")
    }
}