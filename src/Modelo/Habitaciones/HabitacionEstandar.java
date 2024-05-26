package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

public class HabitacionEstandar extends HabitacionEconomica{
    private boolean vistaAlMar;
    private boolean bañera;
    private boolean frigobar;

    public HabitacionEstandar(ETipoHabitacion habitacion, double precioBase, boolean aire, boolean vistaAlMar, boolean bañera, boolean frigobar) {
        super(habitacion, precioBase, aire);
        this.vistaAlMar = vistaAlMar;
        this.bañera = bañera;
        this.frigobar = frigobar;
    }

    public HabitacionEstandar() {
        super();
        this.vistaAlMar = false;
        this.bañera = false;
        this.frigobar = false;
    }
}
