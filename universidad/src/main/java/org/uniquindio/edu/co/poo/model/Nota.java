package org.uniquindio.edu.co.poo.model;

public class Nota {
    private String nombre;
    private double valor;

    // Constructor to initialize Nota with a name and value
    public Nota(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    // Getters and setters (if needed)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}