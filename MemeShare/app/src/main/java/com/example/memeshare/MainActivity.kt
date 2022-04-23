package com.example.memeshare

import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class MainActivity : AppCompatActivity() {

    var URL:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMeme()
    }

    private fun loadMeme(){
        val ProgressBAR = findViewById<ProgressBar>(R.id.progressBar)
        // isse humara progress bar visible ho ga jb v function call ho ga isse jb v hum next pe click
        //kre ge to ye show ho ga
        ProgressBAR.visibility = View.VISIBLE
        val MemeImageView = findViewById<ImageView>(R.id.memeimageView)

        //Instantiate the RequestQueue.
        //Volley library humare api calls karte hai
       // val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        //Request a string response from the provided URL
        //using this jasonObject we have to load our image
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                //jo urls hume chahiye hum uska string name jo hai usse pass kre ge
                //after getting the url we have insert this url in our imageView using Glide library
                  URL = response.getString("url")
                //Glid.with(kis context).load(jo url load krna hai).int(jiske andar hume dalna hai)
                Glide.with(this).load(URL).listener(object:RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        ProgressBAR.visibility = View.GONE // after doing this circle won't be visible at the time when image is shown
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        ProgressBAR.visibility = View.GONE
                        return false;
                    }
                }).into(MemeImageView)
            },
            Response.ErrorListener {
                // TODO: Handle error
                Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show()
            })

       // queue.add(jsonObjectRequest)//adding it in the queue
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)


    }

    //for sharing the meme we will use Intent function
    fun shareMeme(view: View) {
        val intent = Intent(Intent.ACTION_SEND)//this intent is use to send
        intent.type = "text/plain" // this is the type (isse ye decide kre ga ki hum meme ko kon kon se app se share kr skte hai) us image k type k hisab se
        intent.putExtra(Intent.EXTRA_TEXT,"Hey, Check htis cool meme I got from Reddit $URL" )//our intent is created

        //Now we have to make the chooser ki hume kisse share krne hai(like intsa , fb etc)
                                 //passing the target intent      //message
        val chooser = Intent.createChooser(intent, "Share this meme using...")
        startActivity(chooser)
    }
    fun nextMeme(view: View) {
        //for next meme we have to call the loadMeme() function
        loadMeme()
    }
}