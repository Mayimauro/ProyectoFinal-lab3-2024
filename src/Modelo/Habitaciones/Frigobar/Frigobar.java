package Modelo.Habitaciones.Frigobar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Según el tipo de habitación se puede tener la opción del frigobar, el cual va a contener productos del tipo Producto.
 */
public class Frigobar implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public void recargar()
    {
        for(Producto p : productos) {
            p.recargar();
        }
    }

    @Override
    public String toString() {
        return "Frigobar{" +
                "productos=" + productos +
                '}';
    }
}
