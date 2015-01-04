package com.arenoclif.alco;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {

    public static int REQUEST_PREFERENCES = 1002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_buscador) {
            Intent intent = new Intent(this, SelectorAlimentosActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_registro) {
            Intent intent = new Intent(this, RegistroComidasActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_settings) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsActivity.class);
            startActivityForResult(intent, this.REQUEST_PREFERENCES);
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == this.REQUEST_PREFERENCES) {
            SharedPreferences misPreferencias =
                    PreferenceManager.getDefaultSharedPreferences(this);
            String pref1 = misPreferencias.getString(getResources()
                    .getString(R.string.prefContexturaKey), "Error");
            Toast.makeText(this, "Seleccionaste: " + pref1, Toast.LENGTH_LONG).show();
        }
    }
}
