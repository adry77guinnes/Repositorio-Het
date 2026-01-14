package hilos.runnable;

public class CalculoConRunnable {

    public static void calcular(int[][] notas) {

        Thread[] hilos = new Thread[5];
        HiloRunnable[] tareas = new HiloRunnable[5];

        for (int j = 0; j < 5; j++) {
            tareas[j] = new HiloRunnable(notas, j);
            hilos[j] = new Thread(tareas[j]);
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
            System.out.println("Media módulo " + j + " (Runnable): "
                    + tareas[j].getMedia());
        }
    }
}