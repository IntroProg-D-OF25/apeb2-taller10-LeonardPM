import java.util.Random;

/**
 * Dadas dos matrices (cuadradas y/o rectangulares) de valores enteros aleatorios, desarrollar su
 * procesamiento para calcular y presentar:
 * <p>
 * La suma de las dos matrices (considerar las restricciones matemáticas para ello).
 * La multiplicación de las dos matrices (considerar las reglas matemáticas para ello).
 */
public class Ejercicio2 {
    public static void main(String[] args) {

        int n = 4;
        int[][] matriz1 = new int[n][n];
        int[][] matriz2 = new int[n][n];
        int[][] matriz3 = new int[n][n];

        Random random = new Random();
        System.out.println("MATRIZ [1]");
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matriz1[i][j] = random.nextInt(10);
            }
        }
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[i].length; j++) {
                    System.out.print(matriz1[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println("\nMATRIZ [2]");
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[i].length; j++) {
                    matriz2[i][j] = random.nextInt(10);
                }
            }
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++){
                System.out.print(matriz2[i][j] + "\t");
            }
            System.out.println();
            }
            System.out.println("\nSUMA DE MATRICES\n// MATRIZ [1] + MATRIZ [2] = MATRIZ [3] \t");
            for (int i = 0; i < matriz3.length; i++) {
                for (int j = 0; j < matriz3[i].length; j++) {
                    matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
                    System.out.print(matriz3[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
/**
 * MATRIZ [1]
 * 1	6	1	7
 * 8	7	6	7
 * 5	8	2	3
 * 6	3	1	5
 *
 * MATRIZ [2]
 * 8	0	3	9
 * 3	8	1	7
 * 0	9	2	5
 * 7	2	0	3
 *
 * SUMA DE MATRICES
 * // MATRIZ [1] + MATRIZ [2] = MATRIZ [3]
 * 9	6	4	16
 * 11	15	7	14
 * 5	17	4	8
 * 13	5	1	8
 */
