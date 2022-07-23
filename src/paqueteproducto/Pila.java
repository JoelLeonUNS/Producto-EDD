package paqueteproducto;

/**
 *
 * @author ANGIE
 */
public class Pila {

    public String[] array;
    public int tope;
    public int n;

    public Pila(String[] array, int tope) {
        this.array = array;
        this.tope = tope;
        this.n = array.length - 1;
    }

    public void push(String x) {
        if (tope >= n) {
            System.out.println("\t==== Pila llena ===");
        } else {
            tope = tope + 1;
            array[tope] = x;
        }
    }

    public String pop() {
        String x = "";
        if (tope == -1) {
            System.out.println("\t==== Pila vacia ====");
        } else {
            x = array[tope];
            array[tope] = "";
            tope = tope - 1;
        }
        return x; // retorna el valor que saca de la pila
    }

}
