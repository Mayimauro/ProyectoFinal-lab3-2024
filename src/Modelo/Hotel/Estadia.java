package Modelo.Hotel;

import Modelo.Habitaciones.Habitacion;
import Modelo.Persona.Persona;

import java.time.LocalDate;

/**
 * Clase con el fin de controlar la estadía real de los pasajeros en el hotel. Indica las fechas reales en las que se
 * encontró en el hotel, maneja los checks y muestra los consumos, si los tuviera.
 */
public class Estadia {
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Persona pasajero;
    private Check check;
    private Habitacion habitacion;
    //consumos

    public Estadia(LocalDate fechaIngreso, LocalDate fechaSalida, Persona pasajero, Habitacion habitacion) {
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.pasajero = pasajero;
        check = new Check(fechaIngreso,fechaSalida);
        this.habitacion = habitacion;
    }

    public void realizarCheckOut(LocalDate fechaSalida)
    {
        check.cambiarFechaEgreso(fechaSalida);
    }
}
