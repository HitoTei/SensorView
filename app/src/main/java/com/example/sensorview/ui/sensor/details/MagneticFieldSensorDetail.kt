package com.example.sensorview.ui.sensor.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MagneticFieldSensorDetail(value: List<Float>, modifier: Modifier = Modifier) {
    val x = value[0]
    val y = value[1]
    val z = value[2]

    Column(modifier) {
        Text("MagneticField")
        Text("x: $x, y: $y, z: $z")
    }
}