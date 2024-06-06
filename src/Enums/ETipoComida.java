package Enums;

public enum ETipoComida {
    DESAYUNO(10.0),
    ALMUERZO(20.0),
    CENA(30.0);

    private final double precio;

    ETipoComida(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
