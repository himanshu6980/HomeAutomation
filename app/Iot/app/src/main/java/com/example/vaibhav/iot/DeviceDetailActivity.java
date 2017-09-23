package com.example.vaibhav.iot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class DeviceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        String deviceName,deviceType;
        Boolean triggerIsChecked;
        int id,portNumber;

        Intent i = getIntent();
        triggerIsChecked = i.getBooleanExtra("deviceState",false);
        deviceName = i.getStringExtra("deviceName");
        id = i.getIntExtra("deviceId",0);
        deviceType = i.getStringExtra("deviceType");
        portNumber = i.getIntExtra("portNumber",0);

//        information logging
        Log.i("haha",""+deviceName + " " + triggerIsChecked + " " + id + " " + deviceType + " " + portNumber);
    }
}
