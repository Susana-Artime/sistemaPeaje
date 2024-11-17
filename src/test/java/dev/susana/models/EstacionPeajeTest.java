package dev.susana.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EstacionPeajeTest {

    private EstacionPeaje estacionPeaje;

    @BeforeEach
    void setUp() {
        estacionPeaje = new EstacionPeaje("Peaje Test","Ciudad Test");
    }

    @Test
    void testConstructor() {
        assertThat(estacionPeaje.getNombre(), is("Peaje Test"));
        assertThat(estacionPeaje.getCiudad(), is("Ciudad Test"));
        assertThat(estacionPeaje.getTotalRecaudado(), is(0.0f));
        assertThat(estacionPeaje.getVehiculos(), is(empty()));
    }

    @Test
    void testProcesarVehiculo_Coche() {
        Vehiculo coche = new Coche("ABC123");
        estacionPeaje.procesarVehiculo(coche);

        assertThat(estacionPeaje.getTotalRecaudado(), is(100.0f));
        assertThat(estacionPeaje.getVehiculos(), contains(coche));
    }

    @Test
    void testProcesarVehiculo_Moto() {
        Vehiculo moto = new Moto("XYZ789");
        estacionPeaje.procesarVehiculo(moto);

        assertThat(estacionPeaje.getTotalRecaudado(), is(50.0f));
        assertThat(estacionPeaje.getVehiculos(), contains(moto));
    }

    @Test
    void testProcesarVehiculo_Camion() {
        Vehiculo camion = new Camion("CAM456", 3);
        estacionPeaje.procesarVehiculo(camion);

        assertThat(estacionPeaje.getTotalRecaudado(), is(150.0f));
        assertThat(estacionPeaje.getVehiculos(), contains(camion));
    }

    @Test
    void testImprimirResumen() {
        Vehiculo coche = new Coche("ABC123");
        Vehiculo moto = new Moto("XYZ789");
        Vehiculo camion = new Camion("CAM456", 2);

        estacionPeaje.procesarVehiculo(coche);
        estacionPeaje.procesarVehiculo(moto);
        estacionPeaje.procesarVehiculo(camion);

        String expectedResumen = String.join("\n",
        "--- Resumen de la Estación de Peaje ---",
        "Estación: Peaje Test | Ciudad: Ciudad Test",
        "Total recaudado: 250,00 euros",
        "Vehículos procesados:",
        "- ABC123 | Peaje: 100,00 euros",
        "- XYZ789 | Peaje: 50,00 euros",
        "- CAM456 | Peaje: 100,00 euros");

    
        java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(output));
        estacionPeaje.imprimirResumen();
        System.setOut(System.out);

        String actualOutput = output.toString().trim()
            .replace("\r\n", "\n")
            .replace(".0", "");

        String normalizedExpected = expectedResumen.trim();

        assertThat(actualOutput, is(normalizedExpected));
    }

    
}
