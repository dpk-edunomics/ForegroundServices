package com.dpk.machinetestyuvasoft;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Application extends android.app.Application {
    public static final String CHANNEL_ID = "ServiceChannel";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotification();
    }

    private void createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Service", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
}
