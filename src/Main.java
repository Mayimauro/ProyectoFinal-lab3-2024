import Exceptions.InicioSesionIncorrectoException;
import Modelo.Hotel.Hotel;
import Modelo.Hotel.Reserva;
import Modelo.PaginaPrincipal.PantallasISRD.PantallaInicioSesion;
import Modelo.Persona.Domicilio;
import Modelo.Persona.Persona;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InicioSesionIncorrectoException {

        Hotel hotel = new Hotel();

        PantallaInicioSesion frame = new PantallaInicioSesion(hotel);

    }



}