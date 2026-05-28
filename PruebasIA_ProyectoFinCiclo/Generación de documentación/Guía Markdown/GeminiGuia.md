# Guía de Uso: Método `obtenerTresMayores`
**Para: Desarrolladores Junior** | **Tecnología: Java**

Esta guía explica el funcionamiento, la lógica interna y las consideraciones clave al utilizar el método `obtenerTresMayores`.

---

## 1. Propósito del Método
El método `obtenerTresMayores(List<Integer> numeros)` recibe una lista de números enteros y devuelve una nueva lista con los **tres valores más altos**, ordenados de mayor a menor (de la primera a la tercera posición).

## 2. Cómo funciona (Algoritmo de un solo paso)
A diferencia de un enfoque tradicional que ordenaría toda la lista (lo cual es costoso en rendimiento), este método es altamente eficiente porque **recorre la lista una sola vez ($O(n)$)**.

### Flujo de la lógica:
1. Se inicializan tres variables (`primero`, `segundo`, `tercero`) con el valor más bajo posible en Java (`Integer.MIN_VALUE`).
2. Se evalúa cada número (`num`) de la lista mediante una estructura condicional en cascada (*efecto dominó*):
   - **Caso 1 (`num > primero`):** El número actual es el más grande visto hasta ahora. El antiguo `segundo` pasa a ser el `tercero`, el antiguo `primero` pasa a ser el `segundo`, y `primero` toma el valor de `num`.
   - **Caso 2 (`num > segundo`):** El número no supera al primero, pero es mayor que el segundo. El antiguo `segundo` se desplaza a `tercero`, y `segundo` toma el valor de `num`.
   - **Caso 3 (`num > tercero`):** El número solo supera al tercero. `tercero` toma el valor de `num`.

## 3. Ejemplo de Ejecución Paso a Paso
Dada la lista: `[5, 12, 3]`

| Número Evaluado (`num`) | `primero` | `segundo` | `tercero` | Nota / Condición Activada |
| :--- | :--- | :--- | :--- | :--- |
| *Inicio* | `-2147483648` | `-2147483648` | `-2147483648` | Valores iniciales (`MIN_VALUE`) |
| **5** | **5** | `-2147483648` | `-2147483648` | `5 > primero`. Se desplazan los mínimos. |
| **12** | **12** | **5** | `-2147483648` | `12 > primero`. El 5 pasa a ser el segundo. |
| **3** | 12 | 5 | **3** | No supera a 12 ni a 5, pero `3 > tercero`. |

**Resultado devuelto:** `[12, 5, 3]`

---

## 4. Alertas y Casos Borde (Edge Cases) ⚠️

Antes de integrar este código en producción, ten en cuenta los siguientes comportamientos:

1. **Listas con duplicados:** Si la lista contiene elementos repetidos (ej. `[99, 99, 50]`), el método los tratará como individuales. El resultado será `[99, 99, 50]`. Si necesitas elementos *únicos*, se Ly se debería limpiar la lista con un `Set` antes de procesarla.
2. **Listas con menos de 3 elementos:** Si pasas una lista con un solo elemento (ej. `[42]`), el resultado será `[42, -2147483648, -2147483648]`. Los puestos vacíos se rellenan con `Integer.MIN_VALUE`. 
   * *Buenas prácticas:* Añade una validación previa (`numeros.size() < 3`) para lanzar una excepción o manejar el error según las reglas del negocio.
3. **Valores Nulos (`null`):** El método no gestiona valores `null`. Si la lista de entrada es `null` o contiene elementos `null`, el programa lanzará un `NullPointerException` (NPE).