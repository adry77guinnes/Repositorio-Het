public class PalindromeChecker {

    /**
     * Verifica si una cadena es un palíndromo ignorando espacios y mayúsculas/minúsculas.
     *
     * @param s la cadena a verificar
     * @return true si es palíndromo, false en caso contrario
     */
    public static boolean esPalindromo(String s) {

        // CORRECCIÓN 1:
        // Se mantiene la validación de null y cadena vacía.
        // Una cadena vacía suele considerarse palíndromo.
        if (s == null || s.isEmpty()) {
            return true;
        }

        int izquierda = 0;
        int derecha = s.length() - 1;

        while (izquierda < derecha) {

            // CORRECCIÓN 2:
            // charAt() recibe la POSICIÓN entre paréntesis.
            // Antes estaba: s.charAt[izquierda]
            while (izquierda < derecha && s.charAt(izquierda) == ' ') {
                izquierda++;
            }

            // CORRECCIÓN 3:
            // Igual que antes: charAt() debe usar paréntesis.
            // Antes estaba: s.charAt[derecha]
            while (izquierda < derecha && s.charAt(derecha) == ' ') {
                derecha--;
            }

            if (izquierda < derecha) {

                // CORRECCIÓN 4:
                // toLowerCase() necesita recibir un carácter.
                // Antes faltaban los paréntesis correctos.
                char charIzq = Character.toLowerCase(s.charAt(izquierda));
                char charDer = Character.toLowerCase(s.charAt(derecha));

                // CORRECCIÓN 5:
                // La comparación debe usar != para detectar diferencias.
                // Antes podía haber un error lógico usando = o == incorrectamente.
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

        // CORRECCIÓN 6:
        // Se usa printf correctamente para mostrar resultados formateados.
        for (String prueba : pruebas) {
            System.out.printf("\"%s\" → %b%n",
                    prueba,
                    esPalindromo(prueba));
        }
    }
}