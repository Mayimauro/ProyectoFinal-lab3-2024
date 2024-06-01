package Modelo.Habitaciones.Frigobar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Según el tipo de habitación se puede tener la opción del frigobar, el cual va a contener productos del tipo Producto.
 */
public class Frigobar implements Serializable {
    private ArrayList<Producto> productos;

    public Frigobar() {
        this.productos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Frigobar{" +
                "productos=" + productos +
                '}';
    }
}
