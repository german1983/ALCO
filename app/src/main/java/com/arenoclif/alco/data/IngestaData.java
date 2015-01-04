package com.arenoclif.alco.data;

import android.content.Context;
import android.os.Bundle;

import com.arenoclif.alco.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by german1983 on 12/8/14.
 */
public class IngestaData {
    private List<Ingesta> ingestas = new ArrayList<Ingesta>();
    private HashMap<String, List<String>> ingestasDummy = new HashMap<String, List<String>>();
    private List<Alimento> alimentos = new ArrayList<Alimento>();
    private List<String> momentos;
    private Context context;

    public IngestaData(Context c) {
        context = c;
        alimentos = new AlimentoData().getAlimentos();

        momentos = Arrays.asList(context.getResources().getStringArray(R.array.RegistroMomentos));

        int cantidad_alimentos = alimentos.size();
        int cantidad_momentos = momentos.size();
        double max_porcion = 5.0;
        Random rnd = new Random();

        int cantRnd = rnd.nextInt(20);

        for (int i = 0; i < cantRnd + 1; i++) {
            String m = momentos.get(rnd.nextInt(cantidad_momentos));
            ingestas.add(
                    new Ingesta(alimentos.get(rnd.nextInt(cantidad_alimentos)),
                            rnd.nextDouble() * max_porcion,
                            m));
        }

        Collections.sort(ingestas, new IngestaComparator());

        String momento;
        String momentoAnterior = "0";
        List<String> lstIngestaPorMomento = null;

        int i = 0;
        do {
            Ingesta ingestaParaIncorporar = (Ingesta) ingestas.get(i++);
            momento = ingestaParaIncorporar.getMomento();

            if ((lstIngestaPorMomento == null)) {
                lstIngestaPorMomento = new ArrayList<String>();
            } else if (!momento.equals(momentoAnterior)) {
                ingestasDummy.put(momentoAnterior, lstIngestaPorMomento);
                lstIngestaPorMomento = new ArrayList<String>();
            }
            lstIngestaPorMomento.add(ingestaParaIncorporar.getAlimento().getNombre() + " - " +
                    ingestaParaIncorporar.getCantidad());
            momentoAnterior = momento;

        } while (i < ingestas.size());
        cantRnd = 0;
    }

    public IngestaData(Bundle bundle) {
        double cantidad = bundle.getDouble(Ingesta.INGESTA_CANTIDAD);
        String momento = bundle.getString(Ingesta.INGESTA_MOMENTO);
        Bundle alimento = bundle.getBundle(Ingesta.INGESTA_ALIMENTO);
        String alimentoNombre = alimento.getString(Alimento.ALIMENTO_NOMBRE);

        if (ingestasDummy.containsKey(momento)) {
            ingestasDummy.get(momento).add(alimentoNombre + " - " + cantidad);
        } else {
            List<String> lstIngesta = new ArrayList<String>();
            lstIngesta.add(alimentoNombre + " - " + cantidad);
            ingestasDummy.put(momento, lstIngesta);
        }

    }

    public IngestaData(ArrayList<Ingesta> ingestas) {

        Iterator<Ingesta> iterIngestas = ingestas.iterator();

        while (iterIngestas.hasNext()) {
            Ingesta ingesta = iterIngestas.next();
            double cantidad = ingesta.getCantidad();
            String momento = ingesta.getMomento();
            Bundle alimento = ingesta.getAlimento().toBundle();
            String alimentoNombre = alimento.getString(Alimento.ALIMENTO_NOMBRE);

            if (ingestasDummy.containsKey(momento)) {
                ingestasDummy.get(momento).add(alimentoNombre + " - " + cantidad);
            } else {
                List<String> lstIngesta = new ArrayList<String>();
                lstIngesta.add(alimentoNombre + " - " + cantidad);
                ingestasDummy.put(momento, lstIngesta);
            }
        }
    }

    public HashMap<String, List<String>> getIngestas() {
        return ingestasDummy;
    }
}
