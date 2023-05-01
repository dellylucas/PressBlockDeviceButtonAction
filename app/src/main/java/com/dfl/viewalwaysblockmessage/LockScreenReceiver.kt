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
        if (intent?.action == Intent.ACTION_SCREEN_OFF || intent?.action == Intent.ACTION_USER_PRESENT) {
            val activityIntent = Intent(context, MainActivityTwo::class.java)
            activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            // Iniciar la actividad
            context!!.startActivity(activityIntent)

        }
    }
}