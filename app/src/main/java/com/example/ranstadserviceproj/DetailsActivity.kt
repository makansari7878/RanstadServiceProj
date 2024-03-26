package com.example.ranstadserviceproj

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class DetailsActivity : AppCompatActivity() {

    lateinit var sp : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        sp = getSharedPreferences("myfile", MODE_PRIVATE)


        var submitBtton = findViewById<Button>(R.id.buttonSubmit)
        var usernameEditText = findViewById<EditText>(R.id.editTextUsername)

        usernameEditText.setText(sp.getString("keyusername", ""))

        submitBtton.setOnClickListener {
            var username = usernameEditText.text.toString()
            var editor = sp.edit()
            editor.putString("keyusername", username)
            editor.commit()

            usernameEditText.setText("")
        }
    }
}