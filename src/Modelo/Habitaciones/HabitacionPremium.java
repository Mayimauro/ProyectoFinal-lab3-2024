package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

public class HabitacionPremium extends HabitacionEstandar{
    private boolean jacuzzi;
    private boolean servicioDesayuno;

    public HabitacionPremium(ETipoHabitacion habitacion, double precioBase, boolean aire, boolean vistaAlMar, boolean bañera, boolean frigobar, boolean jacuzzi, boolean servicioDesayuno) {
        super(habitacion, precioBase, aire, vistaAlMar, bañera, frigobar);
        this.jacuzzi = jacuzzi;
        this.servicioDesayuno = servicioDesayuno;
    }

    public HabitacionPremium() {
        super();
        this.jacuzzi = false;
        this.servicioDesayuno = false;
    }
}
