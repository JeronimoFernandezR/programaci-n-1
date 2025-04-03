package org.uniquindio.edu.co.poo.model;

public class VehiculoBlindado extends Vehiculo {
    private int nivelBlindaje;

    public VehiculoBlindado(String id, String modelo, String fechaFabricacion, int kilometraje, EstadoOperativo estado, int nivelBlindaje) {
        super(id, modelo, fechaFabricacion, kilometraje, estado);
        this.nivelBlindaje = nivelBlindaje;
    }

    public int getNivelBlindaje() {
        return nivelBlindaje;
    }

    public void setNivelBlindaje(int nivelBlindaje) {
        this.nivelBlindaje = nivelBlindaje;
    }
}