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
//        pantalla.Pantalla1();


        Habitacion A1 = new HabitacionPremium(ETipoHabitacion.DOBLE_TIPO_1,true,true);

//        System.out.println(A1.costoFinalHabitacion());

        Domicilio domicilio = new Domicilio("a","1",false,"casa","bs","mar","1233");
        Persona persona = new Persona("Lud","i","123","ll","333",domicilio);
        Domicilio domicilio2 = new Domicilio("b","1",false,"casa","bs","mar","1233");
        Persona persona2 = new Persona("bla","i","456","bb","333",domicilio2);
        Domicilio domicilio3 = new Domicilio("c","1",false,"casa","bs","mar","1233");
        Persona persona3 = new Persona("May","i","789","mm","333",domicilio3);


        persona.agregarAlArchivo(persona);
        persona2.agregarAlArchivo(persona2);
        persona3.agregarAlArchivo(persona3);


        Reserva r1 = new Reserva("2024-06-20","2024-07-15",persona,A1);
        Reserva r2 = new Reserva("2024-07-20","2024-08-13",persona2,A1);
        Reserva r3 = new Reserva("2024-08-20","2024-09-17",persona3,A1);
        System.out.println(r1.precioFinal());



        //System.out.println(A1.costoFinalHabitacion());

        //System.out.printf("\n\n--el nombre de la habitacion es: "+A1.getClass().getName());


    }
}