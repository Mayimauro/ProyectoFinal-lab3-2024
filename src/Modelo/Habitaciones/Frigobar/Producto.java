package Modelo.Habitaciones.Frigobar;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public Producto() {
        this.nombre = "";
        this.precio = 0;
        this.stock = 0;
    }
}
