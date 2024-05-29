package Modelo.Persona;

import java.io.Serializable;

public class Domicilio implements Serializable {
    private String nombreCalle;
    private String altura;
    private boolean depto;
    private String descripcion;
    private String Provincia;
    private String localidad;
    private String codigoPostal;

    public Domicilio(String nombreCalle, String altura, boolean depto, String descripcion,String Provincia, String localidad, String codigoPostal) {
        this.nombreCalle = nombreCalle;
        this.altura = altura;
        this.depto = depto;
        this.descripcion = descripcion;
        this.Provincia = Provincia;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
    }

}
