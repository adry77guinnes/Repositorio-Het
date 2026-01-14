package hilos.thread;

public class HiloThread extends Thread {

    private int[][] notas;
    private int modulo;
    private double media;

    public HiloThread(int[][] notas, int modulo) {
        this.notas = notas;
        this.modulo = modulo;
    }

    @Override
    public void run() {
        int suma = 0;

        for (int i = 0; i < 10; i++) {
            suma += notas[i][modulo];
        }

        media = (double) suma / 10;
    }

    public double getMedia() {
        return media;
    }
}
