package ejercicio3;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println(myStack.peek()); // 5
        System.out.println(myStack.pop()); // 5

        System.out.println(myStack.peek()); // 4
        System.out.println(myStack.empty()); // falst

        System.out.println(myStack.search(1)); // 0
    }
}
