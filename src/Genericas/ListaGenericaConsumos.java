package Genericas;

import java.util.ArrayList;

public class ListaGenericaConsumos {
    public ArrayList<Object> consumos;

    public ListaGenericaConsumos() {
        this.consumos = new ArrayList<>();
    }

    public ArrayList<Object> getConsumos() {
        return consumos;
    }

    public void agregarConsumo(Object o)
    {
        consumos.add(o);
    }
}
