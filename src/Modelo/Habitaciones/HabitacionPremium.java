package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

public class HabitacionPremium extends HabitacionEstandar{
    public static final double PRECIO_BASE_PREIMIUM = 350;
    private boolean jacuzzi; //50
    private boolean servicioDesayuno; //0

    public HabitacionPremium(ETipoHabitacion habitacion, boolean jacuzzi, boolean servicioDesayuno) {
        super(habitacion);
        super.setPrecioBase(PRECIO_BASE_PREIMIUM);
        this.jacuzzi = jacuzzi;
        this.servicioDesayuno = servicioDesayuno;
    }

    @Override
    public double calcularCostoAdiconal() {
        if(jacuzzi)
        {
            return super.calcularCostoAdiconal() + 50;
        }
        else return super.calcularCostoAdiconal();
    }

    //toString


    @Override
    public String toString() {
        return "HabitacionPremium{"+ super.toString() +
                "jacuzzi=" + jacuzzi +
                ", servicioDesayuno=" + servicioDesayuno +
                '}';
    }
}
