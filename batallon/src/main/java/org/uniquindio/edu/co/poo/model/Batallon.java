package org.uniquindio.edu.co.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Batallon {
    private String nombre;
    private String ubicacion;
    private final List<Vehiculo> vehiculos;
    private final List<String> personal;
    private final List<Mision> misiones;

    
    public Batallon(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.vehiculos = new ArrayList<>();
        this.personal = new ArrayList<>();
        this.misiones = new ArrayList<>();
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public List<String> getPersonal() {
        return personal;
    }

    public List<Mision> getMisiones() {
        return misiones;
    }

    // Métodos para gestionar vehículos
    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    // Métodos para gestionar personal
    public void agregarPersonal(String persona) {
        this.personal.add(persona);
    }

    public void eliminarPersonal(String persona) {
        this.personal.remove(persona);
    }

    // Métodos para gestionar misiones
    public void agregarMision(Mision mision) {
        this.misiones.add(mision);
    }

    public void eliminarMision(Mision mision) {
        this.misiones.remove(mision);
    }

    // Método para obtener vehículos con más de 50 misiones completadas
    public List<Vehiculo> obtenerVehiculosConMasDe50Misiones() {
        List<Vehiculo> vehiculosConMasDe50Misiones = new ArrayList<>();

        for (Vehiculo vehiculo : vehiculos) {
            int contador = 0;

            // Contar cuántas veces aparece el vehículo en las misiones
            for (Mision mision : misiones) {
                if (mision.getVehiculosUtilizados().contains(vehiculo)) {
                    contador++;
                }
            }

            // Si el vehículo aparece en más de 50 misiones, agregarlo a la lista
            if (contador > 50) {
                vehiculosConMasDe50Misiones.add(vehiculo);
            }
        }

        return vehiculosConMasDe50Misiones;
    }
}
