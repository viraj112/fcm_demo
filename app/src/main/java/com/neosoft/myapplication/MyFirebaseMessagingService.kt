package com.neosoft.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.ktx.remoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    lateinit var  notification :Notification
    private val ID = "fcm_noti"
    private val NAME = "fcm_notification"


    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("TOKEN", "onNewToken: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        if (message.notification != null) {
            pushNotification(
                message.notification?.title,
                message.notification?.body
            )
        }
    }

    private fun pushNotification(title: String?, body: String?) {

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(this,HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(ID,NAME,NotificationManager.IMPORTANCE_HIGH)
            channel.description = "hfjdshfkjdshfkjdshfds"

            if (notificationManager !=null){
                notificationManager.createNotificationChannel(channel)
                notification = Notification.Builder(this)
                    .setSmallIcon(androidx.loader.R.drawable.notification_bg)
                    .setContentIntent(pendingIntent)
                    .setChannelId(ID)
                    .setContentTitle(title)
                    .setSubText(body)
                    .setAutoCancel(true)
                    .build()
            }else{
                notification = Notification.Builder(this)
                    .setSmallIcon(androidx.loader.R.drawable.notification_bg)
                    .setContentIntent(pendingIntent)
                    .setChannelId(ID)
                    .setContentTitle(title)
                    .setSubText(body)
                    .setAutoCancel(true)
                    .build()
            }

            if (notificationManager !=null){
                notificationManager.notify(1,notification)
            }
        }



    }


}