package com.example.ranstadserviceproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class SplashActviity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_actviity)

        var splashTextview = findViewById<TextView>(R.id.textView)



        GlobalScope.launch {

            for(i in 1..5){
                delay(1000)

                launch (Dispatchers.Main){
                        splashTextview.setText(" $i")
                }
            }
        }

        thread {
            Thread.sleep(5000)
            var myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

    }
}