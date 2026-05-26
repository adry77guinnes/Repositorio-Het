import java.util.ArrayList;
import java.util.List;

public class BuscadorMasAltos {

    /**
     * Devuelve los tres números más altos de la lista, permitiendo duplicados.
     */
    public static List<Integer> obtenerTresMasAltos(List<Integer> numeros) {
        // Si la lista es nula o tiene menos de 3 elementos, lanzamos excepción
        if (numeros == null || numeros.size() < 3) {
            throw new IllegalArgumentException("La lista debe contener al menos 3 elementos.");
        }

        // Inicializamos con el valor más bajo posible
        int primero = Integer.MIN_VALUE;
        int segundo = Integer.MIN_VALUE;
        int tercero = Integer.MIN_VALUE;

        for (int num : numeros) {
            if (num > primero) {
                tercero = segundo;     // Desplazamos valores
                segundo = primero;
                primero = num;
            } 
            else if (num > segundo) {
                tercero = segundo;
                segundo = num;
            } 
            else if (num > tercero) {
                tercero = num;
            }
        }

        // Corregido: List<Resultados> → List<Integer>
        List<Integer> topTres = new ArrayList<>();
        topTres.add(primero);
        topTres.add(segundo);
        topTres.add(tercero);

        return topTres;
    }

    public static void main(String[] args) {
        List<Integer> misNumeros = List.of(10, 4, 55, 23, 99, 45, 99, 0, -5);
       
        List<Integer> resultado = obtenerTresMasAltos(misNumeros);
        System.out.println("Los 3 números más altos son: " + resultado);
        // Salida esperada: [99, 99, 55]
    }
}