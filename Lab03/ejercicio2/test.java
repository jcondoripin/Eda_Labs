package ejercicio2;

public class test {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("\t.:Ejecucion:.");
        System.out
                .println("Tamaño: " + stack.size() + "\n" + "El elemento superior y que se quitara es: " + stack.pop());
        int indicePrueba = stack.search("B");
        System.out.println("El elemento B, esta en la posicion: " + indicePrueba);
        System.out.println("Tamaño: " + stack.size());
        System.out.println("Elemento superior: " + stack.peek());
    }
}