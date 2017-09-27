package com.example.vaibhav.iot.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.vaibhav.iot.MainActivity;
import com.example.vaibhav.iot.R;

public class SplashActivitry extends Activity {
    private static int SPLASH_TIME_OUT=3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView textView_internet;
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);
        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activitry);
        textView_internet = (TextView)findViewById(R.id.textView_internet_Connectivity);
        textView_internet.setVisibility(View.INVISIBLE);
        if (conMgr.getActiveNetworkInfo() != null
                && conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected()) {

                textView_internet.setVisibility(View.INVISIBLE);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(SplashActivitry.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
        else
        {
            textView_internet.setVisibility(View.VISIBLE);
            textView_internet.setText("Check Your Internet Connection");
        }

    }
}
