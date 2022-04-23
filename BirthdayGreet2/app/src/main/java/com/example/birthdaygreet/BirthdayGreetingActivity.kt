package com.example.birthdaygreet

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BirthdayGreetingActivity : AppCompatActivity() {

    companion object{ // companion object are same as Static
        const val NAME_EXTRA ="name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_greeting)

        //TO PLAY THE MUSIC
        val mp = MediaPlayer.create(this , R.raw.music2)
        mp.start()

        //here we are receiving the intent in which we have passed a String so we will do intent.getStringExtra(key which we have passed)
        val name = intent.getStringExtra(NAME_EXTRA) //key value should be same as we have passed

        //Set The Name
        val ref = findViewById<TextView>(R.id.birthdayGreeting) // got the reference of birthdayGreeting

        ref.text = "Happy Birthday $name!"
             //OR
       // ref.setText("Happy Birthday\n $name!") // Setting the msg which we want to display on the Screen when we click the button
    }
}