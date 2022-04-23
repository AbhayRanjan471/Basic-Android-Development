package com.example.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class helloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        //here we are receiving that value .The value is of type String so we mage a val of type String which is nullable also
        //its type is String so we have used getStringExtra(key)
        val guestName: String? = intent.getStringExtra("NAME")
        guestName?.let {
            val name = findViewById<TextView>(R.id.name)
           // name.text = getString(R.string.Hello)
            name.text = it

            Toast.makeText(this , "This activity was launchrd by: $it" , Toast.LENGTH_LONG).show()
        }

    }
}