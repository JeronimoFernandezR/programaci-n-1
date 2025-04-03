package org.uniquindio.edu.co.poo.model;

import java.util.Date;
import java.util.List;

public class Mision {
    private Date fecha;
    private String ubicacion;
    private List<String> personalAsignado; 
    private List<Vehiculo> vehiculosUtilizados; 
    
    public Mision(Date fecha, String ubicacion, List<String> personalAsignado, List<Vehiculo> vehiculosUtilizados) {
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.personalAsignado = personalAsignado;
        this.vehiculosUtilizados = vehiculosUtilizados;
    }

    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<String> getPersonalAsignado() {
        return personalAsignado;
    }

    public void setPersonalAsignado(List<String> personalAsignado) {
        this.personalAsignado = personalAsignado;
    }

    public List<Vehiculo> getVehiculosUtilizados() {
        return vehiculosUtilizados;
    }

    public void setVehiculosUtilizados(List<Vehiculo> vehiculosUtilizados) {
        this.vehiculosUtilizados = vehiculosUtilizados;
    }

    // Método para agregar un miembro del personal
    public void agregarPersonal(String personal) {
        this.personalAsignado.add(personal);
    }

    // Método para agregar un vehículo
    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculosUtilizados.add(vehiculo);
    }
}
