package com.arenoclif.alco;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.arenoclif.alco.data.Alimento;
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
    Alimento alimento;

    RegistroComidasExpListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public RegistroComidasFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.registro_fragment, container, false);


        listDataHeader = Arrays.asList(getResources().getStringArray(R.array.RegistroMomentos));

        // get the listview
        expListView = (ExpandableListView) rootView.findViewById(R.id.registroListView);

        // preparing list data
        //prepareListData();
        listDataChild = new IngestaData(this.getActivity().getApplicationContext()).getIngestas();

        listAdapter = new RegistroComidasExpListAdapter(this.getActivity().getApplicationContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        return rootView;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Leche");
        top250.add("Chocolate");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Alfajor Terrabusi");
        nowShowing.add("Vauquita Light");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Milanesa al Horno");
        comingSoon.add("Papas al Horno");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
