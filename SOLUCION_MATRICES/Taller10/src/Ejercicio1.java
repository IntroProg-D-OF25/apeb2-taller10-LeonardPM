import java.util.Random;

/**
 * Ejercicio 1
 * Dada una matriz cuadrada (m X m) de valores enteros aleatorios, desarrollar su procesamiento para presentar los elementos:
 * <p>
 * De la diagonal principal.
 * De la diagonal segundaria.
 * Ubicados bajo la diagonal principal.
 * Ubicados sobre la diagonal principal.
 * Ubicados bajo la diagonal secundaria.
 * Ubicados sobre la diagonal secundaria.
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 4;
        int[][] matriz = new int[n][n];
        System.out.println("MATRIZ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(10);

            }

        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("DIAGONAL PRINCIPAL");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + " \t");

        }
        System.out.println("\nDIAGONAL SECUNDARIA");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][matriz.length - 1 - i] + "\t");
        }
        System.out.println("\nELEMENTOS BAJO LA DIAGONAL PRINCIPAL");
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
        }
        System.out.println("\nELEMENTOS SOBRE LA DIAGONAL PRINCIPAL");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; i > j; j++) {
                System.out.print(matriz[i][j] + "\t ");
            }
        }
        System.out.println("\nELEMENTOS BAJO LA DIAGONAL SECUNDARIA");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i + j > matriz.length - 1) {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
        }
        System.out.println("\nELEMENTOS SOBRE LA DIAGONAL SECUNDARIA");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i + j < matriz.length - 1) {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
        }
    }
}
/**
 *MATRIZ
 * 7	3	3	9
 * 6	0	3	0
 * 4	1	3	5
 * 6	5	1	8
 * DIAGONAL PRINCIPAL
 * 7 	0 	3 	8
 * DIAGONAL SECUNDARIA
 * 9	3	1	6
 * ELEMENTOS BAJO LA DIAGONAL PRINCIPAL
 * 6	4	1	6	5	1
 * ELEMENTOS SOBRE LA DIAGONAL PRINCIPAL
 * 6	 4	 1	 6	 5	 1
 * ELEMENTOS BAJO LA DIAGONAL SECUNDARIA
 * 0	3	5	5	1	8
 * ELEMENTOS SOBRE LA DIAGONAL SECUNDARIA
 * 7	3	3	6	0	4
 * Process finished with exit code 0
 */