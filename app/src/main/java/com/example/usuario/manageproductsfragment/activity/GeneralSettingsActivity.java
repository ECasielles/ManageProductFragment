package com.example.usuario.manageproductsfragment.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.usuario.manageproductsfragment.R;

public class GeneralSettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.general_settings);
    }
}