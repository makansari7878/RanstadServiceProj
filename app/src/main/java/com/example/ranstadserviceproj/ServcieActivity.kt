package com.example.ranstadserviceproj


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ServcieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servcie)

        var startButton = findViewById<Button>(R.id.buttonStart)
        var stopButton  = findViewById<Button>(R.id.buttonStop)

        startButton.setOnClickListener {
           /* var myIntent = Intent(this, MyService::class.java)
            startService(myIntent)*/

            var myIntent = Intent(this, MyForegroundService::class.java)
            startService(myIntent)
        }

        stopButton.setOnClickListener {
            var myIntent = Intent(this, MyService::class.java)
            stopService(myIntent)
        }

    }
}