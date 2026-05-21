import java.util.Scanner;

public class CalculadoraFactorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un número entero positivo: ");
        
        // Validar que la entrada sea un número
        if (sc.hasNextInt()) {
            int numero = sc.nextInt();
            
            if (numero < 0) {
                System.out.println("Error: El factorial no está definido para números negativos.");
            } else {
                long resultado = calcularFactorial(numero);
                System.out.println("El factorial de " + numero + " es: " + resultado);
            }
        } else {
            System.out.println("Error: Por favor, introduce un número válido.");
        }
        
        sc.close();
    }

    /**
     * Función que calcula el factorial de un número.
     * Se usa 'long' para permitir resultados más grandes que un 'int'.
     */
    public static long calcularFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
