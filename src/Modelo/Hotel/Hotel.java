package Modelo.Hotel;

import Enums.ETipoHabitacion;
import Modelo.Habitaciones.Habitacion;
import Modelo.Habitaciones.HabitacionEconomica;
import Modelo.Habitaciones.HabitacionEstandar;
import Modelo.Habitaciones.HabitacionPremium;
import Modelo.Persona.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel implements Serializable {
    private HashMap<Integer,Habitacion> listaHabitaciones;  //(el integer es el numero de la habitacion)
    private ArrayList<Reserva> reservas;
    private ArrayList<Persona> HistorialPersonas;
    private HashMap<Persona,Check> registroChekcs; //guardamos los checks por persona


    public Hotel() {
        this.listaHabitaciones = new HashMap<Integer,Habitacion>();
        //agregarHabitacionesXArchivo();
        cargarDesdeArchivo();
        this.reservas = new ArrayList<>();
        HistorialPersonas = new ArrayList<>();
        registroChekcs = new HashMap<>();
    }

    /**
     * con esta funcion cargamos habitraciones dentro de nuestro hotel desde un archivo
     * va a ser borrada una vez tengamos todos el archivo en nuestras pc
     * para usar descomentar la funcion en el constructor ir al main y darle al play
     */
    private void agregarHabitacionesXArchivo()
    {
        HashMap<Integer,Habitacion> Habitaciones = new HashMap<>();
        HabitacionPremium p1 = new HabitacionPremium(ETipoHabitacion.DOBLE_TIPO_1,true,true);
        HabitacionPremium p2 = new HabitacionPremium(ETipoHabitacion.DOBLE_TIPO_2,true,true);
        HabitacionPremium p3 = new HabitacionPremium(ETipoHabitacion.TRIPLE,true,true);
        HabitacionEstandar e1 = new HabitacionEstandar(ETipoHabitacion.DOBLE_TIPO_1,true,true,true);
        HabitacionEstandar e2 = new HabitacionEstandar(ETipoHabitacion.TRIPLE,true,true,true);
        HabitacionEconomica eco1 = new HabitacionEconomica(ETipoHabitacion.SIMPLE,true);
        HabitacionEconomica eco2 = new HabitacionEconomica(ETipoHabitacion.DOBLE_TIPO_1,true);
        HabitacionEconomica eco3 = new HabitacionEconomica(ETipoHabitacion.SIMPLE,false);
        Habitaciones.put(1,eco1);
        Habitaciones.put(2,eco2);
        Habitaciones.put(3,eco3);
        Habitaciones.put(4,e1);
        Habitaciones.put(5,e2);
        Habitaciones.put(6,p1);
        Habitaciones.put(7,p2);
        Habitaciones.put(8,p3);

        try (FileOutputStream fos = new FileOutputStream("ListaHabitaciones.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(Habitaciones);
            System.out.println("HashMap ha sido serializado y guardado en hashmap.ser");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarDesdeArchivo()
    {
        String filePath = "ListaHabitaciones.ser";
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("El archivo " + filePath + " no existe.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Deserializar el objeto y asignarlo al HashMap
            HashMap<Integer,Habitacion> map = (HashMap<Integer,Habitacion>) ois.readObject();
            System.out.println("HashMap ha sido deserializado:");
            listaHabitaciones = map;
            System.out.println(listaHabitaciones);

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de entrada/salida al leer el archivo: " + filePath);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada al deserializar el archivo.");
            e.printStackTrace();
        }
    }

}
