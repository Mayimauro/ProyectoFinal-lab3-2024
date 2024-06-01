package Modelo.Hotel;

import Modelo.Habitaciones.Frigobar.Frigobar;
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
    private ServicioHabitacion servicioHabitacion;
    //consumos

    /**
     *
     * al recibir una habitacion compruebo que tipo es para saber si tiene o no frigobar
     * si es economica recive un null el frigobar
     * tendriamos que tener un precio final aca para saber lo que gasto en estadia+servicios?
     *
     */
    public Estadia(LocalDate fechaIngreso, LocalDate fechaSalida, Persona pasajero, Habitacion habitacion) {
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.pasajero = pasajero;
        check = new Check(fechaIngreso,fechaSalida);
        this.habitacion = habitacion;
        if(habitacion.getClass().getName().equals("Modelo.Habitaciones.HabitacionEstandar") || habitacion.getClass().getName().equals("Modelo.Habitaciones.HabitacionPremium"))
        {
            Frigobar f = new Frigobar();
            servicioHabitacion = new ServicioHabitacion(habitacion,f);
        }else {
            servicioHabitacion = new ServicioHabitacion(habitacion,null);
        }

    }

    public void realizarCheckOut(LocalDate fechaSalida)
    {
        check.cambiarFechaEgreso(fechaSalida);
    }
}
