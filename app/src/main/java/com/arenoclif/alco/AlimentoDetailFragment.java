package com.arenoclif.alco;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arenoclif.alco.data.Alimento;

/**
 * Created by German on 24/11/2014.
 */
public class AlimentoDetailFragment extends Fragment {
    Alimento alimento;

    public AlimentoDetailFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getArguments();
        if (b != null && b.containsKey(Alimento.ALIMENTO_NOMBRE)){
            alimento = new Alimento(b);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alimento_detail_fragment, container, false);

        if (alimento != null){
            TextView tvNombre = (TextView) view.findViewById(R.id.alimentoDetailNombre);
            tvNombre.setText(String.valueOf(alimento.getNombre()));

            TextView tvCreditos = (TextView) view.findViewById(R.id.alimentoDetailCreditos);
            tvCreditos.setText(String.valueOf(alimento.getCreditos()));

            TextView tvUM = (TextView) view.findViewById(R.id.alimentoDetailUnidad);
            tvUM.setText(alimento.getUnidadMedida());

        }

        return view;
    }
}
