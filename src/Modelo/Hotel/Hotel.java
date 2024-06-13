package Modelo.Hotel;

import Enums.EEstadoHabitacion;
import Enums.ETipoHabitacion;
import Exceptions.InicioSesionIncorrectoException;
import Modelo.Habitaciones.Habitacion;
import Modelo.Habitaciones.HabitacionEconomica;
import Modelo.Habitaciones.HabitacionEstandar;
import Modelo.Habitaciones.HabitacionPremium;
import Modelo.Persona.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;

    private HashMap<Integer, Habitacion> listaHabitaciones;//(el integer es el numero de la habitacion)
    private ArrayList<Reserva> reservas;
    private ArrayList<Estadia> estadias;
    private ArrayList<Persona> usuarios;

    public Hotel() {
        this.listaHabitaciones = new HashMap<Integer, Habitacion>();
        reservas = new ArrayList<>();
        this.estadias = new ArrayList<>();
        leerEstadia();
        this.reservas = leerReservasDesdeArchivo("reservas");
        this.usuarios = new ArrayList<>();
        //agregarHabitacionesXArchivo();
        cargarDesdeArchivo();
        usuarios = cargarPersonasLista("Usuarios");

    }

    //metodos

    public int validarUsuario(String mail, String password) throws InicioSesionIncorrectoException {

        for (Persona persona : usuarios) {

            if (persona.getMail().equals(mail) && persona.getContrasena().equals(password)) {
                if (mail.contains("@admin.com")) {
                    return 1;
                } else if (mail.contains("@conserje.com")) {
                    return 2;
                } else {
                    return 0;
                }
            }
        }
        throw new InicioSesionIncorrectoException();
    }

    public Persona buscarPersona(String mail, String password) {
        for (Persona persona : usuarios) {

            if (persona.getMail().equals(mail) && persona.getContrasena().equals(password)) {
                return persona;
            }
        }
        return null;
    }

    public HashMap<Integer, Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public Habitacion getHabitacion(int key) {
        return listaHabitaciones.get(key);
    }

    //archivos

    /**
     * con esta funcion cargamos habitraciones dentro de nuestro hotel desde un archivo
     * va a ser borrada una vez tengamos todos el archivo en nuestras pc
     * para usar descomentar la funcion en el constructor ir al main y darle al play
     */
    private void agregarHabitacionesXArchivo() {
        HashMap<Integer, Habitacion> Habitaciones = new HashMap<>();
        HabitacionPremium p1 = new HabitacionPremium(1, ETipoHabitacion.DOBLE_TIPO_1, true, true);
        HabitacionPremium p2 = new HabitacionPremium(2, ETipoHabitacion.DOBLE_TIPO_2, true, true);
        HabitacionPremium p3 = new HabitacionPremium(3, ETipoHabitacion.TRIPLE, true, true);
        HabitacionEstandar e1 = new HabitacionEstandar(4, ETipoHabitacion.DOBLE_TIPO_1, true, true, true);
        HabitacionEstandar e2 = new HabitacionEstandar(5, ETipoHabitacion.TRIPLE, true, true, true);
        HabitacionEconomica eco1 = new HabitacionEconomica(6, ETipoHabitacion.DOBLE_TIPO_1, true);
        HabitacionEconomica eco2 = new HabitacionEconomica(7, ETipoHabitacion.DOBLE_TIPO_1, true);
        HabitacionEconomica eco3 = new HabitacionEconomica(8, ETipoHabitacion.DOBLE_TIPO_2, false);
        Habitaciones.put(1, eco1);
        Habitaciones.put(2, eco2);
        Habitaciones.put(3, eco3);
        Habitaciones.put(4, e1);
        Habitaciones.put(5, e2);
        Habitaciones.put(6, p1);
        Habitaciones.put(7, p2);
        Habitaciones.put(8, p3);

        try (FileOutputStream fos = new FileOutputStream("ListaHabitaciones");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(Habitaciones);
            System.out.println("HashMap ha sido serializado y guardado en hashmap.ser");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarDesdeArchivo() {
        String filePath = "ListaHabitaciones";
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("El archivo " + filePath + " no existe.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Deserializar el objeto y asignarlo al HashMap
            HashMap<Integer, Habitacion> map = (HashMap<Integer, Habitacion>) ois.readObject();
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
    }

    public ArrayList<Persona> cargarPersonasLista(String nombreArchivo) {
        ArrayList<Persona> personas = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while (true) {
                try {
                    Persona persona = (Persona) ois.readObject();
                    System.out.printf("\n----cargada en la lista en clase hotel " + persona.toString() + "---\n");
                    personas.add(persona);
                } catch (EOFException eof) {
                    break; // Fin del archivo alcanzado
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return personas;

    }

    private void guardarHabitacionesArchivo() {
        try (FileOutputStream fos = new FileOutputStream("ListaHabitaciones");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(listaHabitaciones);
            System.out.println("HashMap ha sido serializado y guardado en hashmap.ser");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para mostrar la lista de habitaciones disponibles.
     *
     * @return retorna un string con los datos de las habitaciones disponibles.
     */
    public String mostrarHabitacionesDisponibles() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Habitacion> entry : listaHabitaciones.entrySet()) {
            System.out.printf("\n---habitacion: " + entry.getValue().toString() + "---\n");
            if (entry.getValue().getEstado().equals(EEstadoHabitacion.DISPONIBLE)) {
                System.out.printf("\n---habitacion: " + entry.getValue().toString() + "---\n");
                sb.append("Habitacion= ").append(entry.getKey())
                        .append(", ").append(entry.getValue().toString())
                        .append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Método para mostrar la lista de habitaciones disponibles.
     *
     * @return retorna un string con los datos de las habitaciones disponibles.
     * <p>
     *
     */
    public String mostrarHabitacionesDisponiblesXFecha(LocalDate fechaEntradaFuturoHuesped, LocalDate fechaSaladiaFuturoHuesped) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Habitacion> entry : listaHabitaciones.entrySet()) {    //RECORRO EL HASHMAP
            if (entry.getValue().getEstado().equals(EEstadoHabitacion.RESERVADA)) //VEO CUALES HABITACIONES ESTAN RESERVADAS
            {
                for (Reserva r : reservas) {  ///RECORRO LAS RESERVAS
                    {
                        if (r.getHabitacion().equals(entry.getValue())) //ME FIJO QUE LA HABITACION COINCIDA CON LA RESERVA
                        {
                            if (fechaEntradaFuturoHuesped.isAfter(r.getFechaSalida()))  //SI LA FECHA DE ENTRADA DEL HUESPED ES DESPUES DE LA DE SALIDA DE LA RESERVA SE AGREGA
                            {
                                sb.append("Habitacion= ").append(entry.getKey())
                                        .append(", ").append(entry.getValue().toString())
                                        .append("\n");
                            } else if (fechaEntradaFuturoHuesped.isBefore(r.getFechaIngreso()) && fechaSaladiaFuturoHuesped.isBefore(r.getFechaIngreso())) { //SI LAS FECHAS SON ANTES DE LA ENTRADA DEL HUESPED SE ARGEGA

                                sb.append("Habitacion= ").append(entry.getKey())
                                        .append(", ").append(entry.getValue().toString())
                                        .append("\n");
                            }
                            //---BUSCAR FORMA DE QUE NO SE REPITAN LAS HABITACIONES------
                        }
                    }

                }
            }
        }
        return sb.toString();
    }

    /**
     * Método para mostrar la lista de habitaciones
     *
     * @return retorna un string con los datos de todas las habitaciones del hotel.
     */
    public String mostrarHabitacionesConNumero() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Habitacion> entry : listaHabitaciones.entrySet()) {
            sb.append("Habitacion= ").append(entry.getKey())
                    .append(", ").append(entry.getValue().toString())
                    .append("\n");
        }
        return sb.toString();
    }

    public String mostrarHabitacionesNoDisponibles() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Habitacion> entry : listaHabitaciones.entrySet()) {
            if (entry.getValue().getEstado().equals(EEstadoHabitacion.OCUPADA)) {
                System.out.printf("\n---habitacion: " + entry.getValue().toString() + "---\n");
                sb.append("Habitacion= ").append(entry.getKey())
                        .append(", ").append(entry.getValue().toString())
                        .append("\n");
            }
        }
        return sb.toString();
    }

    public String mostrarAlquileresPorPasajero(Persona pasajero) {
        StringBuilder sb = new StringBuilder();
        for (Reserva r : reservas) {
            if (r.getPersona().equals(pasajero)) {
                sb.append("Reservas: ").append(r).append("\n");
            }

        }
        return sb.toString();
    }

    public void cambiarEstadoHabitacion(int key, EEstadoHabitacion estado)
    {
        if(listaHabitaciones.containsKey(key))
        {
            if(!listaHabitaciones.get(key).getEstado().equals(EEstadoHabitacion.OCUPADA))
            {
                listaHabitaciones.get(key).setEstado(estado);
                guardarHabitacionesArchivo();
            }

        }
    }

    public boolean verificarQueTieneReserva(Persona p) {
        boolean aux = false;
        for (Reserva r : reservas) {
            if (r.getPersona().equals(p)) {
                aux = true;
            }
        }
        return aux;
    }


    public void agregarReserva(Reserva r1) {
        r1.reservarHabitacion();
        reservas.add(r1);
        guardarReservasArchivo();
        guardarHabitacionesArchivo();
    }

    public void cancelarReserva(Reserva r) {
        for (Map.Entry<Integer, Habitacion> entry : listaHabitaciones.entrySet()) {
            if (entry.getValue().equals(r.getHabitacion())) {
                System.out.printf("\n---habitacion: " + entry.getValue().toString() + "---\n");
                entry.getValue().setEstado(EEstadoHabitacion.DISPONIBLE);
                System.out.printf("\n---habitacion: " + entry.getValue().toString() + "---\n");
            } else {
                System.out.printf("\n---no encontre la habitacion---\n");
            }
        }
        reservas.remove(r);
        guardarReservasArchivo();
        guardarHabitacionesArchivo();
    }

    public ArrayList<Reserva> listaReservaPasajero(Persona p) {
        ArrayList<Reserva> reservasPasajero = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getPersona().equals(p)) {
                reservasPasajero.add(r);
            }
        }
        return reservasPasajero;
    }


    public void agregarHabitacion(int numero,Habitacion a)
    {
        listaHabitaciones.put(numero,a);
        guardarHabitacionesArchivo();
    }

    public void guardarReservasArchivo()
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("reservas"))) {
            for (Reserva reserva : reservas) {
                oos.writeObject(reserva);
            }
            System.out.println("Archivo serializado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Reserva> leerReservasDesdeArchivo(String nombreArchivo) {
        ArrayList<Reserva> reservas = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while (true) {
                try {
                    Reserva r1 = (Reserva) ois.readObject();
                    reservas.add(r1);
                } catch (EOFException eof) {
                    break; // Fin del archivo alcanzado
                     }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return reservas;
    }

    public String mostrarHuespedes()
    {
        StringBuilder sb = new StringBuilder();
        for(Estadia e : estadias)
        {
            sb.append("Huespedes= ").append(e.getPasajero().toString());
        }
        return sb.toString();
    }

    public void finEstadia(String dni){
        for(Estadia e : estadias)
        {
            if(e.getCheck().getCheckOut().equals(LocalDate.now()))
            {
                e.getHabitacion().setEstado(EEstadoHabitacion.EN_LIMPIEZA);
                estadias.remove(e);
            }
        }
    }

    public void eliminarHabitacion(int numero)
    {
        listaHabitaciones.remove(numero);
        guardarHabitacionesArchivo();
    }

    public boolean existeHabitacion(int numero)
    {
        if(listaHabitaciones.get(numero)!=null)
        {
            return true;
        }else {
            return false;
        }
    }

    public int numeroHabitacion() {
        return listaHabitaciones.size()+1;
    }

    public boolean borrarUsuario(String dni)
    {
        boolean borrado = false;
        for(Persona p : usuarios)
        {
            if(p.getDNI().equals(dni))
            {
                if(p.getMail().contains("@admin.com"))
                {
                    System.out.printf("\n---no se puede eliminar un administrador---\n");
                }else {
                    usuarios.remove(p);
                    p.actualizarArchivo(p);
                    borrado = true;
                }
            }
        }
        return borrado;
    }

    public boolean confirmarEstadia(String dni)
    {
        boolean confirmar = false;
        for(Reserva r : reservas)
        {
            if(r.getPersona().getDNI().equals(dni))
            {
                if(r.getFechaIngreso().equals(LocalDate.now()))
                {
                    Estadia e1 = new Estadia(r.getFechaIngreso(),r.getFechaSalida(),r.getPersona(),r.getHabitacion());
                    estadias.add(e1);
                    guardarEstadias();
                    confirmar = true;

                }else {
                    confirmar = false;
                }
            }
        }
        return confirmar;
    }
    public int verificarEstadia(String dni)
    {
        for(Estadia e : estadias)
        {
            if(e.getPasajero().getDNI().equals(dni))
            {
                if(e.getHabitacion().getClass().getName().equals("Modelo.Habitaciones.HabitacionEstandar") || e.getHabitacion().getClass().getName().equals("Modelo.Habitaciones.HabitacionPremium"))
                {
                    return 1;
                }else{
                    return -1;
                }

            }
        }
        return 0;
    }

    public Estadia getEstadia(String dni)
    {
            for(Estadia e : estadias)
            {
                if(e.getPasajero().getDNI().equals(dni))
                {
                    return e;

                }
            }
            return null;
    }

    public void guardarEstadias()
    {
        try (FileOutputStream fileOut = new FileOutputStream("estadias");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(estadias);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void leerEstadia()
    {
        try (FileInputStream fileIn = new FileInputStream("estadias");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            estadias = (ArrayList<Estadia>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ServicioHabitacion obtenerFrigobar(Persona p)
    {
        for(Estadia e : estadias)
        {
            if(e.getPasajero().getDNI().equals(p.getDNI()))
            {
                return e.getServicioHabitacion();
            }
        }
        return null;
    }

    public void pasarHuespedesAJson()
    {
        Gson gson = new Gson();
        ArrayList<Persona> pasajeros = new ArrayList<>();
        for(Estadia e : estadias)
        {
            pasajeros.add(e.getPasajero());
        }

        try(FileWriter writer = new FileWriter("pasajeros.json")){
            gson.toJson(pasajeros,writer);

        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }


}
