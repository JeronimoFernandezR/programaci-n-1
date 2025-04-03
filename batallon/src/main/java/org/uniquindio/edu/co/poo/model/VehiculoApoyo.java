package org.uniquindio.edu.co.poo.model;

public class VehiculoApoyo extends Vehiculo {
    private TipoApoyo tipoApoyo;

    public VehiculoApoyo(String id, String modelo, String fechaFabricacion, int kilometraje, EstadoOperativo estado, TipoApoyo tipoApoyo) {
        super(id, modelo, fechaFabricacion, kilometraje, estado);
        this.tipoApoyo = tipoApoyo;
    }

    public TipoApoyo getTipoApoyo() {
        return tipoApoyo;
    }

    public void setTipoApoyo(TipoApoyo tipoApoyo) {
        this.tipoApoyo = tipoApoyo;
    }
}