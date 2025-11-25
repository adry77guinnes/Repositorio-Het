/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicahilos;

import datos.Cursos;
import secuencial.CalculadoraSecuencial;
import hilos.thread.SumaCursoThread;
import hilos.runnable.SumaCursoRunnable;
import hilos.pool.SumarCursoPool;

public class Main {

    public static void main(String[] args) {

        Cursos cursoActual = new Cursos();
        Cursos cursoAnterior = new Cursos();

        // Crear objetos SumaCursoThread para curso actual y curso anterior
        SumaCursoThread scActual = new SumaCursoThread(cursoActual);
        SumaCursoThread scAnterior = new SumaCursoThread(cursoAnterior);

        // Crear objetos SumaCursoRunnable para curso actual y curso anterior
        SumaCursoRunnable scrActual = new SumaCursoRunnable(cursoActual);
        SumaCursoRunnable scrAnterior = new SumaCursoRunnable(cursoAnterior);

        // Crear objetos SumarCursoPool para curso actual y curso anterior
        SumarCursoPool scpActual = new SumarCursoPool(cursoActual);
        SumarCursoPool scpAnterior = new SumarCursoPool(cursoAnterior);

        // Mostrar matrices por consola
        System.out.println("==== CURSO ACTUAL ====");
        cursoActual.mostrarNotas();

        System.out.println("\n==== CURSO ANTERIOR ====");
        cursoAnterior.mostrarNotas();

        // Calcular suma secuencial
        CalculadoraSecuencial calculadora = new CalculadoraSecuencial();
        int sumaTotal = calculadora.sumarTodosLosCursos(cursoActual, cursoAnterior);

        // Ejecutar los hilos y obtener suma de cada curso
        int sumaActual = scActual.sumarCurso();
        int sumaAnterior = scAnterior.sumarCurso();
        int sumaTotalHilos = sumaActual + sumaAnterior;

        // Ejecutar los Runnable y obtener suma de cada curso
        int sumaActualRunnable = scrActual.sumarCurso();
        int sumaAnteriorRunnable = scrAnterior.sumarCurso();
        int sumaTotalRunnable = sumaActualRunnable + sumaAnteriorRunnable;

        // Ejecutar el ThreadPool y obtener suma de cada curso
        int sumaActualPool = scpActual.sumarCurso();
        int sumaAnteriorPool = scpAnterior.sumarCurso();
        int sumaTotalPool = sumaActualPool + sumaAnteriorPool;

        //Muestra de resultados por consola
        System.out.println("\nSuma total de ambos cursos (secuencial): " + sumaTotal);
        System.out.println("\nSuma total de ambos cursos (Thread): " + sumaTotalHilos);
        System.out.println("\nSuma total de ambos cursos (Runnable): " + sumaTotalRunnable);
        System.out.println("\nSuma total de ambos cursos (ThreadPool): " + sumaTotalPool);
    }
}
