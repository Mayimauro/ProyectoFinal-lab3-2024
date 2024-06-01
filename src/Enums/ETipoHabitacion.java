package Enums;

import java.io.Serializable;

/**
 * Clase de tipo enum para indicar los tipos de habitaciones que dispone el hotel y sus capacidades.
 * Sus atributos incluyen la cantidad de camas simples y la cantidad de camas dobles en cada tipo de habitación.
 */
public enum ETipoHabitacion implements Serializable {
    DOBLE_TIPO_1(0,1),
    DOBLE_TIPO_2(2,0), 
    TRIPLE(1,1),
    CUADRUPLE_TIPO_1(2,1),
    CUADRUPLE_TIPO_2(0,2);

    ETipoHabitacion(int cantidadCamasSimples, int cantidadCamasDobles) {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
