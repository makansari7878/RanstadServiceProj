package com.example.ranstadserviceproj


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ServcieActivity : AppCompatActivity() {

    lateinit var sp :SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servcie)
        sp = getSharedPreferences("myfile", Context.MODE_PRIVATE)
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