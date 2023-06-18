package Lab04.ejercicio1;

import java.io.IOException;

public class ejercicio1 {
    public static void main(String[] args) throws IOException {

    }

    public static void generarPeorCaso(int t, NodeList listaNodos) {
        for (int i = 0; i < t; i++) {
            listaNodos.put(t - i);
        }
    }

    public static long insertionSort(NodeList lista_de_nodos) {
        int key;
        int i;
        long nano_startTime = System.nanoTime();
        for (int j = 1; j < lista_de_nodos.getSize(); j = j + 1) {
            key = (int) lista_de_nodos.get(j).getValor();

            i = j - 1;
            while (i > -1 && (int) lista_de_nodos.get(i).getValor() > key) {
                lista_de_nodos.replace(i + 1, lista_de_nodos.get(i).getValor());
                i = i - 1;
            }
            lista_de_nodos.replace(i + 1, key);
        }
        long nano_endTime = System.nanoTime();
        return nano_endTime - nano_startTime;
    }
}
