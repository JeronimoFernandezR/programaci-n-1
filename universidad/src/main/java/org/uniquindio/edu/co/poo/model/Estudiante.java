package org.uniquindio.edu.co.poo.model;

import java.util.Arrays;

public class Estudiante {
    private String nombre;
    private String identificacion;
    private Nota[] listaNotas;

    // Constructor

    public Estudiante(String nombre, String identificacion, int cantidadNotas) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.listaNotas = new Nota[5];
    }

    // Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Nota[] getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(Nota[] listaNotas) {
        this.listaNotas = listaNotas;
    }


    // crud
    
    public void agregarNota(Nota nota) {
        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] == null) {
                listaNotas[i] = nota;
                break;
            }
        }
    
    }

    public void eliminarNota(String nombreNota) {
        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] != null && listaNotas[i].getNombre().equals(nombreNota)) {
                listaNotas[i] = null;
                break;
            }
        }
    }

    public double calcularPromedio() {
        double suma = 0;
        int contador = 0;
        for (Nota nota : listaNotas) {
            if (nota != null) {
                suma += nota.getValor();
                contador++;
            }
        }
        return suma / contador;
    }
    
    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", identificacion=" + identificacion + ", listaNotas="
                + Arrays.toString(listaNotas) + "]";
    }
    
    


}
