package com.example.eventhandling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//this set the layout of the screen

        //FOR SHOW NAME BUTTON

        //here we call the 'findViewById' which find the view by its Id
        //here the variable is of type TextView
        //we have put the name in val myName and now we can manipulate its value
        //here TextView and Button are the tye of the variable inside which we have created, name and show_name
        val myName: TextView = findViewById(R.id.name) //here name is that Id which we have given to it when we have created the TextView
        val showName: Button = findViewById(R.id.show_name)//same for the show name

        //1st way to use OnClick
//        val listener = object: View.OnClickListener {
//            override fun onClick(v: View?) {
//               // TODO("Not yet implemented")
//                myName.text = getString((R.string.my_name))
//            }
//        }
//        showName.setOnClickListener(listener)

        //2nd way to set the text when button (SHOW NAME ) is clicked
        showName.setOnClickListener{
            myName.text = getString(R.string.my_name)
        }


        //FOR SHOW MESSAGE BUTTON

        val myMessage: EditText = findViewById(R.id.message)
        val showMessage: Button = findViewById(R.id.show_message)

        val no :Int = 0;
        showMessage.setOnClickListener{
            Toast.makeText(this , myMessage.text , Toast.LENGTH_LONG).show()
        }
    }
}