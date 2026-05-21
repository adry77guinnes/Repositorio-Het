public class Palindromo {

    public static boolean esPalindromo(String texto) {
        // Eliminar espacios y convertir a minúsculas
        String limpio = texto.replaceAll("\\s+", "").toLowerCase();

        int izquierda = 0;
        int derecha = limpio.length() - 1;

        while (izquierda < derecha) {
            if (limpio.charAt(izquierda) != limpio.charAt(derecha)) {
                return false;
            }

            izquierda++;
            derecha--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(esPalindromo("Anita lava la tina")); // true
        System.out.println(esPalindromo("Hola mundo")); // false
    }
}