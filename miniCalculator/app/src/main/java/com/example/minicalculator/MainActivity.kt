package com.example.minicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.first_value)
        val num2: EditText = findViewById(R.id.second_value)
        var ans = findViewById<TextView>(R.id.answer)

        val add = findViewById<Button>(R.id.addition)
        val sub = findViewById<Button>(R.id.substract)
        val multi = findViewById<Button>(R.id.mutliply)
        val div = findViewById<Button>(R.id.divide)

        add.setOnClickListener{
            val number1 = Integer.parseInt(num1.text.toString())
            val number2 = Integer.parseInt(num2.text.toString())
            ans.text = "Addition: ${number1+number2}"
        }

        sub.setOnClickListener{
            val number1 = Integer.parseInt(num1.text.toString())
            val number2 = Integer.parseInt(num2.text.toString())
            ans.text = "Substraction: ${number1 - number2}"
        }

        multi.setOnClickListener{
            val number1 = Integer.parseInt(num1.text.toString())
            val number2 = Integer.parseInt(num2.text.toString())
            ans.text = "Multiply: ${number1 * number2}"
        }

        div.setOnClickListener{
            val number1 = Integer.parseInt(num1.text.toString())
            val number2 = Integer.parseInt(num2.text.toString())
            if(number2 != 0) {
                ans.text = "Division: ${number1 / number2}"
            }
            else{
                ans.text ="INVALID INPUT for Division"
            }

            //OR
            //ans.text = if(number2!=0) "Division: ${number1 / number2}" else "INVALID INPUT for Division"
        }
    }
}