package hilos.thread;

public class CalculoConThread {

    public static void calcular(int[][] notas) {

        HiloThread[] hilos = new HiloThread[5];

        for (int j = 0; j < 5; j++) {
            hilos[j] = new HiloThread(notas, j);
            hilos[j].start();
        }

        for (int j = 0; j < 5; j++) {
            try {
                hilos[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 0; j < 5; j++) {
            System.out.println("Media módulo " + j + " (Thread): "
                    + hilos[j].getMedia());
        }
    }
}