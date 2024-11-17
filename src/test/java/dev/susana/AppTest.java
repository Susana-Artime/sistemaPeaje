package dev.susana;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class AppTest {

        @Test
        void testRegistrarCoche() {

            String simulatedInput = "1\nCOCHE123\n4\n5"; 
        
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output));

            
            App.main(new String[]{});

            
            System.setOut(System.out);


            String actualOutput = output.toString();

            
            assertThat(actualOutput, containsString("Vehículo procesado: COCHE123 | Peaje cobrado: 100,00 euros"));

            assertThat(actualOutput, containsString("--- Resumen de la Estación de Peaje ---"));
            assertThat(actualOutput, containsString("Total recaudado: 100,00 euros"));
            assertThat(actualOutput, containsString("- COCHE123 | Peaje: 100,00 euros"));
    }


        @Test
        void testRegistrarMoto() {
    
            String simulatedInput = "2\nMOTO456\n4\n5"; // 2 -> registrar moto, "MOTO456" -> placa de la moto, 4 -> mostrar resumen, 5 -> salir
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output));


            App.main(new String[]{});


            System.setOut(System.out);

            String actualOutput = output.toString();

            assertThat(actualOutput, containsString("Vehículo procesado: MOTO456 | Peaje cobrado: 50,00 euros"));

    
            assertThat(actualOutput, containsString("--- Resumen de la Estación de Peaje ---"));
            assertThat(actualOutput, containsString("Total recaudado: 50,00 euros"));
            assertThat(actualOutput, containsString("- MOTO456 | Peaje: 50,00 euros"));
    }

        @Test
        void testRegistrarCamion() {

            String simulatedInput = "3\nCAMION789\n3\n4\n5";
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));


            ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output));

            
            App.main(new String[]{});

            
            System.setOut(System.out);

            
            String actualOutput = output.toString();

            assertThat(actualOutput, containsString("Vehículo procesado: CAMION789 | Peaje cobrado: 150,00 euros"));

            
            assertThat(actualOutput, containsString("--- Resumen de la Estación de Peaje ---"));
            assertThat(actualOutput, containsString("Total recaudado: 150,00 euros"));
            assertThat(actualOutput, containsString("- CAMION789 | Peaje: 150,00 euros"));
    }

        @Test
        void testSalirDelSistema() {
            
            String simulatedInput = "5"; 
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output));

            App.main(new String[]{});

            
            System.setOut(System.out);

            
            String actualOutput = output.toString();

            
            assertThat(actualOutput, containsString("Saliendo del sistema..."));

            
            assertThat(actualOutput, not(containsString("--- Resumen de la Estación de Peaje ---")));
        }

}
