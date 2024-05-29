package Modelo.Persona;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Persona implements Serializable {
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


    public void agregarAlArchivo(Persona persona) {
        try (FileOutputStream fileOut = new FileOutputStream("Personas.ser", true);
             ObjectOutputStream out = true ? new AppendingObjectOutputStream(fileOut) : new ObjectOutputStream(fileOut)) {
            out.writeObject(persona);
            System.out.println("El objeto ha sido guardado en " + "Personas.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private static class AppendingObjectOutputStream extends ObjectOutputStream {
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
                ", DNI='" + DNI;
    }
}
