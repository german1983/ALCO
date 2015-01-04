package com.arenoclif.alco;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.arenoclif.alco.data.Ingesta;
import com.arenoclif.alco.data.IngestaData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by german1983 on 11/30/14.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RegistroComidasFragment extends Fragment {

    static ArrayList<Ingesta> ingestas = new ArrayList<Ingesta>();
    IngestaData iData;
    RegistroComidasExpListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Ingesta ingesta;

    public RegistroComidasFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // bundle = savedInstanceState;
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(Ingesta.INGESTA)) {
            ingesta = bundle.getParcelable(Ingesta.INGESTA);
            ingestas.add(ingesta);
//            Parcelable[] parcelables = bundle.getParcelableArray(Ingesta.INGESTA);
//            if (parcelables != null) {
//                ingestas = Arrays.copyOf(parcelables, parcelables.length, Ingesta[].class);
//            }


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        listDataHeader = Arrays.asList(getResources().getStringArray(R.array.RegistroMomentos));
        View rootView = inflater.inflate(R.layout.registro_fragment, container, false);
        // get the listview
        expListView = (ExpandableListView) rootView.findViewById(R.id.registroListView);

        // preparing list data
        prepareListData();

        listAdapter = new RegistroComidasExpListAdapter(this.getActivity().getApplicationContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        return rootView;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        if (ingesta == null)
            iData = new IngestaData(this.getActivity().getApplicationContext());
        else
            iData = new IngestaData(ingestas);
        listDataChild = iData.getIngestas();
    }
}
