/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos.pool;

import datos.Cursos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumarCursoPool {

    private Cursos curso;

    public SumarCursoPool(Cursos curso) {
        this.curso = curso;
    }

    public int sumarCurso() {
        int[][] matriz = curso.getNotas();
        int[] resultados = new int[matriz.length]; // Array para guardar la suma de cada fila

        ExecutorService executor = Executors.newFixedThreadPool(10); // Pool de 10 hilos
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < matriz.length; i++) {
            SumaFilaPool tarea = new SumaFilaPool(matriz[i], resultados, i);
            Future<?> future = executor.submit(tarea);
            futures.add(future);
        }

        // Esperar a que terminen todas las tareas
        for (Future<?> f : futures) {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        int sumaTotal = 0;
        for (int r : resultados) {
            sumaTotal += r;
        }

        return sumaTotal;
    }
}
