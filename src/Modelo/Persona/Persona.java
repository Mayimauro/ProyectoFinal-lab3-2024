package Modelo.Persona;

public class Persona {
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
}
