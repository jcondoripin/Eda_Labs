
package Lab05;

import java.util.Arrays;
import java.util.List;

import Lab05.Exceptions.ItemDuplicated;
import Lab05.Exceptions.NotFoundException;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class Test {
    public static void main(String[] args) throws ItemDuplicated, NotFoundException {
        AVLTree<Integer> arbol = new AVLTree<>();

        // Prueba gráfica
        Graph myTree = new SingleGraph("Mi arbol");

        // Ejemplo de inserción de palabras
        List<String> palabras = Arrays.asList("HELLO", "WORLD", "AVL", "TREE", "DATA", "STRUCTURE");
        for (String palabra : palabras) {
            int valorAscii = palabra.chars().sum();
            arbol.insert(valorAscii);
        }

        // Ejemplo de búsqueda
        NodoAVL<Integer> resultado = arbol.search("AVL".chars().sum());
        if (resultado != null)
            System.out.println("La palabra 'AVL' está en el árbol AVL.");
        else
            System.out.println("La palabra 'AVL' no está en el árbol AVL.");

        // Ejemplo de obtener el mínimo y máximo
        int minimo = arbol.getMin();
        int maximo = arbol.getMax();
        System.out.println("El valor mínimo es: " + minimo);
        System.out.println("El valor máximo es: " + maximo);

        // Ejemplo de eliminación de una palabra
        arbol.remove("AVL".chars().sum());
        resultado = arbol.search("AVL".chars().sum());
        if (resultado == null)
            System.out.println("La palabra 'AVL' ha sido eliminada correctamente.");

        addNodesToGraph(arbol.getRoot(), myTree);
        arbol.addEdgesToGraph(arbol.getRoot(), myTree);
        myTree.setAttribute("ui.stylesheet",
                "node { size: 20px; shape: circle; fill-color: blue; text-alignment: center; }");
        myTree.setAttribute("ui.quality");
        myTree.setAttribute("ui.antialias");
        System.setProperty("org.graphstream.ui", "swing");
        myTree.display();
    }

    public static void addNodesToGraph(NodoAVL<Integer> node, Graph graph) {
        if (node != null) {
            String nodeId = String.valueOf(node.getValue());
            graph.addNode(nodeId);

            addNodesToGraph(node.getLeft(), graph);
            addNodesToGraph(node.getRight(), graph);
        }
    }
}
