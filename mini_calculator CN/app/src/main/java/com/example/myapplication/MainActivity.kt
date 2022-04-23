package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener {
            val number1 = Integer.parseInt(num1.text.toString())
            val number2 = Integer.parseInt(num2.text.toString())

            ans.text = "Addition: ${number1 + number2}"
        }

        sub.setOnClickListener {
            val number1 = Integer.parseInt(num1.text.toString())
            val number2 = Integer.parseInt(num2.text.toString())

            ans.text = "Subtraction: ${number1 - number2}"
        }

        multiply.setOnClickListener {
            val number1 = Integer.parseInt(num1.text.toString())
            val number2 = Integer.parseInt(num2.text.toString())

            ans.text = "Multiplication: ${number1 * number2}"
        }

        div.setOnClickListener {
            val number1 = Integer.parseInt(num1.text.toString())
            val number2 = Integer.parseInt(num2.text.toString())

            ans.text = if(number2!=0) "Division: ${number1 / number2}" else "INVALID INPUT for Division"
        }
    }
}
