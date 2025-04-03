package org.uniquindio.edu.co.poo.model;

public class TransporteTropas extends Vehiculo {
    private int capacidadTropas;

    public TransporteTropas(String id, String modelo, String fechaFabricacion, int kilometraje, EstadoOperativo estado, int capacidadTropas) {
        super(id, modelo, fechaFabricacion, kilometraje, estado);
        this.capacidadTropas = capacidadTropas;
    }

    public int getCapacidadTropas() {
        return capacidadTropas;
    }

    public void setCapacidadTropas(int capacidadTropas) {
        this.capacidadTropas = capacidadTropas;
    }
}