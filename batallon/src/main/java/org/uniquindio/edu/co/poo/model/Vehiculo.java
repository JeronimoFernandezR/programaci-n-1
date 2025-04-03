package org.uniquindio.edu.co.poo.model;

public abstract class Vehiculo {

    protected String id;
    protected String modelo;
    protected String fechaFabricacion;
    protected int kilometraje;
    protected EstadoOperativo estado; 

    // Constructor vacío
    public Vehiculo() {
        this.estado = EstadoOperativo.DISPONIBLE; // Estado por defecto
    }

    // Constructor con parámetros
    public Vehiculo(String id, String modelo, String fechaFabricacion, int kilometraje) {
        this.id = id;
        this.modelo = modelo;
        this.fechaFabricacion = fechaFabricacion;
        this.kilometraje = kilometraje;
        this.estado = EstadoOperativo.DISPONIBLE; // Estado por defecto
    }

    public Vehiculo(String id, String modelo, String fechaFabricacion, int kilometraje, EstadoOperativo estado) {
        this.id = id;
        this.modelo = modelo;
        this.fechaFabricacion = fechaFabricacion;
        this.kilometraje = kilometraje;
        this.estado = estado;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public EstadoOperativo getEstado() {
        return estado;
    }

    public void setEstado(EstadoOperativo estado) {
        this.estado = estado;
    }
}
