public class PalindromeChecker {

    /**
     * Verifica si una cadena es un palíndromo ignorando espacios y mayúsculas/minúsculas.
     * * @param s la cadena a verificar
     * @return true si es palíndromo, false en caso contrario
     */
    public static boolean esPalindromo(String s) {
        if (s == null || s.isEmpty()) {
            return true; 
        }

        int izquierda = 0;
        int derecha = s.length() - 1;

        while (izquierda < derecha) {
            // [CAMBIO 1] Se cambiaron los bucles 'while' por 'if' para evitar bucles infinitos
            // Saltar espacios por la izquierda
            if (izquierda < derecha && s.charAt(izquierda) == ' ') {
                izquierda++;
                continue; // [CAMBIO 2] Forzar la reevaluación de la condición principal
            }
            // Saltar espacios por la derecha
            if (izquierda < derecha && s.charAt(derecha) == ' ') {
                derecha--;
                continue; // [CAMBIO 2] Forzar la reevaluación de la condición principal
            }

            // [CAMBIO 3] Ya no es necesario el 'if (izquierda < derecha)' aquí,
            // ya que los 'continue' aseguran que solo llegamos aquí si ambos son caracteres válidos.
            char charIzq = Character.toLowerCase(s.charAt(izquierda));
            char charDer = Character.toLowerCase(s.charAt(derecha));

            if (charIzq != charDer) {
                return false;
            }

            izquierda++;
            derecha--;
        }
        return true;
    }

    // Método main para probar
    public static void main(String[] args) {
        String[] pruebas = {
            "Anita lava la tina",
            "A man a plan a canal Panama",
            "Hola mundo",
            "radar",
            "   A   b   a   ",
            "12321",
            ""
        };

        for (String prueba : pruebas) {
            System.out.printf("\"%s\" → %b%n", prueba, esPalindromo(prueba));
        }
    }
}