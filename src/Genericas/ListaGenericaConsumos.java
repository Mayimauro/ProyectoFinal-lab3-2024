package Genericas;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaGenericaConsumos<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public ArrayList<T> consumos;

    public ListaGenericaConsumos() {
        this.consumos = new ArrayList<>();
    }

    public ArrayList<T> getConsumos() {
        return consumos;
    }

    public void agregarConsumo(T t)
    {
        consumos.add(t);
    }
}
