package com.example.autocall

import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar
import java.util.jar.Manifest

const val PERMISSION_REQUEST_PHONE_CALL = 0;

class MainActivity : AppCompatActivity() , ActivityCompat.OnRequestPermissionsResultCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callSupport = findViewById<Button>(R.id.call_support)
        callSupport.setOnClickListener {
           // makePhoneCall()
            makePhoneCallAfterPermission(it) // here we are passing the button which is clicked ie, (it)
        }
    }

    private fun makePhoneCallAfterPermission(view: View) {
        //this is the way we check the permission form user
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED){
                    //if the permission is granted then we will call the function
            makePhoneCall()
        }
        else{
            //if it is denied we will call the requestCallPermission() function and give another chance to user to make the call
            requestCallPermission(view)
        }

    }

    private fun requestCallPermission(view: View) {

        if(ActivityCompat.shouldShowRequestPermissionRationale(this , android.Manifest.permission.CALL_PHONE)){
            val snack = Snackbar.make(view,"We need your permission to make a call." +
            "When asked please give the permission" , Snackbar.LENGTH_INDEFINITE)

            snack.setAction("OK" , View.OnClickListener {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE) ,
                PERMISSION_REQUEST_PHONE_CALL)
            })
            snack.show()
        }
        else{
            ActivityCompat.requestPermissions(this , arrayOf(android.Manifest.permission.CALL_PHONE) ,
            PERMISSION_REQUEST_PHONE_CALL)
        }

    }

    private fun makePhoneCall(){
        //it create an intent
        val intent = Intent().apply {
            action = ACTION_CALL
            data = Uri.parse("tel: 8877078492")
        }
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == PERMISSION_REQUEST_PHONE_CALL){
            if(grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall()
            }
            else{
                Toast.makeText(this ,"Permission denied to make phone call", Toast.LENGTH_SHORT).show()
            }
        }
    }
}