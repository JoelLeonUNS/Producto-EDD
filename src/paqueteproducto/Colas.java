package paqueteproducto;

public class Colas {

    public String[] arrayCola;
    public int fin;
    public int frente;
    public int n;

    public Colas(String[] arrayCola, int fin, int frente) {
        this.arrayCola = arrayCola;
        this.fin = fin;
        this.frente = frente;
        this.n = arrayCola.length - 1;
    }

    public void insertar(String x) {
        if (fin == n) {
            System.out.println("\n¡Cola llena!\n");
        } else {
            fin++;
            arrayCola[fin] = x;
            if (frente == -1) {
                frente = 0;
            }
        }
    }

    public void suprimir() {
        if (frente == -1) {
            System.out.println("\n¡Cola vacía!\n");
        } else {
            arrayCola[frente] = " ";
            if (frente == fin) {
                frente = -1;
                fin = -1;
            } else {
                frente++;
            }
        }
    }

}
