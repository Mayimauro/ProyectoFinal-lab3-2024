package Modelo.Hotel;

import Enums.ETipoComida;
import Genericas.ListaGenericaConsumos;
import Modelo.Habitaciones.Frigobar.Frigobar;
import Modelo.Habitaciones.Frigobar.Producto;
import Modelo.Habitaciones.Habitacion;

import java.util.ArrayList;

public class ServicioHabitacion {
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
    public int consumirProducto(String nombre) {
        Producto p = frigobar.existeProducto(nombre);
        if(p != null)
        {
            if(p.bajaStock())
            {
                consumos.agregarConsumo(p);
                precioFinal += p.getPrecio()*(p.getStock()-2); //calculo el precioFinal cada vez que consume algo
                return 1;
            }else{
                return -1;
            }
        }else
        {
            return 0;
        }
    }

    private void calcularPrecioComidas(ETipoComida e)
    {
        precioFinal += e.getPrecio();
    }

    public void pedirComida(ETipoComida e)
    {
        if(e == ETipoComida.CENA)
        {
            consumos.agregarConsumo(e);
        }else if (e == ETipoComida.ALMUERZO){
            consumos.agregarConsumo(e);
        }else {
            consumos.agregarConsumo(e);
        }
        calcularPrecioComidas(e);
    }

}
