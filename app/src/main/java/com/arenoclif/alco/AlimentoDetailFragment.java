package com.arenoclif.alco;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.arenoclif.alco.data.Alimento;
import com.arenoclif.alco.data.Ingesta;

/**
 * Created by German on 24/11/2014.
 */
public class AlimentoDetailFragment extends Fragment {
    Alimento alimento;
    View view;

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
        view = inflater.inflate(R.layout.alimento_detail_fragment, container, false);

        if (alimento != null){
            TextView tvNombre = (TextView) view.findViewById(R.id.alimentoDetailNombre);
            tvNombre.setText(String.valueOf(alimento.getNombre()));

            TextView tvCreditos = (TextView) view.findViewById(R.id.alimentoDetailCreditos);
            tvCreditos.setText(String.valueOf(alimento.getCreditos()));

            TextView tvUM = (TextView) view.findViewById(R.id.alimentoDetailUnidad);
            tvUM.setText(alimento.getUnidadMedida());

            SeekBar porcion = (SeekBar) view.findViewById(R.id.seekBarPorcion);
            porcion.setMax(alimento.getPorcionMax());
            porcion.setProgress(alimento.getPorcionMin());
            porcion.setOnSeekBarChangeListener(new porcionChanged());

            Button btnIncorporar = (Button) view.findViewById(R.id.btnIncorporar);
            btnIncorporar.setOnClickListener(new incorporarPressed());

        }

        return view;
    }


    private class porcionChanged implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)

        {
            EditText tamanoPorcion = (EditText) view.findViewById(R.id.txtTamanoPorcion);
            TextView creditosPorcion = (TextView) view.findViewById(R.id.txtCreditosPorcion);

            float value = (float) (progress / 10.0);
            float totalCreditosPorcion = value * (float) alimento.getCreditos();
            tamanoPorcion.setText((value) + "\n");
            creditosPorcion.setText((totalCreditosPorcion) + "\n");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

    }

    private class incorporarPressed implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            Log.d("com.arenoclif.alco", "Se incorporará un alimento");
            // EditText tamanoPorcion  =(EditText)v.findViewById(R.id.txtTamanoPorcion);
            TextView creditosPorcion = (TextView) view.findViewById(R.id.txtCreditosPorcion);
            Spinner horario = (Spinner) view.findViewById(R.id.cmbHorarios);

            CharSequence chrCreditosPorcion = creditosPorcion.getText();
            String strCreditosPorcion = String.valueOf(chrCreditosPorcion);
            Double dblCreditosPorcion = Double.valueOf(strCreditosPorcion);

            Ingesta nuevaIngesta = new Ingesta(alimento,
                    dblCreditosPorcion,
                    String.valueOf(horario.getSelectedItem()));

            Intent i = new Intent(v.getContext(), RegistroComidasActivity.class);
            i.putExtra(Ingesta.INGESTA, nuevaIngesta);

            startActivity(i);
        }
    }
}

