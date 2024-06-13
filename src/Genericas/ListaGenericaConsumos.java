package Genericas;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaGenericaConsumos implements Serializable {

    private static final long serialVersionUID = 1L;

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
