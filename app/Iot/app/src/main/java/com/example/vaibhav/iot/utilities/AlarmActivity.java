package com.example.vaibhav.iot.utilities;


import android.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.vaibhav.iot.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        final TextView textViewHourAndMInute;
        final FragmentManager fragmentManager = getSupportFragmentManager();
        EditText editTextMsg;
        Button buttonsetAlarm;
       /* DateFormat df = new SimpleDateFormat("h:mm a");
        String date = df.format(Calendar.getInstance().getTime());*/

        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        textViewHourAndMInute =(TextView)findViewById(R.id.textView_hour);
        editTextMsg = (EditText)findViewById(R.id.editText_msg);
        buttonsetAlarm= (Button)findViewById(R.id.button_setAlarm);

        // textViewHourAndMInute.setText(date);

        textViewHourAndMInute.setText(today.format("%k:%M"));
        String Time_1 = textViewHourAndMInute.getText().toString();

        textViewHourAndMInute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseAlarmTime chooseAlarmTime =new ChooseAlarmTime();
                chooseAlarmTime.show(fragmentManager,"TimePicker");

            }
        });
        buttonsetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Time_2 = textViewHourAndMInute.getText().toString();


            }
        });


    }
}
