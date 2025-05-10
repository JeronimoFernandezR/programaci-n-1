
package org.unquindio.edu.co.poo.model;

public class TrianguloEquilatero implements Figura {
    private double lado;

    public TrianguloEquilatero(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return (Math.sqrt(3) / 4) * Math.pow(lado, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 3 * lado;
    }
}