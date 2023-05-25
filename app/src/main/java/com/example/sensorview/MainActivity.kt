package com.example.sensorview

import android.content.Intent
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.sensorview.ui.sensor.SensorDetailActivity
import com.example.sensorview.ui.theme.SensorViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        setContent {
            SensorViewTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SensorList(sensorManager = sensorManager, onSensorClick = { sensorType ->
                        val intent = Intent(this, SensorDetailActivity::class.java).apply {
                            putExtra("sensorType", sensorType)
                        }
                        this.startActivity(intent)
                    }, modifier = Modifier)
                }
            }
        }
    }
}
