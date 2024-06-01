package Exceptions;

import java.io.IOException;

/**
 * Excepción creada con el fin de indicarle al usuario cuando ingresa una fecha inválida en la búsqueda de disponibilidad
 * de habitaciones.
 * Se lanza cuando ingresa una fecha de ingreso anterior al día de la fecha, o cuando ingresa una fecha de salida anterior
 * al día de ingreso.
 */
public class FechaInvalidaException extends IOException {
    public FechaInvalidaException()
    {
        super();
        System.out.println("Fecha inválida.");
    }
}
