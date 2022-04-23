package com.example.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Hello world")

        // region
        //here d stand for debugging
//        Log.d("MainActivity" , "Hello world!")
//
//        val x: String? = "jhon"
//        val y : String? = null
//        Log.d("MainActivity" ,(x!!.length + y!!.length).toString() )
    }
}