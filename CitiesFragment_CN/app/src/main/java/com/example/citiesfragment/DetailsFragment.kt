package com.example.citiesfragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details.view.*

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {


      var position: String? = null
      lateinit var viewOfLayout:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         viewOfLayout = inflater!!.inflate(R.layout.fragment_details, container, false)
        //val fragmentInside= DetailsFragment()
     //   var position= arguments?.getString("Position")

        return viewOfLayout
    }

    fun refreshFrag(){

        position= arguments?.getString("Position")
        Log.d("posvalue",position.toString())
        if(position.equals("0")) {
            viewOfLayout.capitalText.setText("COUNTRY: INDIA")
            viewOfLayout.populationText.setText("POPULATION: 1.9 CR")
        }

        if(position.equals("1")) {
            viewOfLayout.capitalText.setText("COUNTRY: ALBANA")
            viewOfLayout.populationText.setText("POPULATION: 28.5 Lakhs")
        }
        if(position.equals("2")) {
            viewOfLayout.capitalText.setText("COUNTRY: FRANCE")
            viewOfLayout.populationText.setText("POPULATION: 6.7 CR")
        }
        if(position.equals("3")) {
            viewOfLayout.capitalText.setText("COUNTRY: ITALY")
            viewOfLayout.populationText.setText("POPULATION: 6.04 CR")
        }
        if(position.equals("4")) {
            viewOfLayout.capitalText.setText("COUNTRY: NETEHRLANDS")
            viewOfLayout.populationText.setText("POPULATION: 28.5 Lakhs")
        }


    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
}
