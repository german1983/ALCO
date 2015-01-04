package com.arenoclif.alco;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by german1983 on 1/4/15.
 */
public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
