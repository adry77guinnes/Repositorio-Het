/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package secuencial;

import datos.Cursos;

public class CalculadoraSecuencial {

    public int sumarTodosLosCursos(Cursos cursoActual, Cursos cursoAnterior) {
        int suma = 0;

        // Sumar notas del curso actual
        int[][] actual = cursoActual.getNotas();
        for (int[] actual1 : actual) {
            for (int j = 0; j < actual1.length; j++) {
                suma += actual1[j];
            }
        }

        // Sumar notas del curso anterior
        int[][] anterior = cursoAnterior.getNotas();
        for (int[] anterior1 : anterior) {
            for (int j = 0; j < anterior1.length; j++) {
                suma += anterior1[j];
            }
        }

        return suma;
    }
}
