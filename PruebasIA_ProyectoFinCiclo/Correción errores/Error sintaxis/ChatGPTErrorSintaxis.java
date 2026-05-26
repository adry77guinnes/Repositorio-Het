import java.util.ArrayList;
import java.util.List;

public class BuscadorMasAltos {

    public static List<Integer> obtenerTresMasAltos(List<Integer> numeros) {

        // Verificamos que la lista no sea nula y tenga al menos 3 elementos
        if (numeros == null || numeros.size() < 3) {
            throw new IllegalArgumentException(
                "La lista debe contener al menos 3 elementos."
            );
        }

        // Inicializamos las variables con el menor valor posible de Integer
        int primero = Integer.MIN_VALUE;
        int segundo = Integer.MIN_VALUE;
        int tercero = Integer.MIN_VALUE;

        // Recorremos todos los números de la lista
        for (int num : numeros) {

            // Si encontramos un número mayor que el primero
            if (num > primero) {

                // Desplazamos los valores hacia abajo
                tercero = segundo;
                segundo = primero;
                primero = num;

            }

            // Si no es mayor que el primero pero sí que el segundo
            else if (num > segundo) {

                tercero = segundo;
                segundo = num;

            }

            // Si no es mayor que los anteriores pero sí que el tercero
            else if (num > tercero) {

                tercero = num;

            }
        }

        /*
         * ERROR CORREGIDO:
         * El código original declaraba:
         * List<Resultados> topTres
         *
         * Pero la clase "Resultados" no existe y además
         * estamos guardando enteros.
         *
         * Debe ser:
         */
        List<Integer> topTres = new ArrayList<>();

        // Añadimos los tres números más altos encontrados
        topTres.add(primero);
        topTres.add(segundo);
        topTres.add(tercero);

        // Devolvemos la lista
        return topTres;
    }

    public static void main(String[] args) {

        List<Integer> misNumeros =
            List.of(10, 4, 55, 23, 99, 45, 99, 0, -5);

        List<Integer> resultado =
            obtenerTresMasAltos(misNumeros);

        System.out.println(
            "Los 3 números más altos son: " + resultado
        );

        // Salida esperada: [99, 99, 55]
    }
}