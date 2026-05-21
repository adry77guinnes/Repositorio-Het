o	public class VerificadorNumeros {

    /**
     * Determina si un número entero es par o impar.
     * @param numero El número a evaluar.
     * @return Una cadena de texto indicando si es "Par" o "Impar".
     */
    public static String verificarParOImpar(int numero) {
        if (numero % 2 == 0) {
            return "Par";
        } else {
            return "Impar";
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        int miNumero = 7;
        System.out.println("El número " + miNumero + " es: " + verificarParOImpar(miNumero));
    }
}
