import java.util.ArrayList;
import java.util.List;

public class BuscadorMasAltos {

    public static List<Integer> obtenerTresMasAltos(List<Integer> numeros) {
        // Si la lista es nula o tiene menos de 3 elementos, manejamos el caso base
        if (numeros == null || numeros.size() < 3) {
            // Puedes lanzar una excepción o simplemente devolver la lista existente
            throw new IllegalArgumentException("La lista debe contener al menos 3 elementos.");
        }

        // Inicializamos las tres variables con el valor más bajo posible en Java
        int primero = Integer.MIN_VALUE;
        int segundo = Integer.MIN_VALUE;
        int tercero = Integer.MIN_VALUE;

        for (int num : numeros) {
            // Si el número actual es mayor que el primero actual
            if (num > primero) {
                tercero = segundo; // El segundo pasa a ser tercero
                segundo = primero; // El primero pasa a ser segundo
                primero = num;     // El actual se convierte en el nuevo primero
            } 
            // Si no es mayor que el primero, pero sí que el segundo
            else if (num > segundo) {
                tercero = segundo; // El segundo pasa a ser tercero
                segundo = num;     // El actual se convierte en el nuevo segundo
            } 
            // Si no es mayor que los anteriores, pero sí que el tercero
            else if (num > tercero) {
                tercero = num;     // El actual se convierte en el nuevo tercero
            }
        }

        // Guardamos los resultados en una lista para devolverlos
        List<Resultados> topTres = new ArrayList<>();
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