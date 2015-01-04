package com.arenoclif.alco.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by German on 22/11/2014.
 */
public class AlimentoData {
    private List<Alimento> alimentos = new ArrayList<Alimento>();

    public AlimentoData() {
        alimentos.add(new Alimento("Papa", "Unidad", 2.0, 1, 1000));
        alimentos.add(new Alimento("Maiz", "Gramo", 0.5, 1, 10000));
        alimentos.add(new Alimento("Milanesa", "Gramo", 4.0, 2, 10000));

    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }
}
