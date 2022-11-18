package com.example.vaibhav.iot;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vaibhav.iot.data.DeviceContract;
import com.example.vaibhav.iot.data.IotDbHelper;

public class CreateDeviceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_device);

        Button button = findViewById(R.id.create_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add details entered to database
                save();
                //then send intent to mainActivity
                Intent i = new Intent(CreateDeviceActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void save(){
        EditText deviceNameView = findViewById(R.id.name);
        String deviceName = deviceNameView.getText().toString();
        long deviceDateCreated = System.currentTimeMillis();
        Spinner deviceTypeSpinner = findViewById(R.id.device_type_spinner);
        EditText devicePortNumberView = findViewById(R.id.device_port_number);
        int devicePortNumber = Integer.valueOf(devicePortNumberView.getText().toString());

        //enter this info in database
        ContentValues values = new ContentValues();
        values.put(DeviceContract.DeviceEntry.COLUMN_DEVICE_NAME, deviceName);
        values.put(DeviceContract.DeviceEntry.COLUMN_DATE, deviceDateCreated);
        values.put(DeviceContract.DeviceEntry.COLUMN_LAST_TRIGGERED, deviceDateCreated);
        values.put(DeviceContract.DeviceEntry.COLUMN_DEVICE_TYPE, deviceTypeSpinner.getSelectedItem().toString());
        values.put(DeviceContract.DeviceEntry.COLUMN_DEVICE_PORT_NUMBER, devicePortNumber);
        IotDbHelper helper = new IotDbHelper(this);

        long count = helper.getWritableDatabase().insert(DeviceContract.DeviceEntry.TABLE_NAME, null, values);
        if(count>0){
            Toast.makeText(this,"device created successfully",Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this,"some problem occurred",Toast.LENGTH_SHORT).show();
    }
}
