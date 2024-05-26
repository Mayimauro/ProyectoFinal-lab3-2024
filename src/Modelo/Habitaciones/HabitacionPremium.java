package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

public class HabitacionPremium extends HabitacionEstandar{
    public static final double PRECIO_BASE_PREIMIUM = 200;
    private boolean jacuzzi;
    private boolean servicioDesayuno;

    public HabitacionPremium(ETipoHabitacion habitacion, boolean jacuzzi, boolean servicioDesayuno) {
        super(habitacion);
        super.setPrecioBase(PRECIO_BASE_PREIMIUM);
        this.jacuzzi = jacuzzi;
        this.servicioDesayuno = servicioDesayuno;
    }

}
