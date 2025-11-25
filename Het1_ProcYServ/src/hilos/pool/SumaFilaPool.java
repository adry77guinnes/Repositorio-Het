/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos.pool;

public class SumaFilaPool implements Runnable {

    private int[] fila;
    private int[] resultados;
    private int indice;

    public SumaFilaPool(int[] fila, int[] resultados, int indice) {
        this.fila = fila;
        this.resultados = resultados;
        this.indice = indice;
    }

    @Override
    public void run() {
        int suma = 0;
        for (int nota : fila) {
            suma += nota;
        }
        resultados[indice] = suma; // Guardar el resultado en el array
    }
}

