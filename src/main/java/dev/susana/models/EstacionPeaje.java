package dev.susana.models;

import java.util.ArrayList;
import java.util.List;

public class EstacionPeaje {

    private String nombre;
    private String ciudad;
    private int totalRecaudado;
    private List<Vehiculo> vehiculos;

    public EstacionPeaje(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.totalRecaudado = 0;
        this.vehiculos = new ArrayList<>();
    }

    public void procesarVehiculo(Vehiculo vehiculo) {
        int peaje = vehiculo.calcularPeaje();
        totalRecaudado += peaje;
        vehiculos.add(vehiculo);
        System.out.println("Vehículo procesado: " + vehiculo.getPlaca() + " | Peaje cobrado: " + peaje + " euros");
    }

    public void imprimirResumen() {
        System.out.println("\n--- Resumen de la Estación de Peaje ---");
        System.out.println("Estación: " + nombre + " | Ciudad: " + ciudad);
        System.out.println("Total recaudado: " + totalRecaudado + " euros");
        System.out.println("Vehículos procesados:");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("- " + vehiculo.getPlaca() + " | Peaje: " + vehiculo.calcularPeaje() + " euros");
        }
    }
}
    

