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

    public void argrgarProductos(Producto producto) {
        productos.add(producto);
    }

    public Producto existeProducto(String nombre) {

        for(Producto p : productos) {
            if(p.getNombre().equals(nombre)) {
                return p;
            }
        }
        return null;
    }

    public int devolverStock(int num)
    {
        return productos.get(num).getStock();
    }

    @Override
    public String toString() {
        return "Frigobar{" +
                "productos=" + productos +
                '}';
    }
}
