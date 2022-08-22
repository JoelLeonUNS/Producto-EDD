package paqueteproducto;

import javax.swing.JOptionPane;

/**
 *
 * @author ANGIE
 */
public class Pila {

    private final String[] array;
    private int fondo;
    private int tope;
    private final int n;

    public Pila(String[] array, int tope, int fondo) {
        this.array = array;
        this.fondo = fondo;
        this.tope = tope;
        this.n = array.length - 1;
    }

    public void push(String x) {
        if (tope >= n) {
            JOptionPane.showMessageDialog(null, "¡Pila llena!");
            System.out.println("\t==== Pila llena ===");
        } else {
            tope = tope + 1;
            array[tope] = x;
            if (fondo == -1) {
                fondo = 0;
            }
        }
    }

    public String pop() {
        String x = "";
        if (tope == -1) {
            JOptionPane.showMessageDialog(null, "¡Pila vacía!");
            System.out.println("\t==== Pila vacia ====");
        } else {
            x = array[tope];
            array[tope] = null;
            if (fondo == tope) {
                fondo = -1;
                tope = -1;
            } else {
                tope = tope - 1;
            }
        }
        return x; // retorna el valor que saca de la pila
    }// x <-- pop();

    public String[] getArray() {
        return array;
    }

    public int getFondo() {
        return fondo;
    }

    public int getTope() {
        return tope;
    }

    public int getN() {
        return n;
    }

}
