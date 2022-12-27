package com.neosoft.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SensorRestarterBroadcastReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, p1: Intent?) {
        Log.i("ddsd", "onReceive: Service stops")
        context?.startService(Intent(context, BoundService::class.java))
    }
}