package com.arenoclif.alco;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by german1983 on 1/4/15.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
    }
}
