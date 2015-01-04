package com.arenoclif.alco.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by German on 22/11/2014.
 */
public class Alimento implements Parcelable {

    //Constants for field references
    public static final String ALIMENTO_NOMBRE = "nombre";
    public static final String ALIMENTO_UM = "unidadMedida";
    public static final String ALIMENTO_CREDITOS = "creditos";
    public static final String ALIMENTO_PORCION_MIN = "porcionMin";
    public static final String ALIMENTO_PORCION_MAX = "porcionMax";
    public static final Parcelable.Creator<Alimento> CREATOR = new Parcelable.Creator<Alimento>() {
        public Alimento createFromParcel(Parcel in) {
            return new Alimento(in);
        }

        public Alimento[] newArray(int size) {
            return new Alimento[size];
        }
    };
    //Private fields
    private String nombre;
    private String unidadMedida;
    private double creditos;
    private int porcionMin;
    private int porcionMax;

    public Alimento(String nombre, String UM, double creditos, int porcionMin, int porcionMax) {
        setNombre(nombre);
        setUnidadMedida(UM);
        setCreditos(creditos);
        setPorcionMax(porcionMax);
        setPorcionMin(porcionMin);
    }

    public Alimento(Parcel in) {
        setNombre(in.readString());
        setUnidadMedida(in.readString());
        setCreditos(in.readDouble());
        setPorcionMin(in.readInt());
        setPorcionMax(in.readInt());
    }

    public Alimento(Bundle b) {
        setNombre(b.getString(ALIMENTO_NOMBRE));
        setUnidadMedida(b.getString(ALIMENTO_UM));
        setCreditos(b.getDouble(ALIMENTO_CREDITOS));
        setPorcionMin(b.getInt(ALIMENTO_PORCION_MIN));
        setPorcionMax(b.getInt(ALIMENTO_PORCION_MAX));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getCreditos() {
        return creditos;
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public int getPorcionMax() {
        return porcionMax;
    }

    public void setPorcionMax(int porcionMax) {
        this.porcionMax = porcionMax;
    }

    public int getPorcionMin() {
        return porcionMin;
    }

    public void setPorcionMin(int porcionMin) {
        this.porcionMin = porcionMin;
    }

    public String toString() {
        return getNombre();
    }

    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putString(ALIMENTO_NOMBRE, this.getNombre());
        b.putString(ALIMENTO_UM, this.getUnidadMedida());
        b.putDouble(ALIMENTO_CREDITOS, this.getCreditos());
        b.putInt(ALIMENTO_PORCION_MAX, this.getPorcionMax());
        b.putInt(ALIMENTO_PORCION_MIN, this.getPorcionMin());
        return b;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.getNombre());
        dest.writeString(this.getUnidadMedida());
        dest.writeDouble(this.getCreditos());
        dest.writeInt(this.getPorcionMax());
        dest.writeInt(this.getPorcionMin());
    }


}
