/**
 * Clase utilitaria que proporciona funcionalidad para comprobar si una cadena
 * es un palíndromo, ignorando espacios en blanco y sin distinguir entre
 * mayúsculas y minúsculas.
 * 
 * <p>Esta clase solo contiene métodos estáticos y no está diseñada para ser instanciada.</p>
 * 
 * @author Tu Nombre (opcional)
 * @version 1.0
 */
public class PalindromeChecker {

    /**
     * Verifica si una cadena es un palíndromo, ignorando espacios en blanco
     * y sin diferenciar entre mayúsculas y minúsculas.
     * 
     * <p>Un palíndromo es una palabra, frase o secuencia que se lee igual
     * hacia adelante que hacia atrás.</p>
     * 
     * <p>Se consideran válidas las cadenas vacías y {@code null}, devolviendo
     * {@code true} en ambos casos.</p>
     * 
     * @param s la cadena a verificar. Puede ser {@code null} o vacía.
     * @return {@code true} si la cadena es un palíndromo (ignorando espacios
     *         y mayúsculas/minúsculas), {@code false} en caso contrario.
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
     * Método principal para probar el funcionamiento de {@link #esPalindromo(String)}.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        String[] pruebas = {
            "Anita lava la tina",
            "A man a plan a canal Panama",
            "Hola mundo",
            "radar",
            " A b a ",
            "12321",
            ""
        };
        
        for (String prueba : pruebas) {
            System.out.printf("\"%s\" → %b%n", prueba, esPalindromo(prueba));
        }
    }
}