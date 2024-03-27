package com.example.ranstadserviceproj

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

class DetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        var submitBtton = findViewById<Button>(R.id.buttonSubmit)
        var usernameEditText = findViewById<EditText>(R.id.editTextUsername)
        var ageEditText = findViewById<EditText>(R.id.editTextAge)
        var saveButton = findViewById<Button>(R.id.buttonSave)

        var db = Room.databaseBuilder(this,MyDB::class.java,"mydatabase")
            .fallbackToDestructiveMigration().build()
        var h = Handler()


        saveButton.setOnClickListener {
            var myName = usernameEditText.text.toString()
            var myAgeText = ageEditText.text.toString()
            var myAge = myAgeText.toInt()

            GlobalScope.launch {
                var users = MyEntity()
                users.myname = myName
                users.age = myAge
                db.myDao().saveData(users)
            }

            usernameEditText.setText("")
            ageEditText.setText("")


        }




            submitBtton.setOnClickListener {

                thread {

                    db.myDao().readData().forEach {
                        h.post {
                            var result = "id : ${it.myid} with name ${it.myname} of age ${it.age} "
                            Toast.makeText(this,"result is " + result, Toast.LENGTH_SHORT).show()
                        }
                }



                }

            }
    }
}