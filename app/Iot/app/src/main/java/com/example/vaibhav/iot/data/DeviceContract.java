package com.example.vaibhav.iot.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Vaibhav on 9/18/2017.
 */
public class DeviceContract {

    private static final String TAG = DeviceContract.class.getSimpleName();

    public static final String CONTENT_AUTHORITY = "com.example.vaibhav.iot";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static class DeviceEntry implements BaseColumns {
        public static final String PATH = "devices";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH)
                .build();
        public static final String TABLE_NAME = "devices";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_DEVICE_NAME = "name";
        public static final String COLUMN_LAST_TRIGGERED = "lastTriggered";
        public static final String COLUMN_DEVICE_STATE = "state";
        public static final String COLUMN_DEVICE_TYPE = "type";
        public static final String COLUMN_DEVICE_PORT_NUMBER = "port";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_DATE + " INTEGER, " +
                COLUMN_DEVICE_NAME + " TEXT NOT NULL, " +
                COLUMN_LAST_TRIGGERED + " INTEGER, " +
                COLUMN_DEVICE_STATE + " INTEGER DEFAULT 0, " +
                COLUMN_DEVICE_TYPE + " TEXT NOT NULL, " +
                COLUMN_DEVICE_PORT_NUMBER + " INTEGER NOT NULL, " +

                /*
                 * To ensure this table can only contain one weather entry per date, we declare
                 * the date column to be unique. We also specify "ON CONFLICT REPLACE". This tells
                 * SQLite that if we have a weather entry for a certain date and we attempt to
                 * insert another weather entry with that date, we replace the old weather entry.
                 */
                " UNIQUE (" + COLUMN_DATE + ") ON CONFLICT REPLACE);";
    }

}
