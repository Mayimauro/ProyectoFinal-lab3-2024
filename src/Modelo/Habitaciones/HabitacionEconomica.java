package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

public class HabitacionEconomica extends Habitacion {
    private boolean aire;

    public HabitacionEconomica(ETipoHabitacion habitacion, double precioBase, boolean aire) {
        super(habitacion, precioBase);
        this.aire = aire;
    }

    public HabitacionEconomica() {
        super();
        this.aire = false;
    }
}
