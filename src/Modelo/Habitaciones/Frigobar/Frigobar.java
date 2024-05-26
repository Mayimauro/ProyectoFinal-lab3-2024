package Modelo.Habitaciones.Frigobar;

import java.io.Serializable;
import java.util.ArrayList;

public class Frigobar implements Serializable {
    private ArrayList<Producto> productos;

    public Frigobar() {
        this.productos = new ArrayList<>();
    }


    //tostring

    @Override
    public String toString() {
        return "Frigobar{" +
                "productos=" + productos +
                '}';
    }
}
