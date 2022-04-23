package com.example.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //reference of the button start_activity
        val startActivity = findViewById<Button>(R.id.start_activity)

        startActivity.setOnClickListener{
          //  we are creating an instance of Intent class and calling the component activity class helloActivity.kt
                                           //helloActivity: this is the name of the component which we want to launch
            val intent = Intent(this , helloActivity::class.java).apply {
              //here using putExtra we are passing it to helloActivity
               // putExtra(key, value) method of Intent class send the data to the helloActivity.kt class.
                putExtra("NAME" , "JHON")
            }
            //The startActivity() method starts the Intent
            startActivity(intent)
        }
    }
}