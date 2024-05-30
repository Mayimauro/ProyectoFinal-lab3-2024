package Modelo.Habitaciones;

import Enums.ETipoHabitacion;
import Interfaces.ICalcularCostoAdicional;

public class HabitacionEstandar extends HabitacionEconomica {
    public static final double PRECIO_BASE_ESTANDAR = 150;
    private boolean vistaAlMar; //30
    private boolean bañera; //20
    private boolean frigobar; //0

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
        return "HabitacionEstandar{" + super.toString()+
                "vistaAlMar=" + vistaAlMar +
                ", bañera=" + bañera +
                ", frigobar=" + frigobar +
                '}';
    }
}
