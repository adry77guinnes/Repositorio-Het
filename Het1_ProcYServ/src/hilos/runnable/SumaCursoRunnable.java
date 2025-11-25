/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos.runnable;

import datos.Cursos;

public class SumaCursoRunnable {

    private Cursos curso;

    public SumaCursoRunnable(Cursos curso) {
        this.curso = curso;
    }

    public int sumarCurso() {
        int sumaTotal = 0;

        int[][] matriz = curso.getNotas();
        SumaFilaRunnable[] tareas = new SumaFilaRunnable[matriz.length];
        Thread[] hilos = new Thread[matriz.length];

        // Crear un Runnable por cada fila y asociarlo a un Thread
        for (int i = 0; i < matriz.length; i++) {
            tareas[i] = new SumaFilaRunnable(matriz[i]);
            hilos[i] = new Thread(tareas[i]);
            hilos[i].start();
        }
        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join(); // Esperar a que el hilo termine
                sumaTotal += tareas[i].getResultado(); // Añadir resultado de la fila
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return sumaTotal;
    }
}
