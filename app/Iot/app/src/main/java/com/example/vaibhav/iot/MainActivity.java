package com.example.vaibhav.iot;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        //finding the views
        devicesRecyclerView = mainBinding.devicesRecyclerView;
        devicesAdapter = new DevicesAdapter();
        devicesRecyclerView.setAdapter(devicesAdapter);
        devicesLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        devicesRecyclerView.setLayoutManager(devicesLayoutManager);
    }
}
