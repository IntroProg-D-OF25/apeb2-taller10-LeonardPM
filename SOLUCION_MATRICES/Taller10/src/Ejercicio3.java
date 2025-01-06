import java.util.Random;

/**
 * El primer ciclo paralelo C, cuenta con 28 estudiantes, de los cuáles al finalizar el periodo, la Dirección de la carrera de Computación a solicitado las siguientes
 * estadísticas de la materia INTRODUCCIÓN A LA PROGRAMACIÓN en función a los promedios por estudiante, dichos promedios se deben calcular
 * (ponderar, ya que el docente ingrese todo sobre 10pts.) de 3 calificaciones (ACD que representa el 35% de la nota, APE del 35% y la nota del AA con un peso del 30%).
 * En resumen, los requerimientos son los siguientes:
 * <p>
 * Registre los nombres de cada estudiante de dicho paralelo.
 * Genere aleatoriamente las notas ACD, APE, AA, para cada uno de los 28 estudiantes de 0-10 pts.
 * Calcule el promedio de cada uno de los estudiantes del paralelo dada la siguiente ponderación: ACD->35%, APE->35%, y el AA->30%.
 * Obtenga el promedio del curso, del paralelo C.
 * Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por encima del promedio del curso.
 * Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por debajo del promedio del curso.
 * Muestre el estudiante con su calificación, si es el del mayor promedio (el más alto de la clase).
 * Muestre el estudiante con su calificación, si es el del menor promedio (el más bajo de la clase).
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        int numEstudiantes = 28;
        double[] SupPromedioCur = new double[numEstudiantes];
        double[] BajoPromedioCur = new double[numEstudiantes];
        double[] ACD = new double[numEstudiantes];
        double[] APE = new double[numEstudiantes];
        double[] AA = new double[numEstudiantes];
        String[] Estudiante = new String[numEstudiantes];
        double[] PromedioEstu = new double[numEstudiantes];
        float Promediotot = 0;

        Random random = new Random();

        for (int i = 0; i < Estudiante.length; i++) {
            ACD[i] = random.nextDouble(10);
            APE[i] = random.nextDouble(10);
            AA[i] = random.nextDouble(10);
            Estudiante[i] = "Estudiante" + (i + 1);
            PromedioEstu[i] = (ACD[i] * .35) + (APE[i] * .35) + (AA[i] * .30);
            Promediotot += PromedioEstu[i];
            System.out.println("PROMEDIO DE CADA UNO DE LOS ESTUDIANTES: " + " "+Estudiante[i] + "\t" + PromedioEstu[i]);
        }
        Promediotot /= numEstudiantes;

        double maxPromedio = PromedioEstu[0];
        double minPromedio = PromedioEstu[0];
        String estudianteMax = Estudiante[0];
        String estudianteMin = Estudiante[0];

        for (int i = 0; i < Estudiante.length; i++) {
            if (PromedioEstu[i] > Promediotot) {
                SupPromedioCur[i] = PromedioEstu[i];
            }
        }
        for (int i = 0; i < numEstudiantes; i++) {
            if (PromedioEstu[i] < Promediotot) {
                BajoPromedioCur[i] = PromedioEstu[i];
            }
        }
        for (int i = 0; i < Estudiante.length; i++) {
            if (PromedioEstu[i] > maxPromedio) {
                maxPromedio = PromedioEstu[i];
                estudianteMax = Estudiante[i];
            }
            if (PromedioEstu[i] < minPromedio) {
                minPromedio = PromedioEstu[i];
                estudianteMin = Estudiante[i];
            }
        }
        System.out.println("\nPROMEDIO DEL CURSO: " + Promediotot);
        System.out.println("\nESTUDIANTES POR ENCIMA DEL PROMEDIO DEL CURSO:");
        for (int i = 0; i < numEstudiantes; i++) {
            if (PromedioEstu[i] > Promediotot) {
                System.out.printf("%s: %.2f%n", Estudiante[i], PromedioEstu[i]);
            }
        }

        System.out.println("\nESTUDIANTES POR DEBAJO DEL PROMEDIO DEL CURSO:");
        for (int i = 0; i < numEstudiantes; i++) {
            if (PromedioEstu[i] < Promediotot) {
                System.out.printf("%s: %.2f%n", Estudiante[i], PromedioEstu[i]);
            }
        }

        System.out.println("\nESTUDIANTE CON EL MAYOR PROMEDIO: " + estudianteMax + " - " + maxPromedio);
        System.out.println("ESTUDIANTE CON EL MENOR PROMEDIO: " + estudianteMin + " - " + minPromedio);
    }
}
/**
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante1	7.455839329664515
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante2	2.578146890841193
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante3	4.3288660203123275
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante4	4.059628286359404
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante5	5.897745341371419
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante6	3.1892602634666334
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante7	5.288114073584408
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante8	4.608114113536183
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante9	4.557520401140985
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante10	4.5892739610176925
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante11	4.436739456313509
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante12	4.216594754204768
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante13	6.885494636867598
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante14	7.165788295396547
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante15	3.184750867462212
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante16	7.3344155017566015
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante17	4.227226858399839
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante18	5.47540686079672
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante19	4.420843808594518
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante20	5.951585674504253
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante21	6.739237094943807
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante22	5.877188360525819
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante23	5.023184039531632
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante24	6.658678355306053
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante25	2.2720753732039176
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante26	1.9845853737877368
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante27	3.0118724633433827
 * PROMEDIO DE CADA UNO DE LOS ESTUDIANTES:  Estudiante28	5.6172883243257985
 *
 * PROMEDIO DEL CURSO: 4.894124
 *
 * ESTUDIANTES POR ENCIMA DEL PROMEDIO DEL CURSO:
 * Estudiante1: 7.46
 * Estudiante5: 5.90
 * Estudiante7: 5.29
 * Estudiante13: 6.89
 * Estudiante14: 7.17
 * Estudiante16: 7.33
 * Estudiante18: 5.48
 * Estudiante20: 5.95
 * Estudiante21: 6.74
 * Estudiante22: 5.88
 * Estudiante23: 5.02
 * Estudiante24: 6.66
 * Estudiante28: 5.62
 *
 * ESTUDIANTES POR DEBAJO DEL PROMEDIO DEL CURSO:
 * Estudiante2: 2.58
 * Estudiante3: 4.33
 * Estudiante4: 4.06
 * Estudiante6: 3.19
 * Estudiante8: 4.61
 * Estudiante9: 4.56
 * Estudiante10: 4.59
 * Estudiante11: 4.44
 * Estudiante12: 4.22
 * Estudiante15: 3.18
 * Estudiante17: 4.23
 * Estudiante19: 4.42
 * Estudiante25: 2.27
 * Estudiante26: 1.98
 * Estudiante27: 3.01
 *
 * ESTUDIANTE CON EL MAYOR PROMEDIO: Estudiante1 - 7.455839329664515
 * ESTUDIANTE CON EL MENOR PROMEDIO: Estudiante26 - 1.9845853737877368
 */



