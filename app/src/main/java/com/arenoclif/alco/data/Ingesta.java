package com.arenoclif.alco.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

/**
 * Created by german1983 on 12/8/14.
 */
public class Ingesta implements Parcelable {
    //Constants for field references
    public static final String INGESTA_ALIMENTO = "alimento";
    public static final String INGESTA_CANTIDAD = "cantidad";
    public static final String INGESTA_MOMENTO = "momento";
    public static final String INGESTA = "com.arenoclif.ingesta";
    public static final Parcelable.Creator<Ingesta> CREATOR = new Parcelable.Creator<Ingesta>() {
        public Ingesta createFromParcel(Parcel in) {
            return new Ingesta(in);
        }

        public Ingesta[] newArray(int size) {
            return new Ingesta[size];
        }
    };
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

    public Ingesta(Parcel in) {
        setAlimento((Alimento) in.readParcelable(Alimento.class.getClassLoader()));
        setCantidad(in.readDouble());
        setMomento(in.readString());
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.getAlimento(), flags);
        dest.writeDouble(this.getCantidad());
        dest.writeString(this.getMomento());
    }
}

class IngestaComparator implements Comparator<Ingesta> {
    @Override
    public int compare(Ingesta lhs, Ingesta rhs) {
        return lhs.getMomento().compareTo(rhs.getMomento());
    }
}
