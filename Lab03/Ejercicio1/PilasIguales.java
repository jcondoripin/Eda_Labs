import java.util.Stack;
public class PilasIguales {
    public static void main(String[] args) {
        // Crear las pilas
        Stack<Integer> pila1 = new Stack<>(); // Crear una pila llamada pila1
        Stack<Integer> pila2 = new Stack<>(); // Crear una pila llamada pila2
        Stack<Integer> pila3 = new Stack<>(); // Crear una pila llamada pila3
        // Agregar elementos a las pilas
        pila1.push(1); // Agregar el número 1 a la pila1
        pila1.push(2); // Agregar el número 2 a la pila1
        pila1.push(3); // Agregar el número 3 a la pila1

        pila2.push(4); // Agregar el número 4 a la pila2
        pila2.push(2); // Agregar el número 2 a la pila2
        pila2.push(5); // Agregar el número 5 a la pila2

        pila3.push(6); // Agregar el número 6 a la pila3
        pila3.push(2); // Agregar el número 2 a la pila3
        pila3.push(7); // Agregar el número 7 a la pila3
        // Encontrar el número donde las pilas son iguales
        int numeroIgual = encontrarNumeroIgual(pila1, pila2, pila3); // Llamar al método encontrarNumeroIgual con las tres pilas y guardar el resultado 
                                                                     //en la variable numeroIgual
        System.out.println("El número en el que las pilas son iguales es: " + numeroIgual); // Imprimir el número encontrado
    }
    public static int encontrarNumeroIgual(Stack<Integer> pila1, Stack<Integer> pila2, Stack<Integer> pila3) {
        while (!pila1.isEmpty() && !pila2.isEmpty() && !pila3.isEmpty()) { // Mientras todas las pilas tengan elementos
            int elementoPila1 = pila1.pop(); // Obtener y eliminar el elemento en la parte superior de pila1 y guardarlo en la variable elementoPila1
            int elementoPila2 = pila2.pop(); // Obtener y eliminar el elemento en la parte superior de pila2 y guardarlo en la variable elementoPila2
            int elementoPila3 = pila3.pop(); // Obtener y eliminar el elemento en la parte superior de pila3 y guardarlo en la variable elementoPila3

            if (elementoPila1 == elementoPila2 && elementoPila2 == elementoPila3) { // Si los tres elementos son iguales
                return elementoPila1; // Devolver el elemento encontrado
            }
        }
        return -1; // Si no hay números iguales en las pilas, devolver -1
    }
}
