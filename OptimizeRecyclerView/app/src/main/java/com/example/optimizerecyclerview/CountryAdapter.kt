package com.example.optimizerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

//here we rae using ListAdapter instead of RecyclerView.Adapter<>                      //viewHolder
class CountryAdapter(private val listener: (Country)-> Unit): ListAdapter<Country, CountryAdapter.CountryViewHolder>(DiffCallback()) {

//    var countryData = arrayOf<Country>()
//    set(value) {
//        field = value
//        notifyDataSetChanged()
//    }
   inner class CountryViewHolder(view: View): RecyclerView.ViewHolder(view){
        val countryFlag = view.findViewById<ImageView>(R.id.country_flag)
        val countryName = view.findViewById<TextView>(R.id.country_name)
        val capitalCity = view.findViewById<TextView>(R.id.country_capital)
       init {
           itemView.setOnClickListener {
               listener.invoke(getItem(adapterPosition))
           }
       }
    }

    //This function is called when we are creating new Views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        //converting the  Xml type into view type
        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
       val viewHolder = CountryViewHolder(itemLayout)
        itemLayout.setOnClickListener {
            listener.invoke(countryData[viewHolder.adapterPosition])
        }
        return viewHolder
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
          //inherit from DiffUtil.ItemCallback<Country>()
class DiffCallback: DiffUtil.ItemCallback<Country>(){
    override fun areItemsSame(oldItem: Country, newItem: Country): Boolean{
        return oldItem.code == newItem.code
    }
     override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean{
         return oldItem == newItem
     }

}
//    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view){
//        val countryFlag = view.findViewById<ImageView>(R.id.country_flag)
//        val countryName = view.findViewById<TextView>(R.id.country_name)
//        val capitalCity = view.findViewById<TextView>(R.id.country_capital)
//
//}

