package org.uniquindio.edu.co.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private String ubicacion;
    private ArrayList<Estudiante> listaEstudiantes;

    // Constructor

    public Universidad(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaEstudiantes = new ArrayList<>();
    }

    // Getters and Setters

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

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public List<Estudiante> getEstudiantes() {
        return listaEstudiantes;
    }
    // Metodos

    public String agregarEstudiante(String nombre, String identificacion) {
        String mensaje = "Estudiante agregado correctamente";
        
        if (buscarEstudiante(identificacion) != null) {
            mensaje = "El estudiante ya existe";
        } else {
            Estudiante estudiante = new Estudiante(nombre, identificacion, 0);
            listaEstudiantes.add(estudiante);
        }
        return mensaje;
    }

    public double calcularPromedioGeneral() {
        double suma = 0;
        int contador = 0;
        for (Estudiante estudiante : listaEstudiantes) {
            suma += estudiante.calcularPromedio();
            contador++;
        }
        return suma / contador;
    }

    public Estudiante buscarEstudiante(String identificacion) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getIdentificacion().equals(identificacion)) {
                return estudiante;
            }
        }
        return null;
    }

    public void eliminarEstudiante(String identificacion) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante != null) {
            listaEstudiantes.remove(estudiante);
        }
    }

    public void modificarEstudiante(String identificacion, String nombre) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante != null) {
            estudiante.setNombre(nombre);
        }
    }

    public void agregarNotaEstudiante(String identificacion, Nota nota) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante != null) {
            estudiante.agregarNota(nota);
        }
    }

    public void eliminarNotaEstudiante(String identificacion, String nombreNota) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante != null) {
            estudiante.eliminarNota(nombreNota);
        }
    }

    @Override
    public String toString() {
        return "Universidad [nombre=" + nombre + ", ubicacion=" + ubicacion + ", listaEstudiantes=" + listaEstudiantes
                + "]";
    }
    
    
}
