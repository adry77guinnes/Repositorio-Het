o	public class ParImpar {
    
    /**
     * Función que determina si un número es par o impar
     * @param numero el número entero a evaluar
     * @return "Par" si es par, "Impar" si es impar
     */
    public static String esParOImpar(int numero) {
        if (numero % 2 == 0) {
            return "Par";
        } else {
            return "Impar";
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        System.out.println("5 → " + esParOImpar(5));     // Impar
        System.out.println("8 → " + esParOImpar(8));     // Par
        System.out.println("0 → " + esParOImpar(0));     // Par
        System.out.println("-4 → " + esParOImpar(-4));   // Par
    }
}
