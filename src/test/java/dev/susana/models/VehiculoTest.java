package dev.susana.models;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class VehiculoTest {

    static class VehiculoPrueba extends Vehiculo {
        public VehiculoPrueba(String placa) {
            super(placa);
        }

        @Override
        public float calcularPeaje() {
            return 42.0f; 
        }
    }

    @Test
    void testConstructorAndGetPlaca() {

        Vehiculo vehiculo = new VehiculoPrueba("ABC123");
        assertThat(vehiculo.getPlaca(), is("ABC123"));
    }

    @Test
    void testCalcularPeaje() {

        Vehiculo vehiculo = new VehiculoPrueba("XYZ789");
        assertThat(vehiculo.calcularPeaje(), is(42.0f));
    }

}
