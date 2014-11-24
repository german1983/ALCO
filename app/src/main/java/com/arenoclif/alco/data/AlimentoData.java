package com.arenoclif.alco.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by German on 22/11/2014.
 */
public class AlimentoData {
    private List<Alimento> alimentos = new ArrayList<Alimento>();

    public List<Alimento> getAlimentos(){
        return alimentos;
    }

    public AlimentoData(){
        alimentos.add(new Alimento("Papa", "Unidad", 2.0));
        alimentos.add(new Alimento("Maiz", "Gramo", 0.5));
        alimentos.add(new Alimento("Milanesa", "Gramo", 4.0));

    }
}
