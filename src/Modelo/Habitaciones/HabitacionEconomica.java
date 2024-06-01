package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

public class HabitacionEconomica extends Habitacion {
    public static final double PRECIO_BASE_ECONOMICA = 100;
    private boolean aire; //20

    /**
     * Constructor diseñado para este tipo de habitación, donde el usuario elije las comodidades adicionales.
     */
    public HabitacionEconomica(ETipoHabitacion habitacion, boolean aire) {
        super(habitacion);
        super.setPrecioBase(PRECIO_BASE_ECONOMICA);
        this.aire = aire;
    }

    /**
     * Constructor diseñado para el tipo de habitación que hereda de esta, la cual va a tener todas las comodidades
     * incluidas.
     */
    public HabitacionEconomica(ETipoHabitacion habitacion) {
        super(habitacion);
        super.setPrecioBase(PRECIO_BASE_ECONOMICA);
        this.aire = true;
    }

    /**
     * Método heredado y sobreescrito para calcular el costo adicional.
     * @return retorna el costo adicional según las comodidades elejidas por el usuario.
     */
    @Override
    public double calcularCostoAdiconal() {
        if(aire)
        {
            return super.calcularCostoAdiconal() + 20;
        }
        else return super.calcularCostoAdiconal();
    }

    @Override
    public String toString() {
        return "HabitacionEconomica{"+ super.toString() +
                "aire=" + aire +
                '}';
    }
}
