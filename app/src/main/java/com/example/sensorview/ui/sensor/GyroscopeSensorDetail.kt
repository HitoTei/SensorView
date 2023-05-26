package com.example.sensorview.ui.sensor

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GyroscopeSensorDetail(value: List<Float>, modifier: Modifier = Modifier) {
    val axisX = value[0]
    val axisY = value[1]
    val axisZ = value[2]

    Column(modifier) {
        Text("Gyroscope")
        Text("x: $axisX, y: $axisY, z: $axisZ")
    }
}