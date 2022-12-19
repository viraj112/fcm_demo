package com.neosoft.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val borad = object :BroadcastReceiver(){
        override fun onReceive(p0: Context?, intent: Intent?) {
            when(intent?.action){
                "com.neosoft.apptimer.ACTION_SEND" ->{
                    val data = intent.getStringExtra("com.neosoft.apptimer")
                    Toast.makeText(applicationContext,"hii${data}",Toast.LENGTH_LONG).show()
                    abb.text = data.toString()

                }
            }
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@addOnCompleteListener
            }
            val token = task.result
            Log.d("TOKEN", "onCreate:$token ")
        }

        val intentFilter = IntentFilter("com.neosoft.apptimer.ACTION_SEND")
        registerReceiver(borad,intentFilter)



    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(borad)
    }
}