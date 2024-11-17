package dev.susana.models;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CamionTest {

    @Test
    void testConstructorAndGetNumeroEjes() {
        
        Camion camion = new Camion("CAM123", 3);

        assertThat(camion.getPlaca(), is("CAM123"));
        assertThat(camion.getNumeroEjes(), is(3));
    }

    @Test
    void testCalcularPeaje() {

        Camion camion = new Camion("CAM456", 4);

        assertThat(camion.calcularPeaje(), is(200.0f));
    }

    @Test
    void testCalcularPeajeConUnEje() {

        Camion camion = new Camion("CAM789", 1);

        assertThat(camion.calcularPeaje(), is(50.0f));
    }

    @Test
    void testCalcularPeajeConCeroEjes() {
        
        Camion camion = new Camion("CAM000", 0);

        assertThat(camion.calcularPeaje(), is(0.0f));
    }
    
}
