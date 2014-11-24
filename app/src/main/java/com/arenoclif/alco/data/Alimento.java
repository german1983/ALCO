package com.arenoclif.alco.data;

import android.os.Bundle;

/**
 * Created by German on 22/11/2014.
 */
public class Alimento {

    //Constants for field references
    public static final String ALIMENTO_NOMBRE = "nombre";
    public static final String ALIMENTO_UM = "unidadMedida";
    public static final String ALIMENTO_CREDITOS = "creditos";

    //Private fields
    private String nombre;
    private String unidadMedida;
    private double creditos;

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

    public Alimento(String nombre, String UM, double creditos){
        setNombre(nombre);
        setUnidadMedida(UM);
        setCreditos(creditos);
    }

    public String toString(){
        return getNombre();
    }

    public Bundle toBundle(){
        Bundle b = new Bundle();
        b.putString(ALIMENTO_NOMBRE, this.getNombre());
        b.putString(ALIMENTO_UM, this.getUnidadMedida());
        b.putDouble(ALIMENTO_CREDITOS, this.getCreditos());
        return b;
    }

    public Alimento (Bundle b) {
        setNombre(b.getString(ALIMENTO_NOMBRE));
        setUnidadMedida(b.getString(ALIMENTO_UM));
        setCreditos(b.getDouble(ALIMENTO_CREDITOS));
    }

}
