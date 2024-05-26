package Modelo.Hotel;

import Modelo.Habitaciones.Habitacion;
import Modelo.Persona.Persona;


import java.time.LocalDate;

public class Reserva {
    private LocalDate fechaReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Persona persona;
    private Habitacion habitacion;

    public Reserva(LocalDate fechaReserva, LocalDate fechaIngreso, LocalDate fechaSalida, Persona persona, Habitacion habitacion) {
        this.fechaReserva = fechaReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.persona = persona;
        this.habitacion = habitacion;
    }
}
