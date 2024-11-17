package dev.susana.models;

abstract class Vehiculo {

        private String placa;
    
        public Vehiculo(String placa) {
            this.placa = placa;
        }
    
        public String getPlaca() {
            return placa;
        }
    
        public abstract float calcularPeaje();
    }
    

