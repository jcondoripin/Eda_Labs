public class ejercicio2 {
    public void main(String[] args) {

    }

    public void insertionSort(DoubleNodeList<Integer> list) {
        Node<Integer> puntero = list.getHead().getNextNode();

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
    }

}
