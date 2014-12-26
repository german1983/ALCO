package com.arenoclif.alco.data;

import android.os.Bundle;

import java.util.Comparator;

/**
 * Created by german1983 on 12/8/14.
 */
public class Ingesta {
    //Constants for field references
    public static final String INGESTA_ALIMENTO = "alimento";
    public static final String INGESTA_CANTIDAD = "cantidad";
    public static final String INGESTA_MOMENTO = "momento";

    // Atributos
    private Alimento alimento;
    private double cantidad;
    private String momento;


    public Ingesta(Bundle b) {
        setAlimento(new Alimento(b.getBundle(INGESTA_ALIMENTO)));
        setCantidad(b.getDouble(INGESTA_CANTIDAD));
        setMomento(b.getString(INGESTA_MOMENTO));
    }

    public Ingesta(Alimento a, double c, String m) {
        setCantidad(c);
        setAlimento(a);
        setMomento(m);
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMomento() {
        return momento;
    }

    public void setMomento(String momento) {
        this.momento = momento;
    }

    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putBundle(INGESTA_ALIMENTO, this.getAlimento().toBundle());
        b.putDouble(INGESTA_CANTIDAD, this.getCantidad());
        b.putString(INGESTA_MOMENTO, this.getMomento());
        return b;
    }

}

class IngestaComparator implements Comparator<Ingesta> {
    @Override
    public int compare(Ingesta lhs, Ingesta rhs) {
        return lhs.getMomento().compareTo(rhs.getMomento());
    }
}
