import java.util.ArrayList;
import java.util.List;

public class TopThreeFinder {

    /**
     * Devuelve los 3 valores más altos de la lista.
     * Si hay menos de 3 elementos, devuelve todos los valores ordenados de mayor a menor.
     * Maneja duplicados correctamente.
     * 
     * @param numbers Lista de números (puede contener nulls, negativos y duplicados)
     * @return Lista con los 3 valores más altos (o menos si no hay suficientes), ordenados de mayor a menor
     */
    public static List<Integer> obtenerTopTres(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new ArrayList<>();
        }

        // Inicializamos con los valores más bajos posibles
        Integer primero = null;
        Integer segundo = null;
        Integer tercero = null;

        for (Integer num : numbers) {
            if (num == null) {
                continue; // Ignoramos nulls
            }

            if (primero == null || num > primero) {
                tercero = segundo;
                segundo = primero;
                primero = num;
            } else if (segundo == null || num > segundo) {
                tercero = segundo;
                segundo = num;
            } else if (tercero == null || num > tercero) {
                tercero = num;
            }
        }

        List<Integer> resultado = new ArrayList<>();
        
        if (primero != null) resultado.add(primero);
        if (segundo != null) resultado.add(segundo);
        if (tercero != null) resultado.add(tercero);

        return resultado;
    }

    // Sobrecarga para arrays
    public static List<Integer> obtenerTopTres(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new ArrayList<>();
        }
        
        List<Integer> lista = new ArrayList<>();
        for (int n : numbers) {
            lista.add(n);
        }
        return obtenerTopTres(lista);
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        List<Integer> numeros = List.of(5, 12, 3, 8, 19, 1, 15, 19, 7);
        System.out.println(obtenerTopTres(numeros)); // [19, 19, 15]

        int[] array = {10, 5, 8, 12, 3};
        System.out.println(obtenerTopTres(array));   // [12, 10, 8]
    }
}