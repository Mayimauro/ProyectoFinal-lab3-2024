package Modelo.Hotel;

import java.time.LocalDate;

public class Check {
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Check(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void cambiarFechaEgreso(LocalDate checkOut)
    {
        this.checkOut = checkOut;
    }

}
