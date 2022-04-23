package com.example.citiesfragments

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CityAdapter(cities: Array<City>) :RecyclerView.Adapter<CityViewHOlder>() {

   private val cityData = cities//Array<City>()
//    set(value) {
//        field = value
//        notifyDataSetChanged()
//    }

//    fun updatelist(citylist: List<City>){
//        cityData.clear()
//        cityData.addAll(citylist)
//        notifyDataSetChanged()
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHOlder {
        //TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_one , parent,false)
        val viewHolder = CityViewHOlder(view)
        //set On click
        return viewHolder
    }

    override fun onBindViewHolder(holder: CityViewHOlder, position: Int) {
        //TODO("Not yet implemented")
        //with(holder){
            holder.cityname.text = cityData[position].name
       // }


    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return cityData.size
    }
}

class CityViewHOlder(view:View) : RecyclerView.ViewHolder(view) {
val cityname: TextView = view.findViewById(R.id.cities_name)
}

