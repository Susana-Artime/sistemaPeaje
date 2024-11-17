package dev.susana.models;

public class Moto extends Vehiculo {

    public Moto(String placa) {
        super(placa);
    }

    @Override
    public float calcularPeaje() {
        return 50;
    }
    
}
