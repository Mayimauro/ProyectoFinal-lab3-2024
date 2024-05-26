package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

public class HabitacionEconomica extends Habitacion {
    public static final double PRECIO_BASE_ECONOMICA = 100;
    private boolean aire;

    //constructor para este tipo de habitación
    public HabitacionEconomica(ETipoHabitacion habitacion, boolean aire) {
        super(habitacion);
        super.setPrecioBase(PRECIO_BASE_ECONOMICA);
        this.aire = aire;
    }
    //constructor para el siguiente tipo de habitación que va a tener estos atributos en true
    public HabitacionEconomica(ETipoHabitacion habitacion) {
        super(habitacion);
        super.setPrecioBase(PRECIO_BASE_ECONOMICA);
        this.aire = true;
    }


    //to string


    @Override
    public String toString() {
        return "HabitacionEconomica{"+ super.toString() +
                "aire=" + aire +
                '}';
    }
}
