package com.example.vaibhav.iot.utilities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.vaibhav.iot.MainActivity;
import com.example.vaibhav.iot.R;

public class SplashActivitry extends Activity {
    private static int SPLASH_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activitry);
        new Handler().postDelayed(new Runnable()
        {
            public void run ()
            {
                Intent intent = new Intent(SplashActivitry.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}