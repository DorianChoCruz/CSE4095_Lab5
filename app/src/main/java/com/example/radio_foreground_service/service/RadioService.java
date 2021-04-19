package com.example.radio_foreground_service.service;


import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.radio_foreground_service.MainActivity;
import com.example.radio_foreground_service.R;

import static com.example.radio_foreground_service.MainActivity.NOTIFICATION_CHANNEL_ID;

public class RadioService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String radioName= intent.getStringExtra("radioExtra");
        Intent notificationIntent= new Intent(this, MainActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,0, notificationIntent,0);
        Notification notification= new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID)
                .setContentTitle("Radio App")
                .setContentText(radioName+ " is playing")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}