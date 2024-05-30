package Exceptions;

import java.io.IOException;

public class FechaInvalidaException extends IOException {
    public FechaInvalidaException()
    {
        super();
        System.out.println("Fecha inválida.");
    }
}
