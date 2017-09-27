package com.example.vaibhav.iot;


import android.preference.PreferenceFragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.vaibhav.iot.utilities.AppCompatPreferenceActivity;

public class SettingActivity extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MainPreferenceFragment()).commit();
    }

    public static class MainPreferenceFragment extends PreferenceFragment {
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_main);
            //  bindPreferenceSummaryToValue(findPreference(getString(R.string.key_notifications_new_message_ringtone)));
        }

    }
}