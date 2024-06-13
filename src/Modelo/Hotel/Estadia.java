package Modelo.Hotel;

import Enums.EEstadoHabitacion;
import Modelo.Habitaciones.Frigobar.Frigobar;
import Modelo.Habitaciones.Frigobar.Producto;
import Modelo.Habitaciones.Habitacion;
import Modelo.Persona.Persona;
import com.google.gson.*;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 * Clase con el fin de controlar la estadía real de los pasajeros en el hotel. Indica las fechas reales en las que se
 * encontró en el hotel, maneja los checks y muestra los consumos, si los tuviera.
 */
public class Estadia implements Serializable {

    private static final long serialVersionUID = 1L;

    private Persona pasajero;
    private Check check;
    private Habitacion habitacion;
    private ServicioHabitacion servicioHabitacion;
    private double precioFinal;

    /**
     *
     * al recibir una habitacion compruebo que tipo es para saber si tiene o no frigobar
     * si es economica recive un null el frigobar
     * tendriamos que tener un precio final aca para saber lo que gasto en estadia+servicios?
     *
     */
    public Estadia(LocalDate fechaIngreso, LocalDate fechaSalida, Persona pasajero, Habitacion habitacion) {
        check = new Check(fechaIngreso,fechaSalida);
        this.pasajero = pasajero;
        this.habitacion = habitacion;
        habitacion.setEstado(EEstadoHabitacion.OCUPADA);
        if(habitacion.getClass().getName().equals("Modelo.Habitaciones.HabitacionEstandar") || habitacion.getClass().getName().equals("Modelo.Habitaciones.HabitacionPremium"))
        {
            Frigobar f = new Frigobar();
            agregarProductos(f);
            servicioHabitacion = new ServicioHabitacion(habitacion,f);
        }else {
            servicioHabitacion = new ServicioHabitacion(habitacion,null);
        }
        this.precioFinal = precioFinal(fechaIngreso,fechaSalida);
    }

    private int calcularDias(LocalDate fechaIngreso, LocalDate fechaSalida)
    {
        long daysBetween =  fechaSalida.toEpochDay() - fechaIngreso.toEpochDay();
        return (int) daysBetween;
    }

    private double precioFinal(LocalDate fechaIngreso, LocalDate fechaSalida)
    {
        int dias = calcularDias(fechaIngreso,fechaSalida);

        if(dias !=0)
        {

            return habitacion.costoFinalHabitacion()*dias;

        }else {

            return habitacion.costoFinalHabitacion();
        }
    }

    public ServicioHabitacion getServicioHabitacion()
    {
        return servicioHabitacion;
    }
    public Check getCheck() {
        return check;
    }
    public Habitacion getHabitacion() {
        return habitacion;
    }
    public Persona getPasajero() {
        return pasajero;
    }
    public double getPrecioFinal()
    {
        return precioFinal;
    }

    public void actualizarPrecioFinal(double p)
    {
        precioFinal +=p;
    }

    private void agregarProductos(Frigobar f) {
        Producto p1 = new Producto("Snack",10);
        Producto p2 = new Producto("Cocucha",20);
        Producto p3 = new Producto("Gomitas",25);
        f.argrgarProductos(p1);
        f.argrgarProductos(p2);
        f.argrgarProductos(p3);
    }

}
