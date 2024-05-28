package co.edu.uniquindio.poo;
import java.time.LocalDateTime;

public class Ingreso {
    private Vehiculo vehiculo;
    private int i, j;
    private LocalDateTime fechaIngreso;

    /**
     * metodo constructor de la clase ingreso
     */

    public Ingreso(Vehiculo vehiculo, int i, int j, LocalDateTime fechaIngreso) {
        this.vehiculo = vehiculo;
        this.i = i;
        this.j = j;
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * metodo get Vehiculo
     */

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * metodo get I
     */

    public int getI() {
        return i;
    }

    /**
     * metodo get J
     */

    public int getJ() {
        return j;
    }

    /**
     * metodo para saber la hora actual en la que se hace el ingreso
     */

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }
}