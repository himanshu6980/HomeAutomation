package com.example.vaibhav.iot;

import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.vaibhav.iot.data.DeviceContract;
import com.example.vaibhav.iot.data.IotDbHelper;
import com.example.vaibhav.iot.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    RecyclerView devicesRecyclerView;
    DevicesAdapter devicesAdapter;
    LinearLayoutManager devicesLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        FloatingActionButton fab = mainBinding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("haha","fab clicked");
                Intent i = new Intent(MainActivity.this, CreateDeviceActivity.class);
                startActivity(i);
            }
        });

        //setting recyclerview
        devicesRecyclerView = mainBinding.devicesRecyclerView;
        devicesAdapter = new DevicesAdapter();
        devicesRecyclerView.setAdapter(devicesAdapter);
        devicesLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        devicesRecyclerView.setLayoutManager(devicesLayoutManager);

        IotDbHelper helper = new IotDbHelper(this);
        Cursor cursor = helper.getReadableDatabase().query(
                DeviceContract.DeviceEntry.TABLE_NAME,null,null,null,null,null,null
        );
        devicesAdapter.swapCursor(cursor);
    }
}
