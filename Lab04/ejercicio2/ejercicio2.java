import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ejercicio2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el tamaño maximo: ");
        int tamano = sc.nextInt();
        ArrayList<DoubleNodeList<Integer>> casos = new ArrayList<>();
        for (int n = 1; n <= tamano; n++) {
            casos.add(peorCaso(n));
        }
        PrintWriter archivo = new PrintWriter("insertionTimes.txt");

        Iterator<DoubleNodeList<Integer>> puntero = casos.iterator();
        while (puntero.hasNext()) {
            archivo.println(String.valueOf(insertionSort(puntero.next())));
        }
        archivo.close();
        sc.close();

    }

    public static long insertionSort(DoubleNodeList<Integer> list) {
        Node<Integer> puntero = list.getHead().getNextNode();
        long start = System.nanoTime();
        while (puntero != null) {
            Node<Integer> keyNode = puntero;
            int key = keyNode.getData();
            Node<Integer> prevNode = puntero.getPreviuosNode();

            while (prevNode != null && prevNode.getData().compareTo(key) > 0) {
                prevNode.getNextNode().setData(prevNode.getData());
                prevNode = prevNode.getPreviuosNode();
            }

            if (prevNode == null) {
                list.getHead().setData(key);
            } else {
                prevNode.getNextNode().setData(key);
            }
            puntero = puntero.getNextNode();
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static DoubleNodeList<Integer> peorCaso(int t) {
        DoubleNodeList<Integer> lista = new DoubleNodeList<>();
        for (int i = t; i >= 0; i--) {
            lista.addNode(i);
        }
        return lista;
    }

}
