package org.uniquindio.edu.co.poo.model;

import java.time.LocalDate;

public record Paciente(String nombre, String apellidos, String id, String telefono, LocalDate ultimaFecha) {

}
