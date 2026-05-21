import java.util.Scanner;

public class Factorial {

    /**
     * Calcula el factorial de un número entero no negativo.
     * @param n Número entero >= 0
     * @return Factorial de n (como long)
     */
    public static long calcularFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        
        long factorial = 1;
        
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        
        return factorial;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un número entero no negativo: ");
        
        try {
            int numero = scanner.nextInt();
            long resultado = calcularFactorial(numero);
            System.out.println("El factorial de " + numero + " es: " + resultado);
            
        } catch (Exception e) {
            System.out.println("Error: Debes introducir un número entero válido.");
        } finally {
            scanner.close();
        }
    }
}
