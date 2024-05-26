package Modelo.Habitaciones;

import Enums.ETipoHabitacion;

import java.io.Serializable;

public abstract class Habitacion implements Serializable {
    private ETipoHabitacion habitacion;
    private int numero;
    private double precioBase;
    private double costoAdicional;
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

    public double getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(double costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }



    //to string


    @Override
    public String toString() {
        return "Habitacion{" +
                "habitacion=" + habitacion +
                ", numero=" + numero +
                ", precioBase=" + precioBase +
                ", costoAdicional=" + costoAdicional +
                ", disponibilidad=" + disponibilidad +
                '}';
    }
}
