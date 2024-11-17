package dev.susana.models;

public class Coche extends Vehiculo{

    public Coche(String placa) {
        super(placa);
    }

    @Override
    public float calcularPeaje() {
        return 100;
    }
    
}
