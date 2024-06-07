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
    private double precioBase;
    private EEstadoHabitacion estado;

    public Habitacion(ETipoHabitacion habitacion) {
        this.habitacion = habitacion;
        this.precioBase = 0;
        this.estado = EEstadoHabitacion.DISPONIBLE;
    }

    public ETipoHabitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(ETipoHabitacion habitacion) {
        this.habitacion = habitacion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setEstado(EEstadoHabitacion estado) {
        this.estado = estado;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
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

    public EEstadoHabitacion getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return habitacion +
                ", precioBase=" + precioBase +
                ", disponibilidad=" + estado+", ";
    }
}
