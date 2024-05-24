package Modelo.Hotel;

import Modelo.Habitaciones.Frigobar.Frigobar;
import Modelo.Habitaciones.Frigobar.Producto;
import Modelo.Habitaciones.Habitacion;

import java.util.ArrayList;

public class ServicioHabitacion {
    private Habitacion habitacion;
    private Frigobar frigobar;
    private ArrayList<Producto> productos; //(productos consumidos en el frigobar)
    private double precioFinal;
}
