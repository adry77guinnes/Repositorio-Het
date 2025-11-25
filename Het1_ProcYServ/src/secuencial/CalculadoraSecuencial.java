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
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                suma += actual[i][j];
            }
        }

        // Sumar notas del curso anterior
        int[][] anterior = cursoAnterior.getNotas();
        for (int i = 0; i < anterior.length; i++) {
            for (int j = 0; j < anterior[i].length; j++) {
                suma += anterior[i][j];
            }
        }

        return suma;
    }
}
