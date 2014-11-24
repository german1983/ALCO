package com.arenoclif.alco;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arenoclif.alco.data.Alimento;


public class SelectorAlimentosActivity extends Activity
implements AlimentosListFragment.Callbacks{

    public static final String ALIMENTO_BUNDLE = "ALIMENTO_BUNDLE";
    private static final int REQUEST_CODE = 1001;

    private boolean isTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador_alimentos);

        if(findViewById(R.id.detailContainer) != null){
            isTwoPane = true;
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(Alimento alimento) {
        Bundle b = alimento.toBundle();

        if (isTwoPane){
            AlimentoDetailFragment fragment = new AlimentoDetailFragment();
            fragment.setArguments(b);
            getFragmentManager().beginTransaction()
                    .replace(R.id.detailContainer, fragment)
                    .commit();
        }
        else {
            Intent intent = new Intent(this, AlimentoDetailActivity.class);
            intent.putExtra(ALIMENTO_BUNDLE, b);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }
}
