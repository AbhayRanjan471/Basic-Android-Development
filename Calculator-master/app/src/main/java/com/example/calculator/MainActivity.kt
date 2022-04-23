package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun handleClick(view: View) {
        val text = (view as Button).text.toString()
        val tag = view.tag as String

        when(tag){
            "value" -> {

            }
            "operator" -> {

            }
            "equal" -> {

            }
            "point" -> {

            }
            "clear" -> {

            }
        }
    }
}
