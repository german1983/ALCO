package com.arenoclif.alco;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

/**
 * Created by german1983 on 11/30/14.
 */
public class RegistroComidasActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        RegistroComidasFragment fragment = new RegistroComidasFragment();

        Bundle b = getIntent().getExtras();

        fragment.setArguments(b);

        getFragmentManager().beginTransaction()
                .add(R.id.registroContainer, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
