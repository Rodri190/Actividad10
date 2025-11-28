package model;

public class Celular {
    private final String id;
    private final String marca;
    private final String modelo;
    private final double precio;

    public Celular(String id, String marca, String modelo, double precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getId() { return id; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return String.format("%s | %s %s | $%.2f", id, marca, modelo, precio);
    }
}
