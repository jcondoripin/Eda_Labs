import java.util.Stack;

public class PilasIguales{
    public static void main(String[] args) {
        Stack < String > pila1 = new Stack < String > ();
        Stack < String > pila2 = new Stack < String > ();

        pila1.push(Integer.toString(6));
        pila1.push(Integer.toString(4));
        pila1.push(Integer.toString(3));
        pila2.push(Integer.toString(6));
        pila2.push(Integer.toString(4));
        pila2.push(Integer.toString(3));
        
        boolean band = true;    

        while( !pila1.empty() && !pila2.empty() && band ){
            if(Integer.parseInt(pila1.pop()) != Integer.parseInt(pila2.pop()))
                band = false;
        }

        if( band && pila1.empty() && pila2.empty() )
            System.out.println("\nSon Pilas Iguales\n");
        else
        System.out.println("\nNo Son Pilas Iguales\n");
    }
}
