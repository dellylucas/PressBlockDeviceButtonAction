package com.dfl.viewalwaysblockmessage

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class LockScreenReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_SCREEN_OFF || intent?.action == Intent.ACTION_SCREEN_ON) {
            val CHANNEL_ID = "id_holaa"
            val intentt = Intent(context, MainActivityTwo::class.java)
            intentt.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            val pendingIntent = PendingIntent.getActivity(context, 0, intentt, PendingIntent.FLAG_MUTABLE)


            val builder = context?.let {
                NotificationCompat.Builder(it, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Título de la notificación")
                    .setContentText("Contenido de la notificación")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setContentIntent(pendingIntent)
                    .setFullScreenIntent(pendingIntent, true)
            }

            val notificationManager = context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Nombre del canal",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            }
            notificationManager.createNotificationChannel(channel)
            notificationManager.notify(23423, builder!!.build())





        }
    }
}