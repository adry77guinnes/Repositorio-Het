package datos;

public class GeneradorNotas {

    public static int[][] generar() {
        int[][] notas = new int[10][5];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                notas[i][j] = (int)(Math.random() * 11);
            }
        }

        return notas;
    }
    public static void mostrar(int[][] notas) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(notas[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
