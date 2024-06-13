package Modelo.Hotel;

import Enums.ETipoComida;
import Genericas.ListaGenericaConsumos;
import Modelo.Habitaciones.Frigobar.Frigobar;
import Modelo.Habitaciones.Frigobar.Producto;
import Modelo.Habitaciones.Habitacion;

import java.io.Serializable;
import java.util.ArrayList;

public class ServicioHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private Habitacion habitacion;
    private Frigobar frigobar;
    private ListaGenericaConsumos consumos;
    private double precioFinal;

    public ServicioHabitacion(Habitacion habitacion, Frigobar frigobar) {
        this.habitacion = habitacion;
        this.frigobar = frigobar;
        this.consumos = new ListaGenericaConsumos();
        precioFinal = 0;
    }

    /**
     * funcion para consumir productos del frigobar, ademas calcula el precio final de lo que va consumiendo
     * @param nombre recibe el nombre del producto a consumir
     * @return devuleve 1 si se confirmo la consumicion
     * @return devuleve -1 si no hay mas stock del producto que quiere consumir
     * @return devuleve 0 si no hay de ese producto en el frigobar
     */
    public boolean consumirProducto(String nombre) {
        Producto p = frigobar.existeProducto(nombre);

        if(p != null)
        {
            if(p.bajaStock())
            {
                consumos.agregarConsumo(p);
                precioFinal = precioFinal + p.getPrecio();
                return true;
            }
        }
        return false;
    }

    private void calcularPrecioComidas(ETipoComida e)
    {
        precioFinal = precioFinal + e.getPrecio();
    }

    public boolean pedirComida(ETipoComida e)
    {
        boolean pedido = false;
        if(e == ETipoComida.CENA)
        {
            consumos.agregarConsumo(e);
            pedido = true;
        }else if (e == ETipoComida.ALMUERZO){
            consumos.agregarConsumo(e);
            pedido = true;
        }else {
            consumos.agregarConsumo(e);
            pedido = true;
        }
        calcularPrecioComidas(e);
        return pedido;
    }

    public int verStock(int x)
    {
        return frigobar.devolverStock(x);
    }

    public void recargarFrigobar()
    {
        frigobar.recargar();
    }

    public double getPrecioFinal()
    {
        return precioFinal;
    }

}
