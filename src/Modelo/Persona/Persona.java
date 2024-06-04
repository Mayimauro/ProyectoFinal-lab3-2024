package Modelo.Persona;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase la cual detalla todos los datos pertinentes a la persona que realiza la reserva.
 */
public class Persona implements Serializable {
    private static final long serialVersionUID =1L;

    private String nombre;
    private String apellido;
    private String DNI;
    private String mail;
    private String contrasena;
    private Domicilio domicilio;

    public Persona(String nombre, String apellido, String DNI, String mail, String contrasena, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.mail = mail;
        this.contrasena = contrasena;
        this.domicilio = domicilio;
    }

    //metodos
    public void agregarDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getMail() {
        return mail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    //archivos

    public void reiniciarArchivo() {
        try {
            File archivo = new File("Personas.ser");
            if (archivo.exists()) {
                archivo.delete();
            }
            archivo.createNewFile();
        } catch (IOException e) {
            System.err.println("Error al reiniciar el archivo: " + e.getMessage());
        }
    }

    public void agregarAlArchivo(Persona persona) {
        try (FileOutputStream fileOut = new FileOutputStream("Personas.ser", true);
             ObjectOutputStream out = new AppendingObjectOutputStream(fileOut)) {
            out.writeObject(persona);
            System.out.println("El objeto ha sido guardado en " + "Personas.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public static class AppendingObjectOutputStream extends ObjectOutputStream {
        public AppendingObjectOutputStream(FileOutputStream out) throws IOException {
            super(out);
        }
        @Override
        protected void writeStreamHeader() throws IOException {
            reset(); // Resetea el encabezado para no escribir uno nuevo
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNI='" + DNI+
                ", mail = " +mail+
                ", contra = " +contrasena;
    }
}
