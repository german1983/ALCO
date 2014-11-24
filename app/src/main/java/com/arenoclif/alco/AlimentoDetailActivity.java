package com.arenoclif.alco;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Created by German on 24/11/2014.
 */
public class AlimentoDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_alimento);

        if (savedInstanceState == null){
            AlimentoDetailFragment fragment = new AlimentoDetailFragment();

            Bundle b = getIntent().getBundleExtra(SelectorAlimentosActivity.ALIMENTO_BUNDLE);
            fragment.setArguments(b);

            getFragmentManager().beginTransaction()
                    .add(R.id.detailContainer, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return true;
    }
}
