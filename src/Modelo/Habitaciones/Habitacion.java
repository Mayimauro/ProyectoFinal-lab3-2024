package Modelo.Habitaciones;

import Enums.ETipoHabitacion;
import Interfaces.ICalcularCostoAdicional;

import java.io.Serializable;

public abstract class Habitacion implements Serializable, ICalcularCostoAdicional {
    private ETipoHabitacion habitacion;
    private int numero;
    private double precioBase;
    //private double costoAdicional;
    private boolean disponibilidad;

    public Habitacion(ETipoHabitacion habitacion) {
        this.habitacion = habitacion;
        //this.numero = numero; //hacerlo autoincremental, crear funcion
        this.precioBase = 0;
        //this.costoAdicional = costoAdicional; //calcularlo con funcion
        this.disponibilidad = true;
    }

    public ETipoHabitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(ETipoHabitacion habitacion) {
        this.habitacion = habitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }


    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public double calcularCostoAdiconal() {
        return 0;
    }

    public double costoFinalHabitacion() {
        return precioBase + calcularCostoAdiconal();
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "habitacion=" + habitacion +
                ", numero=" + numero +
                ", precioBase=" + precioBase +
                ", costoAdicional="  +
                ", disponibilidad=" + disponibilidad +
                '}';
    }
}
