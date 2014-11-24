package com.arenoclif.alco;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.arenoclif.alco.data.Alimento;
import com.arenoclif.alco.data.AlimentoData;

import java.util.List;

/**
 * Created by German on 22/11/2014.
 */
public class AlimentoArrayAdapter extends ArrayAdapter<Alimento>{

    private Context context;
    private List<Alimento> alimentos;

    public AlimentoArrayAdapter(Context context, int resource, List<Alimento> objects) {
        super(context, resource, objects);
        this.context = context;
        this.alimentos = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Alimento alimento = alimentos.get(position);

        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.alimento_listitem, null);

        TextView nombre = (TextView) view.findViewById(R.id.alimentoNombre);
        nombre.setText(alimento.getNombre());

        TextView unidadMedida = (TextView) view.findViewById(R.id.alimentoUM);
        unidadMedida.setText(alimento.getUnidadMedida());

        TextView creditos = (TextView) view.findViewById(R.id.alimentoCreditos);
        double creditosNumero = alimento.getCreditos();
        creditos.setText(String.valueOf(creditosNumero));

        return view;
    }
}
