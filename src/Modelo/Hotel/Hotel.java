package Modelo.Hotel;

import Modelo.Habitaciones.Habitacion;
import Modelo.Persona.Persona;

import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private HashMap<Integer,Habitacion> listaHabitaciones;  //(el integer es el numero de la habitacion)
    private ArrayList<Reserva> reservas;
    private ArrayList<Persona> HistorialPersonas;
}
