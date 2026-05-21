public class ValidadorPalindromo {

    public static boolean esPalindromo(String cadena) {
        // Si es nula o vacía, la consideramos palíndromo por defecto (o según tu lógica de negocio)
        if (cadena == null) {
            return false;
        }

        // 1. Convertimos todo a minúsculas para ignorar las mayúsculas
        String cadenaLimpia = cadena.toLowerCase();

        // 2. Inicializamos los dos punteros
        int izquierda = 0;
        int derecha = cadenaLimpia.length() - 1;

        // 3. Recorremos la cadena hacia el centro
        while (izquierda < derecha) {
            char charIzquierda = cadenaLimpia.charAt(izquierda);
            char charDerecha = cadenaLimpia.charAt(derecha);

            // Si el carácter de la izquierda es un espacio, lo saltamos
            if (charIzquierda == ' ') {
                izquierda++;
            } 
            // Si el carácter de la derecha es un espacio, lo saltamos
            else if (charDerecha == ' ') {
                derecha--;
            } 
            // Si ambos son caracteres válidos, los comparamos
            else {
                if (charIzquierda != charDerecha) {
                    return false; // No es palíndromo
                }
                // Si son iguales, avanzamos ambos punteros hacia el centro
                izquierda++;
                derecha--;
            }
        }

        return true; // Si terminó el bucle sin fallas, es un palíndromo
    }

    public static void main(String[] args) {
        // Pruebas de verificación
        String prueba1 = "Anita lava la tina";
        String prueba2 = "La ruta nos aporto otro paso natural";
        String prueba3 = "Java no es un palindromo";

        System.out.println("\"" + prueba1 + "\" ¿Es palíndromo?: " + esPalindromo(prueba1)); // true
        System.out.println("\"" + prueba2 + "\" ¿Es palíndromo?: " + esPalindromo(prueba2)); // true
        System.out.println("\"" + prueba3 + "\" ¿Es palíndromo?: " + esPalindromo(prueba3)); // false
    }
}