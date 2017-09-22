package com.example.vaibhav.iot;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vaibhav.iot.data.DeviceContract;
import com.example.vaibhav.iot.data.IotDbHelper;
import com.example.vaibhav.iot.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    DevicesAdapter devicesAdapter;
    GridLayoutManager devicesLayoutManager;

    ActionBarDrawerToggle mDrawerToggle;

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

        configureDrawer();

        //setting recyclerview
        devicesAdapter = new DevicesAdapter(this);
        mainBinding.devicesRecyclerView.setAdapter(devicesAdapter);
        devicesLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        mainBinding.devicesRecyclerView.setLayoutManager(devicesLayoutManager);

        IotDbHelper helper = new IotDbHelper(this);
        Cursor cursor = helper.getReadableDatabase().query(
                DeviceContract.DeviceEntry.TABLE_NAME,null,null,null,null,null,null
        );
        devicesAdapter.swapCursor(cursor);
    }

    private void configureDrawer() {
        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_layout);
        final RelativeLayout mainContent = findViewById(R.id.main_content);
        final ListView listView = findViewById(R.id.listview);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mainBinding.drawerLayout,
                mainBinding.toolBar,
                R.string.open_drawer,
                R.string.closeDrawer
        ){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset)
            {
                //TODO: this probably works only on honeycomb or later... make sure to update when you lower minSdk
                //https://stackoverflow.com/questions/20057084/how-to-move-main-content-with-drawer-layout-left-side
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (listView.getWidth() * slideOffset);

                mainContent.setTranslationX(moveFactor);
            }


        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.drawer_item,getResources().getStringArray(R.array.drawer_array));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = ((TextView) view).getText().toString();
                switch (text){
                    case "Settings":
                        Toast.makeText(MainActivity.this,"Settings clicked",Toast.LENGTH_SHORT).show();
                        break;
                    //TODO: to be done by HIMANSHU
                    //TODO: for signout, you will need to clear the shared preferences for email and password
                }
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

}
