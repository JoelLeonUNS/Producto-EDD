package paqueteproducto;

public class MenuMain {

    public static void main(String[] args) {
        String[] cola = {"15", "11", "9", "6", "1"};
        String[] pila = {"b", "a", "z", "y", "x"};
        int fin = 4, frente = 0, tope = 4;

        Cola c = new Cola(cola, fin, frente);
        Pila p = new Pila(pila, tope);
        
        System.out.println(transformacion(c, p));
    }
    
    // Ejemplo de como podría quedar, falta hacerlo mejor.
    public static String transformacion(Cola c, Pila p) {
        String notInf = "";
        
        notInf += c.suprimir();
        notInf += "*";
        notInf += p.pop();
        notInf += "^" + (p.tope + 1);
        notInf += "-"; // operador
        notInf += c.suprimir();
        notInf += "*";
        notInf += p.pop();
        notInf += "^" + (p.tope + 1);
        notInf += "+"; // operador
        notInf += c.suprimir();
        notInf += "*";
        notInf += p.pop();
        notInf += "^" + (p.tope + 1);
        notInf += "-"; // operador
        notInf += c.suprimir();
        notInf += "*";
        notInf += p.pop();
        //notInf += "^" + (p.tope + 1);
        notInf += "-"; // operador
        //notInf += c.suprimir();
        //notInf += "*";
        notInf += p.pop();
        
        return notInf;
    }

}
