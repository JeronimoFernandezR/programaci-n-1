package org.uniquindio.edu.co.poo.model;

import java.util.ArrayList;
import java.util.List;

public record Consultorio(String nombre, List<Paciente> listaPacientes, String direccion, ArrayList<Odontologo> listaOdontologos) {

    // crud para odontologo
    public Consultorio agregarOdontologo(Odontologo odontologo) {
        ArrayList<Odontologo> nuevaLista = new ArrayList<>(listaOdontologos);
        nuevaLista.add(odontologo);
        return new Consultorio(nombre, listaPacientes, direccion, nuevaLista);
    }

    
    public Odontologo obtenerOdontologoPorId(String id) {
        for (Odontologo odontologo : listaOdontologos) {
            if (odontologo.getId().equals(id)) {
                return odontologo;
            }
        }
        return null; 
    }

    
    public Consultorio actualizarOdontologo(String id, Odontologo odontologoActualizado) {
        ArrayList<Odontologo> nuevaLista = new ArrayList<>(listaOdontologos);
        for (int i = 0; i < nuevaLista.size(); i++) {
            if (nuevaLista.get(i).getId().equals(id)) {
                nuevaLista.set(i, odontologoActualizado);
                return new Consultorio(nombre, listaPacientes, direccion, nuevaLista);
            }
        }
        return this; 
    }

   
    public Consultorio eliminarOdontologo(String id) {
        ArrayList<Odontologo> nuevaLista = new ArrayList<>(listaOdontologos);
        nuevaLista.removeIf(odontologo -> odontologo.getId().equals(id));
        return new Consultorio(nombre, listaPacientes, direccion, nuevaLista);
    }
}
