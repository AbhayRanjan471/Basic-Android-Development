package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val launchURl = findViewById<Button>(R.id.launch_url)
        launchURl.setOnClickListener{
            //we create an object intent and use apply function
            val intent = Intent().apply {
                //we are setting intent action as Intent.ActionVies
                action = Intent.ACTION_VIEW // this means that we want to view something
                //then setting the data
                data = Uri.parse("https://www.google.com")
            }
            //now we will call the resolveActivity of Intent
            //packageManager : this packageManager has all the knowledge of app install in our mobile .It check all the activity
            //if any activity handle that request (line 17 to 21)
            //if the request is not null then we will pass the intent and start the activity
            //if we will not handle this activity and if the request is not present then the app will crash
           // startActivity(intent)
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"No activity found to handle this intent",Toast.LENGTH_SHORT).show()
            }
        }
    }
}