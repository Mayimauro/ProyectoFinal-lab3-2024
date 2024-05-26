package Modelo.Persona;

public class Domicilio {
    private String nombreCalle;
    private String altura;
    private boolean depto;
    private String descripcion;
    private String localidad;
    private String codigoPostal;

    public Domicilio(String nombreCalle, String altura, boolean depto, String descripcion, String localidad, String codigoPostal) {
        this.nombreCalle = nombreCalle;
        this.altura = altura;
        this.depto = depto;
        this.descripcion = descripcion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
    }

}
