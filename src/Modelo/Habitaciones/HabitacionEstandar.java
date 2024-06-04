package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

public class HabitacionEstandar extends HabitacionEconomica {
    public static final double PRECIO_BASE_ESTANDAR = 150;
    private boolean vistaAlMar; //30
    private boolean bañera; //20
    private boolean frigobar; //0

    /**
     * Constructor diseñado para este tipo de habitación, donde el usuario elije las comodidades adicionales.
     */
    public HabitacionEstandar(ETipoHabitacion habitacion, boolean vistaAlMar, boolean bañera, boolean frigobar) {
        super(habitacion);
        super.setPrecioBase(PRECIO_BASE_ESTANDAR);
        this.vistaAlMar = vistaAlMar;
        this.bañera = bañera;
        this.frigobar = frigobar;
    }

    /**
     * Constructor diseñado para el tipo de habitación que hereda de esta, la cual va a tener todas las comodidades
     * incluidas.
     */
    public HabitacionEstandar(ETipoHabitacion habitacion) {
        super(habitacion);
        super.setPrecioBase(PRECIO_BASE_ESTANDAR);
        this.vistaAlMar = true;
        this.bañera = true;
        this.frigobar = true;
    }

    /**
     * Método heredado y sobreescrito para calcular el costo adicional.
     * @return retorna el costo adicional según las comodidades elejidas por el usuario.
     */
    @Override
    public double calcularCostoAdiconal() {
        double adicional = 0;

        if(vistaAlMar && bañera)
        {
            adicional += 50;
        } else if (!vistaAlMar && bañera) {
            adicional += 30;

        } else if (vistaAlMar && !bañera) {
            adicional += 20;
        }

        return super.calcularCostoAdiconal() + adicional;
    }

    @Override
    public String toString() {
        return super.toString()+
                "vistaAlMar=" + vistaAlMar +
                ", bañera=" + bañera +
                ", frigobar=" + frigobar+", ";
    }
}
