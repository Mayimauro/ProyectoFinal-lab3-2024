package Modelo.Habitaciones.Frigobar;

import java.io.Serializable;

public class Producto implements Serializable {
    public static final int STOCK = 2;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = STOCK;
    }
    public Producto() {
        this.nombre = "";
        this.precio = 0;
        this.stock = STOCK;
    }


    //tostring

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
