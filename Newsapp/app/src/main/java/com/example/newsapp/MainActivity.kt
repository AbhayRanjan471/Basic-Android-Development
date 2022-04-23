package com.example.newsapp

import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class MainActivity : AppCompatActivity(), NewsItemClicked {
    private lateinit var mAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //As we have created the RecyclerView now the recyclerView need a layout manager and a adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //inserting a LayoutManager
        //now we have clarified that RecyclerView  ak Linear layout manager hai
        //we can use other layoutManager also such as Gride layout or Stagate layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()
        //Now we have to create an Adapter and insert the item inside it
         mAdapter  = NewsListAdapter(this)

        //NOw we have to link this Adapter with RecyclerView
        recyclerView.adapter = mAdapter
    }

    //creating list of items
    private fun fetchData() {
       // val url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=8e01be2e8ee9423a9fc0875c304e100f"
        val url = "https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json"

        //Request a string response from the provided URL
        //using this jasonObject we have to load our image
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,

            Response.Listener {
                val newsJsonArray = it.getJSONArray("articles")
                val newsArray = ArrayList<News>()

                for (i in 0 until newsJsonArray.length()) {
                    val newsJsonObject = newsJsonArray.getJSONObject(i)
                    val news = News(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                    newsArray.add(news)//adding the news in the newsArray
                }

                mAdapter.updateNews(newsArray)
            },
            Response.ErrorListener {
                // TODO: Handle error
                // Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show()
            }
        )
        // queue.add(jsonObjectRequest)//adding it in the queue
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }


    override fun onItemClicked(item: News) {
        //Here we have used crome custom tab
        //https://developer.chrome.com/docs/android/custom-tabs/integration-guide/
       val builder = CustomTabsIntent.Builder();
        val customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(item.url));
    }
}