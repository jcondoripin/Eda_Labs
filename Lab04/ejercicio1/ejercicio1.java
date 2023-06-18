import java.util.*;
import java.io.IOException;
import java.util.Iterator;
import java.io.PrintWriter;

public class ejercicio1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter archivo = new PrintWriter("insertionTimes.txt");
        System.out.print("Ingresa el tamaño maximo: ");
        int n = sc.nextInt();
        ArrayList<NodeList<Integer>> arreglos = new ArrayList<NodeList<Integer>>();
        for (int i = 0; i < n; i++){
            NodeList<Integer> caso = new NodeList<>();
            generarPeorCaso(i, caso);
            arreglos.add(caso);
        }
        Iterator<NodeList<Integer>> puntero = arreglos.iterator();
        while (puntero.hasNext()) {
            archivo.println(String.valueOf(insertionSort(puntero.next())));
        }
        archivo.close();
        sc.close();

    }

    public static void generarPeorCaso(int t, NodeList<Integer> listaNodos) {
        for (int i = 0; i < t; i++) {
            listaNodos.put(t - i);
        }
    }

    public static long insertionSort(NodeList<Integer> listaNodos) {
        int key;
        int i;
        long nano_startTime = System.nanoTime();
        for (int j = 1; j < listaNodos.getSize(); j = j + 1) {
            key = (int) listaNodos.get(j).getValor();

            i = j - 1;
            while (i > -1 && (int) listaNodos.get(i).getValor() > key) {
                listaNodos.replace(i + 1, listaNodos.get(i).getValor());
                i = i - 1;
            }
            listaNodos.replace(i + 1, key);
        }
        long nano_endTime = System.nanoTime();
        return nano_endTime - nano_startTime;
    }
}
