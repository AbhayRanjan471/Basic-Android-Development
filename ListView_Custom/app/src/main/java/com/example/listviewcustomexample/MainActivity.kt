package com.example.listviewcustomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating an array if City object(inside the constructor we are passing the county name and the capital city)
        val cityData = arrayOf(City("India", "New Delhi"),
                            City("USA", "New York"),
                            City("France", "Paris"),
                            City("Italy", "Rome"),
                            City("Netherlands", "Amsterdam")
        )

        val cities: ListView = findViewById(R.id.cities)

        //here we  are creating our own adapter nad passing the cityDAta
        val cityAdapter = CityAdapter(cityData)

        //here we are setting the adapter
        cities.adapter = cityAdapter
        //An Adapter object acts as a bridge between an AdapterView and the underlying data for that view.
    // The Adapter provides access to the data items. The Adapter is also responsible for making a View for each item in the data set.
    }
}
