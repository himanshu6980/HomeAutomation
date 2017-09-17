package com.example.vaibhav.iot;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vaibhav.iot.data.DeviceContract;

/**
 * Created by Vaibhav on 9/18/2017.
 */
public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.DeviceViewHolder> {
    private static final String TAG = DevicesAdapter.class.getName();

    private Cursor mCursor;

    DevicesAdapter(){
        //default constructor
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_item,parent,false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {

        if( mCursor == null || !mCursor.moveToFirst() ){
            Log.i(TAG,"Either cursor is null or number of rows = 0");
            return;
        }

        //set device name:
        String deviceName = mCursor.getString(mCursor.getColumnIndex(DeviceContract.DeviceEntry.COLUMN_DEVICE_NAME));
        holder.deviceName.setText(deviceName);
    }

    @Override
    public int getItemCount() {
        if ( mCursor != null && mCursor.moveToFirst() ) {
            mCursor.moveToFirst();
            return mCursor.getCount();
        }
        else return 0;
    }

    public void swapCursor(Cursor newCursor){
        mCursor = newCursor;
        notifyDataSetChanged();
    }

    class DeviceViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        TextView deviceName;
        SwitchCompat deviceTrigger;

        DeviceViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
