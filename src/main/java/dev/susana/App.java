package dev.susana;

import java.util.Scanner;

import dev.susana.models.Camion;
import dev.susana.models.Coche;
import dev.susana.models.EstacionPeaje;
import dev.susana.models.Moto;

public class App{
    public static void main( String[] args )
    {
        
        Scanner scanner = new Scanner(System.in);
        EstacionPeaje estacion = new EstacionPeaje("Peaje del Huerna", "Asturias-León");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menú del Sistema de Peaje ---");
            System.out.println("1. Registrar coche");
            System.out.println("2. Registrar moto");
            System.out.println("3. Registrar camión");
            System.out.println("4. Mostrar resumen");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del coche: ");
                    String placaCoche = scanner.next();
                    estacion.procesarVehiculo(new Coche(placaCoche));
                    break;

                case 2:
                    System.out.print("Ingrese la placa de la moto: ");
                    String placaMoto = scanner.next();
                    estacion.procesarVehiculo(new Moto(placaMoto));
                    break;

                case 3:
                    System.out.print("Ingrese la placa del camión: ");
                    String placaCamion = scanner.next();
                    System.out.print("Ingrese el número de ejes del camión: ");
                    int ejes = scanner.nextInt();
                    estacion.procesarVehiculo(new Camion(placaCamion, ejes));
                    break;

                case 4:
                    estacion.imprimirResumen();
                    break;

                case 5:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }

        scanner.close();
    }

}
