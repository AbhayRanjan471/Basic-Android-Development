package com.example.birthdaygreet

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       //  final MediaPlayer mp = MediaPlayer.create(this , R.raw.sample)



//        //findViewById() is used to find the reference
//        // R : is the resource
//        val button: Button = findViewById(R.id.createBirthdayButton)
//        //whenever Button will be clicked this thing will happen
//        button.setOnClickListener{
//            val name: EditText = findViewById(R.id.nameInput) // here we have got the reference from EditText
//            val Name = name.editableText.toString() //converting the name reference into String
//
//            Toast.makeText(this, "name is $Name" , Toast.LENGTH_LONG).show()
//        }
    }


    //TO OPEN A NEW SCREEN
    //using " Intent() " we can share data from one screen to other screen , we can jump form one screen
    // to another screen
    //inside this Intent() constructor we have to pass two thing Current activity ka context or ak
    //kon se activity hume kholne hai us activity ki class hume batane padte hai
    fun createBirthdayCard(view: View) {
        val name = findViewById<EditText>(R.id.nameInput)
        val Name = name.editableText.toString()
        val intent = Intent(this , BirthdayGreetingActivity::class.java)
                                               //this is the syntax to pass the class in java

                         //key       //value
        intent.putExtra(BirthdayGreetingActivity.NAME_EXTRA , Name)
        //here putExtra is a bundle in which we can insert key and values and pass this bundle to another activity
        //we have to receive this activity in BirthdayGreetingActivity class

//        intent.putExtra("song" , mp)

        startActivity(intent) // calling the startActivity() function and passing the intent

        //val b = findViewById<Button>(R.id.createBirthdayButton)


    }

       //TO GET MSG WHENEVER WE CLICK THE BUTTON
//    fun createBirthdayCard(view: View) {
//        //Toast will generally show a msg whenever we click the Button
//        val name: EditText = findViewById(R.id.nameInput)
//        val Name = name.editableText.toString()
//
//
//        Toast.makeText(this, "$Name was clicked" , Toast.LENGTH_LONG).show()
//    }
}