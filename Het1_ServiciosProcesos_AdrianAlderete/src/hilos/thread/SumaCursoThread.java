/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos.thread;

import datos.Cursos;

public class SumaCursoThread {

    private final Cursos curso;

    public SumaCursoThread(Cursos curso) {
        this.curso = curso;
    }

    public int sumarCurso() {
        int sumaTotal = 0;

        int[][] matriz = curso.getNotas();
        SumaFilaThread[] hilos = new SumaFilaThread[matriz.length];

        // Crear un hilo por cada fila
        for (int i = 0; i < matriz.length; i++) {
            hilos[i] = new SumaFilaThread(matriz[i]);
            hilos[i].start();
        }
        for (SumaFilaThread hilo : hilos) {
            try {
                hilo.join(); // Esperar a que el hilo termine
                sumaTotal += hilo.getResultado(); // Añadir resultado de la fila
            }catch (InterruptedException e) {
            }
        }

        return sumaTotal;
    }
}
