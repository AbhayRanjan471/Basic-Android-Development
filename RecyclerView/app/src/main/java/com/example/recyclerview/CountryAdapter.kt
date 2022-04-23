package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//inherit RecyclerView.Adapter<viewHOlder> whose type is of viewHOlder
class CountryAdapter: RecyclerView.Adapter<CountryViewHolder>() {

    var countryData = arrayOf<Country>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    //This function is called when we are creating new Views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        //converting the  Xml type into view type
        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)

        return CountryViewHolder(itemLayout)
    }


    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        with(holder){
           countryFlag.setImageResource(countryData[position].flagId)
            countryName.text = countryData[position].name
            capitalCity.text = countryData[position].capitalCity
        }
    }

    //It gives unique id for the Item
    override fun getItemId(position: Int): Long {
         return countryData[position].code.hashCode().toLong()
    }

    override fun getItemCount(): Int {
     return countryData.size//returning the size of the array
    }
}

class CountryViewHolder(view: View): RecyclerView.ViewHolder(view){
     val countryFlag = view.findViewById<ImageView>(R.id.country_flag)
     val countryName = view.findViewById<TextView>(R.id.country_name)
     val capitalCity = view.findViewById<TextView>(R.id.country_capital)
}