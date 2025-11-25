/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

public class Cursos {

    private int[][] notas;

    public Cursos() {
        notas = new int[10][5];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                notas[i][j] = (int) (Math.random() * 11); // 0 a 10
            }
        }

    }

    public void mostrarNotas() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(notas[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int sumarTodasLasNotas() {
        int suma = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                suma += notas[i][j];
            }
        }

        return suma;

    }

    public int[][] getNotas() {
        return notas;
    }

}
