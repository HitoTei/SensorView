package com.example.sensorview.ui.sensor

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AccelerometerSensorDetail(sensorValue: List<Float>, modifier: Modifier = Modifier) {
    val x = sensorValue[0]
    val y = sensorValue[1]
    val z = sensorValue[2]
    Column(modifier) {
        Text("Accelerometer")
        Text("x: $x, y: $y, z: $z")
    }
}
