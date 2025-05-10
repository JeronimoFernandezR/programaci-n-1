import java.util.ArrayList;
import java.util.List;

public class Estacionamiento {

    // Método para ordenar 
    public static void ordenarPorPlaca(List<Vehiculo> vehiculos) {
        int n = vehiculos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Comparar las placas de los vehículos
                if (vehiculos.get(j).getPlaca().compareTo(vehiculos.get(j + 1).getPlaca()) > 0) {
                    // Intercambiar los vehículos si están en el orden incorrecto
                    Vehiculo aux = vehiculos.get(j);
                    vehiculos.set(j, vehiculos.get(j + 1));
                    vehiculos.set(j + 1, aux);
                }
            }
        }
    }

    
    public static class Vehiculo {
        private String placa;

        public Vehiculo(String placa) {
            this.placa = placa;
        }

        public String getPlaca() {
            return placa;
        }

        @Override
        public String toString() {
            return "Vehiculo{placa='" + placa + "'}";
        }
    }

    // Método principal de prueba
    public static void main(String[] args) {
        
        List<Vehiculo> vehiculos = new ArrayList<>(List.of(
            new Vehiculo("ABC123"),
            new Vehiculo("XYZ789"),
            new Vehiculo("DEF456"),
            new Vehiculo("GHI321")
        ));

        System.out.println("Lista original:");
        vehiculos.forEach(System.out::println);

        ordenarPorPlaca(vehiculos);

        System.out.println("\nLista ordenada por placa:");
        vehiculos.forEach(System.out::println);
    }
}