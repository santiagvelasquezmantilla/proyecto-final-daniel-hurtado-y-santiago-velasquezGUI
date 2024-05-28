package co.edu.uniquindio.poo;

public class Vehiculo {
    private String placa;
    private String modelo;
    private String propietario;

    /**
     * Metodo constructor para la clase Vehiculo
     */

    public Vehiculo(String placa, String modelo, String propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    /**
     * Metodo Get Placa
     */

    public String getPlaca() {
        return placa;
    }

    /**
     * Metodo Get Modelo
     */

    public String getModelo() {
        return modelo;
    }

    /**
     * Metodo Get Propietario
     */

    public String getPropietario() {
        return propietario;
    }
}
