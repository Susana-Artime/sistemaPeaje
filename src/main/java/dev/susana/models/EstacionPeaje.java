package dev.susana.models;

import java.util.ArrayList;
import java.util.List;

public class EstacionPeaje {

    private String nombre;
    private String ciudad;
    private float totalRecaudado;
    private List<Vehiculo> vehiculos;

    public EstacionPeaje(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.totalRecaudado = 0;
        this.vehiculos = new ArrayList<>();
    }

    

    public String getNombre() {
        return nombre;
    }



    public String getCiudad() {
        return ciudad;
    }



    public float getTotalRecaudado() {
        return totalRecaudado;
    }



    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }



    public void procesarVehiculo(Vehiculo vehiculo) {
        float peaje = (int) vehiculo.calcularPeaje();
        totalRecaudado += peaje;
        vehiculos.add(vehiculo);
        System.out.println("Vehículo procesado: " + vehiculo.getPlaca() + " | Peaje cobrado: " + String.format("%.2f", peaje) + " euros");
    }

    public void imprimirResumen() {
        System.out.println("--- Resumen de la Estación de Peaje ---");
        System.out.println("Estación: " + nombre + " | Ciudad: " + ciudad);
        System.out.println("Total recaudado: " + String.format("%.2f", totalRecaudado) + " euros");
        System.out.println("Vehículos procesados:");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("- " + vehiculo.getPlaca() + " | Peaje: " + String.format("%.2f", vehiculo.calcularPeaje()) + " euros");
        }
    }}
    

