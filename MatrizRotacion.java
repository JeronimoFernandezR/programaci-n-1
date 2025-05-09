import java.util.Scanner;

public class MatrizRotacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // dimensiones de la matriz
        System.out.print("Ingrese el número de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas = scanner.nextInt();

        // Crear y llenar 
        int[][] matriz = new int[filas][columnas];
        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        // numero de rotaciones
        System.out.print("Ingrese el número de giros a la derecha: ");
        int rotaciones = scanner.nextInt();

        // mostrar la matriz original
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        // Realizar las rotaciones
        for (int i = 0; i < rotaciones; i++) {
            matriz = rotarMatrizDerecha(matriz);
            System.out.println("Giro " + (i + 1) + " a la derecha:");
            imprimirMatriz(matriz);
        }

        scanner.close();
    }

    // rotar la matriz a la derecha
    public static int[][] rotarMatrizDerecha(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] nuevaMatriz = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nuevaMatriz[j][filas - 1 - i] = matriz[i][j];
            }
        }

        return nuevaMatriz;
    }

    // imprimir
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}