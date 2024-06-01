package Modelo.Habitaciones;

import Enums.EEstadoHabitacion;
import Enums.ETipoHabitacion;
import Interfaces.ICalcularCostoAdicional;

import java.io.Serializable;

/**
 * La clase abstracta Habitacion tiene el fin de reunir los atributos que van a tener todos los distintos tipos de
 * habitación.
 */
public abstract class Habitacion implements Serializable, ICalcularCostoAdicional {
    private ETipoHabitacion habitacion;
    private int numero;
    private double precioBase;
    //private double costoAdicional;
    private boolean disponibilidad;
    private EEstadoHabitacion estado;

    public Habitacion(ETipoHabitacion habitacion) {
        this.habitacion = habitacion;
        //this.numero = numero; //hacerlo autoincremental, crear funcion
        this.precioBase = 0;
        //this.costoAdicional = costoAdicional; //calcularlo con funcion
        this.disponibilidad = true;
        this.estado = EEstadoHabitacion.DISPONIBLE;
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

    /**
     * Método que calcula el costo adicional de cada habitación según su tipo. Lo sobreescribe de la interfaz
     * ICalcularCostoAdicional.
     * Va acumulando el valor del costo adicional de cada tipo de habitación, según de cuántos tipos de habitación herede
     * la seleccionada por el usuario.
     * @return retorna el costo total adicional del tipo de habitación seleccionado por el usuario.
     */
    @Override
    public double calcularCostoAdiconal() {
        return 0;
    }

    /**
     * Método que calcula el costo final de la habitación según el precio base de la misma más el costo adicional por las
     * comodidades seleccionadas por el usuario.
     * @return retorna la sumatoria del precio base más el costo adicional.
     */
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
