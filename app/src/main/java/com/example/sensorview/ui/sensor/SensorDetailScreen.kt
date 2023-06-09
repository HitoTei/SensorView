package com.example.sensorview.ui.sensor

import android.hardware.Sensor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import com.example.sensorview.ui.sensor.details.AccelerometerSensorDetail
import com.example.sensorview.ui.sensor.details.AmbientTemperatureSensorDetail
import com.example.sensorview.ui.sensor.details.GravitySensorDetail
import com.example.sensorview.ui.sensor.details.GyroscopeSensorDetail
import com.example.sensorview.ui.sensor.details.LightSensorDetail
import com.example.sensorview.ui.sensor.details.MagneticFieldSensorDetail
import com.example.sensorview.ui.sensor.details.PressureSensorDetail

@Composable
fun SensorDetailScreen(sensorType: Int, value: LiveData<List<Float>>) {
    val sensorValue by value.observeAsState()

    sensorValue.let {
        if (it == null) {
            Text("Loading...")
        } else {
            when (sensorType) {
                Sensor.TYPE_ACCELEROMETER -> AccelerometerSensorDetail(it)
                Sensor.TYPE_AMBIENT_TEMPERATURE -> AmbientTemperatureSensorDetail(it)
                Sensor.TYPE_GRAVITY -> GravitySensorDetail(it)
                Sensor.TYPE_GYROSCOPE -> GyroscopeSensorDetail(it)
                Sensor.TYPE_LIGHT -> LightSensorDetail(it)
                Sensor.TYPE_MAGNETIC_FIELD -> MagneticFieldSensorDetail(it)
                Sensor.TYPE_PRESSURE -> PressureSensorDetail(it)
                else -> Text("Not implemented yet")
            }
        }
    }

}