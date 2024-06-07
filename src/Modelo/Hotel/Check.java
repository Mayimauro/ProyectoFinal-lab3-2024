package Modelo.Hotel;

import java.time.LocalDate;

/**
 * Esta clase fue diseñada con el fin de controlar las fechas de ingreso y egreso (check in y check out respectivamente)
 * del hotel del pasajero y sus acompañantes.
 * Está contenida en la clase Estadia.
 */
public class Check {
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Check(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    /**
     * Los check se inicializan con las fechas de la reserva, por lo tanto en caso de que los pasajeros decidan prolongar
     * su estadía, se puede modificar tal fecha.
     * @param checkOut
     */
    public void cambiarFechaEgreso(LocalDate checkOut)
    {
        this.checkOut = checkOut;
    }

}
