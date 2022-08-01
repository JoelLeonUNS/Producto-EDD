package paqueteproducto;

/**
 *
 * @author JOEL
 */
public class Cola {

    private final String[] array;
    private int fin;
    private int frente;
    private final int n;

    public Cola(String[] array, int fin, int frente) {
        this.array = array;
        this.fin = fin;
        this.frente = frente;
        this.n = array.length - 1;
    }

    public void insertar(String x) {
        if (fin == n) {
            System.out.println("\n¡Cola llena!\n");
        } else {
            fin++;
            array[fin] = x;
            if (frente == -1) {
                frente = 0;
            }
        }
    }

    public String suprimir() {
        String x = "";
        if (frente == -1) {
            System.out.println("\n¡Cola vacía!\n");
        } else {
            x = array[frente];
            array[frente] = " ";
            if (frente == fin) {
                frente = -1;
                fin = -1;
            } else {
                frente++;
            }
        }
        return x; // retorna el valor que saca de la cola
    }

    public String[] getArray() {
        return array;
    }

    public int getFin() {
        return fin;
    }

    public int getFrente() {
        return frente;
    }

    public int getN() {
        return n;
    }

}
