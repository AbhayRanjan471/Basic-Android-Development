package com.example.listviewcustomexample

import android.widget.TextView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

//CityAdapter inherits from the BaseAdapter()
class CityAdapter(val cityData: Array<City>) : BaseAdapter() {
    override fun getCount(): Int {
        //it returns the size of the total Data that we are showing
        return cityData.size
    }

    override fun getItem(position: Int): City {
        //we return the position of the item inside the cityData
        return cityData[position]
    }

    override fun getItemId(position: Int): Long {
        //using this we return the unique ID of the item
        //we know that the city name is unique so we are using name.hashCode{which is unique} and we converted it to Long
        return cityData[position].name.hashCode().toLong()
    }

    //position : tells for which position this view is asked
    //convertView :old view is passed which can be reuse
    //container: in this case its ListView
    //How to read!
    //ListView asked the adapter about the position at this position I want to show some item give me my item
    //the job of the adapter to find that data inside the Array and get a view and pass it to the ListView

//    override fun getView(position: Int, convertView: View?, container: ViewGroup): View {
//      //The LayoutInflater class is used to instantiate the contents of layout XML files into their corresponding View objects.
//        //In other words, it takes an XML file as input and builds the View objects from it.
//        val convertView = LayoutInflater.from(container.context).inflate(R.layout.city_item,
//                container, false)
//
//        val cityCountry: TextView = convertView.findViewById(R.id.city_country)
//        val cityName: TextView = convertView.findViewById(R.id.city_name)
//
//        //here we are setting the country name and the city name at its position
//        cityCountry.text = getItem(position).country
//        cityName.text = getItem(position).name
//
//        return convertView
//    }

    //IMPROVED VERSION OF getView()
//region
    override fun getView(position: Int, convertView: View?, container: ViewGroup): View {
        val cityView: View
        val viewHolder: ViewHolder

        //first we check for that there is no existing view passed to us
        if(convertView == null){
            cityView = LayoutInflater.from(container.context).inflate(R.layout.city_item,
                container, false)

            viewHolder = ViewHolder() // create an object of View holder
            with(viewHolder){
                cityCountry = cityView.findViewById(R.id.city_country)
                cityName = cityView.findViewById(R.id.city_name)
                //tag is an attribute of every view and we can put object inside this
                cityView.tag = this // here this is the ViewHolder object
            }
        } else{
            cityView = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        //now with viewHolder we set the data
        with(viewHolder){
            cityCountry.text = getItem(position).country
            cityName.text = getItem(position).name
        }

        return cityView
    }
//ViewHolder contains all those variables which we want to interact in the layout
    private class ViewHolder{
    //its lateinit because we are going to initialize it later
        lateinit var cityCountry: TextView
        lateinit var cityName: TextView
    }
//endregion
}