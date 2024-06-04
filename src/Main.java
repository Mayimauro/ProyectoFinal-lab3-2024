import Enums.EEstadoHabitacion;
import Enums.ETipoHabitacion;
import Exceptions.InicioSesionIncorrectoException;
import Modelo.Habitaciones.Habitacion;
import Modelo.Habitaciones.HabitacionEstandar;
import Modelo.Habitaciones.HabitacionPremium;
import Modelo.Hotel.Hotel;
import Modelo.Hotel.Reserva;
import Modelo.PaginaPrincipal.PantallasISRD.PantallaInicioSecion;
import Modelo.Persona.Domicilio;
import Modelo.Persona.Persona;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InicioSesionIncorrectoException {

        Domicilio domicilio = new Domicilio("a","1",false,"casa","bs","mar","1233");
        Persona persona = new Persona("Lud","i","123","lud,admin.com","1",domicilio);
        Domicilio domicilio2 = new Domicilio("b","1",false,"casa","bs","mar","1233");
        Persona persona2 = new Persona("bla","i","456","blas,conserjer.com","1",domicilio2);
        Domicilio domicilio3 = new Domicilio("c","1",false,"casa","bs","mar","1233");
        Persona persona3 = new Persona("May","i","789","mati,gmail.com","1",domicilio3);


//        persona.agregarAlArchivo(persona);
//        persona2.agregarAlArchivo(persona2);
//        persona3.agregarAlArchivo(persona3);


        /**
         *      ARREGLAR ARCHIVOS DE ALGUNA FORMA
         */

        Hotel hotel = new Hotel();
        /**
         * DESCOMENTAR PARA EJECUTAR LA INTERFAZ GRAFICA
         */
        //PantallaInicioSecion frame = new PantallaInicioSecion(hotel);

    }
}