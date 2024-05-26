package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

public class HabitacionEstandar extends HabitacionEconomica{
    public static final double PRECIO_BASE_ESTANDAR = 150;
    private boolean vistaAlMar;
    private boolean bañera;
    private boolean frigobar;

    //constructor para este tipo de habitación
    public HabitacionEstandar(ETipoHabitacion habitacion, boolean vistaAlMar, boolean bañera, boolean frigobar) {
        super(habitacion);
        super.setPrecioBase(PRECIO_BASE_ESTANDAR);
        this.vistaAlMar = vistaAlMar;
        this.bañera = bañera;
        this.frigobar = frigobar;
    }
    //constructor para el siguiente tipo de habitación que va a tener estos atributos en true
    public HabitacionEstandar(ETipoHabitacion habitacion) {
        super(habitacion);
        super.setPrecioBase(PRECIO_BASE_ESTANDAR);
        this.vistaAlMar = true;
        this.bañera = true;
        this.frigobar = true;
    }

}
