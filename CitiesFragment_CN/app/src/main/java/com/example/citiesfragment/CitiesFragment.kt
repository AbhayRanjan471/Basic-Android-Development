package com.example.citiesfragment

import android.content.Intent
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_cities.*
import kotlinx.android.synthetic.main.fragment_cities.view.*
import kotlinx.android.synthetic.main.fragment_cities.view.cities
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 */
class CitiesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

       var viewOfLayout = inflater!!.inflate(R.layout.fragment_cities, container, false)

        val cityNames = arrayOf("New Delhi"," New York", "Paris", "Rome","Amsterdam")
        val cityAdapter=
            activity?.let { ArrayAdapter(it,android.R.layout.simple_list_item_1,cityNames) }


       viewOfLayout.cities.adapter=cityAdapter

       viewOfLayout.cities.setOnItemClickListener { parent, view, position, id ->

//       val bundle= Bundle()
//       bundle.putString("KEY", id.toString())

           val intent= Intent(activity,DetailActivity::class.java)
           intent.putExtra("KEY",position.toString())
           startActivity(intent)





//         val fragmentDetails= DetailsFragment()
//         val bundle= Bundle()
//         bundle.putString("Value",position.toString())
//         fragmentDetails.arguments= bundle
//





         //Log.d("Value",position.toString())


       }

        return viewOfLayout
    }

}
