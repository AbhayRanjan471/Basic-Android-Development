package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Two ways to add fragment
        //1.using Xml
        //2. PROGRAMMATICALLY
        //HOW TO ADD FRAGMENT PROGRAMMATICALLY

        //first we will create an instance of the fragment eg. TwoFragment()
        val fragment = TwoFragment()

        //Then we will get the reference of supportFragmentManager (It manages all the fragment
        // inside activity
        val fragmentManager = supportFragmentManager
        //Each of the action we perform in the fragment either add or remove we do it inside Transaction
        val fragmentTransaction = fragmentManager.beginTransaction()
        //inside that Transaction we are adding the fragment
        //[R.id.main_container] : will use those container in which we ant to show the fragment
        fragmentTransaction.add(R.id.main_container, fragment) // , (... ,"fragment" which we want to show)
        fragmentTransaction.commit() // at last we call the .commit() to show the fragment

//        val fragmet2 = BlankFragment()
//        val fragmentTransaction2 = supportFragmentManager.beginTransaction()
//        fragmentTransaction2.add(R.id.main_container , fragmet2)
//        fragmentTransaction2.commit()
    }
}