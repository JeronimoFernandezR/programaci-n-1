package org.unquindio.edu.co.poo.app;

import java.util.ArrayList;
import java.util.List;

import org.unquindio.edu.co.poo.model.Circulo;
import org.unquindio.edu.co.poo.model.Cuadrado;
import org.unquindio.edu.co.poo.model.Figura;
import org.unquindio.edu.co.poo.model.TrianguloEquilatero;

public class Main {
    public static void main(String[] args) {
        List<Figura> figuras = new ArrayList<>();

        figuras.add(new Circulo(5));
        figuras.add(new Cuadrado(4));
        figuras.add(new TrianguloEquilatero(3));

        for (Figura figura : figuras) {
            System.out.println("Figura: " + figura.getClass().getSimpleName());
            System.out.println("Área: " + figura.calcularArea());
            System.out.println("Perímetro: " + figura.calcularPerimetro());
            System.out.println();
        }
    }
}