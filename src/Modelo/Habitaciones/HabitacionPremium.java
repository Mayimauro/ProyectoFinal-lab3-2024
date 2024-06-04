package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

public class HabitacionPremium extends HabitacionEstandar{
    public static final double PRECIO_BASE_PREIMIUM = 350;
    private boolean jacuzzi; //50
    private boolean servicioDesayuno; //0

    /**
     * Constructor diseñado para este tipo de habitación, donde el usuario elije las comodidades adicionales.
     */
    public HabitacionPremium(ETipoHabitacion habitacion, boolean jacuzzi, boolean servicioDesayuno) {
        super(habitacion);
        super.setPrecioBase(PRECIO_BASE_PREIMIUM);
        this.jacuzzi = jacuzzi;
        this.servicioDesayuno = servicioDesayuno;
    }

    /**
     * Método heredado y sobreescrito para calcular el costo adicional.
     * @return retorna el costo adicional según las comodidades elejidas por el usuario.
     */
    @Override
    public double calcularCostoAdiconal() {
        if(jacuzzi)
        {
            return super.calcularCostoAdiconal() + 50;
        }
        else return super.calcularCostoAdiconal();
    }

    @Override
    public String toString() {
        return super.toString() +
                "jacuzzi=" + jacuzzi +
                ", servicioDesayuno=" + servicioDesayuno+", ";
    }
}
