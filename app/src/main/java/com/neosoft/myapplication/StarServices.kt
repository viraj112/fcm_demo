package com.neosoft.myapplication

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class StarServices : Service() {

    lateinit var player: MediaPlayer

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);

        // providing the boolean
        // value as true to play
        // the audio on loop
        player.setLooping(true);

        // starting the process
        player.start();

        // returns the status
        // of the program
        return START_REDELIVER_INTENT;
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }

}