package com.example.citiesfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val cities = arrayOf(City("New Delhi") ,
        City("New York"),
        City("Paris"),
        City("Amsterdam"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val recyclerView = findViewById<RecyclerView>(R.id.recycleview)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        recyclerView.adapter = CityAdapter(cities)

//            val adapter = CityAdapter()
//               // setHasStableIds(true)
//            }
//            setHasFixedSize(true)
//
//
//        ( recyclerView.adapter as CityAdapter).cityData = cities

    }
}