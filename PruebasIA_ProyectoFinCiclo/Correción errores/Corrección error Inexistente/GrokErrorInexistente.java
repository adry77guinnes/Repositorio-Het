public class PalindromeChecker {

    /**
     * Verifica si una cadena es un palíndromo ignorando espacios 
     * (incluyendo cualquier whitespace) y mayúsculas/minúsculas.
     *
     * @param s la cadena a verificar
     * @return true si es palíndromo, false en caso contrario
     */
    public static boolean esPalindromo(String s) {
        // Cambio 1: Mejor manejo de null y cadena vacía o solo espacios
        if (s == null) {
            return true; // o false según convención deseada
        }

        // Cambio 2: Usamos dos punteros
        int izquierda = 0;
        int derecha = s.length() - 1;

        while (izquierda < derecha) {
            // Cambio 3: Usamos Character.isWhitespace() en lugar de == ' '
            // Esto maneja espacios, tabs, saltos de línea, etc.
            while (izquierda < derecha && Character.isWhitespace(s.charAt(izquierda))) {
                izquierda++;
            }

            // Cambio 4: Misma mejora para el lado derecho
            while (izquierda < derecha && Character.isWhitespace(s.charAt(derecha))) {
                derecha--;
            }

            // Cambio 5: Verificación adicional para evitar IndexOutOfBounds
            // (aunque con las condiciones anteriores es poco probable)
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
            " A b a ",
            "12321",
            "",
            "   ",                    // solo espacios
            null,                     // prueba null
            "A Santa at NASA"         // caso interesante
        };

        for (String prueba : pruebas) {
            System.out.printf("\"%s\" → %b%n", 
                prueba == null ? "null" : prueba, 
                esPalindromo(prueba));
        }
    }
}