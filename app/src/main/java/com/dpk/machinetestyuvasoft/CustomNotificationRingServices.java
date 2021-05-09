package com.dpk.machinetestyuvasoft;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.dpk.machinetestyuvasoft.Application.CHANNEL_ID;

public class CustomNotificationRingServices extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        MediaPlayer ring = MediaPlayer.create(CustomNotificationRingServices.this, R.raw.alan_walke_faded_sms); ring.start();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSound(Uri.parse(ring.toString()))
                .setContentTitle("Hammoq")
                .setContentText("Your Product Uploaded Successfully")
                .setSmallIcon(R.drawable.app_logo)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(2, notification);

        Toast.makeText(this, "Custom Ringtone Notification Sent...", Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

