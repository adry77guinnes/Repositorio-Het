public class PalindromeChecker {

    /**
     * Verifica si una cadena es un palíndromo ignorando espacios y mayúsculas/minúsculas.
     * 
     * @param s la cadena a verificar
     * @return true si es palíndromo, false en caso contrario
     */
    public static boolean esPalindromo(String s) {
        if (s == null || s.isEmpty()) {
            return true; // o false, según tu criterio
        }

        int izquierda = 0;
        int derecha = s.length() - 1;

        while (izquierda < derecha) {
            // Saltar espacios por la izquierda
            while (izquierda < derecha && s.charAt(izquierda) == ' ') {
                izquierda++;
            }
            // Saltar espacios por la derecha
            while (izquierda < derecha && s.charAt(derecha) == ' ') {
                derecha--;
            }

            if (izquierda < derecha) {
                char charIzq = Character.toLowerCase(s.charAt(izquierda));
                char charDer = Character.toLowerCase(s.charAt(derecha));

                if (charIzq != charDer) {
                    return false;
                }

                izquierda++;
                derecha--;
            }
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