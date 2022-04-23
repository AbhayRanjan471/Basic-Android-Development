package com.example.citiesfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val pos= intent.getStringExtra("KEY")
        //Log.d("PointerPos",pos) Working
        val bundle= Bundle()
        bundle.putString("Position",pos)

        val fragmentDetailsFrag= fragment2 as DetailsFragment

        //val fragmentDetails= DetailsFragment()
        fragmentDetailsFrag.arguments= bundle
        fragmentDetailsFrag.refreshFrag()
        //Log.d("Bundleval", fragmentDetails.arguments!!.getString("Position"))




        // Log.d("MYValue",pos)


    }
}

