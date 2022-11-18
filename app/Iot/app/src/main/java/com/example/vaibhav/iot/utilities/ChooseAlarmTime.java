package com.example.vaibhav.iot.utilities;

/**
 * Created by f71ud on 25/09/2017.
 */


import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.vaibhav.iot.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChooseAlarmTime extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(),R.style.DialogTheme,this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView ;
        textView= (TextView)getActivity().findViewById(R.id.textView_hour);
        textView.setText(String.valueOf(hourOfDay)+":"+String.valueOf(minute));
        try {
            Date date = new SimpleDateFormat("h:mm a").parse(textView.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
