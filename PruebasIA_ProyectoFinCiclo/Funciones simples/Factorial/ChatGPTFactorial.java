import java.util.Scanner;

public class Factorial {

    // Función para calcular el factorial
    public static long calcularFactorial(int n) {
        long resultado = 1;

        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }

        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("El factorial no está definido para números negativos.");
        } else {
            long factorial = calcularFactorial(numero);
            System.out.println("El factorial de " + numero + " es: " + factorial);
        }

        scanner.close();
    }
}
