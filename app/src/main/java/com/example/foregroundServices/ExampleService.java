package com.example.foregroundServices;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ExampleService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        String input = intent.getStringExtra("input");
        Notification notification = new NotificationCompat.Builder(this,App.CHANNEL_ID).setContentTitle("Example Service Dweeb").setContentText(input)
                .setSmallIcon(R.drawable.ic_android).setContentIntent(pendingIntent).build();

        startForeground(1,notification);

        //After the work is completed call
        // stopSelf();
        return START_NOT_STICKY;
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
