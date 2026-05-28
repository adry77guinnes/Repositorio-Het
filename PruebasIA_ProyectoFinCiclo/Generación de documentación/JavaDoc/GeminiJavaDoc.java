/**
 * Proporciona utilidades para la verificación de cadenas de texto,
 * enfocándose especialmente en la detección de palíndromos.
 * <p>
 * Un palíndromo es una palabra o frase que se lee igual de izquierda a derecha
 * que de derecha a izquierda, como "Anita lava la tina".
 * </p>
 * * @author TuNombre o Empresa
 * @version 1.0
 */
public class PalindromeChecker {

    /**
     * Verifica si una cadena de texto dada es un palíndromo.
     * <p>
     * Este método es robusto frente a espacios en blanco y no distingue entre
     * mayúsculas y minúsculas (case-insensitive). Las cadenas vacías o nulas 
     * se consideran palíndromos por defecto.
     * </p>
     * * <h3>Ejemplos de uso:</h3>
     * <ul>
     * <li>{@code esPalindromo("radar")} devuelve {@code true}</li>
     * <li>{@code esPalindromo("Anita lava la tina")} devuelve {@code true}</li>
     * <li>{@code esPalindromo("Hola mundo")} devuelve {@code false}</li>
     * </ul>
     * * @param s la cadena de texto que se va a evaluar; puede ser nula o vacía.
     * @return {@code true} si la cadena es un palíndromo (o si es nula/vacía); 
     * {@code false} en caso contrario.
     */
    public static boolean esPalindromo(String s) {
        if (s == null || s.isEmpty()) {
            return true; 
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

    /**
     * Método de entrada principal (main) que sirve para ejecutar pruebas unitarias
     * rápidas en la consola y demostrar el comportamiento de {@link #esPalindromo(String)}.
     * * @param args argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
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