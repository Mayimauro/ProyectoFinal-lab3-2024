package Modelo.Habitaciones.Frigobar;

public class Producto {
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
}
