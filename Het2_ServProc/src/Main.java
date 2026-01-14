import datos.GeneradorNotas;
import hilos.pool.CalculoConPool;
import hilos.runnable.CalculoConRunnable;
import hilos.thread.CalculoConThread;
import secuencial.CalculoSecuencial;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int [][] notas = GeneradorNotas.generar();
        System.out.println("==== NOTAS CURSO ====");
        GeneradorNotas.mostrar(notas);
        System.out.println("---Metodo Secuencial---");
        CalculoSecuencial.calcularMedias(notas);
        System.out.println("---Metodo Thread---");
        CalculoConThread.calcular(notas);
        System.out.println("---Metodo Runnable---");
        CalculoConRunnable.calcular(notas);
        System.out.println("---Metodo Pool de Hilos---");
        CalculoConPool.calcular(notas);
    }
}