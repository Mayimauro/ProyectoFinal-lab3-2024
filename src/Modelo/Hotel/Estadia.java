package Modelo.Hotel;

import Modelo.Habitaciones.Habitacion;
import Modelo.Persona.Persona;

import java.time.LocalDate;

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
