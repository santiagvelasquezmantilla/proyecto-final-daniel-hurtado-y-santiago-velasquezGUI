package co.edu.uniquindio.poo;

 public class Moto extends Vehiculo {
    private String tipo; // "clasica" o "hibrida"
    private int velocidadMaxima;

    /**
     * Metodo constructor clase Moto
     */

    public Moto(String placa, String modelo, String propietario, String tipo, int velocidadMaxima) {
        super(placa, modelo, propietario);
        this.tipo = tipo;
        this.velocidadMaxima = velocidadMaxima;
    }

      /**
     * Metodo get Tipo
     */

     public String getTipo() {
        return tipo;
    }

    /**
     * Metodo get VelocidadMaxima
     */

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }
}