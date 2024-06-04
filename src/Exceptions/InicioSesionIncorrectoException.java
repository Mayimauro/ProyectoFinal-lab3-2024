package Exceptions;

import java.io.IOException;

/**
 * Excepción creada con el fin de indicarle al usuario cuando ingresa un dato de inicio de sesión erróneo, ya sea el
 * nombre de usuario o la contraseña.
 */
public class InicioSesionIncorrectoException extends IOException {
    public InicioSesionIncorrectoException() {
        super("Usuario o contraseña incorrecto.");
    }

    public InicioSesionIncorrectoException(String message) {
        super(message);
    }

}
