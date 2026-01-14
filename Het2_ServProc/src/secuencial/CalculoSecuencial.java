package secuencial;

public class CalculoSecuencial {

    public static void calcularMedias(int[][] notas) {

        for (int j = 0; j < 5; j++) {
            int suma = 0;

            for (int i = 0; i < 10; i++) {
                suma += notas[i][j];
            }

            double media = (double) suma / 10;
            System.out.println("Media módulo " + j + "(Secuencial): " + media);
        }
    }
}