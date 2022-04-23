package com.example.fragmentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //We are going to handle the Fragment using Buttons click

        //ADDING THE FRAGMENT
        val addFragment = findViewById<Button>(R.id.add_button)//getting the reference of the add button
        //setting the OnClick Listener on the button
        addFragment.setOnClickListener{
            //setting ap the fragments PROGRAMMATICALLY
            val fragment = OneFragment() ////first we will create an instance of the fragment eg. OneFragment()

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.main_container, fragment, "OneFragment")//we can add tag also
            fragmentTransaction.commit()
        }

        //REMOVING THE FRAGMENT
        val removeFragment = findViewById<Button>(R.id.remove_button)
        removeFragment.setOnClickListener{

            //Finding the fragment
            val fragment = supportFragmentManager.findFragmentById(R.id.main_container)
                    //OR (we can remove fragment using the tag also which we have given above
           // val fragment = supportFragmentManager.findFragmentByTag("OneFragment")

                //removing the fragment
            fragment?.let {
                supportFragmentManager.beginTransaction().remove(fragment).commit()
            }
        }

        //REPLACING THE FRAGMENT
        val replaceFragment = findViewById<Button>(R.id.replace_button)
        replaceFragment.setOnClickListener{
            val fragment = TwoFragment()

            with(supportFragmentManager.beginTransaction()){
               //calling the replace function
                replace(R.id.main_container , fragment)
                addToBackStack(null)//ye besically hume previous fragment pe le jane ka kam
                // krta hai jb hum back button click krte hai

                //Added a transaction effect
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }
        }
    }
}