package dev.susana.models;

public class Camion extends Vehiculo {

    private int numeroEjes;

    public Camion(String placa, int numeroEjes) {
        super(placa);
        this.numeroEjes = numeroEjes;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    @Override
    public float calcularPeaje() {
        return numeroEjes * 50;
    }
    
}
