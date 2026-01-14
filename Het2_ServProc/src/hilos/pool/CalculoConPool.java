package hilos.pool;

import hilos.runnable.HiloRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CalculoConPool {

    public static void calcular(int[][] notas) {

        ExecutorService pool = Executors.newFixedThreadPool(5);

        List<HiloRunnable> tareas = new ArrayList<>();
        List<Future<?>> futuros = new ArrayList<>();

        for (int j = 0; j < 5; j++) {
            HiloRunnable tarea = new HiloRunnable(notas, j);
            Future<?> f = pool.submit(tarea);

            tareas.add(tarea);
            futuros.add(f);
        }

        for (Future<?> f : futuros) {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();

        for (int j = 0; j < tareas.size(); j++) {
            System.out.println("Media módulo " + j + " (Pool): "
                    + tareas.get(j).getMedia());
        }
    }
}