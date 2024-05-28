package co.edu.uniquindio.poo;

public class Puesto {
    private int i, j;
    private Vehiculo vehiculo;

    /**
     * Metodo constructor clase puesto
     */

    public Puesto(int i, int j) {
        this.i = i;
        this.j = j;
        this.vehiculo = null;
    }

    /**
     * Metodo get I
     */

    public int getI() {
        return i;
    }

    /**
     * Metodo get J
     */

    public int getJ() {
        return j;
    }

    /**
     * Metodo get Vehiculo
     */

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Metodo para confirmar si un cupo está ocupado
     */

    public boolean estaOcupado() {
        return vehiculo != null;
    }

    /**
     * metodo para ocupar un puesto
     */

    public void ocuparPuesto(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * metodo para liberar un puesto
     */

    public void liberarPuesto() {
        this.vehiculo = null;
    }
}