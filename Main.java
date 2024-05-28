package co.edu.uniquindio.poo;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.YearMonth;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero(5, 5);

        boolean salir = false;
        while (!salir) {
            System.out.println("Menú de Parqueadero:");
            System.out.println("1. Configurar tarifas");
            System.out.println("2. Registrar vehículo");
            System.out.println("3. Verificar propietario de un puesto");
            System.out.println("4. Generar reporte diario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    configurarTarifas(parqueadero, scanner);
                    break;
                case 2:
                    registrarVehiculo(parqueadero, scanner);
                    break;
                case 3:
                    verificarPropietario(parqueadero, scanner);
                    break;
                case 4:
                    parqueadero.generarReporteDiario(LocalDateTime.now());
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    private static void configurarTarifas(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese el tipo de vehículo (clasica, hibrida, carro): ");
        String tipoVehiculo = scanner.nextLine();
        System.out.print("Ingrese la tarifa por hora: ");
        double tarifa = scanner.nextDouble();
        scanner.nextLine(); 
        parqueadero.configurarTarifa(tipoVehiculo, tarifa);
        System.out.println("Tarifa configurada.");
    }

    private static void registrarVehiculo(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese el tipo de vehículo (moto, carro): ");
        String tipoVehiculo = scanner.nextLine();
        System.out.print("Ingrese la placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese el modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el propietario: ");
        String propietario = scanner.nextLine();

        Vehiculo vehiculo;
        if (tipoVehiculo.equalsIgnoreCase("moto")) {
            System.out.print("Ingrese el tipo de moto (clasica, hibrida): ");
            String tipoMoto = scanner.nextLine();
            System.out.print("Ingrese la velocidad máxima: ");
            int velocidadMaxima = scanner.nextInt();
            scanner.nextLine(); 
            vehiculo = new Moto(placa, modelo, propietario, tipoMoto, velocidadMaxima);
        } else if (tipoVehiculo.equalsIgnoreCase("carro")) {
            vehiculo = new Carro(placa, modelo, propietario);
        } else {
            System.out.println("Tipo de vehículo inválido.");
            return;
        }

        System.out.print("Ingrese la fila del puesto: ");
        int i = scanner.nextInt();
        System.out.print("Ingrese la columna del puesto: ");
        int j = scanner.nextInt();
        scanner.nextLine(); 

        if (parqueadero.verificarDisponibilidad(i, j)) {
            parqueadero.registrarVehiculo(i, j, vehiculo);
            System.out.println("Vehículo registrado exitosamente en el puesto (" + i + ", " + j + ")");
        } else {
            System.out.println("El puesto (" + i + ", " + j + ") está ocupado.");
        }
    }

    private static void verificarPropietario(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese la fila del puesto: ");
        int i = scanner.nextInt();
        System.out.print("Ingrese la columna del puesto: ");
        int j = scanner.nextInt();
        scanner.nextLine(); 

        String propietario = parqueadero.obtenerPropietario(i, j);
        System.out.println("El propietario del vehículo en el puesto (" + i + ", " + j + ") es: " + propietario);
    }

    @SuppressWarnings("unused")
    private static void generarReporteMensual(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese el año del reporte: ");
        int año = scanner.nextInt();
        System.out.print("Ingrese el mes del reporte: ");
        int mes = scanner.nextInt();
        scanner.nextLine(); 

        YearMonth yearMonth = YearMonth.of(año, mes);
        parqueadero.generarReporteMensual(yearMonth);
    }
}