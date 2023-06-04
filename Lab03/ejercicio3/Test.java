package ejercicio3;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> myQueue = new Queue<>();
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(5);

        System.out.println(myQueue);

        System.out.println(myQueue.getFirst()); // 1
        System.out.println(myQueue.deQueue()); // 1

        System.out.println(myQueue.getFirst()); // 2
        System.out.println(myQueue.empty()); // false

        System.out.println(myQueue.search(2)); // 0
    }
}
