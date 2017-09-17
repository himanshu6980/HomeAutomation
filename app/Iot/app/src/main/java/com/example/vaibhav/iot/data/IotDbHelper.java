package com.example.vaibhav.iot.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vaibhav on 9/18/2017.
 */
public class IotDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "iot.db";

    private static final int DATABASE_VERSION = 1;

    public IotDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DeviceContract.DeviceEntry.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DeviceContract.DeviceEntry.TABLE_NAME);
        onCreate(db);
    }
}
