/**
 *Ejercicio 6
 * Crea un juego de tres en raya utilizando una matriz bidimensional de 3x3. Permita a dos jugadores marcar sus movimientos alternativamente.
 * El juego debe verificar si alguno de los jugadores ha ganado o si hay un empate.
 */
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        char[][] TresRaya = new char[3][3];
        inicializarTablero(TresRaya);
        Scanner teclado = new Scanner(System.in);
        char jugadorAc = 'X'; // Primer jugador usa 'X'
        boolean finJuego = false;

        while (!finJuego) {
            imprtresRaya(TresRaya);
            System.out.println("Turno del jugador " + jugadorAc);
            System.out.print("Ingrese N°fila (1-3): ");
            int fil = teclado.nextInt() - 1; // Convertir a índice 0
            System.out.print("Ingrese columna (1-3): ");
            int crow = teclado.nextInt() - 1;

            if (MovimientoInvalido(TresRaya, fil, crow)) {
                TresRaya[fil][crow] = jugadorAc;
                if (verGan(TresRaya, jugadorAc)) {
                    imprtresRaya(TresRaya);
                    System.out.println("¡El jugador " + jugadorAc + " ha ganado!");
                    finJuego = true;
                } else if (esEmpate(TresRaya)) {
                    imprtresRaya(TresRaya);
                    System.out.println("¡Empate!");
                    finJuego = true;
                } else {
                    // Cambiar turno
                    jugadorAc = (jugadorAc == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Movimiento no válido. Intente nuevamente.");
            }
        }

        teclado.close();
    }

    // Inicializar el tablero con espacios vacíos
    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // Imprimir el tablero
    public static void imprtresRaya(char[][] tablero) {
        System.out.println("  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println(" ---+---+---");
            }
        }
    }

    // Verificar si un movimiento es válido
    public static boolean MovimientoInvalido(char[][] tablero, int fila, int columna) {
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ';
    }

    // Verificar si un jugador ha ganado
    public static boolean verGan(char[][] tablero, char jugador) {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true;
            }
            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) {
                return true;
            }
        }
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            return true;
        }
        return tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador;
    }

    // Verificar si hay un empate
    public static boolean esEmpate(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false; // Hay al menos un espacio vacío
                }
            }
        }
        return true; // No hay espacios vacíos y nadie ha ganado
    }
}

