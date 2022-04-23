package com.example.listview_managestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    val cityData = fillCityData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cities = findViewById<ListView>(R.id.cities)

        //here we  are creating our own adapter nad passing the cityDAta
        val cityAdapter = CityAdapter(cityData)

        //here we are setting the adapter
        cities.adapter = cityAdapter
        //An Adapter object acts as a bridge between an AdapterView and the underlying data for that view.
        // The Adapter provides access to the data items. The Adapter is also responsible for making a View for each item in the data set.

        cities.setOnItemClickListener { parent, view, position, id ->

            val city: City? = cityAdapter.getItem(position)
            city?.let {
                city.favorite = !city.favorite
                cityAdapter.notifyDataSetChanged()
            }
        }
    }

        //creating an array if City object(inside the constructor we are passing the county name and the capital city)
        private fun fillCityData(): Array<City> {
            return arrayOf(
                City("India", "New Delhi"),
                City("USA", "New York"),
                City("France", "Paris"),
                City("Italy", "Rome"),
                City("Netherlands", "Amsterdam")
            )
        }


}