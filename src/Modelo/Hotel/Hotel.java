package Modelo.Hotel;

import Modelo.Habitaciones.Habitacion;
import Modelo.Persona.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel implements Serializable {
    private static final long serialVersionUID =1L;
    private HashMap<Integer,Habitacion> listaHabitaciones; //(el integer es el numero de la habitacion)
    private ArrayList<Reserva> reservas;
    private ArrayList<Persona> historialPersonas;
    private HashMap<Persona,Check> registroChekcs; //guardamos los checks por persona

    public Hotel() {
        this.listaHabitaciones = new HashMap<Integer,Habitacion>();
        this.reservas = new ArrayList<>();
        historialPersonas = new ArrayList<>();
        registroChekcs = new HashMap<>();
        cargarDesdeArchivo();
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
            listaHabitaciones = map;

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

        /**
         * arreglar
         * no carga las personas del archivo a la lista
         */

        try (FileInputStream fileIn = new FileInputStream("Personas.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            while (true) {
                try {
                   Persona persona = (Persona) in.readObject();
                    System.out.printf("\n\n\n----"+persona.toString()+"---\n\n\n");
                   historialPersonas.add(persona);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.printf("\n\n\n----final del archivo---\n\n\n");
            // Se alcanzó el final del archivo
        }
    }

    /**
     * Método para mostrar la lista de habitaciones con su disponibilidad.
     * @return retorna un string con los datos de todas las habitaciones del hotel.
     */
    public String mostrarHabitaciones()
    {
      return listaHabitaciones.toString();
    }
}
