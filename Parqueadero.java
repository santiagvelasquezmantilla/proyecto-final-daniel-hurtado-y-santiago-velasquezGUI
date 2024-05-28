package co.edu.uniquindio.poo;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Parqueadero {
    @SuppressWarnings("unused")
    private int filas;
    @SuppressWarnings("unused")
    private int columnas;
    private Puesto[][] puestos;
    private List<Vehiculo> historialVehiculos;
    private Map<String, Double> tarifasPorHora;
    private List<Ingreso> ingresos;

    /**
     * Metodo Constructor clase Parqueadero
     */

    public Parqueadero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.puestos = new Puesto[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                puestos[i][j] = new Puesto(i, j);
                
            }
        }
        this.historialVehiculos = new ArrayList<>();
        this.ingresos = new ArrayList<>();
    }

    /**
     * Metodo para configurar la tarifa de un vehiculo
     */

    public void configurarTarifa(String tipoVehiculo, double tarifa) {
        tarifasPorHora.put(tipoVehiculo, tarifa);
    }

    /**
     * Metodo para verificar si un espacio está disponible
     */

    public boolean verificarDisponibilidad(int i, int j) {
        return !puestos[i][j].estaOcupado();
    }

    /**
     * metodo para registrar un vehiculo en un espacio
     */

    public void registrarVehiculo(int i, int j, Vehiculo vehiculo) {
        if (verificarDisponibilidad(i, j)) {
            puestos[i][j].ocuparPuesto(vehiculo);
            historialVehiculos.add(vehiculo);
            ingresos.add(new Ingreso(vehiculo, i, j, LocalDateTime.now()));
        } else {
            System.out.println("El puesto (" + i + "," + j + ") está ocupado.");
        }
    }

    /**
     * metpdp para obtener el propietario de un vehiculo
     */

    public String obtenerPropietario(int i, int j) {
        Vehiculo vehiculo = puestos[i][j].getVehiculo();
        if (vehiculo != null) {
            return vehiculo.getPropietario();
        }
        return "Puesto vacío";
    }

    /**
     * metodo para calcular el costo del estacionamiento
     */

    public double calcularCostoEstacionamiento(Vehiculo vehiculo, LocalDateTime salida) {
        for (Ingreso ingreso : ingresos) {
            if (ingreso.getVehiculo().equals(vehiculo)) {
                long horas = ChronoUnit.HOURS.between(ingreso.getFechaIngreso(), salida);
                String tipoVehiculo = vehiculo instanceof Moto ? ((Moto) vehiculo).getTipo() : "carro";
                return horas * tarifasPorHora.get(tipoVehiculo);
            }
        }
        return 0;
    }

    /**
     * metodo para tener un reporte diario de los vehiculos
     */

    public void generarReporteDiario(LocalDateTime fecha) {
        double totalMotosClasicas = 0;
        double totalMotosHibridas = 0;
        double totalCarros = 0;
        for (Ingreso ingreso : ingresos) {
            if (ingreso.getFechaIngreso().toLocalDate().equals(fecha.toLocalDate())) {
                Vehiculo vehiculo = ingreso.getVehiculo();
                double costo = calcularCostoEstacionamiento(vehiculo, LocalDateTime.now());
                if (vehiculo instanceof Moto) {
                    if (((Moto) vehiculo).getTipo().equals("clasica")) {
                        totalMotosClasicas += costo;
                    } else {
                        totalMotosHibridas += costo;
                    }
                } else if (vehiculo instanceof Carro) {
                    totalCarros += costo;
                }
            }
        }
        System.out.println("Reporte diario del " + fecha.toLocalDate());
        System.out.println("Total recaudado por motos clásicas: " + totalMotosClasicas);
        System.out.println("Total recaudado por motos híbridas: " + totalMotosHibridas);
        System.out.println("Total recaudado por carros: " + totalCarros);
    }

    public void generarReporteMensual(YearMonth mes) {
        double totalMotosClasicas = 0;
        double totalMotosHibridas = 0;
        double totalCarros = 0;
        for (Ingreso ingreso : ingresos) {
            if (YearMonth.from(ingreso.getFechaIngreso()).equals(mes)) {
                Vehiculo vehiculo = ingreso.getVehiculo();
                double costo = calcularCostoEstacionamiento(vehiculo, LocalDateTime.now());
                if (vehiculo instanceof Moto) {
                    if (((Moto) vehiculo).getTipo().equals("clasica")) {
                        totalMotosClasicas += costo;
                    } else {
                        totalMotosHibridas += costo;
                    }
                } else if (vehiculo instanceof Carro) {
                    totalCarros += costo;
                }
            }
        }
        System.out.println("Reporte mensual del " + mes);
        System.out.println("Total recaudado por motos clásicas: " + totalMotosClasicas);
        System.out.println("Total recaudado por motos híbridas: " + totalMotosHibridas);
        System.out.println("Total recaudado por carros: " + totalCarros);
    }

}