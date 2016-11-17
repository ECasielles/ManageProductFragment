package com.example.usuario.manageproductsrecycler.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.usuario.manageproductsrecycler.R;

public class AccountSettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_settings);
    }
}
