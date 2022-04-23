package com.example.fragmentinteraction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.fragmentexample.OneFragment

class MainActivity : AppCompatActivity(), OneFragment.OnMessageClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment = OneFragment()
        // TO Show the fragment inside the main_container
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.main_container, fragment, "OneFragment")
        fragmentTransaction.commit()

        val showFragmentMessage = findViewById<Button>(R.id.show_fragment_message)
        showFragmentMessage.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.main_container) as OneFragment
            fragment.showFragmentMessage()
        }
    }


    override fun onMessageClick() {
        showActivityMessage()
    }

    fun showActivityMessage(){
        Toast.makeText(this, "This message is from Activity", Toast.LENGTH_SHORT).show()
    }
}
