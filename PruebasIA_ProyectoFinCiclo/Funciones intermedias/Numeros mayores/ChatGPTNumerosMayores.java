import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> obtenerTresMayores(List<Integer> numeros) {
        int primero = Integer.MIN_VALUE;
        int segundo = Integer.MIN_VALUE;
        int tercero = Integer.MIN_VALUE;

        for (int num : numeros) {
            if (num > primero) {
                tercero = segundo;
                segundo = primero;
                primero = num;
            } else if (num > segundo) {
                tercero = segundo;
                segundo = num;
            } else if (num > tercero) {
                tercero = num;
            }
        }

        List<Integer> resultado = new ArrayList<>();
        resultado.add(primero);
        resultado.add(segundo);
        resultado.add(tercero);

        return resultado;
    }

    public static void main(String[] args) {
        List<Integer> numeros = List.of(5, 12, 3, 99, 42, 18, 77);

        List<Integer> mayores = obtenerTresMayores(numeros);

        System.out.println("Los 3 valores más altos son: " + mayores);
    }
}