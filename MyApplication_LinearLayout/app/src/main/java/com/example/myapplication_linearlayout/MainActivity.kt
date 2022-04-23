package com.example.myapplication_linearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_layout) // here we have made linear_layout as our main so now
                                           // linear layout will we be open on screen first
    }
}