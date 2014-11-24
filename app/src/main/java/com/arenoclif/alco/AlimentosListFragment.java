package com.arenoclif.alco;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.arenoclif.alco.data.Alimento;
import com.arenoclif.alco.data.AlimentoData;

import java.util.List;

public class AlimentosListFragment extends ListFragment {

    List<Alimento> alimentos = new AlimentoData().getAlimentos();
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

}
