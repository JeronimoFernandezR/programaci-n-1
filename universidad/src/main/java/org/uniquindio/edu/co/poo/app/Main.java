package org.uniquindio.edu.co.poo.app;

import javax.swing.JOptionPane;

import org.uniquindio.edu.co.poo.model.Estudiante;
import org.uniquindio.edu.co.poo.model.Nota;
import org.uniquindio.edu.co.poo.model.Universidad;

public class Main {
    private static Universidad universidad;

    public static void main(String[] args) {

        universidad = new Universidad("Uniquindio", "Armenia");

        // Solicitar 3 estudiantes
        for (int i = 0; i < 3; i++) {
            String nombreEstudiante = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante:");
            String identificacionEstudiante = JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante:");

            // Agregar estudiante a la universidad
            universidad.agregarEstudiante(nombreEstudiante, identificacionEstudiante);

            // Solicitar 3 notas para el estudiante
            for (int j = 0; j < 5; j++) {
                String nombreNota = JOptionPane.showInputDialog(null, "Ingrese el nombre de la nota:");
                String valorNotaStr = JOptionPane.showInputDialog(null, "Ingrese el valor de la nota:");
                double valorNota = Double.parseDouble(valorNotaStr);

                // Agregar la nota al estudiante
                Nota nota = new Nota(nombreNota, valorNota);
                universidad.agregarNotaEstudiante(identificacionEstudiante, nota);
            }
        }

        // Mostrar información de los estudiantes
        StringBuilder info = new StringBuilder("Universidad: " + universidad.getNombre() + "\nUbicación: " + universidad.getUbicacion() + "\n\nEstudiantes:\n");
        for (Estudiante estudiante : universidad.getEstudiantes()) {
            info.append(estudiante.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, info.toString());
    }
}
