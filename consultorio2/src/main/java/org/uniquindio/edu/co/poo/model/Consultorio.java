package org.uniquindio.edu.co.poo.model;

import java.util.ArrayList;
import java.util.List;

public record Consultorio(String nombre, List<Paciente> listaPacientes, String direccion, ArrayList<Odontologo> listaOdontologos) {

}
