package com.example.clickcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //FOR BUTTON 1
        var count: Int = 0;
        var myText: TextView = findViewById(R.id.counter_click);
        var button_clicked = findViewById<Button>(R.id.button1)

        button_clicked.setOnClickListener {
            count++;

            myText.setText("Button clicked $count times")
        }

        ///FOR BUTTON 2
        var c: Int = 0;
        var view_text: TextView = findViewById(R.id.counter_text)
        var button2_clicked: Button = findViewById(R.id.button2)
        var button3_clicked = findViewById<Button>(R.id.enable_disable_button)

        //initially named the button3 as Disable
        button3_clicked.setText("DISABLE");

        //when button3 is clicked
        button3_clicked.setOnClickListener {
            if (button3_clicked.text == "DISABLE") {
                button3_clicked.setText("ENABLE")
                button2_clicked.isEnabled = false;
            }
            else if (button3_clicked.text == "ENABLE") {
                button3_clicked.setText("DISABLE")
                button2_clicked.isEnabled = true;
            }
        }

        //when button2 is clicked
        button2_clicked.setOnClickListener {
            c++;
            view_text.setText("Button clicked $c times")
        }
    }

//        button3_clicked.setOnClickListener{
//            if(button3_clicked.isEnabled) {
//                button2_clicked.isEnabled = false;
//                //button3_clicked.isEnabled = false;
//            }
//            button3_clicked.setText("DISABLED")
//        }
//        when(button3_clicked.isEnabled){
//            true -> {
//
//                button2_clicked.setOnClickListener {
//                    c++;
//                    view_text.setText("Button clicked $c times");
//
//                }
//            }
////            false ->{
////                button3_clicked.setText()
////            }
//
//        }
//
//    }

}