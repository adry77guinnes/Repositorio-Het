/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos.runnable;

public class SumaFilaRunnable implements Runnable {

    private int[] fila;
    private int resultado;

    public SumaFilaRunnable(int[] fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        resultado = 0;
        for (int nota : fila) {
            resultado += nota;
        }
    }

    public int getResultado() {
        return resultado;
    }
}

