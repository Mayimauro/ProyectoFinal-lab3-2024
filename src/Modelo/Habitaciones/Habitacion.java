package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

public abstract class Habitacion {
    private ETipoHabitacion habitacion;
    private int numero;
    private double precioBase;
    private double costoAdicional;
    private boolean disponibilidad;

    public Habitacion(ETipoHabitacion habitacion, double precioBase) {
        this.habitacion = habitacion;
        //this.numero = numero; //hacerlo autoincremental, crear funcion
        this.precioBase = precioBase;
        //this.costoAdicional = costoAdicional; //calcularlo con funcion
        this.disponibilidad = true;
    }
    public Habitacion() {
        this.habitacion = ETipoHabitacion.CAMA_MATRIMONIAL;
        this.numero = 0;
        this.precioBase = 0;
        this.costoAdicional = 0;
        this.disponibilidad = true;
    }

}
