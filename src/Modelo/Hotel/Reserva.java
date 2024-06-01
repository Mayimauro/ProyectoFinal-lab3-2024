package Modelo.Hotel;

import Modelo.Habitaciones.Habitacion;
import Modelo.Persona.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private LocalDate fechaReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Persona persona;
    private Habitacion habitacion;
    private double precioPorDia;

    public Reserva( String fechaIngreso, String fechaSalida, Persona persona, Habitacion habitacion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fechaReserva = LocalDate.now();
        this.fechaIngreso = LocalDate.parse(fechaIngreso, formatter);
        this.fechaSalida = LocalDate.parse(fechaSalida, formatter);
        this.persona = persona;
        this.habitacion = habitacion;
        precioPorDia = habitacion.costoFinalHabitacion();
    }

    /**
     * Método para calcular la cantidad de días que se van a alojar los pasajeros según las fechas de entrada y salida
     * ingresadas al realizar la reserva.
     * @return retorna la cantidad de días.
     */
    private int calcularDias()
    {
        long daysBetween = fechaSalida.toEpochDay() - fechaIngreso.toEpochDay();
        return (int) daysBetween;
    }

    /**
     * Método para calcular el precio final de la reserva.
     * @return retorna el precio final de la reserva.
     */
    public double precioFinal()
    {
        int dias = calcularDias();
        if(dias !=0)
        {
            return precioPorDia*dias;
            
        }else return precioPorDia;
    }
}
