package com.example.optimizerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val countries = mutableListOf(
        Country("in" ,"India", "Delhi", R.drawable.india) ,
        Country("us" ,"United State", "Washington D.C", R.drawable.us) ,
        Country("uk" ,"United Kingdom", "London", R.drawable.uk) ,
        Country("ca" ,"Canada", "Ottawa", R.drawable.canada) ,
        Country("es" ,"Spain", "Madrid", R.drawable.spain) ,
        Country("gm" ,"Germany", "Berlin", R.drawable.germany) ,
        Country("sl" ,"Sri Lanka", "Colombo", R.drawable.srilanka) ,
        Country("au" ,"Australia", "Canberra", R.drawable.australia) ,
        Country("ia" ,"Indonisia", "Jakarta", R.drawable.indonisia) ,
        Country("ar" ,"Argentina", "Buenos Aires", R.drawable.argintina) ,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countrytList = findViewById<RecyclerView>(R.id.country_list).apply {

            //1.setting the layout manager for recycler view
            //2.layout manager is responsible for the positioning of item inside the recycler view
            //3.here we have used "this@MainActivity " instead of "this " as context bcz if we see inside
            // this lambda it is referring to the RecyclerView so we have used this@MainActivity so that
            // it can refer to the MainActivity object
            layoutManager = LinearLayoutManager(this@MainActivity)
            //Grid Layout
            // layoutManager = GridLayoutManager(this@MainActivity , 2)//here 2 is the total no of column we want

            //Now we set the Adapter which is a bridge b/w data nd the recyclerView , so its adapter job
            // to manage the data plus create the view
            adapter = CountryAdapter {

                Toast.makeText(
                    this@MainActivity,
                    "Country: {${it.name}} was clicked",
                    Toast.LENGTH_SHORT).show()
            }
//            }.apply {
//                setHasStableIds(true)//this means that each view get its unique Id
//            }
            setHasFixedSize(true)//This help in optimization , This help Recycler view to measure the screen
        }

        val showCountries = findViewById<Button>(R.id.show_country)
        showCountries.setOnClickListener {
            //1.we get reference to county adapter using (countryList.adapter)
            //2.we cast it to the CountryAdapter
            //3.then we set it property countryData to the countries
            (countrytList.adapter as CountryAdapter).submitList(countries.shuffled())
        }
    }
}