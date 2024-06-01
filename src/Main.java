import Enums.EEstadoHabitacion;
import Enums.ETipoHabitacion;
import Modelo.Habitaciones.Habitacion;
import Modelo.Habitaciones.HabitacionEstandar;
import Modelo.Habitaciones.HabitacionPremium;
import Modelo.Hotel.Hotel;
import Modelo.Hotel.Reserva;
import Modelo.PaginaPrincipal.InterfazGrafica;
import Modelo.Persona.Domicilio;
import Modelo.Persona.Persona;

public class Main {
    public static void main(String[] args) {

        InterfazGrafica pantalla = new InterfazGrafica();
       // pantalla.Pantalla1();


        Habitacion A1 = new HabitacionPremium(ETipoHabitacion.DOBLE_TIPO_1,true,true);

        System.out.println(A1.costoFinalHabitacion());

        Domicilio domicilio = new Domicilio("a","1",false,"casa","bs","mar","1233");
        Persona persona = new Persona("Lud","i","123","mm","333",domicilio);

        Reserva r1 = new Reserva("2024-06-20","2024-06-15",persona,A1);
        System.out.println(r1.precioFinal());

        System.out.println(A1.costoFinalHabitacion());

        System.out.printf("\n\n--el nombre de la habitacion es: "+A1.getClass().getName());


    }
}