package com.example.vaibhav.iot.utilities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by f71ud on 27/09/2017.
 */


public class AlertActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.
                setMessage("Choose Action");
        builder.setTitle("Alarm Alert");
        builder.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AudioManager audiomanager = (AudioManager)getSystemService(AUDIO_SERVICE);
                audiomanager.adjustVolume(AudioManager.ADJUST_MUTE,AudioManager.FLAG_VIBRATE);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
