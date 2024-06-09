package Modelo.Hotel;

import Enums.EEstadoHabitacion;
import Modelo.Habitaciones.Habitacion;
import Modelo.Persona.Persona;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Reserva implements Serializable {

    private static final long serialVersionUID =1L;

    private LocalDate fechaReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Persona persona;
    private Habitacion habitacion;
    private double precioPorDia;

    public Reserva(LocalDate fechaIngreso, LocalDate fechaSalida, Persona persona) {
        this.fechaReserva = LocalDate.now();
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.persona = persona;
        this.habitacion = null;
        precioPorDia = 0;
    }

    /**
     * Método para calcular la cantidad de días que se van a alojar los pasajeros según las fechas de entrada y salida
     * ingresadas al realizar la reserva.
     * @return retorna la cantidad de días.
     */
    public int calcularDias()
    {
        long daysBetween = fechaSalida.toEpochDay() - fechaIngreso.toEpochDay();
        return (int) daysBetween;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public LocalDate getFechaSalida()
    {
        return fechaSalida;
    }

    public void reservarHabitacion(){
        habitacion.setEstado(EEstadoHabitacion.RESERVADA);
    }
    public void quitarReserva(){
        habitacion.setEstado(EEstadoHabitacion.DISPONIBLE);
        System.out.printf("\n--el nuevo estado de la habitacion es "+ habitacion.getEstado()+"---\n");
    }

    public Persona getPersona() {
        return persona;
    }

    public void asignarHabitacion(Habitacion hab)
    {
        habitacion = hab;
        precioPorDia = habitacion.costoFinalHabitacion();
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


    @Override
    public String toString() {
        return "reserva hecha = " + fechaReserva +
                "\n check in=" + fechaIngreso +
                "\n check out=" + fechaSalida +
                "\n a nombre de=" + persona.getNombre() +
                "\n habitacion=" + habitacion +
                "\n precioPorDia=" + precioPorDia;
    }
}
