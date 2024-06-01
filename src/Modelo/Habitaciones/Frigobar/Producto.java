package Modelo.Habitaciones.Frigobar;

import java.io.Serializable;

/**
 * Son los productos que va a contener el frigobar.
 */
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

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public boolean bajaStock() {
        if(this.stock >0) {
            stock -= 1;
            return true;
        }else
        {
            return false;
        }
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
