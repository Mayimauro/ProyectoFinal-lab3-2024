import Exceptions.InicioSesionIncorrectoException;
import Modelo.Hotel.Hotel;
import Modelo.PaginaPrincipal.PantallasISRD.PantallaInicioSesion;

public class Main {
    public static void main(String[] args) throws InicioSesionIncorrectoException {

        Hotel hotel = new Hotel();

        PantallaInicioSesion frame = new PantallaInicioSesion(hotel);

    }



}