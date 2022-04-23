package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating a set of data which we want to show in List View
        val cityNames = arrayOf("New Dehi","New York","Paris","Rome","Amsterdam")

        //getting the reference of ListView whoes id is cities
        val cities = findViewById<ListView>(R.id.cities)

        //Adapter : adapter is a  bridge between data and List View and its job is to manipulate the
        //data and create views as required
        //List View doesn't have the knowledge of data, that the job of the adapter to adapt the data
       //to show inside the List View So we use adapter
        //here we are using ArrayAdapter
        val cityAdapter = ArrayAdapter(this , android.R.layout.simple_list_item_1,cityNames)

        //setting the adapter inside the list view
        cities.adapter = cityAdapter

        //here we are setting onClickListner of each Item
        //here adapterView is our ListView
        //view = item view which the user click
        //position = position inside the list view (ie , 1st item , 3 item ets)
        //id = id of that item
        cities.setOnItemClickListener{adapterView , view ,position,id->

           //we know that the view clicked by the user is TextView so we cast it as Text View
            val city:TextView = view as TextView
            Toast.makeText(this,city.text,Toast.LENGTH_SHORT).show()
        }
    }
}