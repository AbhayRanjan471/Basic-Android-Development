package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// Adapter needs a data jo ki use Activity la k de ge .So Adapter gets a data inside the constructor
//we have to extend a RecyclerView.Adapter<viewHolderclass>
class NewsListAdapter( private val listner:NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {
    private val items:ArrayList<News> = ArrayList()
    //this function will be called when we are creating the View holder
    //jitne v list ho ge RecyclerView k andar utne bar ye ViewHolder call ho ga
                                                             // return a NewsHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        //Xml format se View format banane k liye hum LayoutInflater ka use kre ge
        //item_News humara Xml formate me hai or hume View format me chahiye so we will use LayoutInflater
                                                   //jo resource hume inflate krna hai
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = NewsViewHolder(view)
        //when view is created at the same time we will can handle the OnCliickListner
        view.setOnClickListener{
            //clicl karene ke bad jo v kam krna hai wo sare kam ki jimedari ab activity ki hone chahiye
            //we need a call back to now that an item is clicked for that we have to make a call back which is
            //done using interface
            listner.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder//here we have passed the view
    }

    //ye wo function hai jo holder k andar data ko bind kr raha hota hai
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        //ye function ak ak kr k item leta hai or us item ke corresponding jo data uske andar jana chahiye wo feel kr deta hai
        //position tells that ki kis item ko hume bind krna hai
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.title
        //for image we have to use Glid
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image)
    }

    //this function is called only one's and this tells total no. of item
    override fun getItemCount(): Int {
        return items.size // returning the size of the item

    }

    fun updateNews(updatedNews: ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }

}
             //its taking an itemView inside it
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    //humne tile View mangwaya liya or ab ye itemView k andar a raha ho ga
    val titleView = itemView.findViewById<TextView>(R.id.title)
                 val image = itemView.findViewById<ImageView>(R.id.image)
                 val author = itemView.findViewById<TextView>(R.id.author)

}

interface NewsItemClicked{

    fun onItemClicked(item: News)
}
