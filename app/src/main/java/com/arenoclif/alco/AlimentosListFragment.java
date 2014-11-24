package com.arenoclif.alco;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.arenoclif.alco.data.Alimento;
import com.arenoclif.alco.data.AlimentoData;

import java.util.List;

public class AlimentosListFragment extends ListFragment {

    List<Alimento> alimentos = new AlimentoData().getAlimentos();
    private Callbacks activity;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AlimentosListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlimentoArrayAdapter adapter = new AlimentoArrayAdapter(getActivity(),
                R.layout.alimento_listitem,
                alimentos);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.alimentos_list_fragment, container, false);
        return rootView;
    }

    public interface Callbacks {
        public void onItemSelected(Alimento alimento);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Alimento alimento = alimentos.get(position);
        Log.d("ListItemClick", "Paso 1");
        activity.onItemSelected(alimento);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (Callbacks) activity;
    }
}
