package com.example.googlefittest

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

private const val MY_PERMISSIONS_REQUEST_ACTIVITY_RECOGNITION = 0
private const val MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1
private const val MY_PERMISSIONS_REQUEST_BODY_SENSORS = 2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        @RequiresApi(Build.VERSION_CODES.Q)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACTIVITY_RECOGNITION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestingPermissionActivityRecognition()
        }

        @RequiresApi(Build.VERSION_CODES.Q)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestingPermissionAccessFineLocation()
        }

        @RequiresApi(Build.VERSION_CODES.Q)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BODY_SENSORS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestingPermissionBodySensors()
        }
    }

    private fun requestingPermissionBodySensors() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.BODY_SENSORS),
            MY_PERMISSIONS_REQUEST_BODY_SENSORS
        )
    }

    private fun requestingPermissionAccessFineLocation() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
        )
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun requestingPermissionActivityRecognition() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACTIVITY_RECOGNITION),
            MY_PERMISSIONS_REQUEST_ACTIVITY_RECOGNITION
        )
    }
}