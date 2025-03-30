package org.uniquindio.edu.co.poo.app;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.uniquindio.edu.co.poo.model.Consultorio;
import org.uniquindio.edu.co.poo.model.Especialidad;
import org.uniquindio.edu.co.poo.model.Odontologo;
import org.uniquindio.edu.co.poo.model.Paciente;

public class Main {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio("Consultorio 1", new ArrayList<>(), "Calle 123", new ArrayList<>());
      
        
        // info paciente

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del paciente");
        String id = JOptionPane.showInputDialog("Ingrese el id del paciente");
        String telefono = JOptionPane.showInputDialog("Ingrese el telefono del paciente");
        LocalDate ultimaFecha = LocalDate.now();

        
        Paciente paciente = new Paciente(nombre, apellidos, id, telefono, ultimaFecha);
        System.out.println(paciente);

        // info odontologo
        String nombreOdontologo = JOptionPane.showInputDialog("Ingrese el nombre del odontologo");
        String idOdontologo = JOptionPane.showInputDialog("Ingrese el id del odontologo");
        String telefonoOdontologo = JOptionPane.showInputDialog("Ingrese el telefono del odontologo");
        String especialidadOdontologo = JOptionPane.showInputDialog(
            "Ingrese la especialidad del odontologo (ODONTOLOGIA_GENERAL, ORTODONCIA, ENDODONCIA, CIRUGIA_ORAL)"
        );

        // convierte el string recibido a un Especialidad enum y muestrar error si es invalido
    Especialidad especialidad = switch (especialidadOdontologo.toUpperCase()) {
        case "ODONTOLOGIA_GENERAL" -> Especialidad.ODONTOLIGIA_GENERAL;
        case "ORTODONCIA" -> Especialidad.ORTODONCIA;
        case "ENDODONCIA" -> Especialidad.ENDODONCIA;
        case "CIRUGIA_ORAL" -> Especialidad.CIRUGIA_ORAL;
        default -> {
            JOptionPane.showMessageDialog(null, "Especialidad no válida");
            yield null; 
        }
    };

    Odontologo odontologo = new Odontologo(nombreOdontologo, idOdontologo, telefonoOdontologo, especialidad);
        System.out.println(odontologo);

        // agregar paciente y odontologo a la lista del consultorio
        consultorio.listaPacientes().add(paciente);
        consultorio.listaOdontologos().add(odontologo);

        // muestra la informacion del consultorio actualizada
        System.out.println("Consultorio actualizado: " + consultorio);
        
        System.out.println("Lista de pacientes:");
        for (Paciente p : consultorio.listaPacientes()) {
            System.out.println(p);
        }
        System.out.println("Lista de odontologos:");
        for (Odontologo o : consultorio.listaOdontologos()) {
            System.out.println(o);
        }
        // mostrar inf consultorio con la info de los pacientes y odontologos
        System.out.println("Nombre del consultorio: " + consultorio.nombre());
        System.out.println("Dirección del consultorio: " + consultorio.direccion());
        System.out.println("Lista de pacientes: " + consultorio.listaPacientes());
        System.out.println("Lista de odontologos: " + consultorio.listaOdontologos());
      
    }
}
