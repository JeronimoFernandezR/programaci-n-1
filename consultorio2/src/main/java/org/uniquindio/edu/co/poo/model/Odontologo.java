package org.uniquindio.edu.co.poo.model;

public class Odontologo {
    
    private String nombre;
    private String id;
    private String telefono;
    private Especialidad especialidad;

    public Odontologo(String nombre, String id, String telefono, Especialidad especialidad) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Odontologo [nombre=" + nombre + ", id=" + id + ", telefono=" + telefono + ", especialidad="
                + especialidad + "]";
    }

}
