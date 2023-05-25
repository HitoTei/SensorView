package com.example.sensorview.ui.sensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.sensorview.ui.theme.SensorViewTheme

class SensorDetailActivity : ComponentActivity(), SensorEventListener {
    private val viewModel by viewModels<SensorDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        viewModel.sensorType = intent.getIntExtra("sensorType", -1)
        setContent {
            SensorViewTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SensorDetailScreen(viewModel.sensorType, viewModel.sensorValue)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val sensor = viewModel.getSensor()
        if (sensor != null) {
            viewModel.sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.sensorManager?.unregisterListener(this)
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        // FloatArrayのままだとStateで監視できないのでListに変換
        viewModel.sensorValue.value = (sensorEvent?.values ?: return).toList()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Do nothing
    }
}
