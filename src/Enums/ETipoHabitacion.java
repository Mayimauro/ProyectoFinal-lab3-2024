package Enums;

import java.io.Serializable;

public enum ETipoHabitacion implements Serializable {

    SIMPLE(1,0),
    DOBLE_TIPO_1(0,1),
    DOBLE_TIPO_2(2,0), 
    TRIPLE(1,1),
    CUADRUPLE_TIPO_1(2,1),
    CUADRUPLE_TIPO_2(0,2); 


    ETipoHabitacion(int cantidadCamasSimples, int cantidadCamasDobles) {
    }

    //toString

    @Override
    public String toString() {
        return super.toString();
    }
}
