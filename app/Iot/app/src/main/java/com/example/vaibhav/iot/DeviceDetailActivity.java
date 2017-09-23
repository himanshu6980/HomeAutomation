package com.example.vaibhav.iot;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

//import com.example.vaibhav.iot.databinding.ActivityDeviceDetailBinding;

import com.example.vaibhav.iot.databinding.ActivityDeviceDetailBinding;

import java.util.Date;

public class DeviceDetailActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        ActivityDeviceDetailBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_device_detail);

        String deviceName,deviceType;
        Boolean triggerIsChecked;
        int id,portNumber;
        int power=100;
        int bill=600;
        Intent i = getIntent();
        triggerIsChecked = i.getBooleanExtra("deviceState",false);
        deviceName = i.getStringExtra("deviceName");
        id = i.getIntExtra("deviceId",0);
        deviceType = i.getStringExtra("deviceType");
        portNumber = i.getIntExtra("portNumber",0);

//        information logging
        Log.i("haha",""+deviceName + " " + triggerIsChecked + " " + id + " " + deviceType + " " + portNumber);
        binding.deviceName.setText(deviceName);
        binding.devicePort.setText(Integer.toString(portNumber));
       binding.deviceType.setText(deviceType);
      binding.devicePower.setText(Integer.toString(power));
      binding.deviceBill.setText(Integer.toString(bill));

//        TextView devicenameview=(TextView)findViewById(R.id.device_name);
//        devicenameview.setText(deviceName);
  }

}
