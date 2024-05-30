package Exceptions;

import java.io.IOException;

public class InicioSesionIncorrectoException extends IOException {
    public InicioSesionIncorrectoException() {
        super();
        System.out.println("Usuario o contraseña incorrecto.");
    }

}
