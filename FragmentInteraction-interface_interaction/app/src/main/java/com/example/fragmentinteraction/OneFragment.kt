package com.example.fragmentexample


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.fragmentinteraction.MainActivity
import com.example.fragmentinteraction.R


/**
 * A simple [Fragment] subclass.
 */
class OneFragment : Fragment() {

    interface OnMessageClickListener{
        fun onMessageClick()
    }

    var messageListener: OnMessageClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_one, container, false)

        val showActivityMessage = view.findViewById<Button>(R.id.show_activity_message)
        showActivityMessage.setOnClickListener {

           // It binds the fragment with a specific activity , reduce re-usability, so it is a bad practice and should not be used.
//            activity?.let{
//                //cast it to MainActivity and call showActivityMessage
//                (it as MainActivity).showActivityMessage()
//            }

            //This is the correct way to interact with the activity [through interface]
            messageListener?.onMessageClick()//first we check for null ?. the we call the onMessageClick()
        }
        return view
    }

    //There are TWO function in a Fragment
    //1.onAttach : first the fragment is created and then its attach
    //2.onDetach
    override fun onAttach(context: Context) {
        super.onAttach(context)
        messageListener = context as? OnMessageClickListener

        if(messageListener == null){
            throw ClassCastException("$context must implement OnArticleSelectedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        messageListener = null
    }

    fun showFragmentMessage(){
        //we are checking first that the activity is null or not ?.
        activity?.let {
            Toast.makeText(it, "This message is from Fragment", Toast.LENGTH_SHORT).show()
        }
    }

}
