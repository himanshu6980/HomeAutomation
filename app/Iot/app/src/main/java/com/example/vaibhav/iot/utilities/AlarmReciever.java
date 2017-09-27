package com.example.vaibhav.iot.utilities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.vaibhav.iot.MainActivity;
import com.example.vaibhav.iot.R;

/**
 * Created by f71ud on 27/09/2017.
 */

public class AlarmReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm up",Toast.LENGTH_LONG).show();
        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone ringtone;
        RingtoneManager ringtoneManager = null;
        ringtone= ringtoneManager.getRingtone(context,uri);
        ringtone.play();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)

                .setSmallIcon(R.mipmap.logo)
                .setContentTitle("Home Alarm")
                .setContentText("Tap for Alarm Info");

        Intent intent1 = new Intent(context,MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,
                new Intent(context,AlertActivity.class),PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pendingIntent);
        int notification_id =001;
        builder.setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notification_id,builder.build());

    }
}

