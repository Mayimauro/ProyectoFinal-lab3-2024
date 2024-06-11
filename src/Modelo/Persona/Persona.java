package Modelo.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

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
        ArrayList<Persona> personas = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Usuarios"))) {
            while (true) {
                try {
                    Persona userArchi = (Persona) ois.readObject();
                    personas.add(userArchi);
                } catch (EOFException eof) {
                    break; // Fin del archivo alcanzado
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        personas.add(persona);
        escribirArchivo(personas);
    }
    public void actualizarArchivo(Persona persona) {
        ArrayList<Persona> personas = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Usuarios"))) {
            while (true) {
                try {
                    Persona userArchi = (Persona) ois.readObject();
                    personas.add(userArchi);
                } catch (EOFException eof) {
                    break; // Fin del archivo alcanzado
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        personas.remove(persona);
        escribirArchivo(personas);
    }


    public void escribirArchivo(ArrayList<Persona> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Usuarios"))) {
            for (Persona persona : usuarios) {
                oos.writeObject(persona);
            }
            System.out.println("Archivo serializado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDNI() {
        return DNI;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(DNI, persona.DNI);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(DNI);
    }
}
