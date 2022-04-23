package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0
        button.setOnClickListener {
            textView.text = "Button Clicked ${++count} times"
        }

        enableButton.setOnClickListener {
            if (button.isEnabled) {
                button.isEnabled = false
                enableButton.text = "Enable"
            } else {
                button.isEnabled = true
                enableButton.text = "Disabled"
            }
        }
    }
}
