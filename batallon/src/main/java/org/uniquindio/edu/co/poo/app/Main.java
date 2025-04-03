package org.uniquindio.edu.co.poo.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.uniquindio.edu.co.poo.model.Batallon;
import org.uniquindio.edu.co.poo.model.EstadoOperativo;
import org.uniquindio.edu.co.poo.model.Mision;
import org.uniquindio.edu.co.poo.model.TransporteTropas;
import org.uniquindio.edu.co.poo.model.Vehiculo;
import org.uniquindio.edu.co.poo.model.VehiculoBlindado;


 



public class Main {
    public static void main(String[] args) {
        // Crear un batallón
        Batallon batallon = new Batallon("Batallón Águila", "Zona Norte");

        // Crear vehículos
        VehiculoBlindado blindado = new VehiculoBlindado("B001", "Tanque T-90", "2020-05-10", 1000, EstadoOperativo.DISPONIBLE, 5);
        TransporteTropas transporte = new TransporteTropas("T001", "Camión Militar", "2018-03-15", 5000, EstadoOperativo.EN_MISION, 20);

        // Agregar vehículos al batallón
        batallon.agregarVehiculo(blindado);
        batallon.agregarVehiculo(transporte);

        // Crear y registrar misiones
        Random random = new Random(); //  seleccionar vehículos al azar
        for (int i = 0; i < 60; i++) { // Registrar 60 misiones
            List<String> personalMision = new ArrayList<>();
            personalMision.add("Soldado Pérez");
            personalMision.add("Soldado Gómez");

            List<Vehiculo> vehiculosMision = new ArrayList<>();
            // Seleccionar un vehículo al azar de la lista de vehículos del batallón
            Vehiculo vehiculoAleatorio = batallon.getVehiculos().get(random.nextInt(batallon.getVehiculos().size()));
            vehiculosMision.add(vehiculoAleatorio);

            Mision mision = new Mision(new Date(), "Zona de Operaciones " + i, personalMision, vehiculosMision);
            batallon.agregarMision(mision);
        }

        // Mostrar información del batallón
        System.out.println("Información del Batallón:");
        System.out.println("Nombre: " + batallon.getNombre());
        System.out.println("Ubicación: " + batallon.getUbicacion());
        System.out.println("Número de vehículos: " + batallon.getVehiculos().size());
        System.out.println("Número de misiones registradas: " + batallon.getMisiones().size());

        // Obtener vehículos con más de 50 misiones completadas
        List<Vehiculo> vehiculosConMasDe50Misiones = batallon.obtenerVehiculosConMasDe50Misiones();
        if (!vehiculosConMasDe50Misiones.isEmpty()) {
            System.out.println("\nVehículos con más de 50 misiones completadas (serán evaluados para posible reemplazo):");
            for (Vehiculo vehiculo : vehiculosConMasDe50Misiones) {
                System.out.println("- " + vehiculo.getModelo() + " (" + vehiculo.getId() + ")");
            }
        } else {
            System.out.println("\nNo hay vehículos con más de 50 misiones completadas.");
        }
    }
    
}